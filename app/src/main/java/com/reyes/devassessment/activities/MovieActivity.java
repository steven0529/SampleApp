package com.reyes.devassessment.activities;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.reyes.devassessment.R;
import com.reyes.devassessment.asynctask.MoviesGetAsyncTask;
import com.reyes.devassessment.fragments.MovieInfoFragment;
import com.reyes.devassessment.fragments.MovieListFragment;
import com.reyes.devassessment.json.Movie;
import com.reyes.devassessment.json.MovieQuery;

import java.util.List;

/**
 * Created by steven on 6/6/15.
 */
public class MovieActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }

    public void setMovie(Movie movie) {
        MovieInfoFragment movieInfoFrag = (MovieInfoFragment) getFragmentManager().findFragmentById(R.id.movieInfoFrag);
        if (movieInfoFrag != null)
            movieInfoFrag.setMovie(movie);
    }
}
