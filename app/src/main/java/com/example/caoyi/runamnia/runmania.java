package com.example.caoyi.runamnia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class runmania extends Activity {

    String[] countryArray = {"India", "Pakistan", "USA", "UK", "India", "Pakistan", "USA", "UK","India", "Pakistan", "USA", "UK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, countryArray);

        ListView listView = (ListView) findViewById(R.id.country_list);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.start_button) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
