package com.example.caoyi.runamnia;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by ting on 5/17/15.
 */
public class SettingActivity extends Activity {
    public class CreateRoomActivity extends Activity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.setting);

            Button doneBtn = (Button) findViewById(R.id.done_button);
            doneBtn.setOnClickListener(onClickListener);
        }

        private View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                switch (v.getId()) {
                    case R.id.done_button:
                        set();
                        break;
                }

            }
        };

        private void set(){

        }
    }
}
