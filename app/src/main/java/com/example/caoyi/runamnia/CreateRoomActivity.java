package com.example.caoyi.runamnia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by ting on 5/17/15.
 */
public class CreateRoomActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_new_room);

        Button createBtn = (Button)findViewById(R.id.create_room_button);
        createBtn.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(final View v) {
            switch(v.getId()){
                case R.id.create_room_button:
                    createRoomBtnOnClick(v);
                    break;
            }

        }
    };

    private void createRoomBtnOnClick(View view) {
        enterRoom(runmania.RunType.INDOOR);
    }

    private void enterRoom(int runType) {
        //DialogInterface dialog,
        Intent intent = new Intent();
        Bundle bundle=new Bundle();
        switch(runType) {
            case runmania.RunType.INDOOR:
                intent.setClass(this, IndoorRunnerActivity.class);
                bundle.putInt("Player", 1);
                break;
            case runmania.RunType.OUTDOOR:
                intent.setClass(this, OutdoorRunnerActivity.class);
                bundle.putInt("Player", 1);
                //ProgressDialog dialog = ProgressDialog.show(this, "", "Loading. Please wait...", true);
                break;
            default:
                Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                return;
        }
        //dialog.cancel();
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
