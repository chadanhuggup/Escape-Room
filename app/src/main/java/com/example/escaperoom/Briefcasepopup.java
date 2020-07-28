package com.example.escaperoom;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Briefcasepopup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.briefcasepopup);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.5));


        //try password button
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final TextView briefcaseInstruction = (TextView) findViewById(R.id.briefcaseInstruction);
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);

        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEditText.getText().toString().toLowerCase();

                if(password.equals("13579")){
                    briefcaseInstruction.setText("Password to leave: It is a function used to maintain integrity. An algorithm performed on data such as a file or message to produce a number called a checksum.");
                }else if (password.equals("")){
                    Toast.makeText(getApplicationContext(), "Cannot submit blank field", Toast.LENGTH_SHORT).show();
                    briefcaseInstruction.setText("Enter briefcase access pin for final clue");
                }else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    passwordEditText.setText("");
                    briefcaseInstruction.setText("Enter briefcase access pin for final clue");
                }
            }
        });


    }
}
