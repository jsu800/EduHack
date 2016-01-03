package com.teamme;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class LoginView extends Activity implements Constants {

	Button mEdukateLoginButton;
	ImageView mEdukateLogoHeader;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.login_layout);

		// load image
		mEdukateLogoHeader = (ImageView) findViewById(R.id.imageViewEduKLogoId);

		// load button
		mEdukateLoginButton = (Button) findViewById(R.id.loginButtonId);
		mEdukateLoginButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				
				Intent intent = null;
				
				if (isLEFT) {
					
					intent = new Intent(LoginView.this, TopicViewLEFT.class);
					
				} else {
					
					intent = new Intent(LoginView.this, TopicViewRIGHT.class);					
				}
								
				startActivity(intent);
				finish();
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
		// stopListening();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		// stopListening();
	}

}
