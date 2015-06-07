package com.reyes.devassessment.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.reyes.devassessment.R;
import com.reyes.devassessment.asynctask.ImageDownloaderAsyncTask;
import com.reyes.devassessment.json.Movie;

/**
 * Created by steven on 6/6/15.
 */
public class MovieInfoActivity extends ActionBarActivity {

    private ImageView ivCover, ivBackdrop;
    private TextView tvTitle, tvRating, tvYearReleased, tvOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_movie_info);
        ivCover = (ImageView) findViewById(R.id.ivCover);
        ivBackdrop = (ImageView) findViewById(R.id.ivBackdrop);
        tvTitle = (TextView) findViewById(R.id.tvTitle);
        tvRating = (TextView) findViewById(R.id.tvRating);
        tvYearReleased = (TextView) findViewById(R.id.tvYearReleased);
        tvOverview = (TextView) findViewById(R.id.tvOverview);

        Movie currMovie = (Movie) getIntent().getExtras().get("movie");
        setMovie(currMovie);

    }

    private void setMovie(Movie movie) {
        tvTitle.setText(movie.getTitle());
        tvRating.setText(movie.getRating() + "");
        tvYearReleased.setText(movie.getYear() + "");
        tvOverview.setText(movie.getOverview());

        ImageDownloaderAsyncTask coverImgDownloaderAsyncTask
                = new ImageDownloaderAsyncTask(ivCover);
        coverImgDownloaderAsyncTask.execute(movie.getCoverUrl());

        ImageDownloaderAsyncTask backdropImgDownloaderAsyncTask
                = new ImageDownloaderAsyncTask(ivBackdrop);
        backdropImgDownloaderAsyncTask.execute(movie.getBackdropUrl());
    }
}
