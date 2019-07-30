package com.example.moviebuff.activities;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.moviebuff.*;
import com.example.moviebuff.adapters.MovieAdapter;
import com.example.moviebuff.models.*;
import com.example.moviebuff.ui.ApiInterface;
import com.example.moviebuff.adapters.SliderPagerAdapter;
import com.example.moviebuff.ui.MovieItemClickListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import static com.example.moviebuff.ui.ApiInterface.API_KEY;

public class HomeActivity extends AppCompatActivity implements MovieItemClickListener{

    private static final String TAG = HomeActivity.class.getSimpleName();

    //ViewPager sliderpager;
    //TabLayout indicator;
    //RecyclerView MoviesRV;
    public  ArrayList<Movie> slideImages;
    MovieAdapter movieAdapter;

    @BindView(R.id.slider_pager)
    ViewPager sliderpager;

    @BindView(R.id.indicator)
    TabLayout indicator;

    @BindView(R.id.Rv_movies)
    RecyclerView MoviesRV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);



        MoviesRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        MoviesRV.setAdapter(movieAdapter);

        movieLoad();
        loadSlides();




        // a list of slides
        /*lstSlideImages = new ArrayList<>();
        lstSlideImages.add(new SlideImage(R.drawable.ralph, "Wreck It Ralph \n..."));
        lstSlideImages.add(new SlideImage(R.drawable.stark, "Avengers End game \n..."));
        lstSlideImages.add(new SlideImage(R.drawable.ralph, "Wreck It Ralph \n..."));
        lstSlideImages.add(new SlideImage(R.drawable.stark, "Avengers End game \n..."));*/



        //set up time
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);
        indicator.setupWithViewPager(sliderpager, true);

    }
    private  void  movieLoad(){

        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<MovieResponses> call = apiInterface.getPopularMovies(API_KEY);
        call.enqueue(new Callback<MovieResponses>() {
            @Override
            public void onResponse(Call<MovieResponses> call, Response<MovieResponses> response) {
                Log.e(TAG, call.request().toString());


                ArrayList<Movie> movies = response.body().getResults();
                MovieAdapter movieAdapter = new MovieAdapter(getApplicationContext(), movies, HomeActivity.this);
                MoviesRV.setAdapter(movieAdapter);
                MoviesRV.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
                MoviesRV.setHasFixedSize(true);
                //Log.d(TAG, "Number of images received: " + movies.size());



                //Log.e(TAG, call.request().toString());
                //ArrayList<Movie> movies = response.body().getResults();
                //movies = response.body().getResults();


                /*MovieResponses responses = response.body();
                response.body().getResults();*/
                //Log.d(TAG, String.valueOf(response.body().getResults().get(0).getBackdrop_path()));


              /*  if (responses != null){
                    ArrayList<Movie> movies = responses.getResults();
                    Log.d(TAG, String.valueOf(movies.size()));
                }else  {
                    response.errorBody();
                    Log.d(TAG, "ok, this is it (- -)");
                }*/
            }

            @Override
            public void onFailure(Call<MovieResponses> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });
    }
    private void  loadSlides(){
        ApiInterface apiInterface = ApiClient.getRetrofit().create(ApiInterface.class);
        Call<MovieResponses> call = apiInterface.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MovieResponses>() {
            @Override
            public void onResponse(Call<MovieResponses> call, Response<MovieResponses> response) {
                ArrayList<Movie> movies = response.body().getResults();
                SliderPagerAdapter adapter = new SliderPagerAdapter(HomeActivity.this, movies);
                sliderpager.setAdapter(adapter);
                Log.d(TAG, "Number of images received: " + movies.size());
            }
            @Override
            public void onFailure(Call<MovieResponses> call, Throwable t) {
                Log.e(TAG, t.toString());
            }
        });

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void onMovieClick(Movie movieResponses, ImageView movieImageView) {
        // send movieResponses interface to detail activity
        // create the transition animation btw the two activities

        Intent intent = new Intent(this, DetailActivity.class);
        // send movieResponses information to detail Activity
        intent.putExtra("title", movieResponses.getTitle());
        intent.putExtra("imgURL", movieResponses.getPoster_path());
        intent.putExtra("imgCover", movieResponses.getBackdrop_path());


        // animation
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(HomeActivity.this, movieImageView, "sharedName");
        startActivity(intent, options.toBundle());


        //testing when it is clicked
        Toast.makeText(this, "clicked:" + movieResponses.getTitle(), Toast.LENGTH_LONG).show();

    }

    class SliderTimer   extends TimerTask{

        @Override
        public void run() {

            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if (sliderpager.getCurrentItem()< movies.size()-1){
                        sliderpager.setCurrentItem(sliderpager.getCurrentItem()+1);
                    }
                    else
                        sliderpager.setCurrentItem(0);
                }
            });


        }
    }

}
