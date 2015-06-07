package com.reyes.devassessment.asynctask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.reyes.devassessment.adapters.MovieArrayAdapter;
import com.reyes.devassessment.fragments.MovieListFragment;
import com.reyes.devassessment.json.Movie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

public class BackdropDownloaderAsyncTask extends AsyncTask<Void, Void, Void> {

	private Movie movie;
	private Bitmap posterBitmap;
	private MovieArrayAdapter adapter;
	private MovieListFragment movieListFragment;

	public BackdropDownloaderAsyncTask(Movie movie,
									   MovieArrayAdapter adapter,
									   MovieListFragment movieListFragment) {
		this.movie = movie;
		this.adapter = adapter;
		this.movieListFragment = movieListFragment;
	}

	@Override
	protected Void doInBackground(Void... params) {
		InputStream is;
		try {
			if (!movie.getBackdropUrl().equals("")) {
				URL ulrn = new URL(movie.getBackdropUrl());
				HttpURLConnection con = (HttpURLConnection) ulrn
						.openConnection();
				is = con.getInputStream();
				posterBitmap = BitmapFactory.decodeStream(is);
			} else {
				posterBitmap = null;

				// channelListFragment.loadNextLogo();
				// this.cancel(true);
			}
		} catch (IOException e) {
			Log.e("No Resource", "Image resource not found");
			posterBitmap = null;
		}
		return null;
	}

	@Override
	protected void onPostExecute(Void param) {
		super.onPostExecute(param);
//		movie.setLogoLoaded(true);
		if (posterBitmap != null) {
			movie.setBackdrop(posterBitmap);
			posterBitmap = null;
		} else {
//			if (movieListFragment != null)
//				movie.setLogo(BitmapFactory.decodeResource(
//						channelListFragment.getResources(),
//						R.drawable.no_img_avail));
		}
		adapter.notifyDataSetChanged();
		movieListFragment.loadNextBackdrop();
	}

}
