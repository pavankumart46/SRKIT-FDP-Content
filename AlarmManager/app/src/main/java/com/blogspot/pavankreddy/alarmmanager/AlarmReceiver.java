package com.blogspot.pavankreddy.alarmmanager;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import static android.content.Context.NOTIFICATION_SERVICE;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent i) {
        /*This class is responsible for issuing a notification and managing it
         * we can also cancel a notification using this object*/
        NotificationManager nm =
                (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
        /*Creating a notification channel - for android 8.0(oreo) and above
         * devices*/
        String CHANNEL_ID = "mychannel";
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel nc =
                    new NotificationChannel(CHANNEL_ID,"SRKIT FDP CHANNEL",
                            NotificationManager.IMPORTANCE_HIGH);
            nc.enableLights(true);
            nc.enableVibration(true);
            nc.setDescription("MY CHANNEL - MY WISH");
            nm.createNotificationChannel(nc);
        }
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context,CHANNEL_ID);
        builder.setSmallIcon(R.drawable.umbrella);
        builder.setContentTitle("STAND UP AND WALK!");
        builder.setContentText("Walking every one hour is healthy!");
        builder.setPriority(NotificationCompat.PRIORITY_MAX);
        builder.setAutoCancel(true);
        /*PendingIntent is the description of operation that
         * is to be performed outside the app*/
        Intent intent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(context,12,
                        intent,PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.a);
        builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap));
        builder.addAction(R.drawable.umbrella,"YES",pendingIntent);
        builder.addAction(R.drawable.umbrella,"NO",pendingIntent);

        nm.notify(42,builder.build());
    }
}
