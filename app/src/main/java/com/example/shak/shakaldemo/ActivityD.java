package com.example.shak.shakaldemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityD extends AppCompatActivity {
    @OnClick(R.id.btn4A)
    public void buttonAClick(){
        Intent intent = new Intent(this, ActivityA.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn4B)
    public void buttonBClick(){
        Intent intent = new Intent(this, ActivityB.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn4C)
    public void buttonCClick(){
        Intent intent = new Intent(this, ActivityC.class);
        startActivity(intent);
    }
    @OnClick(R.id.btn4D)
    public void buttonDClick(){
        Intent intent = new Intent(this, ActivityD.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d);
        ButterKnife.bind(this);
    }
}