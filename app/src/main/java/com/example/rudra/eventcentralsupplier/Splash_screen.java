package com.example.rudra.eventcentralsupplier;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class Splash_screen extends AppCompatActivity {
private static int Splash_time_out=2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash_screen);
        //String usr_mail=getSharedPreferences("MyPref1", Context.MODE_PRIVATE).getString("email_key",null);
        //Toast.makeText(Splash_screen.this, usr_mail, Toast.LENGTH_LONG).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if(SharedPref.getLogin(getApplicationContext()) ){
               //if(SharedPref.getMail(getApplicationContext())!=null && SharedPref.getPassword(getApplicationContext() )!=null){
                    Intent i = new Intent(Splash_screen.this, Plan.class);
                    startActivity(i);
                    finish();
                }
                else
                {
                    Intent i = new Intent(Splash_screen.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        },Splash_time_out);



    }
}
