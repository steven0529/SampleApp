package com.reyes.devassessment.json;

import java.util.List;

/**
 * Created by steven on 6/6/15.
 */
public class MovieQuery {

    public static final String TAG_DATA = "data";
    public static final String TAG_STATUS = "status";
    public static final String TAG_STATUS_MESSAGE = "status_message";

    private MovieData movieData;
    private String status;
    private String statusMsg;

    public MovieQuery(MovieData movieData,String status, String statusMsg) {
        this.movieData = movieData;
        this.status = status;
        this.statusMsg = statusMsg;
    }

    public MovieData getMovieData() {
        return movieData;
    }

    public void setMovieData(MovieData movieData) {
        this.movieData = movieData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }

}