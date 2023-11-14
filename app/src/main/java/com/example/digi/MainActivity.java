package com.example.digi;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

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
//public class MainActivity extends AppCompatActivity{

public class MainActivity extends RosActivity {
    public String ss;
    public TextView word1,word2;
    public int highint,weightint,sureint;
    public ImageView abc;
    public ImageView noone,nnn,nfn,nfl,nfr,nhn,nhl,nhr,nbn,nbl,nbr,nnl,nnr,rnn,rhn,rfn,rbn,lnn,lhn,lfn,lbn;
    public Handler handler;
    public MainActivity(){
        super("image","image", URI.create("http://172.20.10.2:11311"));
    }

    class image_set extends Thread{
        String image_choose ;
        image_set(String str) { image_choose = str;}
        @Override
        public void run(){

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    ImageView image_cushin;
                    image_cushin = (ImageView)findViewById(R.id.abc);

                   if(image_choose.equals("nnn")){
                    image_cushin.setImageDrawable(null);
                    image_cushin.setImageResource(R.drawable.correct);

                   }
                   else if(image_choose.equals("nfn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nfn);
                   }
                   else if(image_choose.equals("nfl")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nfl);
                   }
                   else if(image_choose.equals("nfr")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nfr);
                   }
                   else if(image_choose.equals("nhn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nhn);
                   }
                   else if(image_choose.equals("nhl")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nhl);
                   }
                   else if(image_choose.equals("nhr")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nhr);
                   }
                   else if(image_choose.equals("nbn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nbn);
                   }
                   else if(image_choose.equals("nbl")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nbl);
                   }
                   else if(image_choose.equals("nbr")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nbr);
                   }
                   else if(image_choose.equals("nnl")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nnl);
                   }
                   else if(image_choose.equals("nnr")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.nnr);
                   }
                   else if(image_choose.equals("rnn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.rnn);
                   }
                   else if(image_choose.equals("rhn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.rhn);
                   }
                   else if(image_choose.equals("rfn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.rfn);
                   }
                   else if(image_choose.equals("rbn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.rbn);
                   }
                   else if(image_choose.equals("lnn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.lnn);
                   }
                   else if(image_choose.equals("lhn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.lhn);
                   }
                   else if(image_choose.equals("lfn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.lfn);
                   }
                   else if(image_choose.equals("lbn")) {
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.lbn);
                   }
                   else{
                       image_cushin.setImageDrawable(null);
                       image_cushin.setImageResource(R.drawable.noone);
                   }


                }
            });
        }
    }

    @Override
    protected void init(NodeMainExecutor nodeMainExecutor) {
        NodeConfiguration nodeConfiguration1 = NodeConfiguration.newPublic(InetAddressFactory.newNonLoopback().getHostAddress(),getMasterUri());
        NodeConfiguration nodeConfiguration = NodeConfiguration.newPublic(getRosHostname());
        nodeConfiguration.setMasterUri(getMasterUri());
        nodeMainExecutor.execute(new NodeMain() {
            @Override
            public GraphName getDefaultNodeName() {
                return GraphName.of("ros_test");
            }
            @Override
            public void onStart(ConnectedNode connectedNode) {


                final Publisher<Int64MultiArray> pub =  connectedNode.newPublisher("test", std_msgs.Int64MultiArray._TYPE);
                final Subscriber<std_msgs.String> sub = connectedNode.newSubscriber("digi",std_msgs.String._TYPE);
                sub.addMessageListener(new MessageListener<std_msgs.String>() {

                   @Override
                   public void onNewMessage(std_msgs.String string) {
                       word1=findViewById(R.id.word1);
                       word2=findViewById(R.id.word2);
                       image_set test = new image_set(string.getData());


                       test.setPriority(1);
                       test.start();

                     //  ImageView image_cushin;
                      // image_cushin = (ImageView)findViewById(R.id.abc);
                    //   image_cushin.setImageResource(R.drawable.correct);



                       ss=string.getData();


                       ////////////////////////////////////////////////坐姿////////////////////////////////////////////////////////////////////////////////


                       if(ss.equals("nnn")) {
                           word1.setText("嘿嘿,很棒喔!");
                           word2.setText("你已經坐正了");

                       }
                       else if(ss.equals("nfn")) {
                           word1.setText("別忘了要坐正!");
                           word2.setText("身體往後靠一些");
                       }
                       else if(ss.equals("nfl")) {
                           word1.setText("目前前傾偏左!");
                           word2.setText("坐正,身體稍微向後靠");
                       }
                       else if(ss.equals("nfr")) {
                           word1.setText("目前前傾偏右!");
                           word2.setText("坐正,身體稍微向後靠");

                       }
                       else if(ss.equals("nhn")) {
                           word1.setText("別駝背，請坐正!");
                           word2.setText("想像一條線從頭頂往上拉");

                       }
                       else if(ss.equals("nhl")) {
                           word1.setText("嘿嘿,別駝背,要坐好!");
                           word2.setText("而且你還往左偏喔");

                       }
                       else if(ss.equals("nhr")) {
                           word1.setText("嘿嘿,別駝背,要坐好!");
                           word2.setText("而且你還往右偏喔");

                       }
                       else if(ss.equals("nbn")) {
                           word1.setText("別忘了要坐正!");
                           word2.setText("你的重心偏後喔");

                       }
                       else if(ss.equals("nbl")) {
                           word1.setText("目前後傾偏左!");
                           word2.setText("身體向頭頂上方延伸");

                       }
                       else if(ss.equals("nbr")) {
                           word1.setText("目前後傾偏右!");
                           word2.setText("身體向頭頂上方延伸");

                       }
                       else if(ss.equals("nnl")) {
                           word1.setText("嘿嘿,要坐正喔!");
                           word2.setText("你的重心偏左");

                       }
                       else if(ss.equals("nnr")) {
                           word1.setText("嘿嘿,要坐正喔!");
                           word2.setText("你的重心偏右");

                       }
                       else if(ss.equals("rnn")) {
                           word1.setText("別翹腳,請坐正!");
                           word2.setText(null);

                       }
                       else if(ss.equals("rhn")) {
                           word1.setText("欸欸,別翹腳!");
                           word2.setText("背也要記得挺直喔!");

                       }
                       else if(ss.equals("rfn")) {
                           word1.setText("別再翹腳啦!");
                           word2.setText("背再稍微往後靠一點");

                       }
                       else if(ss.equals("rbn")) {
                           word1.setText("別再翹腳啦!");
                           word2.setText("重心要再往前一點喔");

                       }
                       else if(ss.equals("lnn")) {
                           word1.setText("別翹腳,請坐正!");
                           word2.setText(null);

                       }
                       else if(ss.equals("lhn")) {
                           word1.setText("欸欸,別翹腳!");
                           word2.setText("背也要記得挺直喔!");

                       }
                       else if(ss.equals("lfn")) {
                           word1.setText("別再翹腳啦!");
                           word2.setText("背再稍微往後靠一點");

                       }
                       else if(ss.equals("lbn")) {
                           word1.setText("別再翹腳啦!");
                           word2.setText("重心要再往前一點喔!");
                       }
                       else if(ss.equals("wait")){
                           word1.setText("目前無人坐下!");
                           word2.setText(null);
                           sureint =0 ;
                           highint=0;
                           weightint=0;
                       }
                       else{
                           word1.setText("目前無人坐下!");
                           word2.setText(null);

                       }








                       ///////////////////////////////////////////////////坐姿////////////////////////////////////////////////////////////////////////////////
                      // System.out.println(string.getData());

                   }
               });
                connectedNode.executeCancellableLoop(new CancellableLoop() {
                    @Override
                    protected void loop() throws InterruptedException {
                        Int64MultiArray msg = pub.newMessage();
                        long[] operation= {sureint,highint,weightint};
                        msg.setData(operation);
                        pub.publish(msg);

                        Thread.sleep(1000);

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
///////////////
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
    private Button step3;
    private Button plusm;
    private LinearLayout bt2main;
    private LinearLayout bt3main;
    private LinearLayout bt4main;
    private TextView hello;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // hello=findViewById(R.id.number);
        //System.out.println(ss);


        ////



        ////
       // hello.setText(ss);

        Intent intent = getIntent();
         highint=intent.getIntExtra("high",0);
         weightint = intent.getIntExtra("weight",0);
         sureint = intent.getIntExtra("sure",0);
        System.out.println(highint);
        System.out.println(weightint);
        System.out.println(sureint);

        ////
        /*
        String ss = "one";
        if(ss.equals("one")) {
            noone=findViewById(R.id.noone);
            nnn=findViewById(R.id.nnn);
            //c1.setVisibility(View.INVISIBLE);
            nnn.setVisibility(View.VISIBLE);
        }

         */
////
        bt2main = findViewById(R.id.bt2layout);
        bt2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,diary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt3main = findViewById(R.id.bt3layout);
        bt3main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,analysis.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt4main = findViewById(R.id.bt4layout);
        bt4main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,setting.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        plusm = findViewById(R.id.plus);
        plusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,plus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        step3 = findViewById(R.id.step3);
        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,step.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        /////


    }


}

