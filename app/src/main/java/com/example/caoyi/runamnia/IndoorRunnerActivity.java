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

import com.example.caoyi.runamnia.util.RunningRecord;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;


public class IndoorRunnerActivity extends ActionBarActivity implements SensorEventListener, View.OnClickListener {
    Button startBtn;
    Button playBtn;
    Button pauseBtn;
    Button endBtn;
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

        startBtn = (Button) findViewById(R.id.start_button);
        pauseBtn = (Button) findViewById(R.id.pause_button);
        endBtn = (Button) findViewById(R.id.end_button);
        startBtn.setOnClickListener(this);
        pauseBtn.setOnClickListener(this);
        endBtn.setOnClickListener(this);

        setContentView(R.layout.main_page);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        activityRunning = true;
        Date startDate;

    try {
        UserJsonReader userJsonReader = new UserJsonReader();
        UserJsonWriter userJsonWriter = new UserJsonWriter();
        /**
         * Get start time.
         */

        startDate = new Date();
        long startTime=new Date().getTime()/1000; // unit: sec

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

        Date endDate = new Date();
        long endTime=new Date().getTime()/1000; // unit: sec
        double steps = count;
        double calories = calculateCalories(startTime, endTime, userRecord); // unit kcal

        RunningRecord runningRecord = new RunningRecord(startDate, endDate, calories, totalDistance, userRecord.getWeight(), userRecord.getHeight());

        userRecord.addRunningRecord(runningRecord);
        checkChallenges(userRecord);

        userJsonWriter.writeToFile(userRecord);
    }
    catch (FileNotFoundException fileNotFoundException){
    }
    catch (org.json.simple.parser.ParseException parseException){

    }
    }

    public double calculateCalories(long startTime, long endTime, Record userRecord){
        long totalTime=endTime-startTime;

        double height = userRecord.getHeight();
        double weight = userRecord.getWeight();

        double BMR = 10 * weight + 6.25 * height - 125 + 5;

        return BMR*totalTime/86400;
    }

    public void checkChallenges(Record record){
        ArrayList<RunningRecord> tempRecords = record.getRunHistory();
        int prevChallengeCount;


        for(int i = 0; i<tempRecords.size(); i++){
            prevChallengeCount = record.getCompletedCount();
            RunningRecord tempRunningRecord = tempRecords.get(i);
            long startTime = tempRunningRecord.getStartTime().getTime()/1000;
            long endTime = tempRunningRecord.getEndTime().getTime()/1000;
            long tempTime = endTime-startTime;

            double tempDistance = tempRunningRecord.getDistance();
            double tempCaloreis = tempRunningRecord.getCalories();


            if(tempDistance >= 40000){
                record.setChallenges("Run40k");
                record.setChallenges("Run30k");
                record.setChallenges("Run20k");
                record.setChallenges("Run10k");
                record.setChallenges("Run5k");
            }
            else if(tempDistance >= 30000){
                record.setChallenges("Run30k");
                record.setChallenges("Run20k");
                record.setChallenges("Run10k");
                record.setChallenges("Run5k");
            }
            else if(tempDistance >= 20000){
                record.setChallenges("Run20k");
                record.setChallenges("Run10k");
                record.setChallenges("Run5k");
            }
            else if(tempDistance >= 10000 && tempTime/60 < 60){
                record.setChallenges("Run10k");
                record.setChallenges("Run5k");
                record.setChallenges("Run10kin60mins");
            }
            else if (tempDistance >= 10000){
                record.setChallenges("Run10k");
                record.setChallenges("Run5k");
            }
            else if (tempDistance >= 5000 && tempTime/60 < 30){
                record.setChallenges("Run5kin30mins");
                record.setChallenges("Run5k");
            }
            else if (tempDistance >= 5000){
                record.setChallenges("Run5k");
            }

            if(tempCaloreis >= 700){
                record.setChallenges("Burn700cals");
                record.setChallenges("Burn600cals");
                record.setChallenges("Burn500cals");
                record.setChallenges("Burn400cals");
                record.setChallenges("Burn300cals");
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 600){
                record.setChallenges("Burn600cals");
                record.setChallenges("Burn500cals");
                record.setChallenges("Burn400cals");
                record.setChallenges("Burn300cals");
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 500){
                record.setChallenges("Burn500cals");
                record.setChallenges("Burn400cals");
                record.setChallenges("Burn300cals");
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 400){
                record.setChallenges("Burn400cals");
                record.setChallenges("Burn300cals");
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 300){
                record.setChallenges("Burn300cals");
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 200){
                record.setChallenges("Burn200cals");
                record.setChallenges("Burn100cals");
            }
            else if(tempCaloreis >= 100){
                record.setChallenges("Burn100cals");
            }


        }

        int newChallengeCount = record.getCompletedCount();
        if(newChallengeCount >= 30){
            record.setChallenges("Get10Challenges");
            record.setChallenges("Get20Challenges");
            record.setChallenges("Get30Challenges");
        }
        else if(newChallengeCount >= 20){
            record.setChallenges("Get20Challenges");
            record.setChallenges("Get10Challenges");
        }
        else if(newChallengeCount >= 10){
            record.setChallenges("Get10Challenges");
        }
    }

    synchronized private void updateLoop(Sensor countSensor){
        while(activityRunning){

            //runmania.sendInstantDistance(tempDistance);
            //String usersSpeeds = runmania.requestFromServer();

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
    public void onAccuracyChanged(Sensor sensor, int accuracy) {}

    public void startRunning(View v) {
        switch (v.getId()) {
            /**
             * Run starts here.
             */
            case R.id.start_button:
                startBtn.setVisibility(Button.GONE);
                pauseBtn.setVisibility(Button.VISIBLE);
                endBtn.setVisibility(Button.VISIBLE);
                break;
            /**
             * Run ends here.
             */
            case R.id.end_button:
                endBtn.setVisibility(Button.GONE);
                startBtn.setVisibility(Button.VISIBLE);
                pauseBtn.setVisibility(Button.VISIBLE);
                endRunning(v);
                break;
        }
    }

    public void endRunning(View v){
        activityRunning = false;
    }

    @Override
    public void onClick(View view) {

    }
}
