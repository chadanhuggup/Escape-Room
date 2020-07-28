package com.example.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Answer2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.answer2);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.5));

        //receive information passed from Room2 class
        Intent intent = getIntent();
        final String counter = intent.getStringExtra("tipsCount");

        //Add count into textView
        TextView counterTextView = (TextView) findViewById(R.id.counterTextView);
        counterTextView.setText(counter);

        //try password button
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);
        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(counter) >= 4){
                    Intent startIntent = new Intent(getApplicationContext(), Room3.class);
                    startActivity(startIntent);
                    Toast.makeText(getApplicationContext(), "Good job, you reached the final room", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "You have not found enough hints", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
