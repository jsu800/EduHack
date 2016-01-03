package com.teamme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import com.datami.smi.SdState;
import com.datami.smi.SdStateChangeListener;
import com.datami.smi.SmiResult;
import com.datami.smi.SmiSdk;

public class MainApplication extends Application implements
		SdStateChangeListener, Constants {

	private static Context context;
	private Context mContext;

	@Override
	public void onCreate() {
		super.onCreate();
		
		System.out.println("MainApplication: onCreate()");
		
		context = getApplicationContext();
		mContext = this;
		try {

//			SmiSdk.getAppSDAuth(
//					"dmi-att-hack-68fcfe5e708bfaa3806c4888912ea6f2ecb446fd", this,
//					null, R.drawable.ic_green, true);

			SmiSdk.getAppSDAuth(
					"dmi-att-hack-68fcfe5e708bfaa3806c4888912ea6f2ecb446fd", this,
					null, R.drawable.logo_carcierge, true);

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Context getAppContext() {
		return context;
	}

	@Override
	public void onChange(SmiResult currentSdState) {
		System.out.println(">>> state : " + currentSdState.getSdState());
		if (currentSdState.getSdState() == SdState.SD_NOT_AVAILABLE) {
			System.out.println(">>> sdReason: " + currentSdState.getSdReason());
		} else {

			
			if (isRealApp) {
				// Activate the Login Intent from here then on
				Intent intent = new Intent(MainApplication.this,
						LoginView.class);
				startActivity(intent);		
			} else {
				LoadActivityASYNC task = new LoadActivityASYNC();
				task.execute();				
			}


		}

	}

	private class LoadActivityASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			for (int i = 0; i < 1; i++) {
				GET("http://www.att.com/");
			}
			return null;
		}

	}

	public static String GET(String url) {

		System.out.println("HTTP GET ...");

		InputStream inputStream = null;
		String result = "";
		try {

			// create HttpClient
			HttpClient httpclient = new DefaultHttpClient();

			// make GET request to the given URL
			HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

			// receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();

			// convert inputstream to string
			if (inputStream != null) {
				result = convertInputStreamToString(inputStream);
				System.out.println("HTTP GET WORKS!");
			} else
				System.out.println("HTTP GET DID NOT WORK!");

		} catch (Exception e) {
			Log.i("InputStream", e.getLocalizedMessage());
			System.out.println("InputStream" + e.getLocalizedMessage());
		}

		System.out.println(result);

		return result;
	}

	// convert inputstream to String
	private static String convertInputStreamToString(InputStream inputStream)
			throws IOException {
		BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(inputStream));
		String line = "";
		String result = "";
		while ((line = bufferedReader.readLine()) != null)
			result += line;

		inputStream.close();
		return result;

	}

}
