package com.example.caoyi.runamnia.util;

import java.util.*;

/**
 * Created by Chih-YenChang on 5/16/15.
 */
public class RunningRecord {
    private Date startTime;
    private Date endTime;
    private double calories;
    private double distance;
    private double weight;
    private double height;

    /**
     * Helper Functions
     */

    public Date getStartTime(){
        return startTime;
    }

    public Date getEndTime(){
        return endTime;
    }

    public double getCalories(){
        return calories;
    }

    public double getDistance(){
        return distance;
    }

    public double getWeight(){
        return weight;
    }

    public double getHeight(){
        return height;
    }

    public void setStartTime(Date d){
        startTime = d;
    }

    public void setEndTime(Date d){
        endTime = d;
    }

    public void setCalories(double c){
        calories = c;
    }

    public void setDistance(double d){
        distance = d;
    }

    public void setWeight(double w){
        weight = w;
    }

    public void setHeight(double h){
        height = h;
    }
}
