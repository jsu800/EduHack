package com.teamme;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements AnimationListener,
		Constants {

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

		// SmiSdk.getAppSDAuth(
		// "dmi-att-hack-68fcfe5e708bfaa3806c4888912ea6f2ecb446fd", this,
		// null, R.drawable.ic_green, true);

		setContentView(R.layout.login_layout);

		//
		// Intent intent = new Intent(MainActivity.this,
		// ImageMosaicContinuityView.class);
		// startActivity(intent);
		// finish();
		//

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


}
