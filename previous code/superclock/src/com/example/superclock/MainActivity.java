package com.example.superclock;

import java.util.Calendar;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends Activity {
	Button mButton1;
	Button mButton2;
	Button mButtonalarm1;
	Button mButtonalarm2;
	Button mButtonalarm3;
	Button mButtondel1;
	Button mButtondel2;
	Button mButtondel3;
	public int num;
	public int id;
	public int data1;
	public int data2;
	public int data3;
	public String s1;
	public String s2;
	public String s3;
	public String st;
	TextView mTextView;

	Calendar calendar;

	/** Called when the activity is first created. */

	public void updatealarms(int flag){
		int i;
		if (flag==1) {
			s1=s2;
			s2=s3;
			data1=data2;
			data2=data3;
			s3="";
			data3=0;
		}
		if (flag==2){
			s2=s3;
			data2=data3;
			s3="";
			data3=0;
		}
		if (flag==3){
			s3="";
			data3=0;
		}
		if (data1!=0){
			mButtonalarm1.setText(s1);
			mButtondel1.setText("删除");
		}
		else{
			mButtonalarm1.setText("");
			mButtondel1.setText("");
		}
		if (data2!=0){
			mButtonalarm2.setText(s2);
			mButtondel2.setText("删除");
		}
		else{
			mButtonalarm2.setText("");
			mButtondel2.setText("");
		}
		if (data3!=0){
			mButtonalarm3.setText(s3);
			mButtondel3.setText("删除");
		}
		else{
			mButtonalarm3.setText("");
			mButtondel3.setText("");
		}
	};
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		num=0;
		setContentView(R.layout.activity_main);
		calendar = Calendar.getInstance();

		mTextView = (TextView) findViewById(R.id.TextView01);
		mButton1 = (Button) findViewById(R.id.Button01);
		
		mButtonalarm1 = (Button) findViewById(R.id.Button_alarm1);
		mButtonalarm2 = (Button) findViewById(R.id.Button_alarm2);
		mButtonalarm3 = (Button) findViewById(R.id.Button_alarm3);
		mButtondel1 = (Button) findViewById(R.id.Button_del1);
		mButtondel2 = (Button) findViewById(R.id.Button_del2);
		mButtondel3 = (Button) findViewById(R.id.Button_del3);

		s1="";s2="";s3="";
		data1=0;data2=0;data3=0;
		mButton1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				calendar.setTimeInMillis(System.currentTimeMillis());
				int mHour = calendar.get(Calendar.HOUR_OF_DAY);
				int mMinute = calendar.get(Calendar.MINUTE);
				new TimePickerDialog(MainActivity.this,
						new TimePickerDialog.OnTimeSetListener() {
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								calendar.setTimeInMillis(System
										.currentTimeMillis());
								calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
								calendar.set(Calendar.MINUTE, minute);
								calendar.set(Calendar.SECOND, 0);
								calendar.set(Calendar.MILLISECOND, 0);
								/* 建立Intent和PendingIntent，来调用目标组件 */
								Intent intent = new Intent(MainActivity.this,
										AlarmReceiver.class);
								id++;
								num++;
								PendingIntent pendingIntent = PendingIntent
										.getBroadcast(MainActivity.this, id,
												intent, PendingIntent.FLAG_UPDATE_CURRENT);
								AlarmManager am;
								/* 获取闹钟管理的实例 */
								am = (AlarmManager) getSystemService(ALARM_SERVICE);
								/* 设置闹钟 */
								am.set(AlarmManager.RTC_WAKEUP, calendar
										.getTimeInMillis(), pendingIntent);
								/* 设置周期闹 */
								//am.setRepeating(AlarmManager.RTC_WAKEUP, System
								//		.currentTimeMillis()
								//		+ (10 * 1000), (24 * 60 * 60 * 1000),
								//		pendingIntent);
								String tmpS = format(hourOfDay)
										+ ":" + format(minute);
								if (num==1) {data1=id;s1=tmpS;}
								if (num==2)	{data2=id;s2=tmpS;}
								if (num==3) {data3=id;s3=tmpS;}
								
								tmpS = "设置闹钟成功！";
								mTextView.setText(tmpS);
								//显示闹钟列表
								switch(num){
									case 1:
										mButtonalarm1.setText(s1);
										mButtondel1.setText("删除");
										break;
									case 2:
										mButtonalarm2.setText(s2);
										mButtondel2.setText("删除");
										break;
									case 3:
										mButtonalarm3.setText(s3);
										mButtondel3.setText("删除");
										break;
									default:
								}
							}
						}, mHour, mMinute, true).show();
			}
		});

	//	mButton2.setOnClickListener(new View.OnClickListener() {
	//		public void onClick(View v) {
	//			Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
	//			PendingIntent pendingIntent = PendingIntent.getBroadcast(
	//					MainActivity.this, num, intent, PendingIntent.FLAG_UPDATE_CURRENT);
	//			AlarmManager am;
	//			if (num>0)
	//				num--;
	//			/* 获取闹钟管理的实例 */
	//			am = (AlarmManager) getSystemService(ALARM_SERVICE);
				/* 取消 */
	//			am.cancel(pendingIntent);
	//			mTextView.setText("闹钟已取消！");
	//		}
	//	});
	//	*/
		mButtondel1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						MainActivity.this, data1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager am;
				data1=0;
				s1="";
				if (num>0)
					num--;
				/* 获取闹钟管理的实例 */
				am = (AlarmManager) getSystemService(ALARM_SERVICE);
				/* 取消 */
				am.cancel(pendingIntent);
				mTextView.setText("闹钟已取消！");
				updatealarms(1);
			}
		});
		mButtondel2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						MainActivity.this, data2, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager am;
				data2=0;
				s2="";
				if (num>0)
					num--;
				/* 获取闹钟管理的实例 */
				am = (AlarmManager) getSystemService(ALARM_SERVICE);
				/* 取消 */
				am.cancel(pendingIntent);
				mTextView.setText("闹钟已取消！");
				updatealarms(2);
			}
		});
		mButtondel3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, AlarmReceiver.class);
				PendingIntent pendingIntent = PendingIntent.getBroadcast(
						MainActivity.this, data3, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager am;
				data3=0;
				s3="";
				if (num>0)
					num--;
				/* 获取闹钟管理的实例 */
				am = (AlarmManager) getSystemService(ALARM_SERVICE);
				/* 取消 */
				am.cancel(pendingIntent);
				mTextView.setText("闹钟已取消！");
				updatealarms(3);
			}
		});
	}

	/* 格式化字符串(7:3->07:03) */
	private String format(int x) {
		String s = "" + x;
		if (s.length() == 1)
			s = "0" + s;
		return s;
	}
}
