package com.example.escaperoom;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class Clockdaypopup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.clockdaypopup);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.6));


    }
}
