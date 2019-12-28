package com.blogspot.pavankreddy.powerreceiver;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = findViewById(R.id.imageview);
        myReceiver = new MyReceiver(imageView);
        /*Get Registered for a broadcast*/
        IntentFilter intentFilter = new IntentFilter();
        /*Set the broadcast which you want to receive*/
        intentFilter.addAction(Intent.ACTION_POWER_CONNECTED);
        intentFilter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        /*Register the broadcast*/
        this.registerReceiver(myReceiver,intentFilter);
    }
}
