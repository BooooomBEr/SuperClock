/**
 * 
 */
package com.example.superclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import com.example.superclock.ShakeDetector;
/**
 * @author Administrator
 *
 */
public class AlarmReceiver extends BroadcastReceiver {
	
	public void onReceive(final Context context, Intent intent) {
		Toast.makeText(context, "Æð´²À²Æð´²À²", Toast.LENGTH_LONG).show();
        ShakeDetector mShake = new ShakeDetector(context);
		mShake.registerOnShakeListener(new ShakeDetector.OnShakeListener () {
		      public void onShake()
		      {
		    	  Toast.makeText(context, "lalalalalala", Toast.LENGTH_LONG).show();
		      }
		    });
		mShake.start();
		}
	} 


