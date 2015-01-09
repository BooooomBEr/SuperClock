package com.example.superclock;

import java.util.Calendar;


import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.KeyEvent;
import android.widget.Button;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

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
	TextView mTextView1;
	TextView mTextView2;
	TextView mTextView3;
	public static final int FLAG_HOMEKEY_DISPATCHED = 0x80000000; 
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
			mTextView1.setText("闹钟1");
			mButtonalarm1.setText(s1);
			mButtondel1.setText("删除");
			mButtonalarm1.getBackground().setAlpha(255);
			mButtondel1.getBackground().setAlpha(255);
		}
		else{
			mTextView1.setText("");
			mButtonalarm1.setText("");
			mButtondel1.setText("");
			mButtonalarm1.getBackground().setAlpha(0);
			mButtondel1.getBackground().setAlpha(0);

		}
		if (data2!=0){
			mTextView2.setText("闹钟2");
			mButtonalarm2.setText(s2);
			mButtondel2.setText("删除");
			mButtonalarm2.getBackground().setAlpha(255);
			mButtondel2.getBackground().setAlpha(255);
		}
		else{
			mTextView2.setText("");
			mButtonalarm2.setText("");
			mButtondel2.setText("");
			mButtonalarm2.getBackground().setAlpha(0);
			mButtondel2.getBackground().setAlpha(0);

		}
		if (data3!=0){
			mTextView3.setText("闹钟3");
			mButtonalarm3.setText(s3);
			mButtondel3.setText("删除");
			mButtonalarm3.getBackground().setAlpha(255);
			mButtondel3.getBackground().setAlpha(255);
			
		}
		else{
			mTextView3.setText("");
			mButtonalarm3.setText("");
			mButtondel3.setText("");
			mButtonalarm3.getBackground().setAlpha(0);
			mButtondel3.getBackground().setAlpha(0);
		}
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		num=0;
		//this.getWindow().setFlags(FLAG_HOMEKEY_DISPATCHED, FLAG_HOMEKEY_DISPATCHED);
		setContentView(R.layout.activity_main);
		calendar = Calendar.getInstance();
		mTextView = (TextView) findViewById(R.id.TextView01);
		mTextView1 = (TextView) findViewById(R.id.TextView02);
		mTextView2 = (TextView) findViewById(R.id.TextView03);
		mTextView3 = (TextView) findViewById(R.id.TextView04);
		mButton1 = (Button) findViewById(R.id.Button01);
		
		mButtonalarm1 = (Button) findViewById(R.id.Button_alarm1);
		mButtonalarm2 = (Button) findViewById(R.id.Button_alarm2);
		mButtonalarm3 = (Button) findViewById(R.id.Button_alarm3);
		mButtondel1 = (Button) findViewById(R.id.Button_del1);
		mButtondel2 = (Button) findViewById(R.id.Button_del2);
		mButtondel3 = (Button) findViewById(R.id.Button_del3);
		mButtonalarm1.getBackground().setAlpha(0);
		mButtondel1.getBackground().setAlpha(0);
		mButtonalarm2.getBackground().setAlpha(0);
		mButtondel2.getBackground().setAlpha(0);
		mButtonalarm3.getBackground().setAlpha(0);
		mButtondel3.getBackground().setAlpha(0);
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
								if(System.currentTimeMillis() > calendar.getTimeInMillis()){  
									calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 1);  
									}  
								/* 建立Intent和PendingIntent，来调用目标组件 */
								Intent intent = new Intent(MainActivity.this,
										AlarmReceiver.class);
								id++;
								num++;
								if (num==4){
									num=3;
									Toast.makeText(MainActivity.this, "当前闹钟数量达到上限", Toast.LENGTH_LONG).show();
									return;
								}
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
								
								//tmpS = "设置闹钟成功！";
								//mTextView.setText(tmpS);
								Toast.makeText(MainActivity.this, "设置闹钟成功！", Toast.LENGTH_LONG).show();
								//显示闹钟列表
								switch(num){
									case 1:
										mTextView1.setText("闹钟1");
										mButtonalarm1.setText(s1);
										mButtondel1.setText("删除");
										mButtonalarm1.getBackground().setAlpha(255);
										mButtondel1.getBackground().setAlpha(255);
										break;
									case 2:
										mTextView2.setText("闹钟2");
										mButtonalarm2.setText(s2);
										mButtondel2.setText("删除");
										mButtonalarm2.getBackground().setAlpha(255);
										mButtondel2.getBackground().setAlpha(255);
										break;
									case 3:
										mTextView3.setText("闹钟3");
										mButtonalarm3.setText(s3);
										mButtondel3.setText("删除");
										mButtonalarm3.getBackground().setAlpha(255);
										mButtondel3.getBackground().setAlpha(255);
										break;
									default:
								}
							}
						}, mHour, mMinute, true).show();
			}
		});
		mButtonalarm1.setOnClickListener(new View.OnClickListener() {
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
								num=1;
								PendingIntent pendingIntent = PendingIntent
										.getBroadcast(MainActivity.this, data1,
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
								
								tmpS = "更改闹钟成功！";
								Toast.makeText(MainActivity.this, "更改闹钟成功！", Toast.LENGTH_LONG).show();

								//显示闹钟列表
								switch(num){
									case 1:
										mTextView1.setText("闹钟1");
										mButtonalarm1.setText(s1);
										mButtondel1.setText("删除");
										mButtonalarm1.getBackground().setAlpha(255);
										mButtondel1.getBackground().setAlpha(255);
										break;
									case 2:
										mTextView2.setText("闹钟2");
										mButtonalarm2.setText(s2);
										mButtondel2.setText("删除");
										mButtonalarm2.getBackground().setAlpha(255);
										mButtondel2.getBackground().setAlpha(255);
										break;
									case 3:
										mTextView3.setText("闹钟3");
										mButtonalarm3.setText(s3);
										mButtondel3.setText("删除");
										mButtonalarm3.getBackground().setAlpha(255);
										mButtondel3.getBackground().setAlpha(255);
										break;
									default:
								}
							}
						}, mHour, mMinute, true).show();
			}
		});
		mButtonalarm2.setOnClickListener(new View.OnClickListener() {
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
								num=2;
								PendingIntent pendingIntent = PendingIntent
										.getBroadcast(MainActivity.this, data2,
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
								
								tmpS = "更改闹钟成功！";
								Toast.makeText(MainActivity.this, "更改闹钟成功！", Toast.LENGTH_LONG).show();

								//显示闹钟列表
								switch(num){
									case 1:
										mTextView1.setText("闹钟1");
										mButtonalarm1.setText(s1);
										mButtondel1.setText("删除");
										mButtonalarm1.getBackground().setAlpha(255);
										mButtondel1.getBackground().setAlpha(255);
										break;
									case 2:
										mTextView2.setText("闹钟2");
										mButtonalarm2.setText(s2);
										mButtondel2.setText("删除");
										mButtonalarm2.getBackground().setAlpha(255);
										mButtondel2.getBackground().setAlpha(255);
										break;
									case 3:
										mTextView3.setText("闹钟3");
										mButtonalarm3.setText(s3);
										mButtondel3.setText("删除");
										mButtonalarm3.getBackground().setAlpha(255);
										mButtondel3.getBackground().setAlpha(255);
										break;
									default:
								}
							}
						}, mHour, mMinute, true).show();
			}
		});
		mButtonalarm3.setOnClickListener(new View.OnClickListener() {
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
								num=3;
								PendingIntent pendingIntent = PendingIntent
										.getBroadcast(MainActivity.this, data3,
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
								
								tmpS = "更改闹钟成功！";
								Toast.makeText(MainActivity.this, "更改闹钟成功！", Toast.LENGTH_LONG).show();

								//显示闹钟列表
								switch(num){
									case 1:
										mTextView1.setText("闹钟1");
										mButtonalarm1.setText(s1);
										mButtondel1.setText("删除");
										mButtonalarm1.getBackground().setAlpha(255);
										mButtondel1.getBackground().setAlpha(255);
										break;
									case 2:
										mTextView2.setText("闹钟2");
										mButtonalarm2.setText(s2);
										mButtondel2.setText("删除");
										mButtonalarm2.getBackground().setAlpha(255);
										mButtondel2.getBackground().setAlpha(255);
										break;
									case 3:
										mTextView3.setText("闹钟3");
										mButtonalarm3.setText(s3);
										mButtondel3.setText("删除");
										mButtonalarm3.getBackground().setAlpha(255);
										mButtondel3.getBackground().setAlpha(255);
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
				Toast.makeText(MainActivity.this, "闹钟已取消！", Toast.LENGTH_LONG).show();

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
				Toast.makeText(MainActivity.this, "闹钟已取消！", Toast.LENGTH_LONG).show();
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
				Toast.makeText(MainActivity.this, "闹钟已取消！", Toast.LENGTH_LONG).show();
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
