package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Room2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this part hides notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //this and below line = set to be full screen(no notification bar or tool bar) (think notification and tool bar are the same)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide action bar
        setContentView(R.layout.room2);    //must be after requesting full screen
        getSupportActionBar().hide();   //Activity that only display splash screen only

       // setContentView(R.layout.room1);

        Toast.makeText(Room2.this, "Find at least 4 tips about secure password to proceed", Toast.LENGTH_LONG).show();

        //comment out this part for now. want to perfect countdown timer and receiving of countdown timer information first.
        //receive Time information passed from Room1 class
        /*Intent intent = getIntent();
        final String secondsReceived = intent.getStringExtra("secondstosend");
        final String minutesReceived = intent.getStringExtra("minutestosend");*/

        //leave button
        ImageButton leave = (ImageButton) findViewById(R.id.leave);
        leave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                TextView counterTextView = (TextView) findViewById(R.id.counter);
                int counter = Integer.parseInt(counterTextView.getText().toString());

                //send data (amount of hints found) to Answer2 class
                Intent myIntent = new Intent(Room2.this, Answer2.class);
                myIntent.putExtra("tipsCount", Integer.toString(counter));
                startActivity(myIntent);

                //no need to start this intent (don't need the leave box to pop up)
                //startActivity(new Intent(Room2.this,Answer2.class));
            }
        });

        //hint buttons
        final Button hint = (Button) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint.getText().equals("1"))){
                    hint.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: make passwords long", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint2 = (Button) findViewById(R.id.hint2);
        hint2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint2.getText().equals("1"))){
                    hint2.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint2.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: include symbols", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint3 = (Button) findViewById(R.id.hint3);
        hint3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint3.getText().equals("1"))){
                    hint3.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint3.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: include numbers", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint4 = (Button) findViewById(R.id.hint4);
        hint4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint4.getText().equals("1"))){
                    hint4.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint4.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: include uppercase", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint5 = (Button) findViewById(R.id.hint5);
        hint5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint5.getText().equals("1"))){
                    hint5.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint5.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: include lowercase", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint6 = (Button) findViewById(R.id.hint6);
        hint6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //this part just increments counter on hints found
                if (!(hint6.getText().equals("1"))){
                    hint6.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint6.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }

                Toast.makeText(Room2.this, "Tip: avoid dictionary words", Toast.LENGTH_SHORT).show();
            }
        });

        final Button hint7 = (Button) findViewById(R.id.hint7);
        hint7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if (!(hint7.getText().equals("1"))){
                    hint7.setText("1");
                    int counter = 0;
                    TextView counterTextView = (TextView) findViewById(R.id.counter);
                    counter = Integer.parseInt(counterTextView.getText().toString());
                    counter = counter +1;
                    hint7.setBackgroundColor(Color.YELLOW);
                    counterTextView.setText(Integer.toString(counter));
                }
                Toast.makeText(Room2.this, "Tip: don't use personal information", Toast.LENGTH_SHORT).show();
            }
        });


        //commented out this timer section as need perfect the transferring of timer information
        //minutes part not going back up. like not sending information after it reduce and go back up
        //dumpster diving clue in garbage bin, radio button ask what to do when see suspicious email asking for personal info give or report?
        //countdown timer
        //new CountDownTimer(1200000, 1000) {
        /*new CountDownTimer(120000, 1000) {
            TextView mTextField = (TextView) findViewById(R.id.mTextField);
            TextView minutesTextView = (TextView) findViewById(R.id.minutes);
            TextView secondsTextView = (TextView) findViewById(R.id.seconds);

            //try to create own seconds
            int sec = Integer.parseInt(secondsReceived);//60;//Integer.parseInt(secondsTracker);

            public void onTick(long millisUntilFinished) {
                millisUntilFinished = Long.parseLong(minutesReceived);
                //millisUntilFinished = Long.parseLong(minutesTracker);
                //mTextField.setText("Minutes Left" + "\n" + millisUntilFinished / 60000);

                mTextField.setText("Time"+minutesReceived+"Left" + "\n" + (millisUntilFinished / 60000) + ":" + (sec));
                minutesTextView.setText("" + millisUntilFinished / 60000);
                secondsTextView.setText("" + sec);

                if(millisUntilFinished <120000){
                    sec = sec - 1;
                    if(sec == 0 && (millisUntilFinished !=0)){
                        sec = 59;
                    }
                }
                //here you can have your logic to set text to editText
            }

            public void onFinish() {
                mTextField.setText("Time's up !!");
            }

        }.start();
        */


    }
}
