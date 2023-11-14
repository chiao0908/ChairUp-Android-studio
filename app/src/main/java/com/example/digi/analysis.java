package com.example.digi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.AxisValue;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.LineChartView;

public class analysis extends AppCompatActivity {


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
    private List<PointValue>mPointValues = new ArrayList<PointValue>();
    private List<AxisValue> mAxisValues = new ArrayList<AxisValue>();
    String[]date = {"11/29","11/30","12/1","12/2","12/3"};
    //圖示的資料點
    int[]count = {10,30,40,40,20,100};
    private LineChartView lineChart;
    private Button plusm;
    private LinearLayout bt2main;
    private LinearLayout bt1main;
    private LinearLayout bt4main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        ////////////line chart///////////

            lineChart =(LineChartView)findViewById(R.id.chart);
        for(int i = 0;i < date.length;i++){
            mAxisValues.add(new AxisValue(i).setLabel(date[i]));
        }//獲取X軸的標註
        for(int i= 0;i < count.length;i++){
            mPointValues.add(new PointValue(i,count[i]));
        }//獲取座標點
        Line line = new Line(mPointValues).setColor(Color.parseColor("#00219f"));//折線顏色
        List<Line>lines = new ArrayList<Line>();
        line.setShape(ValueShape.CIRCLE);//折線圖上每個資料點的形狀
        line.setCubic(false);//曲線是否平滑
        line.setFilled(false);//是否填充曲線面積
        line.setHasLabels(true);//曲線的資料座標是否加上備註
        line.setHasLines(true);//是否用線顯示 如果為false 則沒有曲線只有點顯示
        line.setHasPoints(false);//是否顯示圓點 如果為false 則沒有原點只有點顯示（每個資料點都是個大的圓點）
        lines.add(line);
        LineChartData data = new LineChartData();
        data.setLines(lines);

        //座標軸
        Axis axisX = new Axis();
        axisX.setHasTiltedLabels(false);//X座標軸字型是斜的顯示還是直的，true是斜的顯示
        axisX.setTextColor(Color.BLUE);//字型顏色
        // axisX.setName("進步曲線");
        axisX.setTextSize(12);
        axisX.setMaxLabelChars(5);//最多幾個x軸座標 縮放讓X軸上資料的個數7<=x<=mAxisXValues.length
        axisX.setValues(mAxisValues);//填充X軸的座標名稱
        data.setAxisXBottom(axisX);//x軸在底部
        axisX.setHasLines(false);//x的分割線
        axisX.setName("date");


        //Y軸是根據資料的大小自動設定y軸上限
        Axis axisY = new Axis();
        axisY.setMaxLabelChars(5);
        axisY.setName("correct percentage %");
        axisY.setTextColor(Color.BLUE);
        axisY.setTextSize(12);
        data.setAxisYLeft(axisY);//Y軸設定在左邊

        //設定行為屬性，支援縮放滑動以及平移
        lineChart.setInteractive(false);
        lineChart.setZoomType(ZoomType.HORIZONTAL);
        lineChart.setMaxZoom((float)1.5);//最多縮放比例
        lineChart.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);
        lineChart.setLineChartData(data);
        lineChart.setVisibility(View.VISIBLE);

        //設定x軸顯示資料的個數
        //不設定axisX.setMaxLabelChars(int count)這句話,則會自動適配X軸所能顯示的儘量合適的資料個數。
        Viewport v = new Viewport(lineChart.getMaximumViewport());
        v.left = 0;
        v.right = 1;
        lineChart.setCurrentViewport(v);//初始化

        //設定x軸的顯示

        //////////////////////////////////////////////////////////////////////////////////////////////////////

        bt2main = findViewById(R.id.bt2layout);
        bt2main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(analysis.this,diary.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt1main = findViewById(R.id.bt1layout);
        bt1main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(analysis.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        bt4main = findViewById(R.id.bt4layout);
        bt4main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(analysis.this,setting.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        plusm = findViewById(R.id.plus);
        plusm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(analysis.this,plus.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });




    }
}