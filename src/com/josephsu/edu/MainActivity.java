package com.josephsu.edu;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class MainActivity extends Activity implements AnimationListener {

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

		setContentView(R.layout.main_view);
		
		Intent intent = new Intent(MainActivity.this,
				ImageMosaicContinuityView.class);
		startActivity(intent);
		finish();


//		mCardShufflingLayout = (LinearLayout) findViewById(R.id.cardShufflingLayoutId);
//		
//		// Load animations
//		loadCardTransitions();
//
//		mImageViewCard1 = (ImageView) findViewById(R.id.imageViewCard1Id);
//		mImageViewCard2 = (ImageView) findViewById(R.id.imageViewCard2Id);
//		mImageViewCard3 = (ImageView) findViewById(R.id.imageViewCard3Id);
//
//		mImageViewCard1.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				System.out.println("mImageViewCard1");
//				Intent intent = new Intent(MainActivity.this,
//						GasStationListActivity.class);
//				startActivity(intent);
//
//			}
//		});
//
//		mImageViewCard2.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				System.out.println("mImageViewCard2");
//				Intent intent = new Intent(MainActivity.this,
//						DiagnosticActivity.class);
//				startActivity(intent);
//
//			}
//		});
//
//		mImageViewCard3.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				System.out.println("mImageViewCard3");
//				// start card #1 shuffling animation
//				startCardTransitions();
//			}
//		});

	}

	private void startCardTransitions() {

//		if (!transitionAlreadyStarted) {
//			transitionAlreadyStarted = true;
//			isFirstCardOut = true;
//			mCardShufflingLayout.startAnimation(mAnimationCardTransitionOut);
//		}
	}

	private void loadCardTransitions() {

//		mAnimationCardTransitionOut = AnimationUtils.loadAnimation(
//				getApplicationContext(), R.anim.card_shuffling_out);
//		mAnimationCardTransitionOut.setAnimationListener(this);
//
//		mAnimationCardTransitionIn = AnimationUtils.loadAnimation(
//				getApplicationContext(), R.anim.card_shuffling_in);
//		mAnimationCardTransitionIn.setAnimationListener(this);

	
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

//		if (isFirstCardOut == true) {
//			mCardShufflingLayout.startAnimation(mAnimationCardTransitionIn);
//			isFirstCardOut = false;
//		}
	}
}
