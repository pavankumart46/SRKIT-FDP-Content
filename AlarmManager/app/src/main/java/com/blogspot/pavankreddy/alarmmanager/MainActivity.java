package com.blogspot.pavankreddy.alarmmanager;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    AlarmManager am;
    SharedPreferences sp;
    boolean flag;

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("STATUS",flag);
        editor.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton = findViewById(R.id.toggle);
        am = (AlarmManager) getSystemService(ALARM_SERVICE);
        sp = getSharedPreferences("mypref",MODE_PRIVATE);
       /*Target is to save the state of the alarm button - on/off */
       if(sp!=null){
           toggleButton.setChecked(sp.getBoolean("STATUS",false));
       }

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            Intent intent = new Intent(MainActivity.this,
                    AlarmReceiver.class);
            PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,
                    23,
                    intent,
                    PendingIntent.FLAG_UPDATE_CURRENT);

            @Override
            public void onCheckedChanged(CompoundButton compoundButton,
                                         boolean b) {
                if(b)
                {
                    flag = b;
                    //We can turn the alarm on
                    long triggertime = SystemClock.elapsedRealtime();
                    long intervalTime = 1*60*1000;
                    am.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                            triggertime,
                            intervalTime,
                            pi);
                }
                else
                {
                    flag = b;
                    //we can turn the alarm off
                    am.cancel(pi);
                }
            }
        });
    }

}
