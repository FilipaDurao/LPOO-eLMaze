package com.example.filipa.myapplication;

import java.lang.*;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    SensorManager sensorManager;
    Sensor acc;

    public float X, Y;
    public TextView textX, textY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager= (SensorManager) this.getSystemService(SENSOR_SERVICE);
        acc = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, acc, sensorManager.SENSOR_DELAY_NORMAL);

        textX = (TextView) findViewById(R.id.center_horizontal);
        textY = (TextView) findViewById(R.id.center_horizontal);

    }

    public void onAccuracyChanged(Sensor acc, int accuracy) {}

    @Override
    public void onSensorChanged(SensorEvent event) {

        if(Math.abs(event.values[0]) > 3 ||
           Math.abs(event.values[1]) > 3 ||
           Math.abs(event.values[2]) > 10) {

            textX.setText("X: " + event.values[0]);
            textY.setText("Y: " + event.values[1]);
        }
    }
}
