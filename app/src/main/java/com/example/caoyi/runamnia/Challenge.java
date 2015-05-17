package com.example.caoyi.runamnia;

/**
 * Created by Chih-YenChang on 5/16/15.
 */
public class Challenge {
    private String name;
    private boolean completed;

    public Challenge(String n){
        name = n;
        completed = false;
    }

    /**
     * Helper Functions.
     */
    public void setCompleted(boolean b){
        completed = b;
    }

    public void setName(String n){
        name = n;
    }

    public String getName(){
        return name;
    }

    public boolean getCompleted(){
        return completed;
    }
}
