package com.fredmedlin.wikilooks.domain;

public class Article {
    long id;
    String title;
    String description;
    double latitude;
    double longitude;

    public Article(long id) {
        this.id = id;
    }

    public Article setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Article setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Article setLocation(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        return this;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
