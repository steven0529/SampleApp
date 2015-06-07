package com.reyes.devassessment.json.util;

import com.reyes.devassessment.json.MovieData;
import com.reyes.devassessment.json.MovieQuery;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by steven on 6/6/15.
 */
public class MovieDataJsonParser {
    static MovieData parseJson(String jsonString) {
        JSONObject movieDataJsonObj;
        try {
            movieDataJsonObj = new JSONObject(jsonString);

            return new MovieData(
                    MovieJsonParser.parseJson(movieDataJsonObj.getString(MovieData.TAG_MOVIES)),
                    movieDataJsonObj.getInt(MovieData.TAG_PAGE_NO)
            );
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
