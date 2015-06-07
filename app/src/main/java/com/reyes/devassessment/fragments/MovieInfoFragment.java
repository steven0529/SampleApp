package com.reyes.devassessment.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reyes.devassessment.R;
import com.reyes.devassessment.asynctask.ImageDownloaderAsyncTask;
import com.reyes.devassessment.json.Movie;

/**
 * Created by steven on 6/6/15.
 */
public class MovieInfoFragment extends Fragment {

    private ImageView ivCover, ivBackdrop;
    private TextView tvTitle, tvRating, tvYearReleased, tvOverview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_info, container, false);

        ivCover = (ImageView) view.findViewById(R.id.ivCover);
        ivBackdrop = (ImageView) view.findViewById(R.id.ivBackdrop);
        tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        tvRating = (TextView) view.findViewById(R.id.tvRating);
        tvYearReleased = (TextView) view.findViewById(R.id.tvYearReleased);
        tvOverview = (TextView) view.findViewById(R.id.tvOverview);
        return view;
    }

    public void setMovie(Movie movie) {
        tvTitle.setText(movie.getTitle());
        tvRating.setText(movie.getRating() + "");
        tvYearReleased.setText(movie.getYear() + "");
        tvOverview.setText(movie.getOverview());

        ImageDownloaderAsyncTask coverImgDownloaderAsyncTask = new ImageDownloaderAsyncTask(ivCover);
        coverImgDownloaderAsyncTask.execute(movie.getCoverUrl());

        ImageDownloaderAsyncTask backdropImgDownloaderAsyncTask = new ImageDownloaderAsyncTask(ivBackdrop);
        backdropImgDownloaderAsyncTask.execute(movie.getBackdropUrl());
    }
}
