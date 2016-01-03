package com.teamme;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionView extends Activity {

	private AlertDialog mAlert;
	private View mToastView;
	private Handler mHandler;
	private AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
	private LayoutInflater mInflater = (LayoutInflater) getContext()
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	private WindowManager.LayoutParams mWindowsManager;
	private Message mMsg = new Message();

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
	}

	private void buildQuestion() {
		final CharSequence[] items = { "Cat", "Mouse", "Human", "Dog" };

		mToastView = mInflater.inflate(R.layout.toast,
				(ViewGroup) findViewById(R.id.toast_layout_root));

		mBuilder.setTitle("What is this animal?");
		mBuilder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {

						if (items[item] != "Dog") {
							Toast.makeText(getContext(), "WRONG! Try Again!",
									Toast.LENGTH_SHORT).show();
						} else {
							buildCorrectToast("Yes it is a DOG!");
						}
					}
				});

		mAlert = mBuilder.create();
		mAlert.requestWindowFeature(Window.FEATURE_NO_TITLE);
		mWindowsManager = mAlert.getWindow().getAttributes();
		mWindowsManager.gravity = Gravity.CENTER_VERTICAL | Gravity.RIGHT;
		mWindowsManager.x = 100; // x position
		mAlert.show();
	}

	private void buildCorrectToast(String message) {

		// HACK - setting x to way off to make it "disappear" for now
		// TODO: how to make dismiss the alert box permenantly? Not in the UI
		// thread?
		mWindowsManager.x = 1000; // x position
		mAlert.dismiss();

		TextView text = (TextView) mToastView.findViewById(R.id.text);
		text.setText(message);

		Toast toast = new Toast(getContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 600, 100);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(mToastView);
		toast.show();

	}

	public void buildCollabDialog() {

		final CharSequence[] items = { "Yes", "No" };

		mBuilder.setTitle("Do you want to work with Joseph?");
		mBuilder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {

						if (items[item] == "Yes") {
							mMsg.obj = "COLLAB_YES";
							mHandler.sendMessage(mMsg);
						}
					}
				});

		mAlert = mBuilder.create();
		mAlert.show();
	}

	public void setHandler(Handler handler) {
		mHandler = handler;
	}

}
