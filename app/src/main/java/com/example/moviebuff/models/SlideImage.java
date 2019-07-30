package com.example.moviebuff.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SlideImage {

    @SerializedName("image")
    @Expose
    private int image;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

    public SlideImage(int image, String title, String backdrop_path) {
        this.image = image;
        this.title = title;
        this.backdrop_path = backdrop_path;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
}
