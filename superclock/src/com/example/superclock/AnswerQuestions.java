package com.example.superclock;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AnswerQuestions extends Activity {

	private String q1="清华香锅哪家强？";
	private String a11="A:紫荆园";
	private String a12="B:桃李园";
	
	private String q2="1+7-3+4-6=?";
	private String a21="A:4";
	private String a22="B:3";
	
	private String q3="2+B=10,那么2B=?";
	private String a31="A:16";
	private String a32="B:14";
	
	private String q4="我国“五岳”中的西岳华山位于哪个省？";
	private String a41="A:山西";
	private String a42="B:陕西";
	
	private String q5="名著《三国演义》中，刘备的“五虎上将”里最后病逝名将是哪一位？";
	private String a51="A:赵子龙";
	private String a52="B:马超";
	
	private String q6="四书五经中的四书指的是《论语》，《大学》，《中庸》和哪本书？";
	private String a61="A:孟子";
	private String a62="B:老子";
	
	private String q7="世界短跑名将尤赛恩·博尔特是哪国人？";
	private String a71="A:喀麦隆";
	private String a72="B:牙买加";
	
	private String q8="我们通常说的“知天命”指的是多少岁？";
	private String a81="A:50";
	private String a82="B:40";
	
	private String q9="垂死病中惊坐起下一句是？";
	private String a91="A:笑问客从何处来";
	private String a92="B:暗风吹雨入寒窗";
	
	private String q10="足球世界杯比赛中，每支队伍规定上场的球员首发人数是多少名？";
	private String a101="A:11";
	private String a102="B:12";
	
	private String q11="上古传说中，后羿一共射落过天上的几个太阳？";
	private String a111="A:9";
	private String a112="B:10";
	
	private String q12="著名的耳机品牌森海塞尔来自哪个欧洲国家？";
	private String a121="A:芬兰";
	private String a122="B:德国";
	
	private String q13="'朝辞白帝彩云间，千里江陵一日还'这首《早发白帝城》是哪位诗人的作品？";
	private String a131="A:李白";
	private String a132="B:白居易";
	
	private String q14="我国历史上存在时间最长的是哪个朝代？";
	private String a141="A:周朝";
	private String a142="B:唐朝";
	
	private String q15="梅西在哪支球队?";
	private String a151="A:切尔西";
	private String a152="B:巴萨";
	
	private String q16="巴西的首都?";
	private String a161="A:巴西利亚";
	private String a162="B:里约热内卢";
		
	
	private int ans1=1;
	private int ans2=2;
	private int ans3=1;
	private int ans4=2;
	private int ans5=1;
	private int ans6=1;
	private int ans7=2;
	private int ans8=1;
	private int ans9=2;
	private int ans10=1;
	private int ans11=1;
	private int ans12=2;
	private int ans13=1;
	private int ans14=1;
	private int ans15=2;
	private int ans16=1;
	
	
	private	int a;
	private int ans;
	Button mButtonans1;
	Button mButtonans2;
	TextView mTextquestion;
	TextView mTextans1;
	TextView mTextans2;
	public void random(){
		a= (int)(Math.random()*16)+1 ;
		switch (a){
		case 1:
			mTextquestion.setText(q1);
			mTextans1.setText(a11);
			mTextans2.setText(a12);
			ans=ans1;
			break;
		case 2:
			mTextquestion.setText(q2);
			mTextans1.setText(a21);
			mTextans2.setText(a22);
			ans=ans2;
			break;
		case 3:
			mTextquestion.setText(q3);
			mTextans1.setText(a31);
			mTextans2.setText(a32);
			ans=ans3;
			break;
		case 4:
			mTextquestion.setText(q4);
			mTextans1.setText(a41);
			mTextans2.setText(a42);
			ans=ans4;
			break;
		case 5:
			mTextquestion.setText(q5);
			mTextans1.setText(a51);
			mTextans2.setText(a52);
			ans=ans5;
			break;
		case 6:
			mTextquestion.setText(q6);
			mTextans1.setText(a61);
			mTextans2.setText(a62);
			ans=ans6;
			break;
		case 7:
			mTextquestion.setText(q7);
			mTextans1.setText(a71);
			mTextans2.setText(a72);
			ans=ans7;
			break;
		case 8:
			mTextquestion.setText(q8);
			mTextans1.setText(a81);
			mTextans2.setText(a82);
			ans=ans8;
			break;
		case 9:
			mTextquestion.setText(q9);
			mTextans1.setText(a91);
			mTextans2.setText(a92);
			ans=ans9;
			break;
		case 10:
			mTextquestion.setText(q10);
			mTextans1.setText(a101);
			mTextans2.setText(a102);
			ans=ans10;
			break;
		case 11:
			mTextquestion.setText(q11);
			mTextans1.setText(a111);
			mTextans2.setText(a112);
			ans=ans11;
			break;
		case 12:
			mTextquestion.setText(q12);
			mTextans1.setText(a121);
			mTextans2.setText(a122);
			ans=ans12;
			break;			
		case 13:
			mTextquestion.setText(q13);
			mTextans1.setText(a131);
			mTextans2.setText(a132);
			ans=ans13;
			break;
		case 14:
			mTextquestion.setText(q14);
			mTextans1.setText(a141);
			mTextans2.setText(a142);
			ans=ans14;
			break;
		case 15:
			mTextquestion.setText(q15);
			mTextans1.setText(a151);
			mTextans2.setText(a152);
			ans=ans15;
			break;
		case 16:
			mTextquestion.setText(q16);
			mTextans1.setText(a161);
			mTextans2.setText(a162);
			ans=ans16;
			break;
		}
	}

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.questions);
		mTextquestion = (TextView) findViewById(R.id.Textquestion);
		mTextans1=(TextView) findViewById(R.id.Textans1);
		mTextans2=(TextView) findViewById(R.id.Textans2);
		mButtonans1 = (Button) findViewById(R.id.Button_ansA);
		mButtonans2 = (Button) findViewById(R.id.Button_ansB);
		mButtonans1.setText("A");
		mButtonans2.setText("B");
		random();
		mButtonans1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (ans==1){
					AnswerQuestions.this.finish();
				}
				else {
					Toast.makeText(AnswerQuestions.this, "回答错误，再来一次！", Toast.LENGTH_LONG).show();
					random();
				}
			}
		});
		mButtonans2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				if (ans==2){
						AnswerQuestions.this.finish();
				}
				else {
					Toast.makeText(AnswerQuestions.this, "回答错误，再来一次！", Toast.LENGTH_LONG).show();
					random();
				}
				}
		});
	}
	@Override
    public boolean onKeyDown( int keyCode, KeyEvent event) {
           // TODO Auto-generated method stub
           if (keyCode == event. KEYCODE_BACK) {
                 return true;
          }
           return super.onKeyDown(keyCode, event);
    }
}
