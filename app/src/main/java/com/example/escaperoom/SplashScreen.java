package com.example.escaperoom;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //this part hides notification bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);  //this and below line = set to be full screen(no notification bar or tool bar) (think notification and tool bar are the same)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //this part hides action bar
        setContentView(R.layout.activity_splash_screen);    //must be after requesting full screen
        getSupportActionBar().hide();   //Activity that only display splash screen only

        SplashScreenLauncher splashScreenLauncher = new SplashScreenLauncher();
        splashScreenLauncher.start();
    }

    private class SplashScreenLauncher extends Thread{
        public void run(){
            try {
                sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            Intent intent = new Intent(SplashScreen.this, MainActivity.class);
            startActivity(intent);
            SplashScreen.this.finish();
        }
    }
}
