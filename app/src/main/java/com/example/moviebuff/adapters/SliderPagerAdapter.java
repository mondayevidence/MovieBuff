package com.example.moviebuff.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.moviebuff.R;
import com.example.moviebuff.models.Movie;
import com.example.moviebuff.models.SlideImage;
import com.squareup.picasso.Picasso;

import java.util.List;

import static com.example.moviebuff.adapters.MovieAdapter.IMAGE_URL_BASE_PATH;

public class SliderPagerAdapter  extends PagerAdapter {

    private Context mContext;
    private List<Movie> movies;

    public SliderPagerAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        String image_url = IMAGE_URL_BASE_PATH + movies.get(position).getBackdrop_path();


        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View slideLayout = inflater.inflate(R.layout.slider_item, null);

        ImageView slideImg = slideLayout.findViewById(R.id.slider_image);
        TextView slideText = slideLayout.findViewById(R.id.slider_title);
        slideText.setText(movies.get(position).getTitle());

        Picasso.get()
                .load(image_url)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(slideImg);
        //slideImg.setImageResource(slideImages.get(position).getImage());


        //Glide.with(mContext).load(slideImage.getUrl()).into(slideImg);
        /*Picasso.Builder builder = new Picasso.Builder(mContext);
        builder.downloader(new OkHttp3Downloader(mContext));
        builder.build().load(mList.get(position).getUrl()).placeholder(R.drawable.deadpool)
                .error(R.drawable.terminator).into(container.slideImg
        );*/

        container.addView(slideLayout);
        return  slideLayout;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
container.removeView((View)object);    }
}
