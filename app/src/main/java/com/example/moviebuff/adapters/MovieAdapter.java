package com.example.moviebuff.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.example.moviebuff.R;
import com.example.moviebuff.models.MovieResponses;
import com.example.moviebuff.models.Movie;
import com.example.moviebuff.ui.MovieItemClickListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {

    Context context;
    ArrayList<Movie> movies;
    public static final String IMAGE_URL_BASE_PATH="http://image.tmdb.org/t/p/w342//";


    MovieItemClickListener movieItemClickListener;

    public MovieAdapter(Context context, ArrayList<Movie> movies,  MovieItemClickListener movieItemClickListener) {
        this.context = context;
        this.movies = movies;
        this.movieItemClickListener = movieItemClickListener;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        String image_url = IMAGE_URL_BASE_PATH + movies.get(i).getPoster_path();
        myViewHolder.TvTitle.setText(movies.get(i).getTitle());

        Picasso.get()
                .load(image_url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(myViewHolder.ImgMovie);

    }


    @Override
    public int getItemCount() {
        return movies.size();
    }





    public class  MyViewHolder extends RecyclerView.ViewHolder{

        private TextView TvTitle;
        private ImageView ImgMovie;



        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            TvTitle = itemView.findViewById(R.id.item_movie_title);
            ImgMovie = itemView.findViewById(R.id.item_movie_imgimageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    movieItemClickListener.onMovieClick(movies.get(getAdapterPosition()), ImgMovie);
                }
            });
        }
    }
}
