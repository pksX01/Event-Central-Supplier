package com.example.rudra.eventcentralsupplier;

//import android.app.Dialog;
//import android.content.Context;
//import android.content.Intent;
//import android.support.design.widget.BottomSheetDialog;
//import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Button;

public class dialog_box extends AppCompatActivity {

    protected void onCreate ( Bundle savedInstanceState) {

       super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_box);

    }
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activity_pro_plan, container, false);
        TextView txt=view.findViewById(R.id.feature0);
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(dialog_box.this,profile.class);
                startActivity(intent);
            }
        });
        return view;
    }*/

    public void Plan1(View view){
        Intent intent=new Intent(dialog_box.this,profile.class);
        startActivity(intent);
    }


    public void Plan2(View view){
        Intent intent=new Intent(dialog_box.this,profile.class);
        startActivity(intent);
    }

    public void Plan3(View view){
        Intent intent=new Intent(dialog_box.this,profile.class);
        startActivity(intent);
    }
}