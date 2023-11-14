package com.example.digi;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class account extends AppCompatActivity {

    ///





    ///
    private Button enter;
    private TextView underline;
    @Override

    protected void onCreate(Bundle savedInstanceState) {





        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        TextView underline = (TextView)findViewById(R.id.underline); underline.setText(Html.fromHtml("<u>"+"立即註冊"+"</u>"));
        enter = findViewById(R.id.buttonenter);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(account.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}


