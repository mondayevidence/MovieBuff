package com.example.moviebuff.ui;

import com.example.moviebuff.models.Images;
import com.example.moviebuff.models.MovieResponses;
import com.example.moviebuff.models.SlideImage;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    //insert key here
    public  static String API_KEY = "insert api key";



    @GET("top_rated")
    Call<MovieResponses> getTopRatedMovies(@Query("api_key") String apiKey);


    @GET("popular")
    Call<MovieResponses> getPopularMovies(@Query("api_key") String apiKey);


}
