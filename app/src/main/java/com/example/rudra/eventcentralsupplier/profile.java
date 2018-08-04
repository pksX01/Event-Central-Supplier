package com.example.rudra.eventcentralsupplier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import static android.text.Html.fromHtml;

public class profile extends AppCompatActivity {

    @Override
    public boolean onNavigateUp(){
        finish();
        return true;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Toolbar m_tool=(Toolbar) findViewById(R.id.pro_tool);
        setSupportActionBar(m_tool);
        getSupportActionBar().setTitle(fromHtml("<font color='#ffffff'>Profile Setup</font>"));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void Next(View v){
        SharedPref.clearAll(getApplicationContext());
        Intent i = new Intent(profile.this, MainActivity.class);
        startActivity(i);
        finish();
    }
}
