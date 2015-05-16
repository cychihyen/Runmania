package com.example.caoyi.runamnia.util;

import java.util.*;

/**
 * Created by Chih-YenChang on 5/16/15.
 */
public class Record {
    private String name;
    private char gender;
    private ArrayList<RunningRecord> runHistory;
    private HashMap<String, Boolean> challenges = new HashMap<String, Boolean>();



    public Record(String n, char g, ArrayList<RunningRecord> rh){
        name = n;
        gender = g;
        runHistory = rh;
        challenges.put("", false);
    }


    /**
     * Helper Functions
     */
    String getName(){
        return name;
    }

    char getGender(){
        return gender;
    }

    ArrayList<RunningRecord> getRunHistory(){
        return runHistory;
    }

    HashMap<String, Boolean> getChallenges(){
        return challenges;
    }

    void setName(String n){
        name = n;
    }

    void setGender(char g){
        gender = g;
    }

    void addRunHistoy(RunningRecord rr){
        runHistory.add(rr);
    }

    void setChallenges(String c)

}
