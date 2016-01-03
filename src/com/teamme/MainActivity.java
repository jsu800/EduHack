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
