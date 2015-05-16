package com.example.caoyi.runamnia;

import com.example.caoyi.runamnia.util.RunningRecord;

import java.util.*;

/**
 * Created by Chih-YenChang on 5/16/15.
 */
public class Record {
    private String name;
    private char gender;
    private double height;
    private double weight;
    private ArrayList<RunningRecord> runHistory;
    private Map<String, Map<String,Boolean>> challenges = new HashMap<String, Map<String,Boolean>>();



    public Record(String n, char g, double h, double w, ArrayList<RunningRecord> rh){
        name = n;
        gender = g;
        height = h;
        runHistory = rh;
//        Map<String, Boolean> map = new HashMap<String, Boolean>();
        challenges.put("Run",new HashMap<String,Boolean>().put("This is ...",false));
        challenges.put("Run10mins",);
        challenges.put("Run20mins", false);
        challenges.put("Run30mins", false);
        challenges.put("Run40mins", false);
        challenges.put("Run50mins", false);
        challenges.put("Run60mins", false);
        challenges.put("Run90mins", false);
        challenges.put("Run120mins", false);
        challenges.put("Run5k", false);
        challenges.put("Run10k", false);
        challenges.put("Run15k", false);
        challenges.put("Run20k", false);
        challenges.put("Run40k",false);
        challenges.put("Run5kin30mins", false);
        challenges.put("Run10kin60mins", false);
        challenges.put("Run90mins", false);
        challenges.put("Run120mins", false);
        challenges.put("Run5k", false);
        challenges.put("Run10k", false);
        challenges.put("Run15k", false);
        challenges.put("Run20k", false);
        challenges.put("Run40k",false);
        challenges.put("Run5kin30mins", false);
        challenges.put("Run10kin60mins", false);



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

    void setChallenges(String c){
        challenges.put(c,true);
    }

}
