package com.teamme;

import java.io.IOException;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionView extends Activity implements Constants {

	private AlertDialog mAlert;
	private View mToastView;
	private Handler mHandler;
	// private AlertDialog.Builder mBuilder = new
	// AlertDialog.Builder(MainApplication.getAppContext());
	// private LayoutInflater mInflater = (LayoutInflater)
	// MainApplication.getAppContext()
	// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	private AlertDialog.Builder mBuilder;
	private LayoutInflater mInflater;
	private WindowManager.LayoutParams mWindowsManager;
	private Message mMsg = new Message();

	CharSequence[] items = null;
	CharSequence[] itemsRIGHT = { "K", "F", "O", "W" };
	CharSequence[] itemsLEFT = { "H2", "N2", "O2", "K2" };

	String question = null;
	String questionRIGHT = "This element is very flammable and is found in the air we breathe:";
	String questionLEFT = "What gas is comprised of the most abundant element in the universe?";

	public QuestionView() {
		super();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		buildQuestion();
	}

	private void buildQuestion() {

		mBuilder = new AlertDialog.Builder(QuestionView.this);
		mInflater = (LayoutInflater) QuestionView.this
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		if (isLEFT) {
			mBuilder.setTitle(questionLEFT);
			items = itemsLEFT;
		} else {
			mBuilder.setTitle(questionRIGHT);
			items = itemsRIGHT;
		}

		mToastView = mInflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		mBuilder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {

						if ((isLEFT && items[item] != "H2") || (!isLEFT
								&& items[item] != "O")) {
							Toast.makeText(QuestionView.this,
									"WRONG! Try Again!", Toast.LENGTH_SHORT)
									.show();
						} else {
							buildCorrectToast("CORRECT!");
						}
					}
				});

		mAlert = mBuilder.create();
		mAlert.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mWindowsManager = mAlert.getWindow().getAttributes();
//		mWindowsManager.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
		mWindowsManager.gravity = Gravity.CENTER_VERTICAL;
//		mWindowsManager.x = 100; // x position
		mAlert.show();
	}

	private void buildCorrectToast(String message) {

		// HACK - setting x to way off to make it "disappear" for now
		// TODO: how to make dismiss the alert box permenantly? Not in the UI
		// thread?
//		mWindowsManager.x = 1000; // x position
		mAlert.dismiss();

		TextView text = (TextView) mToastView.findViewById(R.id.text);
		text.setText(message);

		Toast toast = new Toast(QuestionView.this);
//		toast.setGravity(Gravity.CENTER_VERTICAL, 300, 300);
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(mToastView);
		toast.show();
		
		LoadActivityASYNC task = new LoadActivityASYNC();
		task.execute();

	}


	public void setHandler(Handler handler) {
		mHandler = handler;
	}

	private class LoadActivityASYNC extends AsyncTask<String, Void, String> {

		@Override
		protected String doInBackground(String... params) {

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			Intent intent = null;
			
			if (isLEFT) 
				intent = new Intent(QuestionView.this, TeamMeViewLEFT.class);
			else 
				intent = new Intent(QuestionView.this, TeamMeViewRIGHT.class);
			
			startActivity(intent);
			finish();

			return null;
		}

	}
	
}
