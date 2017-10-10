package com.example.jussi.tyokohtainenriskinarviointi;


import android.app.Activity;
import android.app.LoaderManager;
import android.content.Context;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session.SendEmail;
import com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends Activity {


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;

    private View mLoginFormView;
    String jsonEncode;


    SessionManager session;

    private String mpassword;
    static String mEmail;

    JSONObject jsonObj;
    String uuid;
    String ok;
    String errorMessage;
    Boolean noErrors = false;
    private StringBuilder sb = new StringBuilder();
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);
        session = new SessionManager(this.getApplicationContext());
        InputStream is;
        int i;
        String line;


        is = this.getBaseContext().getResources().openRawResource(R.raw.password);

        try {

            while ((i = is.read()) != -1) {
                sb.append((char) i);

            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEmail = mEmailView.getText().toString();
                mpassword = mPasswordView.getText().toString();

                if (correctEmail(mEmail) && isStrongPassword(mpassword)) {
                    //sendEmail= new SendEmail(mEmail,  sb.toString());
                    tryToRegister();

                } else if (!correctEmail(mEmail))
                    mEmailView.setText("Sähköposti ei kelpaa");
                else if (!isStrongPassword(mpassword))
                    mPasswordView.setError("Käytä pieniä ja isoja kirjaimia sekä numeroita väh 5 merkin verran!");
            }
        });
    }

    private void tryToRegister() {

        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

// Instantiate the RequestQueue with the cache and network.
        requestQueue = AppController.getInstance(this).getRequestGueue();

// Start the queue
        requestQueue.start();
        //urt.execute((Void) null);

        final String url = "https://botniamillservice.000webhostapp.com/register.php";
        final Context context = getContext();

        // Request a string response from the provided URL.


        StringRequest strinRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        JSONObject jsonobejct = null;
                        try {
                            jsonobejct = new JSONObject(response);

                            String error = jsonobejct.getString("error");
                            if (error.equals("false")) {
                                uuid = jsonobejct.getString("unique_id");

                                noErrors = true;
                                Log.e("OK", String.valueOf(noErrors.booleanValue()));
                                mEmail = jsonobejct.getString("email");
                                ok = jsonobejct.getString("ok");

                                Toast toast = Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_LONG);
                                toast.show();

                                new Thread(new Runnable() {

                                    public void run() {

                                        new SendEmail(mEmail, sb.toString(), uuid);
                                    }
                                }).start();

                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                intent.putExtra("email", mEmail);
                                startActivity(intent);

                            } else {
                                errorMessage = jsonobejct.getString("error_msg");
                                Log.d("ERROR", errorMessage);
                                Toast toast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_SHORT);
                                toast.show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //mTextView.setText("That didn't work!");
                Log.e("ERROR", error.getMessage());

                error.printStackTrace();

            }
        })

        {

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("password", mpassword);
                params.put("email", mEmail);
                return params;
            }

        };

        AppController.getInstance(this).addToRequestQueue(strinRequest);


    }


    private boolean correctEmail(String email) {

        Matcher m = null;
        if (email.equals("jussi.isokangas@gmail.com") || email.equals("jussi.isokangas@kolumbus.fi"))
            return true;

       /* else if (email.equals(""))
            return false;
        else {
            String[] splitEmail = email.split("@");
            Pattern p = Pattern.compile("caverion.com");
            m = p.matcher(splitEmail[1]);
        }*/
        // return m.matches();
        return false;
    }


    private boolean isStrongPassword(String password) {
        if (password.length() < 5)
            return false;

        Pattern p = Pattern.compile("[a-z]{1,5}[0-9]{1,3}[A-Z]{1,3}");

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        char[] charArray = password.toCharArray();
        String word = null;
        for (int i = 0; i < charArray.length; i++) {
            word = Character.toString(charArray[i]);
            if (word.matches("[a-z]")) {
                if (!sb1.substring(0).equals(word) || !sb3.substring(1).equals(word) || !sb3.substring(2).equals(word))
                    sb1.append(word);


            }
            if (word.matches("[0-9]")) {
                if (!sb2.substring(0).equals(word))
                    sb2.append(word);
            }

            if (word.matches("[A-Z]")) {
                if (!sb3.substring(0).equals(word))
                    sb3.append(word);

            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sb1.toString());
        sb.append(sb2.toString());
        sb.append(sb3.toString());
        System.out.println(sb.substring(0));
        System.out.println(sb.toString());

        Matcher m = p.matcher(sb.toString());
        return (m.find());
    }


    private Context getContext() {

        return this.getApplicationContext();

    }


}





