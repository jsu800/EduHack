package com.teamme;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoHalfContinuityView extends Activity implements
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

	boolean transitionAlreadyStarted = false;

	Bitmap rsrcBitmap = null;
	boolean isSplit = false;
	long lastTime = 0;
	boolean isFirstTime = true;

	LinearLayout.LayoutParams lp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		if (isLEFT)
			setContentView(R.layout.movie_mosaic_view_left);
		else
			setContentView(R.layout.movie_mosaic_view_right);
		loadImageViews();
		loadVideo();
	}

	private void loadImageViews() {

		mVideoView = (VideoView) findViewById(R.id.imageViewCenter);

		if (isLEFT) {

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

		} else {
			mImageMosaicViewTop5 = (ImageView) findViewById(R.id.imageViewTop5);
			mImageMosaicViewTop6 = (ImageView) findViewById(R.id.imageViewTop6);
			mImageMosaicViewTop7 = (ImageView) findViewById(R.id.imageViewTop7);
			mImageMosaicViewTop8 = (ImageView) findViewById(R.id.imageViewTop8);
			mImageMosaicViewBottom5 = (ImageView) findViewById(R.id.imageViewBottom5);
			mImageMosaicViewBottom6 = (ImageView) findViewById(R.id.imageViewBottom6);
			mImageMosaicViewBottom7 = (ImageView) findViewById(R.id.imageViewBottom7);
			mImageMosaicViewBottom8 = (ImageView) findViewById(R.id.imageViewBottom8);

			mThumbnailTopLayout = (LinearLayout) findViewById(R.id.imageViewLayoutTopRight);
			mThumnailBottomLayout = (LinearLayout) findViewById(R.id.imageViewLayoutBottomRight);
		}

	}

	private void loadVideo() {
		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		mVideoView = (VideoView) findViewById(R.id.imageViewCenter);
		mVideoView.setMediaController(new MediaController(this));
		Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
				+ R.raw.aurelio_casillas);
		mVideoView.setVideoURI(video);
		mVideoView.start();

		if (isLEFT) {

			lp.setMargins(1200, 0, -1000, 0);
			mThumbnailTopLayout.setVisibility(View.GONE);
			mThumnailBottomLayout.setVisibility(View.GONE);

		} else {
			lp.setMargins(-640, 0, 640, 0);
		}
		mVideoView.setLayoutParams(lp);

		mVideoView.setClickable(true);
		mVideoView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// System.out.println(mVideoView);
				// mVideoView.stopPlayback();
				lp.setMargins(0, 0, 0, 0);
				mVideoView.setLayoutParams(lp);
				return true;
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

}
