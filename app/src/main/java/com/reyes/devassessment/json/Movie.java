package com.reyes.devassessment.json;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by steven on 6/6/15.
 */
public class Movie implements Parcelable {

    public static final String TAG_GENRES = "genres";
    public static final String TAG_ID = "id";
    public static final String TAG_IMDB_CODE = "imdb_code";
    public static final String TAG_LANGUAGE = "language";
    public static final String TAG_MPA_RATING = "mpa_rating";
    public static final String TAG_OVERVIEW = "overview";
    public static final String TAG_RATING = "rating";
    public static final String TAG_RUNTIME = "runtime";
    public static final String TAG_SLUG = "slug";
    public static final String TAG_STATE = "state";
    public static final String TAG_TITLE = "title";
    public static final String TAG_TITLE_LONG = "title_long";
    public static final String TAG_URL = "url";
    public static final String TAG_YEAR = "year";

    private List<String> genres;
    private int id;
    private String imdbCode;
    private String language;
    private String mpaRating;
    private String overview;
    private double rating;
    private int runtume;
    private String slug;
    private String state;
    private String title;
    private String titleLong;
    private String url;
    private int year;
    private String backdropUrl;
    private Bitmap backdrop;
    private String coverUrl;


    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie(List<String> genres, int id, String imdbCode,
                 String language, String mpaRating, String overview,
                 double rating, int runtume, String slug,
                 String state, String title, String titleLong,
                 String url, int year) {
        this.genres = genres;
        this.id = id;
        this.imdbCode = imdbCode;
        this.language = language;
        this.mpaRating = mpaRating;
        this.overview = overview;
        this.rating = rating;
        this.runtume = runtume;
        this.slug = slug;
        this.state = state;
        this.title = title;
        this.titleLong = titleLong;
        this.url = url;
        this.year = year;
        this.backdropUrl = "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + slug + "-backdrop.jpg";
        this.coverUrl = "https://dl.dropboxusercontent.com/u/5624850/movielist/images/" + slug + "-cover.jpg";
    }

    public Movie(Parcel source) {;
        genres = new ArrayList<>();
        source.readStringList(genres);
        id = source.readInt();
        imdbCode = source.readString();
        language = source.readString();
        mpaRating = source.readString();
        overview = source.readString();
        rating = source.readDouble();
        runtume = source.readInt();
        slug = source.readString();
        state = source.readString();
        title = source.readString();
        titleLong = source.readString();
        url = source.readString();
        year = source.readInt();
        backdropUrl = source.readString();
        coverUrl = source.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringList(genres);
        dest.writeInt(id);
        dest.writeString(imdbCode);
        dest.writeString(language);
        dest.writeString(mpaRating);
        dest.writeString(overview);
        dest.writeDouble(rating);
        dest.writeInt(runtume);
        dest.writeString(slug);
        dest.writeString(state);
        dest.writeString(title);
        dest.writeString(titleLong);
        dest.writeString(url);
        dest.writeInt(year);
        dest.writeString(backdropUrl);
        dest.writeString(coverUrl);
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImdbCode() {
        return imdbCode;
    }

    public void setImdbCode(String imdbCode) {
        this.imdbCode = imdbCode;
    }

    public String getMpaRating() {
        return mpaRating;
    }

    public void setMpaRating(String mpaRating) {
        this.mpaRating = mpaRating;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getRuntume() {
        return runtume;
    }

    public void setRuntume(int runtume) {
        this.runtume = runtume;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitleLong() {
        return titleLong;
    }

    public void setTitleLong(String titleLong) {
        this.titleLong = titleLong;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBackdropUrl() {
        return backdropUrl;
    }

    public void setBackdropUrl(String backdropUrl) {
        this.backdropUrl = backdropUrl;
    }

    public Bitmap getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(Bitmap backdrop) {
        this.backdrop = backdrop;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
