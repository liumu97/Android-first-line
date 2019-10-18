package com.example.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.File;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendNotice = (Button) findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.send_notice:
                Intent intent = new Intent(this,NotificationActiviy.class);
                PendingIntent pi = PendingIntent.getActivity(this,0,intent,0);
                NotificationManager manager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//                String groupId = "group_001";
//                NotificationChannelGroup group = new NotificationChannelGroup(groupId,"通知组");
//                manager.createNotificationChannelGroup(group);
                String channelId = "channel_001";
//                NotificationChannel adChannel = new NotificationChannel(channelId,"通知测试",NotificationManager.IMPORTANCE_DEFAULT);
//                adChannel.setDescription("通知测试");
//                adChannel.setGroup(groupId);
//                manager.createNotificationChannel(adChannel);
                Notification notification = new NotificationCompat.Builder(this, channelId)
                        .setContentTitle("This is content title")
                        .setContentText("This is content text")
                        .setWhen(System.currentTimeMillis())
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi)
                        .setAutoCancel(true)
                        .setSound(Uri.fromFile(new File("/system/media/audio/ringtones/Atria.ogg")))
                        .setVibrate(new long[]{0,1000,1000,1000})
                        .setLights(Color.GREEN,1000,1000)
//                        .setDefaults(NotificationCompat.DEFAULT_ALL)
//                        .setPriority(NotificationCompat.PRIORITY_MAX)
                        .build();
                manager.notify(8,notification);
                break;
            default:
                break;
        }
    }
}
