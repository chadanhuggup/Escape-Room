package com.example.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Answer3 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.answer3);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.8));


        //try password button
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);

        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEditText.getText().toString().toLowerCase();

                if(password.equals("144")){
                    Intent startIntent = new Intent(getApplicationContext(), Exit.class);
                    startActivity(startIntent);
                    passwordEditText.setText("");
                    Toast.makeText(getApplicationContext(), "Congratulations, you escaped !!!!!", Toast.LENGTH_LONG).show();
                }else if (password.equals("")){
                    Toast.makeText(getApplicationContext(), "Cannot submit blank field", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Incorrect", Toast.LENGTH_SHORT).show();
                    passwordEditText.setText("");
                }
            }
        });


    }
}
