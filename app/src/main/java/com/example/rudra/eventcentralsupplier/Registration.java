package com.example.rudra.eventcentralsupplier;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.content.Intent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Registration extends AppCompatActivity {

    EditText edtxt1,edtxt2,edtxt3,edtxt4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_registration);

        edtxt1=(EditText) findViewById(R.id.editText3);
         edtxt2=(EditText) findViewById(R.id.editText4);
        edtxt3=(EditText) findViewById(R.id.editText5);
         edtxt4=(EditText) findViewById(R.id.editText6);


    }
    public void sign_in(View view){
        Intent intent=new Intent(Registration.this,MainActivity.class);
        startActivity(intent);
        }


    public void click4(View view) {
        String nam=edtxt1.getText().toString();
        String mail=edtxt2.getText().toString();
        String phone=edtxt3.getText().toString();
        String pass=edtxt4.getText().toString();
        String trim_mail=mail.trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        SharedPref.setRegInput(this,nam,mail,phone,pass);

        if(TextUtils.isEmpty(SharedPref.getName(getApplicationContext()))){
            Toast.makeText(Registration.this,"Enter name",Toast.LENGTH_LONG).show();
        }

       else if(TextUtils.isEmpty(SharedPref.getMail(getApplicationContext()))){
            Toast.makeText(Registration.this,"Enter E-mail",Toast.LENGTH_LONG).show();
        }

        else if(TextUtils.isEmpty(SharedPref.getMobile_No(getApplicationContext()))){
            Toast.makeText(Registration.this,"Enter Mobile No.",Toast.LENGTH_LONG).show();
        }

        else if(TextUtils.isEmpty(SharedPref.getPassword(getApplicationContext()))){
            Toast.makeText(Registration.this,"Enter password",Toast.LENGTH_LONG).show();
        }

        else if(trim_mail.matches(emailPattern)){
            if(pass.length()== 8 && Pass_validation(pass)) {
                SharedPref.setLogin(this, true);
                Toast.makeText(Registration.this,"You are registered and will be automatically signed in",Toast.LENGTH_LONG).show();
                Intent i = new Intent(Registration.this, Plan.class);
                startActivity(i);
            }
            else
                Toast.makeText(Registration.this,"Enter valid password ",Toast.LENGTH_LONG).show();
        }

        else{
            Toast.makeText(Registration.this,"Invalid email ",Toast.LENGTH_LONG).show();
        }

    }


    public static boolean Pass_validation(String str){
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        Pattern pattern= Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }


}
