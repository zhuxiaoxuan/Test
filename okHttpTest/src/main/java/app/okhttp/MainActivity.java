package app.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;

import app.okhttp.util.OkHttpClientManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
