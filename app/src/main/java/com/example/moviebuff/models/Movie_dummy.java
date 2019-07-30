package com.example.moviebuff.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Movie_dummy {
    private String title;
    private String description;
    private int thumbnail;
    private String studio;
    private  String rating;
    private String streamingLink;
    private int coverPhoto;

    public Movie_dummy(String title, int thumbnail, int coverPhoto) {
        this.title = title;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Movie_dummy(String title, int thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public Movie_dummy(String title, String description, int thumbnail, String studio, String rating, String streamingLink) {
        this.title = title;
        this.description = description;
        this.thumbnail = thumbnail;
        this.studio = studio;
        this.rating = rating;
        this.streamingLink = streamingLink;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getStreamingLink() {
        return streamingLink;
    }

    public void setStreamingLink(String streamingLink) {
        this.streamingLink = streamingLink;
    }
    /*@SerializedName("vote_count")
    @Expose
    private int vote_count;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("video")
    @Expose
    private boolean video;

    @SerializedName("vote_average")
    @Expose
    private  int vote_average;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("popularity")
    @Expose
    private Double popularity;

    @SerializedName("poster_path")
    @Expose
    private String poster_path;

    @SerializedName("original_language")
    @Expose
    private  String original_language;

    @SerializedName("original_title")
    @Expose
    private String original_title;

    @SerializedName("genre_ids")
    @Expose
    private List<Integer> genre_Ids = new ArrayList<Integer>();

    @SerializedName("backdrop_path")
    @Expose
    private String backdrop_path;

    @SerializedName("adult")
    @Expose
    private boolean adult;

    @SerializedName("overview")
    @Expose
    private String overview;

    @SerializedName("release_date")
    @Expose
    private String  release_date;

    public Movie_dummy(int vote_count, int id, boolean video, int vote_average,
                     String title, Double popularity, String poster_path, String original_language,
                     String original_title, List<Integer> genre_Ids, String backdrop_path,
                     boolean adult, String overview, String release_date) {
        this.vote_count = vote_count;
        this.id = id;
        this.video = video;
        this.vote_average = vote_average;
        this.title = title;
        this.popularity = popularity;
        this.poster_path = poster_path;
        this.original_language = original_language;
        this.original_title = original_title;
        this.genre_Ids = genre_Ids;
        this.backdrop_path = backdrop_path;
        this.adult = adult;
        this.overview = overview;
        this.release_date = release_date;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }

    public int getVote_average() {
        return vote_average;
    }

    public void setVote_average(int vote_average) {
        this.vote_average = vote_average;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public List<Integer> getGenre_Ids() {
        return genre_Ids;
    }

    public void setGenre_Ids(List<Integer> genre_Ids) {
        this.genre_Ids = genre_Ids;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public boolean isAdult() {
        return adult;
    }

    public void setAdult(boolean adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

*/
}
