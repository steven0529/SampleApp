package com.reyes.devassessment.asynctask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

public class ImageDownloaderAsyncTask extends AsyncTask<String, String, String> {

	private static Bitmap image;
	private ImageView imageView;

	public ImageDownloaderAsyncTask(ImageView imageView) {
		this.imageView = imageView;
	}

	@Override
	protected String doInBackground(String... params) {
		InputStream is;
		try {
			URL ulrn = new URL(params[0]);
			HttpURLConnection con = (HttpURLConnection) ulrn.openConnection();
			is = con.getInputStream();
			image = Bitmap.createBitmap(BitmapFactory.decodeStream(is));
		} catch (IOException e) {
			image = null;
			Log.e("No Resource", "Image resource not found");
		}
		return "";
	}

	@Override
	protected void onPostExecute(String param) {
		super.onPostExecute(param);
		if (image != null) {
			imageView.setImageBitmap(image);
		}
	}

}
