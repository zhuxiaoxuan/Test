package com.zxx.simplemvp.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zxx.simplemvp.R;
import com.zxx.simplemvp.callback.DataCallback;
import com.zxx.simplemvp.view.IMainView;

public class MainActivity extends Activity implements IMainView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void getData(DataCallback callback) {

    }
}
