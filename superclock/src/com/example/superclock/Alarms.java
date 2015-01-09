package com.example.superclock;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.os.Bundle;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Vibrator;
import com.example.superclock.ShakeDetector;
import java.util.Timer;
import java.util.TimerTask;

public class Alarms extends Activity {
	Button mButtonwake;
	private int a;
	private Toast toast;
	private int wake;
	private ShakeDetector mShake;
	private  Ringtone r;
	private Vibrator vibrator;
	private static final long[] pattern = {1000,1000,1000,1000};//设置震动响1000ms,停1000ms
	private static final int repeat = 0;//重复次数为，不过好像不太可控
	private void exec(){         
		Timer timer = new Timer();         
		timer.schedule(new TimerTask(){         
			public void run() {                          
				toast.show();      
			}              
		}, 300);
	}
	@Override
    public boolean onKeyDown( int keyCode, KeyEvent event) {
           // TODO Auto-generated method stub
           if (keyCode == event. KEYCODE_BACK) {
                 return true;
          }
           return super.onKeyDown(keyCode, event);
    }
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alarms);
		//播放系统音乐
		wake=0;
		mShake = new ShakeDetector(this);
		mButtonwake = (Button) findViewById(R.id.Buttonwake);
		Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);  
	    r = RingtoneManager.getRingtone(this,notification);  
	    r.play();  
	    //屏幕提示字
	    //Toast.makeText(this,"起床啦",Toast.LENGTH_LONG).show();
	    //震动
	    vibrator = (Vibrator)this.getSystemService(VIBRATOR_SERVICE);    
	    this.getSystemService(VIBRATOR_SERVICE);
		vibrator.vibrate(pattern, repeat);
		//vibrator.vibrate(5000);连续震动5s
		
		a= (int)(Math.random()*3)+1 ; 
		switch (a){
			case 1:
				//拍照唤醒
				toast=Toast.makeText(this, "请拍奇葩照后点击我醒了解除灾难", Toast.LENGTH_LONG);
				Intent intent = new Intent(); //调用照相机
				intent.setAction("android.media.action.STILL_IMAGE_CAMERA");
				startActivity(intent);
				toast.show();
				exec();
				wake=1;
				break;
			case 2:
				//摇动唤醒
				mShake.start();
				Toast.makeText(this, "请以5m/s2加速度摇动手机后后点击我醒了解除灾难", Toast.LENGTH_LONG).show();
				break;
			case 3:
				Intent intent2 = new Intent(); 
	            intent2.setClass(Alarms.this, AnswerQuestions.class);
	            Alarms.this.startActivity(intent2);
	            wake=1;
	            break;
		}
		mShake.registerOnShakeListener(new ShakeDetector.OnShakeListener () {
		      public void onShake()
		      {
		    	  wake=1;
		      }
		    });
		mButtonwake.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (wake==1){
					r.stop();
					vibrator.cancel();
					Alarms.this.finish();
				}
			}
		});
		}
}
