package com.teamme;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;

public class ImageMosaicContinuityView extends Activity implements
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

	float[] history = new float[1];
	String[] direction = { "NONE" };

	boolean transitionAlreadyStarted = false;

	// SensorManager sensorManager;
	// Sensor accelerometer;
	Bitmap rsrcBitmap = null;
	boolean isSplit = false;
	long lastTime = 0;
	boolean isFirstTime = true;
	boolean isFirstClick = true;

	LinearLayout.LayoutParams lp;

	// BitmapDrawable imageDrawableLeft, imageDrawableRight;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lp = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT,
				LayoutParams.MATCH_PARENT);

		if (isLEFT) {

			setContentView(R.layout.thumbnail_movie_mosaic_view_left);

//			setContentView(R.layout.movie_mosaic_view_left);
			// enableAccSensors();

		}
		else {

			setContentView(R.layout.thumbnail_movie_mosaic_view_right);
//			loadImageViews();
//			loadVideo();
		}

		loadImageViews();
		loadVideo();
		loadThumbnailTransitions();
		startThumbnailTransitions();

	}

	private void startThumbnailTransitions() {

		if (!transitionAlreadyStarted) {
			mThumbnailTopLayout.startAnimation(mThumbnailTopTransition);
			mThumnailBottomLayout.startAnimation(mThumbnailBottomTransition);
			transitionAlreadyStarted = true;
		}
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

	// animation listeners
	@Override
	public void onAnimationEnd(Animation animation) {
		// if (animation == mAnimationVideoTransition) {
		//
		// // LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
		// // LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		// //
		// // lp.setMargins(800, 0, -480, 0);
		// // mVideoView.setLayoutParams(lp);
		//
		// } else if (animation == mThumbnailTransition) {
		//
		// }

	}

	@Override
	public void onAnimationStart(Animation animation) {
		// Animation started
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

			// mImageMosaicViewTop1.getViewTreeObserver().addOnGlobalLayoutListener(
			// new MyGlobalListenerClass());

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

//			mThumbnailTopLayout.setVisibility(View.INVISIBLE);
//			mThumnailBottomLayout.setVisibility(View.INVISIBLE);

			// HACK add click listener to the 8th image
//			mImageHack = (ImageView) findViewById(R.id.imageViewInvisible);
//			loadThumbnailTransitions();
//			mImageHack.setClickable(true);
//			mImageHack.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					System.out.println("mImageHack");
//
//					if (isFirstClick) {
//						isFirstClick = false;
//						mThumbnailTopLayout.setVisibility(View.VISIBLE);
//						mThumnailBottomLayout.setVisibility(View.VISIBLE);
//						startThumbnailTransitions();
//
//						// LoadTransitionASYNC task = new LoadTransitionASYNC();
//						// task.execute();
//					}
//				}
//			});
//
//			// telemundo button to set off another activity
//			mImageMosaicViewTop8.setOnClickListener(new OnClickListener() {
//
//				@Override
//				public void onClick(View v) {
//					System.out.println("mImageMosaicViewTop8");
//					LoadActivityASYNC task = new LoadActivityASYNC();
//					task.execute();
//				}
//			});

		}

	}

	private void loadVideo() {

		System.out.println("Load Video...");

		getWindow().setFormat(PixelFormat.TRANSLUCENT);
		mVideoView = (VideoView) findViewById(R.id.imageViewCenter);
		mVideoView.setMediaController(new MediaController(this));
		Uri video = Uri.parse("android.resource://" + getPackageName() + "/"
				+ R.raw.water_drop);
		mVideoView.setVideoURI(video);

		if (isLEFT) {
			lp.setMargins(400, 0, -400, 0);

		} else {
			lp.setMargins(-640, 0, 640, 0);

		}

		mVideoView.setLayoutParams(lp);

		mVideoView.start();

//		mThumbnailTopLayout.setVisibility(View.GONE);
//		mThumnailBottomLayout.setVisibility(View.GONE);

		
		mVideoView.setClickable(true);
		mVideoView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				mVideoView.stopPlayback();
				LoadThumbnailASYNC task = new LoadThumbnailASYNC();
				task.execute();
				return false;
			}
		});

	}

	private void splitVideo() {

		if (isFirstTime) {

			if (isLEFT) {
				System.out.println("Splitting video on RIGHT...");
				mVideoView.start();
				isFirstTime = false;
			} else {
				// mVideoView.stopPlayback();
				// mVideoView.start();
				isFirstTime = false;
			}

		}

		if (isSplit)
			isSplit = false;
		else
			isSplit = true;

		if (isLEFT) {
			if (isSplit)
				lp.setMargins(400, 0, -800, 0);
			else
				lp.setMargins(0, 0, 0, 0);
		} else {
			if (isSplit)
				lp.setMargins(-600, 0, 600, 0);
			else
				lp.setMargins(0, 0, 0, 0);
		}
		mVideoView.setLayoutParams(lp);
	}

	// Declare the layout listener
	class MyGlobalListenerClass implements
			ViewTreeObserver.OnGlobalLayoutListener {
		@Override
		public void onGlobalLayout() {
			View v = (View) findViewById(R.id.imageViewTop1);
			String x = Integer.toString(v.getWidth());
			String y = Integer.toString(v.getHeight());

		}
	}

	//
	// private void enableAccSensors() {
	// sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
	// accelerometer = sensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER)
	// .get(0);
	// sensorManager.registerListener(this, accelerometer, 1000000);
	//
	// }

	@SuppressWarnings("deprecation")
	private BitmapDrawable getLeftDrawable() {
		final int START_X = 0;
		final int START_Y = 0;
		final int WIDTH_PX = getRsrcBitmap().getWidth() / 2;
		final int HEIGHT_PX = getRsrcBitmap().getHeight();
		Bitmap newBitmap = Bitmap.createBitmap(getRsrcBitmap(), START_X,
				START_Y, WIDTH_PX, HEIGHT_PX, null, false);
		return new BitmapDrawable(newBitmap);
	}

	@SuppressWarnings("deprecation")
	private BitmapDrawable getRightDrawable() {
		final int START_X = getRsrcBitmap().getWidth() / 2;
		final int START_Y = 0;
		final int WIDTH_PX = getRsrcBitmap().getWidth() / 2;
		final int HEIGHT_PX = getRsrcBitmap().getHeight();
		Bitmap newBitmap = Bitmap.createBitmap(getRsrcBitmap(), START_X,
				START_Y, WIDTH_PX, HEIGHT_PX, null, false);
		return new BitmapDrawable(newBitmap);
	}

	private Bitmap getResizedBitmapFromResource() {

		Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.ff7_600_450);
		// R.drawable.ff_1920_1200);

		int width = bitmap.getWidth();
		int height = bitmap.getHeight();

		System.out.println("width = " + width + " height = " + height);

		int newWidth = getWindowManager().getDefaultDisplay().getWidth();
		int newHeight = getWindowManager().getDefaultDisplay().getHeight();

		System.out.println("newWidth = " + newWidth + " newHeight = "
				+ newHeight);

		// calculate the scale
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;

		// createa matrix for the manipulation
		Matrix matrix = new Matrix();
		// resize the bit map
		matrix.postScale(scaleWidth, scaleHeight);

		// recreate the new Bitmap
		return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true);
	}

	// @Override
	// public void onSensorChanged(SensorEvent event) {
	//
	// final float alpha = (float) 0.8;
	// float gravity = 0;
	// long time = System.currentTimeMillis();
	//
	// // Isolate the force of gravity with the low-pass filter.
	// gravity = alpha * gravity + (1 - alpha) * event.values[0];
	//
	// // Remove the gravity contribution with the high-pass filter.
	// float xChange = history[0] - (event.values[0] - gravity);
	//
	// history[0] = event.values[0] - gravity;
	//
	// time = System.currentTimeMillis();
	// if (xChange > 2) {
	//
	// System.out.println("LEFT");
	//
	// if ((time - lastTime) > 1000)
	// splitVideo();
	// lastTime = time;
	//
	// } else if (xChange < -2) {
	//
	// System.out.println("RIGHT");
	//
	// if ((time - lastTime) > 1000)
	// splitVideo();
	// lastTime = time;
	// }
	// }
	//
	// @Override
	// public void onAccuracyChanged(Sensor sensor, int accuracy) {
	// // nothing to do here
	// }
	//
	// public void stopListening() {
	// if (isLEFT)
	// sensorManager.unregisterListener(this, accelerometer);
	// }
	//
	// private void display(String msg) {
	//
	// if (mToast != null) {
	// mToast.setText(msg);
	// mToast.show();
	// }
	// }

	public Bitmap getRsrcBitmap() {
		return rsrcBitmap;
	}

	public void setRsrcBitmap(Bitmap rsrcBitmap) {

		int width = rsrcBitmap.getWidth();
		int height = rsrcBitmap.getHeight();

		System.out.println("rsrcBitmap width = " + width
				+ "rsrcBitmap height = " + height);

		this.rsrcBitmap = rsrcBitmap;
	}

	// DEFAULT OVERRIDES

	@Override
	protected void onResume() {
		super.onResume();

	}

	@Override
	protected void onPause() {
		super.onPause();
		// stopListening();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// stopListening();
	}

	@Override
	public void onAnimationRepeat(Animation animation) {
		// TODO Auto-generated method stub

	}

	private class LoadTransitionASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			startThumbnailTransitions();
			return null;
		}

	}

	private class LoadActivityASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// HACK
			Intent intent = new Intent(ImageMosaicContinuityView.this,
					VideoHalfContinuityView.class);
			startActivity(intent);
			finish();
			return null;
		}

	}

	private class LoadThumbnailASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {
			// HACK
			Intent intent = new Intent(ImageMosaicContinuityView.this,
					ThumbnailMosaicViewLEFT.class);
			startActivity(intent);
			finish();
			return null;
		}

	}

}
