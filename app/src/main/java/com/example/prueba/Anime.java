package com.example.prueba;

import java.util.List;

public class Anime {

    private String titles;
    private String descriptions;
    private Boolean favorites;
    private String imageurl;

    public Anime(String titles, String descriptions, Boolean favorites, String imageurl) {
        this.titles = titles;
        this.descriptions = descriptions;
        this.favorites = favorites;
        this.imageurl = imageurl;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Boolean getFavorites() {
        return favorites;
    }

    public void setFavorites(Boolean favorites) {
        this.favorites = favorites;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }
}
