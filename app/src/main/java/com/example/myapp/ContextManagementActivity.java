package com.example.myapp;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ContextManagementActivity extends AppCompatActivity {


        String room;
    private Object state;
    private android.os.Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_management);

        // get room id from EditText
        ((Button) findViewById(R.id.buttonCheck)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                room = ((EditText) findViewById(R.id.editText1))
                        .getText().toString();
                retrieveRoomContextState(room);
            }
        });
    }


    protected void onUpdate(RoomContextState context) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_management);

        ((Button) findViewById(R.id.buttonCheck)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                room = ((EditText) findViewById(R.id.editText1))
                        .getText().toString();
                retrieveRoomContextState(room);
            }
        });
    }



    protected void updateContextView() {
        if (this.state != null) {
            contextView.setVisibility(View.VISIBLE);
            ((TextView) findViewById(R.id.textViewLightValue)).setText(Integer
                    .toString(state.getLight()));//getLightLevel
            ((TextView) findViewById(R.id.textViewNoiseValue)).setText(Float
                    .toString(state.getNoise()));//getNoiseLevel
            if (state.getStatus().equals(RoomContextState.ON)) //getLightStatus
                image.setImageResource(R.drawable.ic_bulb_on);
            else
                image.setImageResource(R.drawable.ic_bulb_off);
        } else {
            initView();
        }
    }



    public void retrieveRoomContextState(String room) {
    }


    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/


}
