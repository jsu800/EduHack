package com.josephsu.edu;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

public class GasStationListActivity extends Activity {

	private static final String TAG = "GasStationListActivity";


	ImageView mGasStationListImageView;

	public GasStationListActivity() {
		Log.i(TAG, "Instantiated new " + this.getClass());
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.i(TAG, "called onCreate");
		super.onCreate(savedInstanceState);

		
		setContentView(R.layout.list_row);

//		mGasStationListImageView = (ImageView) findViewById(R.id.imageViewGasStationListId);
//		mGasStationListImageView.setOnClickListener(new OnClickListener() {
//			@Override
//			public void onClick(View v) {
//				System.out.println("mGasStationListImageView");
//			}
//		});

		
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


}
