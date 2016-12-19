package com.zxx.viewgroup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ClassViewGoup class_viewgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        class_viewgroup = (ClassViewGoup) findViewById(R.id.class_viewgroup);
    }
}
