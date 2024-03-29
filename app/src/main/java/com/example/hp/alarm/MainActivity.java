package com.example.hp.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);

    }
    public void onClick(View view){
        startAlert();
    }
    public void startAlert(){
        EditText time=findViewById(R.id.time);
        int i= Integer.parseInt(time.getText().toString());
        Intent intent=new Intent(this,MyBroadcastRecevier.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),234324243, intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this,"Alarm set in"+i+"seconds",Toast.LENGTH_LONG).show();

    }
}
