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

	private String q1="�廪����ļ�ǿ��";
	private String a11="A:�Ͼ�԰";
	private String a12="B:����԰";
	
	private String q2="1+7-3+4-6=?";
	private String a21="A:4";
	private String a22="B:3";
	
	private String q3="2+B=10,��ô2B=?";
	private String a31="A:16";
	private String a32="B:14";
	
	private String q4="�ҹ����������е�������ɽλ���ĸ�ʡ��";
	private String a41="A:ɽ��";
	private String a42="B:����";
	
	private String q5="�������������塷�У������ġ��廢�Ͻ������������������һλ��";
	private String a51="A:������";
	private String a52="B:��";
	
	private String q6="�����徭�е�����ָ���ǡ����������ѧ��������ӹ�����ı��飿";
	private String a61="A:����";
	private String a62="B:����";
	
	private String q7="����������������������������Ĺ��ˣ�";
	private String a71="A:����¡";
	private String a72="B:�����";
	
	private String q8="����ͨ��˵�ġ�֪������ָ���Ƕ����ꣿ";
	private String a81="A:50";
	private String a82="B:40";
	
	private String q9="�������о�������һ���ǣ�";
	private String a91="A:Ц�ʿʹӺδ���";
	private String a92="B:���紵���뺮��";
	
	private String q10="�������籭�����У�ÿ֧����涨�ϳ�����Ա�׷������Ƕ�������";
	private String a101="A:11";
	private String a102="B:12";
	
	private String q11="�ϹŴ�˵�У�����һ����������ϵļ���̫����";
	private String a111="A:9";
	private String a112="B:10";
	
	private String q12="�����Ķ���Ʒ��ɭ�����������ĸ�ŷ�޹��ң�";
	private String a121="A:����";
	private String a122="B:�¹�";
	
	private String q13="'���ǰ׵۲��Ƽ䣬ǧ�ｭ��һ�ջ�'���ס��緢�׵۳ǡ�����λʫ�˵���Ʒ��";
	private String a131="A:���";
	private String a132="B:�׾���";
	
	private String q14="�ҹ���ʷ�ϴ���ʱ��������ĸ�������";
	private String a141="A:�ܳ�";
	private String a142="B:�Ƴ�";
	
	private String q15="÷������֧���?";
	private String a151="A:�ж���";
	private String a152="B:����";
	
	private String q16="�������׶�?";
	private String a161="A:��������";
	private String a162="B:��Լ����¬";
		
	
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
					Toast.makeText(AnswerQuestions.this, "�ش��������һ�Σ�", Toast.LENGTH_LONG).show();
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
					Toast.makeText(AnswerQuestions.this, "�ش��������һ�Σ�", Toast.LENGTH_LONG).show();
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
