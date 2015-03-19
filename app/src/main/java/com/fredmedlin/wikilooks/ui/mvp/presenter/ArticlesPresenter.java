package com.fredmedlin.wikilooks.ui.mvp.presenter;

import com.fredmedlin.wikilooks.domain.Article;
import com.fredmedlin.wikilooks.ui.mvp.model.ArticlesModel;
import com.fredmedlin.wikilooks.ui.mvp.model.ArticlesModel.ArticleReceivedEvent;
import com.fredmedlin.wikilooks.ui.mvp.model.ArticlesModel.GeoArticlesEvent;
import com.fredmedlin.wikilooks.ui.mvp.model.ArticlesModel.LocationEvent;

public class ArticlesPresenter {

    ArticlesModel model;
    ArticlesView view;

    public ArticlesPresenter(ArticlesModel model, ArticlesView view) {
        this.model = model;
        this.view = view;
        model.requestLocation();
    }

    public void onLocationReceived(LocationEvent event) {
        model.fetchArticlesByLocation(event.getLatitude(), event.getLongitude());
    }

    public void onArticlesReceived(GeoArticlesEvent event) {
        long[] articleIds = event.getArticleIds();
        if (articleIds != null) {
            for (long id : articleIds) {
                model.fetchArticle(id);
            }
        }
    }

    public void onArticleReceived(ArticleReceivedEvent event) {
        Article article = model.getArticle(event.getArticleId());
        view.addArticle(article.getTitle(),
                article.getDescription(),
                article.getLatitude(),
                article.getLongitude());
    }

    public interface ArticlesView {
        void addArticle(String title, String description, double lat, double lon);
    }
}
