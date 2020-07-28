package com.example.escaperoom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Answer1 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.answer1);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        getWindow().setLayout((int)(width*.5),(int)(height*.5));


        //try password button
        final EditText passwordEditText = (EditText) findViewById(R.id.passwordEditText);
        final Button tryPassword = (Button) findViewById(R.id.tryPasswordButton);

        tryPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordEditText.getText().toString().toLowerCase();

                if((password.equals("hash"))||(password.equals("hashing"))||(password.equals("hash values"))||(password.equals("hash value"))||(password.equals("hash function"))){
                    Intent startIntent = new Intent(getApplicationContext(), Room2.class);
                    startActivity(startIntent);
                    passwordEditText.setText("");
                    Toast.makeText(getApplicationContext(), "Well done, you made it to the second room", Toast.LENGTH_SHORT).show();
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
