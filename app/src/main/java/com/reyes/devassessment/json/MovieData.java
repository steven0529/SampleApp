package com.reyes.devassessment.json;

import java.util.List;

/**
 * Created by steven on 6/6/15.
 */
public class MovieData {

    public static final String TAG_MOVIES = "movies";
    public static final String TAG_PAGE_NO = "page_number";

    private List<Movie> movies;
    private int pageNumber;

    public MovieData(List<Movie> movies, int pageNumber) {
        this.movies = movies;
        this.pageNumber = pageNumber;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
}
