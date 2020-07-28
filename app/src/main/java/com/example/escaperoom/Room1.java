package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class Room1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this part hides notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //this and below line = set to be full screen(no notification bar or tool bar) (think notification and tool bar are the same)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide action bar
        setContentView(R.layout.activity_main);    //must be after requesting full screen
        getSupportActionBar().hide();   //Activity that only display splash screen only

        setContentView(R.layout.room1);

        //wall button
        Button wall = (Button) findViewById(R.id.wall);
        wall.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room1.this,Wallpopup.class));
            }
        });

        //cabinet button
        Button cabinet = (Button) findViewById(R.id.cabinet);
        cabinet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room1.this,Cabinetpopup.class));
            }
        });

        //leave button
        ImageButton leave = (ImageButton) findViewById(R.id.leave);
        leave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //comment out this part for now. want to perfect countdown timer and transferring of countdown timer information first.
                //store textView data into variable to send
                /*TextView minutesTextView = (TextView) findViewById(R.id.minutes);
                TextView secondsTextView = (TextView) findViewById(R.id.seconds);
                long minutesTracker = Long.parseLong(minutesTextView.getText().toString());
                int secondsTracker = Integer.parseInt(secondsTextView.getText().toString());*/


                //send data (amount of hints found) to Answer2 class
                Intent myIntent = new Intent(Room1.this, Room2.class);

                //Commented out this section for now. Want to perfect transferring of countdown information
                /*myIntent.putExtra("minutestosend", Long.toString(minutesTracker));
                myIntent.putExtra("secondstosend", Integer.toString(secondsTracker));
                startActivity(myIntent);*/

                startActivity(new Intent(Room1.this,Answer1.class));
            }
        });

        //sticky note button
        Button chair = (Button) findViewById(R.id.chair);
        chair.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room1.this,Chairpopup.class));
            }
        });

        //briefcase button
        Button briefcase = (Button) findViewById(R.id.briefcase);
        briefcase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room1.this,Briefcasepopup.class));
            }
        });

        //dumpster diving clue in garbage bin, radio button ask what to do when see suspicious email asking for personal info give or report?
        //countdown timer
        //new CountDownTimer(1200000, 1000) {

        //commented out this section for now. need to perfect first
        /*new CountDownTimer(120000, 1000) {
            TextView mTextField = (TextView) findViewById(R.id.mTextField);
            TextView minutesTextView = (TextView) findViewById(R.id.minutes);
            TextView secondsTextView = (TextView) findViewById(R.id.seconds);

            //try to create own seconds
            int sec = 60;

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("Minutes Left" + "\n" + millisUntilFinished / 60000);

                mTextField.setText("Time Left" + "\n" + (millisUntilFinished / 60000) + ":" + (sec));
                minutesTextView.setText("" + millisUntilFinished / 60000);
                secondsTextView.setText("" + sec);

                if(millisUntilFinished <120000){
                    sec = sec - 1;
                    if(sec == 0 && (millisUntilFinished !=0)){
                        sec = 59;
                    }
                }
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                mTextField.setText("Time's up !!");
            }

        }.start();
        */

    }
}
