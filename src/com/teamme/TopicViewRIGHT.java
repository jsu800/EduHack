package com.teamme;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class TopicViewRIGHT extends Activity {

	RelativeLayout mEdukateLoadingLayout;
	ImageView mEdukateMainImageView;
	Handler mHandler;
	loadEdukateMemberASYNC task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.topic_view_layout_right);
		task = new loadEdukateMemberASYNC();
		// load layouts

		// load main view
		mEdukateMainImageView = (ImageView) findViewById(R.id.imageViewTopicRightId);
		mEdukateMainImageView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				setContentView(R.layout.loading_layout);
				mEdukateLoadingLayout = (RelativeLayout) findViewById(R.id.loadingPanel);
				
				task.execute();
			}
		});

		mHandler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.obj == "DONE") {

					// done loading
					mEdukateLoadingLayout.setVisibility(View.GONE);
					
					// load room view
					Intent intent = new Intent(TopicViewRIGHT.this,
						QuestionView.class);
					startActivity(intent);
					finish();
				}
			}
		};


	}

	private class loadEdukateMemberASYNC extends
			AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			// wait 3 seconds then go ...
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Message msg = new Message();
			msg.obj = "DONE";
			mHandler.sendMessage(msg);

			return null;
		}

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

}
