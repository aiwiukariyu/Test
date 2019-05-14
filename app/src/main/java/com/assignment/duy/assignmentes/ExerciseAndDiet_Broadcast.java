package com.assignment.duy.assignmentes;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.widget.Toast;
public class ExerciseAndDiet_Broadcast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){
        Vibrator vibrator= (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(1000);

        Notification noti= new Notification.Builder(context)
                .setContentTitle("Alarm on")
                .setContentText("Alarm set")
                .setSmallIcon(R.mipmap.ic_launcher).build();
        Toast.makeText("ALARM",Toast.LENGTH_SHORT).show();

        NotificationManager manager =(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        noti.flags |=Notification.FLAG_AUTO_CANCEL;
        manager.notify(0,noti);


    }

}
