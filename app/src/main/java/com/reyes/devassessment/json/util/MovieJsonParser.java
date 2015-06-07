package com.reyes.devassessment.json.util;

import android.util.Log;

import com.reyes.devassessment.json.Movie;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by steven on 6/6/15.
 */

public class MovieJsonParser {
    public static List<Movie> parseJson(String jsonString) {
        try {
            JSONArray moviesJsonArray = new JSONArray(jsonString);
            Movie[] movieArray = new Movie[moviesJsonArray.length()];
            for(int i = 0; i < moviesJsonArray.length(); i++) {
                JSONObject movieJsonObj = moviesJsonArray.getJSONObject(i);
                Movie movie = new Movie(parseMovieGenres(movieJsonObj.getJSONArray(Movie.TAG_GENRES)),
                        movieJsonObj.getInt(Movie.TAG_ID),
                        movieJsonObj.getString(Movie.TAG_IMDB_CODE),
                        movieJsonObj.getString(Movie.TAG_LANGUAGE),
                        movieJsonObj.getString(Movie.TAG_MPA_RATING),
                        movieJsonObj.getString(Movie.TAG_OVERVIEW),
                        movieJsonObj.getDouble(Movie.TAG_RATING),
                        movieJsonObj.getInt(Movie.TAG_RUNTIME),
                        movieJsonObj.getString(Movie.TAG_SLUG),
                        movieJsonObj.getString(Movie.TAG_STATE),
                        movieJsonObj.getString(Movie.TAG_TITLE),
                        movieJsonObj.getString(Movie.TAG_TITLE_LONG),
                        movieJsonObj.getString(Movie.TAG_URL),
                        movieJsonObj.getInt(Movie.TAG_YEAR));
                movieArray[i] = movie;
            }
            return new ArrayList<Movie>(Arrays.asList(movieArray));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static List<String> parseMovieGenres(JSONArray moviesJsonArray) throws JSONException {
        List<String> genres = new ArrayList<>();
        for(int j=0;j<moviesJsonArray.length();j++)
        {
            String genre = moviesJsonArray.getString(j);
            genres.add(genre);
        }
        return genres;
    }
}
