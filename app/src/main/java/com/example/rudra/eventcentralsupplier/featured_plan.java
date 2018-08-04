package com.example.rudra.eventcentralsupplier;


//import android.app.Dialog;
import android.support.v4.app.Fragment;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.design.widget.BottomSheetDialog;
import android.widget.Button;


public class featured_plan extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.activity_featured_plan,container,false);
        Button btn=view.findViewById(R.id.btnclick);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v){
            dialog_button();
        }
    });
    return view;
    }
    public void dialog_button(){
        View view = getLayoutInflater().inflate(R.layout.activity_dialog_box,null);
        final BottomSheetDialog dialog=new BottomSheetDialog(getActivity());
        dialog.setContentView(view);
        Button btn=dialog.findViewById(R.id.btn_x);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
