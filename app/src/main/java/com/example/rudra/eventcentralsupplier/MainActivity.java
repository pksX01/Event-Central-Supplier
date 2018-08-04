package com.example.rudra.eventcentralsupplier;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private LoginButton login_button;

    EditText ed1,ed2;

    public static final String Email ="email_key";
    public static final String Password ="pass_key";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        ed1=(EditText) findViewById(R.id.editText);
        ed2=(EditText) findViewById(R.id.editText2);


        callbackManager = CallbackManager.Factory.create();

        login_button=(LoginButton) findViewById(R.id.login_button);
        ImageView img = (ImageView) findViewById(R.id.fb);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login_button.performClick();

            }
        });



        List< String > permissionNeeds = Arrays.asList("user_photos",
                "public_profile", "AccessToken");
        login_button.registerCallback(callbackManager,
                new FacebookCallback < LoginResult > () {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        // App code
                        Log.d("Success", "Login");
                        Intent intent=  new Intent(MainActivity.this,Plan.class);
                        startActivity(intent);

                        String accessToken = loginResult.getAccessToken()
                                .getToken();
                        Log.i("accessToken", accessToken);
                      //  Toast.makeText(MainActivity.this,accessToken,Toast.LENGTH_LONG).show();
                        GraphRequest request = GraphRequest.newMeRequest(
                                loginResult.getAccessToken(),
                                new GraphRequest.GraphJSONObjectCallback() {
                                    @Override
                                    public void onCompleted(JSONObject object,
                                                            GraphResponse response) {

                                        Log.i("LoginActivity",
                                                response.toString());
                                        try {
                                     //   Toast.makeText(MainActivity.this,object.toString(),Toast.LENGTH_LONG).show();


                                           String id = object.getString("id");
                                            try {
                                                URL profile_pic = new URL(
                                                        "http://graph.facebook.com/" + id + "/picture?type=large");
                                                Log.i("profile_pic",
                                                        profile_pic + "");


                                            } catch (MalformedURLException e) {
                                                e.printStackTrace();
                                            }
                                            String name = object.getString("name");



                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }

                                });
                        Bundle parameters = new Bundle();
                        parameters.putString("fields",
                                "id,name");
                        request.setParameters(parameters);
                        request.executeAsync();
                    }



                    @Override
                    public void onCancel() {
                        // App code
                        Toast.makeText(MainActivity.this, "Login Cancel",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                        Toast.makeText(MainActivity.this,
                                exception.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });

    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void sign_up(View view){
        Intent i=new Intent(MainActivity.this,Sign_up.class);
        startActivity(i);
    }

    public void Sign_click(View v){
       String mail=ed1.getText().toString();
       String pass=ed2.getText().toString();
       String trim_mail=mail.trim();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        SharedPref.setUserInput(this,mail,pass);
       if(TextUtils.isEmpty(SharedPref.getPassword(getApplicationContext())) || TextUtils.isEmpty(SharedPref.getMail(getApplicationContext()))){
           Toast.makeText(MainActivity.this,"Enter email and password",Toast.LENGTH_LONG).show();
        }

       else if(trim_mail.matches(emailPattern)){
           if(pass.length()== 8 && Pass_validation(pass)) {
               SharedPref.setLogin(this, true);
               Toast.makeText(MainActivity.this,"You are signed in",Toast.LENGTH_LONG).show();

               Intent i = new Intent(MainActivity.this, Plan.class);
               startActivity(i);
           }
           else
               Toast.makeText(MainActivity.this,"Enter valid password ",Toast.LENGTH_LONG).show();
        }

        else{
           Toast.makeText(MainActivity.this,"Invalid email ",Toast.LENGTH_LONG).show();
       }

    }

    public static boolean Pass_validation(String str){
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&+=!])(?=\\S+$).{4,}$";
        Pattern pattern= Pattern.compile(PASSWORD_PATTERN);
        Matcher matcher=pattern.matcher(str);
        return matcher.matches();
    }



    public void Forget_click(View v3){
        Toast.makeText(getApplicationContext(),"You have forgotten your password",Toast.LENGTH_SHORT).show();

    }
}
