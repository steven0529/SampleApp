package com.reyes.devassessment.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reyes.devassessment.R;
import com.reyes.devassessment.asynctask.ImageDownloaderAsyncTask;
import com.reyes.devassessment.json.Movie;
import com.reyes.devassessment.view.MovieListItemViewHolder;

/**
 * Created by steven on 6/6/15.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    private Context context;
    private int layoutResourceId;
    private Movie data[] = null;

    public MovieArrayAdapter(Context context, int layoutResourceId, Movie[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row = convertView;
        MovieListItemViewHolder viewHolder = null;
        if (row == null) {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            viewHolder = new MovieListItemViewHolder();
            viewHolder.setTvTitle((TextView) row.findViewById(R.id.tvTitle));
            viewHolder.setTvYearReleased((TextView) row.findViewById(R.id.tvYearReleased));
            viewHolder.setIvBackdrop((ImageView) row.findViewById(R.id.ivBackdrop));
            row.setTag(viewHolder);
        } else {
            viewHolder = (MovieListItemViewHolder) row.getTag();
        }

        Movie movie = data[position];
        viewHolder.setMovie(movie);
        viewHolder.getTvTitle().setText(movie.getTitle());
        viewHolder.getTvYearReleased().setText(movie.getYear() + "");
        viewHolder.getIvBackdrop().setImageBitmap(movie.getBackdrop());
        return row;

    }
}
