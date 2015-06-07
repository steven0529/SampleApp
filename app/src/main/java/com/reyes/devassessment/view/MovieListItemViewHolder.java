package com.reyes.devassessment.view;

import android.widget.ImageView;
import android.widget.TextView;

import com.reyes.devassessment.json.Movie;

/**
 * Created by steven on 6/6/15.
 */
public class MovieListItemViewHolder {

    private Movie movie;
    private TextView tvTitle, tvYearReleased;
    private ImageView ivBackdrop;

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public TextView getTvTitle() {
        return tvTitle;
    }

    public void setTvTitle(TextView tvTitle) {
        this.tvTitle = tvTitle;
    }

    public TextView getTvYearReleased() {
        return tvYearReleased;
    }

    public void setTvYearReleased(TextView tvYearReleased) {
        this.tvYearReleased = tvYearReleased;
    }

    public ImageView getIvBackdrop() {
        return ivBackdrop;
    }

    public void setIvBackdrop(ImageView ivBackdrop) {
        this.ivBackdrop = ivBackdrop;
    }
}
