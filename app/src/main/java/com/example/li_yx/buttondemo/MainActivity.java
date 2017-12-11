package com.example.li_yx.buttondemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.li_yx.buttondemo.view.ManyButtonView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ButtonModel> list = new ArrayList<>();
    private ManyButtonView buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonView = findViewById(R.id.buttonView);
        initData();
        buttonView.configStatus(0,"已付款",list);
    }



    private void initData() {

        list.clear();

        View.OnClickListener listenerOne = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"按钮1",Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener listenerTwo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"按钮2",Toast.LENGTH_SHORT).show();
            }
        };

        View.OnClickListener listenerThree = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"按钮3",Toast.LENGTH_SHORT).show();
            }
        };

        ButtonModel one = new ButtonModel();
        one.promotion = "满百减5";
        one.textContent = "按钮one";
        one.isShowRedPoint = true;
        one.listener = listenerOne;


        ButtonModel two = new ButtonModel();
        two.promotion="";
        two.textContent="按钮two";
        two.isShowRedPoint=false;
        two.listener = listenerTwo;

//        ButtonModel three = new ButtonModel();
//        three.promotion="";
//        three.textContent="按钮Three";
//        three.isShowRedPoint=false;
//        three.listener = listenerThree;

        list.add(one);
        list.add(two);
//        list.add(three);
    }


}
