package com.fredmedlin.wikilooks.ui.mvp.model;

import com.fredmedlin.wikilooks.domain.Article;

public class ArticlesModel {

    public void requestLocation() {
    }

    public void fetchArticlesByLocation(double lat, double lon) {
    }

    public void fetchArticle(long articleId) {
    }

    public Article getArticle(long articleId) {
        return null;
    }

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

