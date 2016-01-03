package com.teamme;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.datami.smi.SdStateChangeListener;
import com.datami.smi.SmiResult;
import com.datami.smi.SmiSdk;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements AnimationListener,
		Constants, SdStateChangeListener {

	private static final String TAG = "MainActivity";

	LinearLayout mCardShufflingLayout;
	ImageView mImageViewCard1, mImageViewCard2, mImageViewCard3;
	Animation mAnimationCardTransitionOut, mAnimationCardTransitionIn;
	boolean transitionAlreadyStarted = false;
	boolean isFirstCardOut = false;

	public MainActivity() {
		Log.i(TAG, "Instantiated new " + this.getClass());
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.i(TAG, "called onCreate");
		super.onCreate(savedInstanceState);

		SmiSdk.getAppSDAuth(
				"dmi-att-hack-68fcfe5e708bfaa3806c4888912ea6f2ecb446fd", this,
				null, R.drawable.ic_green, true);

		setContentView(R.layout.login_layout);

		//
		// Intent intent = new Intent(MainActivity.this,
		// ImageMosaicContinuityView.class);
		// startActivity(intent);
		// finish();
		//

	}

	private class LoadActivityASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			for (int i = 0; i < 5; i++) {
				GET("http://www.att.com");
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

	@Override
	public void onPause() {
		super.onPause();
	}

	@Override
	public void onResume() {
		super.onResume();

	}

	public void onDestroy() {
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		Log.i(TAG, "called onCreateOptionsMenu");
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Log.i(TAG, "called onOptionsItemSelected; selected item: " + item);
		return true;
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onAnimationEnd(Animation animation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onChange(SmiResult result) {
		// TODO Auto-generated method stub

		System.out.println("==================== " + result.getSdState());

		LoadActivityASYNC task = new LoadActivityASYNC();
		task.execute();

	}

	// private void buildQuestion() {
	// final CharSequence[] items = { "Cat", "Mouse", "Human", "Dog" };
	//
	// mToastView = mInflater.inflate(R.layout.toast,
	// (ViewGroup) findViewById(R.id.toast_layout_root));
	//
	// mBuilder.setTitle("What is this animal?");
	// mBuilder.setSingleChoiceItems(items, -1,
	// new DialogInterface.OnClickListener() {
	// public void onClick(DialogInterface dialog, int item) {
	//
	// if (items[item] != "Dog") {
	// Toast.makeText(getContext(), "WRONG! Try Again!",
	// Toast.LENGTH_SHORT).show();
	// } else {
	// buildCorrectToast("Yes it is a DOG!");
	// }
	// }
	// });
	//
	// mAlert = mBuilder.create();
	// mAlert.requestWindowFeature(Window.FEATURE_NO_TITLE);
	// mWindowsManager = mAlert.getWindow().getAttributes();
	// mWindowsManager.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
	// mWindowsManager.x = 100; // x position
	// mAlert.show();
	// }
	//
	// private void buildCorrectToast(String message) {
	//
	// // HACK - setting x to way off to make it "disappear" for now
	// // TODO: how to make dismiss the alert box permenantly? Not in the UI
	// // thread?
	// mWindowsManager.x = 1000; // x position
	// mAlert.dismiss();
	//
	// TextView text = (TextView) mToastView.findViewById(R.id.text);
	// text.setText(message);
	//
	// Toast toast = new Toast(getContext());
	// toast.setGravity(Gravity.CENTER_VERTICAL, 600, 100);
	// toast.setDuration(Toast.LENGTH_LONG);
	// toast.setView(mToastView);
	// toast.show();
	//
	// }

}
