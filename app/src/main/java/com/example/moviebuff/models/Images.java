package com.example.moviebuff.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Images {

    @SerializedName("images")
    private List<SlideImage> slider_image;

    public Images(){

    }

    public  List<SlideImage> getSlideImage(){
        return slider_image;
    }
}
