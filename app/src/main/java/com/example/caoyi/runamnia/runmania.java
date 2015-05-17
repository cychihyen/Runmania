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

import com.example.caoyi.runamnia.util.SystemUiHider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class runmania extends Activity {
    static  BufferedReader in;
    static PrintWriter out;
    static Socket socket;

    public static ClientThread client;

    public class ClientThread implements Runnable{
        public void run(){
            try{
                runmania.socket = new Socket("192.168.3.252", 9898);
                runmania.in = new BufferedReader(
                        new InputStreamReader(runmania.socket.getInputStream()));
                runmania.out = new PrintWriter(runmania.socket.getOutputStream(), true);

                // Consume the initial welcoming messages from the server
                for (int i = 0; i < 2; i++) {
                    System.out.println(runmania.in.readLine() + "\n");
                }
            }catch (IOException e){
                System.out.println(e.getMessage());
            }
        }
        public void createRoom(String roomName, String roomDis){
            runmania.out.println("CreateRoom " + roomName + " " + roomDis);
        }

    }

    private int distance;

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

        this.client = new ClientThread();
        new Thread(client).start();
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
        Intent intent = new Intent(this, CreateRoomActivity.class);
        //Bundle bundle=new Bundle();
        //intent.putExtras(bundle);
        startActivity(intent);
    }

    public void accompBtnOnClick(View v) {
        Toast.makeText(getApplicationContext(), "Clicked on Acc Button", Toast.LENGTH_LONG).show();
    }

    public void settingBtnOnClick(View v) {
        Intent intent = new Intent(this, SettingActivity.class);
        //Bundle bundle=new Bundle();
        //intent.putExtras(bundle);
        startActivity(intent);
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
