package com.exam_gethistorycal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TouchDraw touchDraw = new TouchDraw(this);
        setContentView(touchDraw);
    }
}