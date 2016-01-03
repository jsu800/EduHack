package com.teamme;


import android.app.Application;
import android.content.Intent;

public class MainApplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		System.out.println("========MainApplication");
		
		
//		Intent i = new Intent(this, MainActivity.class);
//		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//		startActivity(new Intent(getApplicationContext(),MainActivity.class));
		
	}

	 	
	
}

