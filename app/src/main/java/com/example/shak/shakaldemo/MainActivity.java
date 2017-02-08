package com.example.shak.shakaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.shak.shakaldemo.util.UtilLog;

public class MainActivity extends BaseActivity {
    private ImageButton bt1;
    private ImageButton bt2;
    private ImageButton bt3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialView();
        initialListener();
    }

    private void initialView() {
        bt1 = (ImageButton) findViewById(R.id.bt1);
        bt3 = (ImageButton) findViewById(R.id.bt3);
    }



    private void initialListener() {
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(v.getContext(), "Button1 was clicked", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(v.getContext(),ViewPagerActivity.class);
                startActivity(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                toActivity(ListViewActivity.class);
              //  Intent intent = new Intent(v.getContext(),ListViewActivity.class);
              //  startActivity(intent);
            }
        });

    }

    public void onClick(View v) {
    //    Toast.makeText(this, "Button2 was clicked", Toast.LENGTH_LONG).show();
        toastLong("Button2 was clicked");
       UtilLog.logD("testD","Toast");
    }
}

