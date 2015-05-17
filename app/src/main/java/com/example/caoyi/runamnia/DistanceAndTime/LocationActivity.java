package com.example.caoyi.runamnia.DistanceAndTime;

import android.app.Activity;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Thomas on 5/16/15 @ HoustonHackathon.
 */
public class LocationActivity extends Activity implements LocationListener {
    static final int MIN_TIME = 5000;
    static final float MIN_DIST = 5;
    LocationManager mgr;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView) findViewById(R.id.txv);

        mgr = (LocationManager) getSystemService(LOCATION_SERVICE);
    }

    @Override
    protected void onResume(){
        super.onResume();

        String best = mgr.getBestProvider(new Criteria(), true);
        if (best != null) {
            txv.setText("Trying to get GPS information...");
            mgr.requestLocationUpdates(best,
                    MIN_TIME, MIN_DIST, this);
        }
        else
            txv.setText("Please make sure that your GPS serivce is open.");
    }

    @Override
    protected void onPause() {
        super.onPause();
        mgr.removeUpdates(this);
    }

    @Override
    public void onLocationChanged(Location location) {
        String str = "Location provider:" + location.getProvider();
        str += String.format("\nLatitude: %.5f\nLongitude: %.5f\nCurrent speed: %.2f",
                location.getLatitude(),
                location.getLongitude(),
                location.getSpeed());
        //txv.setText(str);
        //location.getTime();
    }

    @Override
    public void onProviderDisabled(String provider) {}

    @Override
    public void onProviderEnabled(String provider) {}

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {}

    public void setup(View v) {
        Intent it =
                new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
        startActivity(it);
    }

    public void goBack(View v) {
        finish();
    }
}
