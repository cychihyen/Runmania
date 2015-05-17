package com.example.caoyi.runamnia;

import android.content.Context;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.hardware.*;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.util.Date;

public class IndoorRunnerActivity extends ActionBarActivity implements SensorEventListener, View.OnClickListener {
    Button playBtn;
    Button pauseBtn;
    private SensorManager sensorManager;
    private double count;
    boolean activityRunning;


    private double tempDistance = 0;
    private double tempTimestamp = 0;
    Record userRecord;

    double totalDistance=0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        playBtn = (Button) findViewById(R.id.button_start);
        pauseBtn = (Button) findViewById(R.id.button_end);
        playBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        setContentView(R.layout.activity_indoor_runner);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        activityRunning = true;
        Date startTime;

    try {
        UserJsonReader userJsonReader = new UserJsonReader();
        UserJsonWriter userJsonWriter = new UserJsonWriter();
        /**
         * Get start time.
         */
        startTime = new Date();

        userRecord = userJsonReader.readFromFile();
        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
        if (countSensor != null) {
            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
        } else {
            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
        }

        /**
         * loop sensor updates
         */
        updateLoop(countSensor);

        Date endTime = new Date();
        double steps = count;


        //user hit stop button -> get end time


        //calculate calories
        calculateCalories();


        //get distance,endtime



        //add runningRecord constructor
        //  -> userRecord.addRunningRecord(rr);
        //check challenge (complete -> true)
        //update user record (sets function)
        //userJsonWriter.writeeToFile(userRecord);
    }
    catch (FileNotFoundException fileNotFoundException){
    }
    catch (org.json.simple.parser.ParseException parseException){

    }
    }

//    To do: implement calculateCalories()
    public int calculateCalories(){
        return 1000;
    }


    synchronized private void updateLoop(Sensor countSensor){
        while(activityRunning){

            runmania.sendInstantDistance(tempDistance);
            String usersSpeeds runmania.requestFromServer();
            // send data to server
            // update view using tmp Class
            try {

                   Thread.sleep(500); //Constant
            } catch (Exception e) {

            }



        }
    }

    @Override
    public void onSensorChanged(SensorEvent event){
        boolean first=true;
        double previousTotalDistance = 0;
        if(activityRunning){
            int stepCount = (int) event.values[0];
            double height = userRecord.getHeight();

            if (first) {
                totalDistance = stepCount*(height/0.8);
                previousTotalDistance = totalDistance;
                first=false;
            }
            else{
                previousTotalDistance=totalDistance;
                totalDistance = stepCount*(height/0.8);
//                totalDistance+=previousTotalDistance;
            }
//            tempTimestamp = new Date() - startTime;
            tempDistance=totalDistance - previousTotalDistance;
            // update tmp Class


        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public void startRunning(View v) {
        switch (v.getId()) {
            /**
             * Run starts here.
             */
            case R.id.button_start:
                playBtn.setVisibility(Button.GONE);
                pauseBtn.setVisibility(Button.VISIBLE);
                break;
            /**
             * Run starts here.
             */
            case R.id.button_end:
                pauseBtn.setVisibility(Button.GONE);
                playBtn.setVisibility(Button.VISIBLE);
                break;
        }
    }

    public void endRunning(View v){
        activityRunning = false;
    }
}
