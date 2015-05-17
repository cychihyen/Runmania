package com.example.caoyi.runamnia;

import com.example.caoyi.runamnia.util.RunningRecord;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Created by Chih-YenChang on 5/16/15.
 */
public class UserJsonReader {
    public Record readFromFile() throws FileNotFoundException, org.json.simple.parser.ParseException{
        Record record = new Record();
        ArrayList<RunningRecord> runningHistory = new ArrayList<RunningRecord>();
        Map<String,Challenge> challenges = record.getChallenges();
        String FILE_NAME = "/Users/Chih-YenChang/Documents/HoustonHackathon/Runmania/app/src/main/res/userInfo.config";
        InputStream fis = new FileInputStream(FILE_NAME);

        JSONParser jsonParser = new JSONParser();
        JSONObject response = (JSONObject) jsonParser.parse(fis.toString());
        JSONArray historyArray = (JSONArray) response.get("History");
        JSONArray challengeArray = (JSONArray) response.get("Challenge");

        String name = (String) response.get("Name");
        record.setName(name);

        char gender = (char) response.get("Gender");
        record.setGender(gender);

        double weight = (double) response.get("Weight");
        record.setWeight(weight);

        double height = (double) response.get("Height");
        record.setHeight(height);

        for(int i = 0; i<historyArray.size(); i++){
            JSONObject cur_history = (JSONObject) historyArray.get(i);
            Date sDate = (Date) cur_history.get("StartDate");
            Date eDate = (Date) cur_history.get("EndDate");
            double cal = (double) cur_history.get("Calories");
            double dis = (double) cur_history.get("Distance");
            double h_weight = (double) cur_history.get("Weight");
            double h_height = (double) cur_history.get("Height");

            RunningRecord cur_r = new RunningRecord(sDate,eDate,cal,dis,h_weight,h_height);
            runningHistory.add(cur_r);
        }
        record.setRunHistory(runningHistory);

        for(int i = 0; i<challengeArray.size(); i++){
            JSONObject cur_challenge = (JSONObject) challengeArray.get(i);
            String challengeName = (String) cur_challenge.get("ChallengeName");
            boolean challengeCompleted = (boolean) cur_challenge.get("Complete");
            challenges.get(challengeName).setCompleted(challengeCompleted);
        }

        return record;
    }
}
