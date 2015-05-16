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
    void setCompleted(boolean b){
        completed = b;
    }

    void setName(String n){
        name = n;
    }

    String getName(){
        return name;
    }

    boolean getCompleted(){
        return completed;
    }
}
