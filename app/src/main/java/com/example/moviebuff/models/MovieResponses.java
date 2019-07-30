package com.example.moviebuff.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MovieResponses {

    @SerializedName("page")
    @Expose
    private int page;


    @SerializedName("results")
    @Expose
    private ArrayList<Movie> results;

    @SerializedName("total_pages")
    @Expose
    private int totalPages;

    public MovieResponses(int page, ArrayList<Movie> results, int totalPages) {
        this.page = page;
        this.results = results;
        this.totalPages = totalPages;
    }



    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public ArrayList<Movie> getResults() {
        return results;
    }

    public void setResults(ArrayList<Movie> results) {
        this.results = results;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }
}
