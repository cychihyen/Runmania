package com.example.caoyi.runamnia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;


public class runmania extends Activity {

    public static class RunType {
        public final static int INDOOR = 0;
        public final static int OUTDOOR = 1;
    }

    String[] countryArray = {"India", "Pakistan", "USA", "UK", "India", "Pakistan", "USA", "UK","India", "Pakistan", "USA", "UK"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview, countryArray);

        ListView listView = (ListView) findViewById(R.id.country_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                final String item = (String) parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), item + " selected", Toast.LENGTH_LONG).show();
            }

        });

        registerBtns();
    }

    private void registerBtns(){
        Button createBtn = (Button)findViewById(R.id.create_button);
        createBtn.setOnClickListener(onClickListener);
        Button accompBtn = (Button)findViewById(R.id.accomplishment_button);
        accompBtn.setOnClickListener(onClickListener);
        Button settingBtn = (Button)findViewById(R.id.setting_button);
        settingBtn.setOnClickListener(onClickListener);
        Button exitBtn = (Button)findViewById(R.id.exit_button);
        exitBtn.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.create_button:
                    createBtnOnClick(v);
                    break;
                case R.id.accomplishment_button:
                    accompBtnOnClick(v);
                    break;
                case R.id.setting_button:
                    settingBtnOnClick(v);
                    break;
                case R.id.exit_button:
                    endBtnOnClick(v);
                    break;
            }

        }
    };

    public void createBtnOnClick(View v) {
        enterCreateRoomPage();
    }

    private void enterCreateRoomPage() {
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        intent.setClass(this, CreateRoomActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void accompBtnOnClick(View v) {
        Toast.makeText(getApplicationContext(), "Clicked on Acc Button", Toast.LENGTH_LONG).show();
    }

    public void settingBtnOnClick(View v) {
        Toast.makeText(getApplicationContext(), "Clicked on Setting Button", Toast.LENGTH_LONG).show();
    }

    public void endBtnOnClick(View v) {
        Toast.makeText(getApplicationContext(), "Clicked on End Button", Toast.LENGTH_LONG).show();
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
