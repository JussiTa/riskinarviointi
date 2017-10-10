package com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.jussi.tyokohtainenriskinarviointi.LoginActivity;

import java.util.HashMap;

/**
 * Created by jussi on 1/20/17.
 */

public class SessionManager {

    SharedPreferences pref;

    Context context;
    SharedPreferences.Editor editor;
    int PRIVATE_MODE =0;

    //Shared filename;
    private static final String   PREF_NAME ="RiskinarviointiLomake";

    //All shared preferences key Keys;

    private String IS_LOGGEDIN ="IsLoggedIn";
    //User name and email keys must be public outside access

    public static String KEY_PASS= "psw";
    public static String KEY_EMAIL ="email";



    public SessionManager(Context context){

        this.context =context;

        pref= context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);

        editor = pref.edit();
    }

    public void createLoginSession(String email,String psw){

        editor.putBoolean(IS_LOGGEDIN,true);
        editor.putString(KEY_EMAIL,email);
        editor.putString(KEY_PASS,psw);
        editor.commit();

    }

    public HashMap<String,String> getUserDetails() {
        HashMap<String,String> user =new HashMap<String, String>();

        user.put(KEY_PASS,pref.getString(KEY_PASS,null));
        user.put(KEY_EMAIL,pref.getString(KEY_EMAIL,null));

        return user;

    }

    public void checkLogin(String isl) {

        if (!this.IsLogin()) {
            Intent intent = new Intent(context, LoginActivity.class);

            //Stop all Activities
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            //Add a new flag to start Activity

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(intent);
        }

    }

    public boolean IsLogin() {
        Log.d("KEYVALUE",pref.getString(KEY_EMAIL,null));
       // return pref.getBoolean(PREF_NAME,false);
        if(pref.getString(KEY_PASS,null)!= null&& pref.getString(KEY_EMAIL,null)!=null)



          return true;

        return false;































    }


    public void logout(){
        editor.clear();
        editor.commit();

    }




}
