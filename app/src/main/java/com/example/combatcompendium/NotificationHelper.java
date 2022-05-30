package com.example.combatcompendium;

import android.annotation.TargetApi;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public static final String channel1ID = "channel1ID";
    public static final String channel1Name = "Channel 1";
    public static final String channel2ID = "channel2ID";
    public static final String channel2Name = "Channel 2";

    private NotificationManager mManager;

    public NotificationHelper(Context base) {
        super(base);
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            createChannels();
        }

    }

    @TargetApi(Build.VERSION_CODES.O)
    public void createChannels(){
        NotificationChannel channel1 = new NotificationChannel (channel1ID, channel1Name, NotificationManager.IMPORTANCE_HIGH);


        getManager().createNotificationChannel(channel1);
    }

    public NotificationManager getManager() {
        if (mManager == null){
            mManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        }
        return mManager;
    }

    public NotificationCompat.Builder getChannelNotification(){
        return new NotificationCompat.Builder(getApplicationContext(), channel1ID)
                .setContentTitle("Alarm!")
                .setContentText("Check on your lessons.")
                .setSmallIcon(R.drawable.pencil_18);

    }
}
