package com.example.rudra.eventcentralsupplier;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class Sign_up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }
    public void Sign_up1(View view){
        Intent intent=new Intent(Sign_up.this,Registration.class);
        startActivity(intent);
    }

    public void Learn_more(View v){
        Toast.makeText(getApplicationContext(),"Learn More",Toast.LENGTH_SHORT).show();

    }

    public void Skip(View view){
        Toast.makeText(getApplicationContext(),"Learn More",Toast.LENGTH_SHORT).show();



    }
}
