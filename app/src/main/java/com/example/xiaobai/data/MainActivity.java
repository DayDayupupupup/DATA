package com.example.xiaobai.data;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{

    private SensorManager sensorManager;
    private Sensor mag;
    private TextView mag_info;
    private TextView mag_x;
    private TextView mag_y;
    private TextView mag_z;

    double magValue;
//    float magValues[] = new float[3];
//    float r[] = new float[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mag_info = (TextView) findViewById(R.id.mag_info);
        mag_x = (TextView) findViewById(R.id.mag_x);
        mag_y = (TextView) findViewById(R.id.mag_y);
        mag_z = (TextView) findViewById(R.id.mag_z);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mag = sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        sensorManager.registerListener(new MySensorListener(),mag,SensorManager.SENSOR_DELAY_GAME);
    }

    public class MySensorListener implements SensorEventListener {

        public void onAccuracyChanged(Sensor sensor,int accuracy){};

        public void onSensorChanged(SensorEvent event){

            double sum = Math.pow(event.values[0],2)+Math.pow(event.values[1],2)+Math.pow(event.values[2],2);
            magValue = Math.sqrt(sum);
//            mag_x.setText("x:"+event.values[0]);
//            mag_y.setText("y:"+event.values[1]);
//            mag_z.setText("z:"+event.values[2]);
            mag_info.setText("绝对值"+magValue);

        }

    }
}
