package com.example.digi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class step extends AppCompatActivity {
private TextView back;
private Button input;
private Button ensure;
private EditText high;
private EditText weight;
 int highint;
 int weightint;
////////////////////////限制返回


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

    ////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step);



        ensure=findViewById(R.id.ensure);
        input=findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ensure.setVisibility(View.VISIBLE);
                EditText high= findViewById(R.id.high);
                highint=Integer.parseInt(high.getText().toString());
                EditText weight= findViewById(R.id.weight);

                weightint=Integer.parseInt(weight.getText().toString());

            }
        });
        ensure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(step.this,MainActivity.class);
                intent.putExtra("high",highint);
                intent.putExtra("weight",weightint);
                intent.putExtra("sure",1);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);


            }
        });


        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(step.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
    }
}