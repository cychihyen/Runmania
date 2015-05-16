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

    Date getStartTime(){
        return startTime;
    }

    Date getEndTime(){
        return endTime;
    }

    double getCalories(){
        return calories;
    }

    double getDistance(){
        return distance;
    }

    double getWeight(){
        return weight;
    }

    double getHeight(){
        return height;
    }

    void setStartTime(Date d){
        startTime = d;
    }

    void setEndTime(Date d){
        endTime = d;
    }

    void setCalories(double c){
        calories = c;
    }

    void setDistance(double d){
        distance = d;
    }

    void setWeight(double w){
        weight = w;
    }

    void setHeight(double h){
        height = h;
    }
}
