package com.fredmedlin.wikilooks.ui.mvp.model;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(RobolectricTestRunner.class)
@Config(manifest = "app/src/main/AndroidManifest.xml", emulateSdk = 18)
public class ArticlesModelTest {

    @Test
    public void itShouldRequestLocation() {
        assertThat(true).isFalse();
    }

    @Test
    public void itShouldFetchArticlesByLocation() {

    }

    @Test
    public void itShouldFetchArticle() {

    }

    @Test
    public void itShouldGetArticle() {

    }
}