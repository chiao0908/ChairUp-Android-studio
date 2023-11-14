package com.example.digi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.ros.address.InetAddressFactory;
import org.ros.android.RosActivity;
import org.ros.concurrent.CancellableLoop;
import org.ros.message.MessageListener;
import org.ros.namespace.GraphName;
import org.ros.node.ConnectedNode;
import org.ros.node.Node;
import org.ros.node.NodeConfiguration;
import org.ros.node.NodeMain;
import org.ros.node.NodeMainExecutor;
import org.ros.node.topic.Publisher;
import org.ros.node.topic.Subscriber;

import java.net.URI;

import std_msgs.Int64MultiArray;
import std_msgs.String;


public class setting extends RosActivity {
    public int wifiint,toolongint,styleint;

    public setting(){
        super("image","image", URI.create("http://172.20.10.9:11311"));
    }
    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration1 = NodeConfiguration.newPublic(InetAddressFactory.newNonLoopback().getHostAddress(),getMasterUri());
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(new NodeMain() {
            @Override
            public GraphName getDefaultNodeName() {
                return GraphName.of("setting");
            }

            @Override
            public void onStart(ConnectedNode connectedNode) {

                final Publisher<Int64MultiArray> pub =  connectedNode.newPublisher("settingmsg", std_msgs.Int64MultiArray._TYPE);
                final Subscriber<String> sub = connectedNode.newSubscriber("digi2",std_msgs.String._TYPE);
                sub.addMessageListener(new MessageListener<String>() {
                    @Override
                    public void onNewMessage(std_msgs.String string) {
                        //hello=findViewById(R.id.number);
                        //hello.setText(string.getData());
                         System.out.println(string.getData());

                    }
                });
                connectedNode.executeCancellableLoop(new CancellableLoop() {
                    @Override
                    protected void loop() throws InterruptedException {
                        Int64MultiArray msg = pub.newMessage();
                        long[] operation= {wifiint,toolongint,styleint};
                        msg.setData(operation);
                        pub.publish(msg);
                        Thread.sleep(750);
                    }
                });
            }


            @Override
            public void onShutdown(Node node) {

            }

            @Override
            public void onShutdownComplete(Node node) {

            }

            @Override
            public void onError(Node node, Throwable throwable) {

            }
        },nodeConfiguration);

    }

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
    private TextView logout;
    private Button plusm;
    private LinearLayout bt2main;
    private LinearLayout bt3main;
    private LinearLayout bt1main;
    private Switch wifi =null;
    private Switch style=null;
    private Switch toolong=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

/////////////////

        wifi=findViewById(R.id.wifi);
        wifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    wifiint=1;
                    Toast.makeText(setting.this,"wifi connect",Toast.LENGTH_SHORT).show();
                }
                else{
                    wifiint=2;
                    Toast.makeText(setting.this,"wifi disconnect",Toast.LENGTH_SHORT).show();
                }
            }
        });
        toolong=findViewById(R.id.toolong);
        toolong.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    toolongint=1;
                    Toast.makeText(setting.this,"久坐提醒開啟",Toast.LENGTH_SHORT).show();
                }
                else{
                    toolongint=2;
                    Toast.makeText(setting.this,"久坐提醒關閉",Toast.LENGTH_SHORT).show();
                }
            }
        });
        style=findViewById(R.id.style);
        style.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    styleint=1;
                    Toast.makeText(setting.this,"坐姿提醒開啟",Toast.LENGTH_SHORT).show();
                }
                else{
                    styleint=2;
                    Toast.makeText(setting.this,"坐姿提醒關閉",Toast.LENGTH_SHORT).show();
                }
            }
        });


        //////////////////


        bt2main = findViewById(R.id.bt2layout);
        bt2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this,diary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt3main = findViewById(R.id.bt3layout);
        bt3main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this,analysis.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt1main = findViewById(R.id.bt1layout);
        bt1main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        plusm = findViewById(R.id.plus);
        plusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this,plus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(setting.this,account.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });


    }

}