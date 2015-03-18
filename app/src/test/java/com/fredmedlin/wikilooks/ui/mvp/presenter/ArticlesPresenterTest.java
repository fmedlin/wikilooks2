package com.fredmedlin.wikilooks.ui.mvp.presenter;

import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.GeoArticlesEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesModel.LocationEvent;
import com.fredmedlin.wikilooks.ui.mvp.presenter.ArticlesPresenter.ArticlesView;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

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

}
