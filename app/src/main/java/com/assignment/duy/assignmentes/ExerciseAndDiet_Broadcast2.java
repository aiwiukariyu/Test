package com.assignment.duy.assignmentes;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;
public class ExerciseAndDiet_Broadcast2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        NotificationHelper notificationHelper = new NotificationHelper(context);
        NotificationCompat.Builder nb = notificationHelper.getChannelNotification2();
        notificationHelper.getManager().notify(2, nb.build());
    }

}
