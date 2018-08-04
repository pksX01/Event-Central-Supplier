package com.example.rudra.eventcentralsupplier;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class trail_plan extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_trail_plan, container, false);
        Button btn = view.findViewById(R.id.select_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Select();
            }
        });
        return view;
    }

    public void Select (){
        //Toast.makeText(getActivity().getApplicationContext(),"7 days Trial started",Toast.LENGTH_LONG).show();
        Intent intent=new Intent(getActivity(),profile.class);
        startActivity(intent);
    }
}





