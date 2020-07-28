package com.example.escaperoom;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Cabinetpopup extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cabinetpopup);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.5));


        //try password button
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final TextView cabinetInstruction = (TextView) findViewById(R.id.cabinetInstruction);
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);

        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEditText.getText().toString().toLowerCase();

                if(password.equals("lock")){
                    cabinetInstruction.setText("Clue: **THIS** can solve transpositions");
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                }else if (password.equals("")){
                    Toast.makeText(getApplicationContext(), "Cannot submit blank field", Toast.LENGTH_SHORT).show();
                    cabinetInstruction.setText("Enter code to reveal clue in cabinet");
                }else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    passwordEditText.setText("");
                    cabinetInstruction.setText("Enter code to reveal clue in cabinet");
                }
            }
        });


    }
}
