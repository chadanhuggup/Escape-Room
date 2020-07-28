package com.example.escaperoom;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Phonepopup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.phonepopup);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*1));


        //try password button
        final TextView briefcaseInstruction = (TextView) findViewById(R.id.briefcaseInstruction);
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);

        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEditText.getText().toString().toLowerCase();

                if((password.equals("biba"))||(password.equals("biba model"))||(password.equals("kenneth"))||(password.equals("kenneth j. biba"))||(password.equals("kenneth j biba"))||(password.equals("kenneth biba"))||(password.equals("j. biba"))||(password.equals("j biba"))){
                    passwordEditText.setText("");
                    briefcaseInstruction.setText("Clue: Square the even number on the wall");
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(getApplicationContext(), "Cannot submit blank field", Toast.LENGTH_SHORT).show();
                    briefcaseInstruction.setText("Unlock phone for clue\nHint: Name of the model that focuses on integrity. No read down, no write up");
                }else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    passwordEditText.setText("");
                    briefcaseInstruction.setText("Unlock phone for clue\nHint: Name of the model that focuses on integrity. No read down, no write up");
                }
            }
        });


    }
}
