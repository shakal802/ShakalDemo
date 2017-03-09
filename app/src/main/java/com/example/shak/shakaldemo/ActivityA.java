package com.example.shak.shakaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityA extends AppCompatActivity {


    @OnClick(R.id.btn1A)
    public void buttonAClick(){
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn1B)
    public void buttonBClick(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn1C)
    public void buttonCClick(){
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn1D)
    public void buttonDClick(){
        Intent intent = new Intent(this, ActivityD.class);
        startActivity(intent);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        ButterKnife.bind(this);

    }
}