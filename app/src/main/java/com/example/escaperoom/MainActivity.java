package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //forces app to close when press back button on hone screen. this is so it doesn't return to a room after pass third room and return to home
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this part hides notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //this and below line = set to be full screen(no notification bar or tool bar) (think notification and tool bar are the same)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //hide action bar
        setContentView(R.layout.activity_main);    //must be after requesting full screen
        getSupportActionBar().hide();   //Activity that only display splash screen only

        //info button
        Button info = (Button) findViewById(R.id.info);
        info.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Infopopup.class));
            }
        });

        //how button
        Button how = (Button) findViewById(R.id.how);
        how.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Howpopup.class));
            }
        });

        //play button
        Button play = (Button) findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(MainActivity.this,Room1.class));
            }
        });
    }
}
