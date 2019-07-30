package com.example.moviebuff.ui;

import android.widget.ImageView;
import com.example.moviebuff.models.Movie;

public interface MovieItemClickListener {

    // needed for the imageview to make the shared animation btw the activities
    void onMovieClick(Movie movie, ImageView movieImageView);
}
