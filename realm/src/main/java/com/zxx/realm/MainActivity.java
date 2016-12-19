package com.zxx.realm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zxx.realm.bean.Dog;

import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    private static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Use them like regular java objects
        Dog dog = new Dog();
        dog.setName("Rex");
        dog.setAge(1);
        Log.v(TAG, "Name of the dog: " + dog.getName());

        // Create a RealmConfiguration which is to locate Realm file in package's "files" directory.
        RealmConfiguration realmConfig = new RealmConfiguration.Builder(this).build();
    }
}
