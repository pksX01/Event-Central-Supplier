package com.example.rudra.eventcentralsupplier;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;


public  class SharedPref {

    public static final String MyPreference="my_pref";
    public static final String Email="mail_key";
    public static final String Password="pass_key";
    public static final String Name ="name_key";
    public static final String Mobile_No ="mob_key";
    private static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;




    public static void clearAll(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
        editor.clear().apply();
    }

    public static void setLogin(Context context,boolean value){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
        editor.putBoolean("IsLogin",value).commit();
    }

    public static boolean getLogin(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        boolean IsLogin=sharedPreferences.getBoolean("IsLogin",false);
        return IsLogin;


    }

    public static void setUserInput(Context context, String email,String password){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
        editor.putString(Email,email);
        editor.putString(Password,password);
        editor.apply();
    }

    public static void setRegInput(Context context,String name, String email, String mobile_No, String password){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
        editor.putString(Name, name);
        editor.putString(Email,email);
        editor.putString(Mobile_No,mobile_No);
        editor.putString(Password,password);
        editor.apply();
    }

    public static String getMail(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Email,null);

    }

    public static String getPassword(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Password,null);
    }

    public static String getName(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Name,null);

    }

    public static String getMobile_No(Context context){
        sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Mobile_No,null);

    }
}

