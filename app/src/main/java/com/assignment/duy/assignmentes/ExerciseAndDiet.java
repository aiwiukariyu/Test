package com.assignment.duy.assignmentes;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.TimePicker;
import android.app.Activity;
import android.content.Context;

import java.util.Calendar;
import java.util.Date;


public class ExerciseAndDiet extends Fragment {
    TimePicker timePicker;
    TextView textView;

    int mHour,mMin;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.exercise_layout, container, false);
        super.onCreate(savedInstanceState);
        timePicker=(TimePicker) view.findViewById(R.id.timePicker);
        textView=(TextView) view.findViewById(R.id.timeTextView);
    timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
        @Override
        public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
            mHour=hourOfDay;
            mMin=minute;
            textView.setText(textView.getText().toString()+" "+mHour+":"+mMin);

        }
    });

        return inflater.inflate(R.layout.exercise_layout, container, false);
    }
    public void setTimer(View v){

        AlarmManager alarmManager=(AlarmManager) Context.getSystemService(Context.ALARM_SERVICE);

        Date date= new Date();
        Calendar cal_alarm=Calendar.getInstance();
        Calendar cal_now=Calendar.getInstance();

        cal_now.setTime(date);
        cal_alarm.setTime(date);

        cal_alarm.set(Calendar.HOUR_OF_DAY,mHour);
        cal_alarm.set(Calendar.MINUTE,mMin);
        cal_alarm.set(Calendar.SECOND, 0);

        if(cal_alarm.before(cal_now)){
            cal_alarm.add(Calendar.DATE,1);
        }
        Intent i= new Intent(ExerciseAndDiet.this,ExerciseAndDiet_Broadcast.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(ExerciseAndDiet.this,24444,i,0)
        alarmManager.set(AlarmManager.RTC_WAKEUP,cal_alarm.getTimeInMillis(),pendingIntent);

    }
}
