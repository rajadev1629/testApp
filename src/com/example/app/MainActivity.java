package com.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings.Secure;

import com.notikum.notifypassive.UninstallSession;
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
//		UninstallSession.init(MainActivity.this, 1);
		
		
		String uuid = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
//		System.out.println("kkkk first application test: "+uuid);if(isExternalStoragePresent()){
//			System.out.println("kkk external storage present");
//		} else{
//			System.out.println("kkk not present");
//		}
		StorageHelper helper = new StorageHelper();
		System.out.println("kkk if the external storage is available : "+helper.isExternalStorageAvailable());
		System.out.println("kkkk if the external storage is writeable : " +helper.isExternalStorageWriteable());
		System.out.println("kkk if the external storage is available : "+helper.isExternalStorageWriteable());
		
		
	}
	
	public static boolean isExternalStoragePresent() {

		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			mExternalStorageAvailable = mExternalStorageWriteable = true;
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			mExternalStorageAvailable = true;
			mExternalStorageWriteable = false;
		} else {
			mExternalStorageAvailable = mExternalStorageWriteable = false;
		}
		return (mExternalStorageAvailable) && (mExternalStorageWriteable);
	}
	
}
