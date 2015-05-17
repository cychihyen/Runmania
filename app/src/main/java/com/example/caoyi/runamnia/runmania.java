package com.example.caoyi.runamnia;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
                //Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
            }
        });

        this.client = new ClientThread();
        new Thread(client).start();
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
