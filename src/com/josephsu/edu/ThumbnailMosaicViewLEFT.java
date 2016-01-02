package com.josephsu.edu;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import android.widget.VideoView;

public class ThumbnailMosaicViewLEFT extends Activity implements
		AnimationListener, Constants {

	private Toast mToast;
	// ImageView mImageViewRIGHT, mImageViewLEFT;
	ImageView mImageMosaicViewTop1, mImageMosaicViewTop2, mImageMosaicViewTop3,
			mImageMosaicViewTop4, mImageMosaicViewTop5, mImageMosaicViewTop6,
			mImageMosaicViewTop7, mImageMosaicViewTop8,
			mImageMosaicViewBottom1, mImageMosaicViewBottom2,
			mImageMosaicViewBottom3, mImageMosaicViewBottom4,
			mImageMosaicViewBottom5, mImageMosaicViewBottom6,
			mImageMosaicViewBottom7, mImageMosaicViewBottom8, mVideoMain,
			mImageHack;

	VideoView mVideoView;
	LinearLayout mThumbnailTopLayout, mThumnailBottomLayout,
			mVideoCenterLayout;
	Animation mAnimationVideoTransition, mThumbnailTopTransition,
			mThumbnailBottomTransition;

	long lastTime = 0;
	boolean isFirstTime = true;
	boolean isFirstClick = true;

	LinearLayout.LayoutParams lp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		setContentView(R.layout.thumbnail_movie_mosaic_view_left);
		loadImageViews();
		loadThumbnailTransitions();
		startThumbnailTransitions();
	}

	private void startThumbnailTransitions() {

		mThumbnailTopLayout.startAnimation(mThumbnailTopTransition);
		mThumnailBottomLayout.startAnimation(mThumbnailBottomTransition);
	}

	private void loadThumbnailTransitions() {

		// Setting up thumbnail transition
		mThumbnailTopTransition = AnimationUtils.loadAnimation(
				getApplicationContext(), R.anim.thumbnail_transition_top_in);
		mThumbnailTopTransition.setAnimationListener(this);

		mThumbnailBottomTransition = AnimationUtils.loadAnimation(
				getApplicationContext(), R.anim.thumbnail_transition_bottom_in);
		mThumbnailBottomTransition.setAnimationListener(this);
	}

	private void loadImageViews() {

		mVideoView = (VideoView) findViewById(R.id.imageViewCenter);

		mImageMosaicViewTop1 = (ImageView) findViewById(R.id.imageViewTop1);
		mImageMosaicViewTop2 = (ImageView) findViewById(R.id.imageViewTop2);
		mImageMosaicViewTop3 = (ImageView) findViewById(R.id.imageViewTop3);
		mImageMosaicViewTop4 = (ImageView) findViewById(R.id.imageViewTop4);
		mImageMosaicViewBottom1 = (ImageView) findViewById(R.id.imageViewBottom1);
		mImageMosaicViewBottom2 = (ImageView) findViewById(R.id.imageViewBottom2);
		mImageMosaicViewBottom3 = (ImageView) findViewById(R.id.imageViewBottom3);
		mImageMosaicViewBottom4 = (ImageView) findViewById(R.id.imageViewBottom4);

		mThumbnailTopLayout = (LinearLayout) findViewById(R.id.imageViewLayoutTopLeft);
		mThumnailBottomLayout = (LinearLayout) findViewById(R.id.imageViewLayoutBottomLeft);

		// telemundo button to set off another activity
		mImageMosaicViewBottom1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				System.out.println("mImageMosaicViewBottom1");
				LoadActivityASYNC task = new LoadActivityASYNC();
				task.execute();
			}
		});

	}

	
	// DEFAULT OVERRIDES

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	// animation listeners
	@Override
	public void onAnimationEnd(Animation animation) {
	}

	@Override
	public void onAnimationStart(Animation animation) {
		// Animation started
	}

	private class LoadActivityASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// HACK
			Intent intent = new Intent(ThumbnailMosaicViewLEFT.this,
					VideoHalfContinuityView.class);
			startActivity(intent);
			finish();
			return null;
		}

	}

}
