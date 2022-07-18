package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main3Activity extends AppCompatActivity implements SensorEventListener {
    private final String TAG = "Main3Activity";
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    TextView coordinateX;
    TextView coordinateY;
    TextView coordinateZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3_main);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        coordinateX = (TextView) findViewById(R.id.coordX);
        coordinateY = (TextView) findViewById(R.id.coordY);
        coordinateZ = (TextView) findViewById(R.id.coordZ);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            coordinateX.setText(String.valueOf(sensorX));
            coordinateY.setText(String.valueOf(sensorY));
            coordinateZ.setText(String.valueOf(sensorZ));
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        Intent intent = new Intent(this, Activity3.class);
        startActivity(intent);
    }
}