package com.reyes.devassessment.asynctask;

import android.os.AsyncTask;

import com.reyes.devassessment.fragments.MovieListFragment;
import com.reyes.devassessment.json.MovieQuery;
import com.reyes.devassessment.json.util.MovieQueryJsonParser;
import com.reyes.devassessment.util.ServiceHandler;

/**
 * Created by steven on 6/6/15.
 */
public class MoviesGetAsyncTask extends AsyncTask<String, String, String> {

    private MovieListFragment movieListFrag;
    private ServiceHandler serviceHandler;
    private MovieQuery movieQuery;

    public MoviesGetAsyncTask(MovieListFragment movieListFrag) {
        serviceHandler = new ServiceHandler();
        this.movieListFrag = movieListFrag;
    }

    @Override
    protected String doInBackground(String... urls) {
        String jsonString = "";
        try {
            jsonString = serviceHandler.makeServiceCall(urls[0],
                    ServiceHandler.GET);
            this.movieQuery = MovieQueryJsonParser.parseJson(jsonString);
        } catch (Exception e) {
            this.movieQuery = null;
            e.printStackTrace();
        }
        return jsonString;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (this.movieQuery != null)
            movieListFrag.populateListView(this.movieQuery.getMovieData().getMovies());
        else
            movieListFrag.displayNoDataFound();
    }
}
