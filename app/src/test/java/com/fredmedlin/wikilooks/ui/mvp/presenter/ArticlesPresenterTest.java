package com.fredmedlin.wikilooks.ui.mvp.presenter;

import com.fredmedlin.wikilooks.domain.Article;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.ArticleReceivedEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.GeoArticlesEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.LocationEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArticlesPresenterTest {

    ArticlesPresenter presenter;
    @Mock ArticlesModel model;
    @Mock ArticlesView view;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        presenter = new ArticlesPresenter(model, view);
    }

    @Test
    public void itShouldRequestLocation() {
        verify(model).requestLocation();
    }

    @Test
    public void itShouldQueryArticlesByLocation() {
        presenter.onLocationReceived(new LocationEvent(0d, 0d));
        verify(model).fetchArticlesByLocation(0d, 0d);
    }

    @Test // #3
    public void itShouldQueryArticlesById() {
        long articleIds[] = new long[] { 42, 43, 44};
        presenter.onArticlesReceived(new GeoArticlesEvent(articleIds));
        verify(model, times(articleIds.length)).fetchArticle(anyLong());
    }

    @Test // #4
    public void itShouldDisplayArticles() {
        Article article = createTestArticle(42);
        when(model.getArticle(42)).thenReturn(article);

        presenter.onArticleReceived(new ArticleReceivedEvent(42));
        verify(model).getArticle(42);
        verify(view).addArticle(
                eq("All About Apex"),
                eq("The Peak of Good Living."),
                eq(35.7319d),
                eq(-78.8528d)
        );
    }

    private Article createTestArticle(long id) {
        return new Article(id)
            .setTitle("All About Apex")
            .setDescription("The Peak of Good Living.")
            .setLocation(35.7319d, -78.8528d);
    }

}
