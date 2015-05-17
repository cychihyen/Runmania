package com.example.caoyi.runamnia.DistanceAndTime;

import android.hardware.SensorEvent;
import android.location.Location;
//import android.location.LocationListener;
//import android.widget.TextView;

/**
 * Created by Thomas on 5/16/15 @ HoustonHackathon.
 */
public class DistanceMeasuror {
    //TextView txv;
    private Location preLocation;
    private SensorEvent preEvent;

    public float outdoorDistance(Location curLocation, Location preLocation, float curDistance) {
        float newDistance = curDistance + curLocation.distanceTo(preLocation);
        preLocation.setLatitude(curLocation.getLatitude());
        preLocation.setLongitude(curLocation.getLongitude());

        return newDistance;
    }

    public float indoorDistance(SensorEvent newEvent, float height, float curDistance){
        float numStep = newEvent.values[0];
        float stepSize = height/0.8f;
        float newDistance = curDistance + numStep*stepSize;

        return newDistance;
    }

    /*
    public static float stepSize(float height) {
        double earthRadius = 6371000; //meters
        double dLat = Math.toRadians(lat2-lat1);
        double dLng = Math.toRadians(lng2-lng1);
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        float dist = (float) (earthRadius * c);

        return dist;
    }
    */
}
