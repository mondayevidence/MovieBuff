package com.example.moviebuff.activities;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.moviebuff.R;
import com.example.moviebuff.adapters.CastAdapter;
import com.example.moviebuff.models.Cast;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private ImageView MovieThumbnailImg, MOvieCoverImg, rating_star;
    private TextView tv_title, tv_description, rating;
    private FloatingActionButton playfab;
    private RecyclerView RvCast;
    private CastAdapter castAdapter;
    public  static final  String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        //ini views
        iniViews();
        // list of casts
        setupRvCast();

    }

    void iniViews(){
        RvCast = findViewById(R.id.rv_cast);

        playfab = findViewById(R.id.play_fab);
        String movieTitle = getIntent().getExtras().getString("title");
        int imageResourceId = getIntent().getExtras().getInt("imgURL");
        int imagecover = getIntent().getExtras().getInt("imgCover");

        rating_star = findViewById(R.id.detail_image_star_rating);
        rating = findViewById(R.id.detail_movie_rating);

        //String image_url = IMAGE_URL_BASE_PATH + getExtras

        MovieThumbnailImg = findViewById(R.id.detail_movie_img);
        Glide.with(this).load(imageResourceId).into(MovieThumbnailImg);
        MovieThumbnailImg.setImageResource(imageResourceId);

        MOvieCoverImg = findViewById(R.id.detail_movie_cover);
        Glide.with(this).load(imagecover).into(MOvieCoverImg);

        tv_title = findViewById(R.id.detail_movie_title);
        tv_title.setText(movieTitle);
        getSupportActionBar().setTitle(movieTitle);
        tv_description = findViewById(R.id.detail_movie_desc);

        // animation
        MOvieCoverImg.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));
        playfab.setAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_animation));

    }

    void setupRvCast(){
        List<Cast> mdata = new ArrayList<>();
        mdata.add(new Cast("name", R.drawable.cate));
        mdata.add(new Cast("name", R.drawable.johnny));
        mdata.add(new Cast("name", R.drawable.hugh));
        mdata.add(new Cast("name", R.drawable.scarlett));
        mdata.add(new Cast("name", R.drawable.robert));

        castAdapter = new CastAdapter(this, mdata);
        RvCast.setAdapter(castAdapter);
        RvCast.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }
}
