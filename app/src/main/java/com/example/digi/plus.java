package com.example.digi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class plus extends AppCompatActivity {
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

    /////
    //////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public boolean onKeyUp(int keyCode,KeyEvent event){
        return super.onKeyUp(keyCode,event);
    }

    ///////

    private TextView back;
    private Button save;
    private Button neck;
    private Button lefts;
    private Button topb;
    private Button downb;
    private Button waist;
    private Button rights;
    private Button star1;
    private Button star2;
    private Button star3;
    private Button star4;
    private Button star5;
    int flag1 =0;
    private Button star6;
    private Button star7;
    private Button star8;
    private Button star9;
    private Button star10;
    int flag2 =0;
    int neckflag = 0;
    int leftsflag = 0;
    int rightsflag = 0;
    int topbflag = 0;
    int downbflag = 0;
    int waistflag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
        ////////star/////////
        star1=(Button)findViewById(R.id.star1);
        star1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        if(flag1==0){
                                            star1.setActivated(true);
                                            star2.setActivated(false);
                                            star3.setActivated(false);
                                            star4.setActivated(false);
                                            star5.setActivated(false);
                                            flag1=1; }
                                        else if(flag1==1){
                                            star1.setActivated(false);
                                            star2.setActivated(false);
                                            star3.setActivated(false);
                                            star4.setActivated(false);
                                            star5.setActivated(false);
                                            flag1=0;
                                        }

                                        }
                                });
        star2=(Button)findViewById(R.id.star2);
        star2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    star1.setActivated(true);
                    star2.setActivated(true);
                    star3.setActivated(false);
                    star4.setActivated(false);
                    star5.setActivated(false);



                 }
        });
        star3=(Button)findViewById(R.id.star3);
        star3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star1.setActivated(true);
                    star2.setActivated(true);
                    star3.setActivated(true);
                    star4.setActivated(false);
                    star5.setActivated(false);



                 }
        });
        star4=(Button)findViewById(R.id.star4);
        star4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    star1.setActivated(true);
                    star2.setActivated(true);
                    star3.setActivated(true);
                    star4.setActivated(true);
                    star5.setActivated(false);



            }
        });
        star5=(Button)findViewById(R.id.star5);
        star5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    star1.setActivated(true);
                    star2.setActivated(true);
                    star3.setActivated(true);
                    star4.setActivated(true);
                    star5.setActivated(true);



            }
        });
        star6=(Button)findViewById(R.id.star6);
        star6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag2==0){
                    star6.setActivated(true);
                    star7.setActivated(false);
                    star8.setActivated(false);
                    star9.setActivated(false);
                    star10.setActivated(false);
                    flag2=1; }
                else if(flag2==1){
                    star6.setActivated(false);
                    star7.setActivated(false);
                    star8.setActivated(false);
                    star9.setActivated(false);
                    star10.setActivated(false);
                    flag2=0;
                }

            }
        });
        star7=(Button)findViewById(R.id.star7);
        star7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                star6.setActivated(true);
                star7.setActivated(true);
                star8.setActivated(false);
                star9.setActivated(false);
                star10.setActivated(false);



            }
        });
        star8=(Button)findViewById(R.id.star8);
        star8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                star6.setActivated(true);
                star7.setActivated(true);
                star8.setActivated(true);
                star9.setActivated(false);
                star10.setActivated(false);



            }
        });
        star9=(Button)findViewById(R.id.star9);
        star9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                star6.setActivated(true);
                star7.setActivated(true);
                star8.setActivated(true);
                star9.setActivated(true);
                star10.setActivated(false);



            }
        });
        star10=(Button)findViewById(R.id.star10);
        star10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                star6.setActivated(true);
                star7.setActivated(true);
                star8.setActivated(true);
                star9.setActivated(true);
                star10.setActivated(true);



            }
        });

        ///////////star/////////
        //////////////o

        neck=(Button)findViewById(R.id.neck);
        neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(neckflag==0){
                neck.setActivated(true);
                neckflag=1;}
                else if(neckflag==1){
                    neck.setActivated(false);
                    neckflag=0;
                }
            }
        });
        lefts=(Button)findViewById(R.id.lefts);
        lefts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(leftsflag==0){
                    lefts.setActivated(true);
                    leftsflag=1;}
                else if(leftsflag==1){
                    lefts.setActivated(false);
                    leftsflag=0;
                }
            }
        });
        rights=(Button)findViewById(R.id.rights);
        rights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightsflag==0){
                    rights.setActivated(true);
                    rightsflag=1;}
                else if(rightsflag==1){
                    rights.setActivated(false);
                    rightsflag=0;
                }
            }
        });
        topb=(Button)findViewById(R.id.topb);
        topb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(topbflag==0){
                    topb.setActivated(true);
                    topbflag=1;}
                else if(topbflag==1){
                    topb.setActivated(false);
                    topbflag=0;
                }
            }
        });
        downb=(Button)findViewById(R.id.downb);
        downb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(downbflag==0){
                    downb.setActivated(true);
                    downbflag=1;}
                else if(downbflag==1){
                    downb.setActivated(false);
                    downbflag=0;
                }
            }
        });
        waist=(Button)findViewById(R.id.waist);
        waist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(waistflag==0){
                    waist.setActivated(true);
                    waistflag=1;}
                else if(waistflag==1){
                    waist.setActivated(false);
                    waistflag=0;
                }
            }
        });
        //////////////o
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(plus.this,"已儲存",Toast.LENGTH_SHORT).show();
            }
        });
        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(plus.this,diary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

    }

}