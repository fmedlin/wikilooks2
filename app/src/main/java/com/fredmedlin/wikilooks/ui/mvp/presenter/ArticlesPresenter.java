package com.fredmedlin.wikilooks.ui.mvp.presenter;

import com.fredmedlin.wikilooks.domain.Article;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.ArticleReceivedEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.GeoArticlesEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.LocationEvent;

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

    public interface ArticlesModel {
        void requestLocation();
        void fetchArticlesByLocation(double lat, double lon);
        void fetchArticle(long articleId);
        Article getArticle(long articleId);

        public static class LocationEvent {
            double lat;
            double lon;

            public LocationEvent(double lat, double lon) {
                this.lat = lat;
                this.lon = lon;
            }

            public double getLatitude() {
                return lat;
            }

            public double getLongitude() {
                return lon;
            }
        }

        public static class GeoArticlesEvent {
            long[] articleIds;

            public GeoArticlesEvent(long[] articleIds) {
                this.articleIds = articleIds;
            }

            public long[] getArticleIds() {
                return articleIds;
            }
        }

        public static class ArticleReceivedEvent {
            long articleId;

            public ArticleReceivedEvent(long articleId) {
                this.articleId = articleId;
            }

            public long getArticleId() {
                return articleId;
            }
        }
    }

    public interface ArticlesView {
        void addArticle(String title, String description, double lat, double lon);
    }
}
