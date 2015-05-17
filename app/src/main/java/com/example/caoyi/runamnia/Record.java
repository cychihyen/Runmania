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
    private Map<String, Challenge> challenges = new HashMap<String, Challenge>();

    public Record(){
        challenges.put("Run10mins",new Challenge("Run for 10 minutes!"));
        challenges.put("Run20mins",new Challenge("Run for 20 minutes!"));
        challenges.put("Run30mins",new Challenge("Run for 30 minutes!"));
        challenges.put("Run40mins",new Challenge("Run for 40 minutes!"));
        challenges.put("Run50mins",new Challenge("Run for 50 minutes!"));
        challenges.put("Run60mins",new Challenge("Run for 1 hour!"));
        challenges.put("Run90mins",new Challenge("Run for 1.5 hour!"));
        challenges.put("Run120mins",new Challenge("Run for 2 hours!"));

        challenges.put("Run5k",new Challenge("Run for 5 kilometers"));
        challenges.put("Run10k",new Challenge("Run for 10 kilometers!"));
        challenges.put("Run15k",new Challenge("Run for 15 kilometers!"));
        challenges.put("Run20k",new Challenge("Complete a Half Marathon!"));
        challenges.put("Run40k",new Challenge("Complete a full Marathon!"));
        challenges.put("Run5kin30mins",new Challenge("Complete 5k in 30 Minutes!"));
        challenges.put("Run10kin60mins",new Challenge("Complete 10k in 1 hour!"));

        challenges.put("Run7days",new Challenge("Run 1 week in a roll!"));
        challenges.put("Run14days",new Challenge("Run 2 weeks in a roll!"));
        challenges.put("Run30days",new Challenge("Run 1 month in a roll!"));
        challenges.put("Run10daysin1month",new Challenge("Run 10 days in a month!"));
        challenges.put("Run20daysin1month",new Challenge("Run 20 days in a month!"));

        challenges.put("Burn100cals",new Challenge("Burn 100 calories!"));
        challenges.put("Burn200cals",new Challenge("Burn 200 calories!"));
        challenges.put("Burn300cals",new Challenge("Burn 300 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 400 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 500 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 600 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 700 calories!"));

        challenges.put("Get10challenges",new Challenge("Complete 10 challenges"));
        challenges.put("Get10challenges",new Challenge("Complete 20 challenges"));
        challenges.put("Get10challenges",new Challenge("Complete 30 challenges"));

        challenges.put("Get3challengesin1day",new Challenge("Complete 3 challenges in a day"));
        challenges.put("Get5challengesin1day",new Challenge("Complete 5 challenges in a day"));
        challenges.put("Get10challengesin1day",new Challenge("Complete 10 challenges in a day"));
    }

    public Record(String n, char g, double h, double w, ArrayList<RunningRecord> rh){
        name = n;
        gender = g;
        height = h;
        runHistory = rh;
        challenges.put("Run10mins",new Challenge("Run for 10 minutes!"));
        challenges.put("Run20mins",new Challenge("Run for 20 minutes!"));
        challenges.put("Run30mins",new Challenge("Run for 30 minutes!"));
        challenges.put("Run40mins",new Challenge("Run for 40 minutes!"));
        challenges.put("Run50mins",new Challenge("Run for 50 minutes!"));
        challenges.put("Run60mins",new Challenge("Run for 1 hour!"));
        challenges.put("Run90mins",new Challenge("Run for 1.5 hour!"));
        challenges.put("Run120mins",new Challenge("Run for 2 hours!"));

        challenges.put("Run5k",new Challenge("Run for 5 kilometers"));
        challenges.put("Run10k",new Challenge("Run for 10 kilometers!"));
        challenges.put("Run15k",new Challenge("Run for 15 kilometers!"));
        challenges.put("Run20k",new Challenge("Complete a Half Marathon!"));
        challenges.put("Run40k",new Challenge("Complete a full Marathon!"));
        challenges.put("Run5kin30mins",new Challenge("Complete 5k in 30 Minutes!"));
        challenges.put("Run10kin60mins",new Challenge("Complete 10k in 1 hour!"));

        challenges.put("Run7days",new Challenge("Run 1 week in a roll!"));
        challenges.put("Run14days",new Challenge("Run 2 weeks in a roll!"));
        challenges.put("Run30days",new Challenge("Run 1 month in a roll!"));
        challenges.put("Run10daysin1month",new Challenge("Run 10 days in a month!"));
        challenges.put("Run20daysin1month",new Challenge("Run 20 days in a month!"));

        challenges.put("Burn100cals",new Challenge("Burn 100 calories!"));
        challenges.put("Burn200cals",new Challenge("Burn 200 calories!"));
        challenges.put("Burn300cals",new Challenge("Burn 300 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 400 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 500 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 600 calories!"));
        challenges.put("Burn400cals",new Challenge("Burn 700 calories!"));

        challenges.put("Get10challenges",new Challenge("Complete 10 challenges"));
        challenges.put("Get10challenges",new Challenge("Complete 20 challenges"));
        challenges.put("Get10challenges",new Challenge("Complete 30 challenges"));

        challenges.put("Get3challengesin1day",new Challenge("Complete 3 challenges in a day"));
        challenges.put("Get5challengesin1day",new Challenge("Complete 5 challenges in a day"));
        challenges.put("Get10challengesin1day",new Challenge("Complete 10 challenges in a day"));

    }


    /**
     * Helper Functions
     */
    public String getName(){
        return name;
    }

    public char getGender(){
        return gender;
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }

    public ArrayList<RunningRecord> getRunHistory(){
        return runHistory;
    }

    public Map<String, Challenge> getChallenges(){
        return challenges;
    }

    public void setName(String n){
        name = n;
    }

    public void setGender(char g){
        gender = g;
    }

    public void setRunHistory(ArrayList<RunningRecord> arr){
        runHistory = arr;
    }

    public void addRunHistoy(RunningRecord rr){
        runHistory.add(rr);
    }

    public void setWeight(double w){
        weight = w;
    }

    public void setHeight(double h){
        height = h;
    }
    public void setChallenges(String c){
        challenges.get(c).setCompleted(true);
    }

}
