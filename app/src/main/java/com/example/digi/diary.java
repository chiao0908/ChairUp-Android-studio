package com.example.digi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class diary extends AppCompatActivity {

//////限制返回

    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode==KeyEvent.KEYCODE_BACK){
            if(getApplicationInfo().targetSdkVersion>= Build.VERSION_CODES.ECLAIR)
            {
                event.startTracking();
            }
            else{
                onBackPressed();
            }
        }
        return false;
    }
    @Override
    public boolean onKeyUp(int keyCode,KeyEvent event){
        return super.onKeyUp(keyCode,event);
    }
    ///////
    private Button plusm;
    private LinearLayout bt1main;
    private LinearLayout bt3main;
    private LinearLayout bt4main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary);
        bt1main = findViewById(R.id.bt1layout);
        bt1main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diary.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt3main = findViewById(R.id.bt3layout);
        bt3main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diary.this,analysis.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt4main = findViewById(R.id.bt4layout);
        bt4main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diary.this,setting.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        plusm = findViewById(R.id.plus);
        plusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(diary.this,plus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }


}