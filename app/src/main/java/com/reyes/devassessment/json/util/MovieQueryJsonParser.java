package com.reyes.devassessment.json.util;

import com.reyes.devassessment.json.Movie;
import com.reyes.devassessment.json.MovieQuery;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by steven on 6/6/15.
 */
public class MovieQueryJsonParser {

    public static MovieQuery parseJson(String jsonString) {
        JSONObject movieQueryJsonObj;
        try {
            movieQueryJsonObj = new JSONObject(jsonString);

            return new MovieQuery(MovieDataJsonParser.parseJson(movieQueryJsonObj.getString(MovieQuery.TAG_DATA)),
                    movieQueryJsonObj.getString(MovieQuery.TAG_STATUS),
                            movieQueryJsonObj.getString(MovieQuery.TAG_STATUS_MESSAGE));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
