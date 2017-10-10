package com.example.jussi.tyokohtainenriskinarviointi;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
/**
 * Created by jussi on 1/3/17.
 */

public class AppController {

public static final String TAG = AppController.class.getSimpleName();
private  RequestQueue requestQueue;
private static AppController mInstance;
private static Context aCtx;
private JsonObjectRequest jsonRequest;



    private AppController(Context context){
        aCtx = context;
        requestQueue=getRequestGueue();
    }

    public static synchronized AppController getInstance(Context context){
        mInstance= new AppController(context);
        return  mInstance;
    }


    public RequestQueue getRequestGueue(){
        if(requestQueue == null)
            requestQueue =Volley.newRequestQueue(aCtx.getApplicationContext());
        return requestQueue;

    }



    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestGueue().add(req);

    }








}
