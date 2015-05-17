package com.example.caoyi.runamnia;

/**
 * Created by de-weikung on 5/16/15.
 */


import com.example.caoyi.runamnia.util.RunningRecord;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class UserJsonWriter {

    public void writeToFile(Record r)throws FileNotFoundException {

        JsonObjectBuilder UserBuilder = Json.createObjectBuilder();
        JsonArrayBuilder historyArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder singleHistoryBuilder = Json.createObjectBuilder();

        JsonArrayBuilder challengeArrayBuilder = Json.createArrayBuilder();
        JsonObjectBuilder singlechallengeBuilder = Json.createObjectBuilder();

        for (int i = 0; i < r.getRunHistory().size(); i++) {
            RunningRecord temp = r.getRunHistory().get(i);
            singleHistoryBuilder.add("StartDate", temp.getStartTime().toString())
                    .add("EndDate", temp.getEndTime().toString())
                    .add("Calories", temp.getCalories())
                    .add("Distance", temp.getDistance())
                    .add("Weight", temp.getWeight())
                    .add("Height", temp.getHeight());
            historyArrayBuilder.add(singleHistoryBuilder);
        }

        for (String key : r.getChallenges().keySet()) {
            singlechallengeBuilder.add("ChallengeName", key);
            if (r.getChallenges().get(key).getCompleted())
                singlechallengeBuilder.add("Complete", "True");
            else
                singlechallengeBuilder.add("Complete", "False");
            challengeArrayBuilder.add(singlechallengeBuilder);
        }

        UserBuilder.add("Name", r.getName());
        UserBuilder.add("Gender", r.getGender());
        UserBuilder.add("Weight", r.getWeight());
        UserBuilder.add("Height", r.getHeight());
        UserBuilder.add("History", historyArrayBuilder);
        UserBuilder.add("Challenge", challengeArrayBuilder);

        JsonObject UserJsonObject = UserBuilder.build();

        OutputStream os = new FileOutputStream("/Users/Chih-YenChang/Documents/HoustonHackathon/Runmania/app/src/main/res/userInfo.config");
        JsonWriter jsonWriter = Json.createWriter(os);
        jsonWriter.writeObject(UserJsonObject);
        jsonWriter.close();
    }

}