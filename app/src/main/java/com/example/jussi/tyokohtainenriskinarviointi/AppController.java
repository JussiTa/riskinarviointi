package com.example.jussi.tyokohtainenriskinarviointi;

import android.app.Application;
import android.text.TextUtils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
/**
 * Created by jussi on 1/3/17.
 */

public class AppController extends Application {

public static final String TAG = AppController.class.getSimpleName();
private  RequestQueue requestQueue;
private static AppController mInstance;

    @Override
    public void onCreate(){
        super.onCreate();
        mInstance = this;
        requestQueue = Volley.newRequestQueue(this);
    }

    public static synchronized AppController getInstance(){
        return  mInstance;
    }


    public RequestQueue getRequestGueue(){
        if(requestQueue == null)
            requestQueue =Volley.newRequestQueue(getApplicationContext());
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req, String tag ){
            req.setTag(TextUtils.isEmpty(tag) ? TAG: tag);
            getRequestGueue().add(req);
    }


    public <T> void addToRequestQueue(Request<T> req){
        req.setTag(TAG);
        getRequestGueue().add(req);

    }

    public void cancelPendingRequests(Object tag){
        if(requestQueue!=null)
            requestQueue.cancelAll(tag);



    }


}
