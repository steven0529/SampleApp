package com.reyes.devassessment.fragments;

import android.app.Fragment;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;

import com.reyes.devassessment.R;
import com.reyes.devassessment.activities.MovieActivity;
import com.reyes.devassessment.activities.MovieInfoActivity;
import com.reyes.devassessment.adapters.MovieArrayAdapter;
import com.reyes.devassessment.asynctask.BackdropDownloaderAsyncTask;
import com.reyes.devassessment.asynctask.MoviesGetAsyncTask;
import com.reyes.devassessment.json.Movie;
import com.reyes.devassessment.util.ListManager;
import com.reyes.devassessment.view.MovieListItemViewHolder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by steven on 6/6/15.
 */
public class MovieListFragment extends Fragment {

    private MovieArrayAdapter adapter;
    private ListManager<Movie> movieListManager;
    private Queue<BackdropDownloaderAsyncTask> logoDownloaderQueue = new LinkedList<BackdropDownloaderAsyncTask>();

    private List<Movie> movies;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movies_list, container, false);
        AdapterView<Adapter> moviesAdapterView =  (AdapterView<Adapter>) view.findViewById(R.id.lvMovies);
        movieListManager = new ListManager<>(getActivity(),
                moviesAdapterView,
                view.findViewById(R.id.tvNoDataFound),
                view.findViewById(R.id.loadingPanel),
                R.layout.movie_item,
                Movie.class);

        moviesAdapterView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                MovieListItemViewHolder viewHolder = (MovieListItemViewHolder) view
                        .getTag();
                Movie movie = viewHolder.getMovie();

                if ((getResources().getConfiguration().screenLayout &
                        Configuration.SCREENLAYOUT_SIZE_MASK) ==
                        Configuration.SCREENLAYOUT_SIZE_LARGE) {
                    ((MovieActivity)getActivity()).setMovie(movie);
                } else {
                    Intent intent = new Intent(getActivity(), MovieInfoActivity.class);
                    intent.putExtra("movie", movie);
                    startActivity(intent);
                }
            }
        });
        MoviesGetAsyncTask moviesGet = new MoviesGetAsyncTask(this);
        moviesGet.execute(getString(R.string.json_link1));
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (logoDownloaderQueue != null && !logoDownloaderQueue.isEmpty())
            for (int i = 0; i < logoDownloaderQueue.size(); i++)
                logoDownloaderQueue.remove().cancel(true);
    }

    public void populateListView(List<Movie> movies) {
        this.movies = movies;
        if (movieListManager != null)
            adapter = (MovieArrayAdapter) movieListManager.populateList(movies, MovieArrayAdapter.class);
        startLoadingBackdrops();
        if ((getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) ==
                Configuration.SCREENLAYOUT_SIZE_LARGE)
            ((MovieActivity)getActivity()).setMovie(movies.get(0));
    }

    public void displayNoDataFound() {
        if (movieListManager != null)
            movieListManager.displayNoDataFound();
    }

    private void startLoadingBackdrops() {
        if (movies != null && !movies.isEmpty()) {
            logoDownloaderQueue.clear();
            for (int i = 0; i < movies.size(); i++) {
                Movie movie = movies.get(i);
                logoDownloaderQueue.add(new BackdropDownloaderAsyncTask(movie,
                        adapter, this));
            }
            loadNextBackdrop();
        }
    }

    public void loadNextBackdrop() {
        if (!logoDownloaderQueue.isEmpty()) {
            logoDownloaderQueue.remove().execute();
        }
    }
}
