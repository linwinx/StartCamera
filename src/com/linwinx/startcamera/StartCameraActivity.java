package com.linwinx.startcamera;

import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class StartCameraActivity extends Activity {

	 int first = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		 super.onCreate(savedInstanceState); 
		 
		 int currentApiVersion = android.os.Build.VERSION.SDK_INT;	 
		 ComponentName componentName;
		 Log.e("StartCamera","API LEVEL: " + String.valueOf(currentApiVersion));
		 if(currentApiVersion >= 23){//android 6.0
			 componentName=new ComponentName("org.codeaurora.snapcam","com.android.camera.CameraActivity");
		 } else if ((currentApiVersion == 22) || (currentApiVersion == 21)){//android 5.0
			 componentName=new ComponentName("org.codeaurora.snapcam","com.android.camera.CameraLauncher");
		 } else if ((currentApiVersion == 20) || (currentApiVersion == 19)){//android 4.4
			 componentName=new ComponentName("com.android.camera2","com.android.camera.CameraActivity");
		 } else {//android 4.0 (currentApiVersion <= 18)
			 componentName=new ComponentName("com.android.gallery3d","com.android.camera.CameraActivity");
		 }
		 		 			       
		 Intent intentApp=new Intent();
		 intentApp.setComponent(componentName);
		 intentApp.setAction(Intent.ACTION_VIEW);
	     startActivity(intentApp);
        
         finish();
      /*    
        Button button= (Button) findViewById(R.id.start_camera);
        button.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
	      ComponentName componentName=new ComponentName("com.android.gallery3d","com.android.camera.CameraActivity");
	      Intent intent=new Intent();
	      intent.setComponent(componentName);
	      intent.setAction(Intent.ACTION_VIEW);
	      startActivity(intent);
         }
        });
        
        setContentView(R.layout.activity_start_camera);
	  */
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.start_camera, menu);
		return true;
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		
		finish();
		//System.exit(0);
		//或者下面这种方式
		//android.os.Process.killProcess(android.os.Process.myPid()); 
	}

}
