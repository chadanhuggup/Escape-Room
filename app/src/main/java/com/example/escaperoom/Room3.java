package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Room3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this part hides notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //this and below line = set to be full screen(no notification bar or tool bar) (think notification and tool bar are the same)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide action bar
        setContentView(R.layout.room3);    //must be after requesting full screen
        getSupportActionBar().hide();   //Activity that only display splash screen only


        Toast.makeText(getApplicationContext(), "Good job, you reached the final room", Toast.LENGTH_SHORT).show();

        //leave button
        ImageButton leave = (ImageButton) findViewById(R.id.leave);
        leave.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room3.this,Answer3.class));
            }
        });


        //cushion button
        final TextView cushionFlagTextView = (TextView) findViewById(R.id.cushionFlagTextView);
        Button cushionButton = (Button) findViewById(R.id.cushionButton);
        final ImageView cushionImage = findViewById(R.id.cushion1);
        cushionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String cushionFlag = cushionFlagTextView.getText().toString();
                if (cushionFlag.equals("0")){
                    ((ViewGroup.MarginLayoutParams)cushionImage.getLayoutParams()).topMargin += 200;
                    cushionImage.requestLayout();
                    cushionFlagTextView.setText("1");
                }else{
                    ((ViewGroup.MarginLayoutParams)cushionImage.getLayoutParams()).topMargin -= 200;
                    cushionImage.requestLayout();
                    cushionFlagTextView.setText("0");
                }
            }
        });

        //pictureframe button
        final TextView pictureframeFlagTextView = (TextView) findViewById(R.id.pictureframeFlagTextView);
        Button pictureframeButton = (Button) findViewById(R.id.pictureframeButton);
        final ImageView pictureframeImage = (ImageView) findViewById(R.id.pictureFrame);
        pictureframeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pictureframe = pictureframeFlagTextView.getText().toString();
                if (pictureframe.equals("0")){
                    ((ViewGroup.MarginLayoutParams)pictureframeImage.getLayoutParams()).topMargin += 400;
                    //((ViewGroup.MarginLayoutParams)pictureframeImage.getLayoutParams()).leftMargin += 400;
                    pictureframeImage.requestLayout();
                    pictureframeFlagTextView.setText("1");
                }else{
                    ((ViewGroup.MarginLayoutParams)pictureframeImage.getLayoutParams()).topMargin -= 400;
                   // ((ViewGroup.MarginLayoutParams)pictureframeImage.getLayoutParams()).leftMargin -= 400;
                    pictureframeImage.requestLayout();
                    pictureframeFlagTextView.setText("0");
                }
            }
        });

        //clockday imageView clickable
        ImageView clockday = (ImageView) findViewById(R.id.clockday);
        clockday.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room3.this,Clockdaypopup.class));
            }
        });

        //clockday imageView clickable
        ImageView blankpaper = (ImageView) findViewById(R.id.blankpaper);
        blankpaper.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room3.this,Blankpaperpopup.class));
            }
        });

        //phone imageView clickable
        ImageView phone = (ImageView) findViewById(R.id.phone);
        phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(Room3.this,Phonepopup.class));
            }
        });

    }
}
