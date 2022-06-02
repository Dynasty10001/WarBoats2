package com.example.cst143warboats;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.core.app.NotificationCompat;

public class FireNotification extends Service {
    public FireNotification() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate()
    {
        NotificationManager notifyMgr = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification n;

        //Create a pending intent to open (or re-open) this activity
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);


        //In Oreo, channels were added, so we'll check to see what version is in use
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            //Configure a channel to use and then add a notification to it
            String channel = "666";
            CharSequence name = "channel666";
            int importance = NotificationManager.IMPORTANCE_LOW;
            NotificationChannel nChannel = new NotificationChannel(channel, name, importance);
            notifyMgr.createNotificationChannel(nChannel);

            // a builder pattern creates an object that configures and builds another object
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channel)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setChannelId(channel)
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setTicker("Ticker Notify")
                    .setContentTitle("WarBoats Requires Your Assistance")
                    .setContentText("ARRRRR you giving Up? Or Will you Play Again?")
                    .setAutoCancel(false)
                    .setContentIntent(pendingIntent);
            n = builder.build();
        }
        else
        {
            // a builder pattern creates an object that configures and builds another object
            Notification.Builder builder = new Notification.Builder(this)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setPriority(Notification.PRIORITY_DEFAULT)
                    .setTicker("Ticker Notify")
                    .setContentTitle("WarBoats Requires Your Assistance")
                    .setContentText("ARRRRR you giving Up? Or Will you Play Again?")
                    .setAutoCancel(false)
                    .setContentIntent(pendingIntent);
            n = builder.build();
        }
        //use the manager to make the notification appear
        notifyMgr.notify(1, n);
    }
}