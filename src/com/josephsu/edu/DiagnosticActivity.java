package com.josephsu.edu;



import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class DiagnosticActivity extends Activity {

	private static final String TAG = "DiagnosticActivity";


	ImageView mDiagnosticImageView;

	public DiagnosticActivity() {
		Log.i(TAG, "Instantiated new " + this.getClass());
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		Log.i(TAG, "called onCreate");
		super.onCreate(savedInstanceState);

		
		setContentView(R.layout.diagnostic_view);

		mDiagnosticImageView = (ImageView) findViewById(R.id.imageViewDiagnosticId);
		mDiagnosticImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				System.out.println("mDiagnosticImageView");
			}
		});

		
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
