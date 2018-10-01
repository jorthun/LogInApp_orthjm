package com.example.justi.loginapp_orthjm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class LogIn extends AppCompatActivity {
    EditText emailAddress, password;
    Button logIn, register;
    public static ArrayList<String[]> userInfo = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        emailAddress = (EditText) findViewById(R.id.logInID);
        password = (EditText) findViewById(R.id.logInPassword);
        logIn = (Button) findViewById(R.id.logInButton);
        register = (Button) findViewById(R.id.goToRegisterButton);
    }
    /*
    Sends user to registration page
     */
    public void goToRegistration(View view){
        startActivity(new Intent(LogIn.this,Registration.class));
    }
    /*
    Attempts to log in the user with input information
     */
    public void testLogIn(View view){
        boolean loginFound = false;
        //loops through user information
        for (int i = 0; i < userInfo.size();i++){
            //attempts to find users email
            String email = userInfo.get(i)[2];
            if(email.equals(emailAddress.getText().toString().trim())){
                //check if users email matches password if found
                String pass = userInfo.get(i)[4];
                if (pass.equals(password.getText().toString().trim()))
                loginFound = true;
            }
        }
        //displays if the log in information was found or not
        if (loginFound == false){
            Toast.makeText(this,"Invalid Email or Password", Toast.LENGTH_LONG).show();
        }else {
            Toast.makeText(this,"Email and Password found", Toast.LENGTH_LONG).show();
        }
    }
}
