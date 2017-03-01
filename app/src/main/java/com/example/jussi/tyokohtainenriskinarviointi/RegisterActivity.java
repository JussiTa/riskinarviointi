package com.example.jussi.tyokohtainenriskinarviointi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.LoaderManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegisterActivity extends Activity {


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;

    private View mLoginFormView;


    SessionManager session;
    private String mEmail;
    private String mpassword;
    private String mName;
    private String ok = null;
    private boolean formOk=false;
    private String errorMessage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mEmailView = (EditText) findViewById(R.id.email);
        mPasswordView = (EditText) findViewById(R.id.password);


        Button registerButton = (Button) findViewById(R.id.register_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mEmail = mEmailView.getText().toString();
                mpassword = mPasswordView.getText().toString();
                if(correctEmail(mEmail) && isStrongPassword(mpassword))
                    formOk=sendForm();
                else if(correctEmail(mEmail))
                     mEmailView.setText("Sähköposti ei kelpaa");
                else if(! isStrongPassword(mpassword))
                     mEmailView.setText("Käytä pieniä ja isoja kirjaimia sekä numeroita");
                notice(formOk);

            }
        });
    }

    private void notice(boolean formOk) {
       Log.d("XXXXXXX", errorMessage);
        Toast toast;
        if(formOk) {
            toast = Toast.makeText(getApplicationContext(), ok, Toast.LENGTH_LONG);
            toast.show();
        }
        else {
            toast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG);
            toast.show();

        }

    }

    private boolean correctEmail(String email) {

        Pattern p = Pattern.compile("^caverion.com$");
        Matcher m = p.matcher(email);
        return m.matches();
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
                if (!sb1.substring(0).equals(word)||!sb3.substring(1).equals(word)||!sb3.substring(2).equals(word))
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


    private boolean sendForm() {
        String url = "http://192.168.1.113/riskinarviointi/register.php";


        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObj = new JSONObject(response);

                            boolean error = jsonObj.getBoolean("error");
                            if (!error) {
                                ok = jsonObj.getString("ok");

                                //Redirect to LoginActivity

                            } else {

                                errorMessage = jsonObj.getString("error_msg");


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

        AppController.getInstance().addToRequestQueue(stringRequest);


        if(ok!=null)
            return true;
        return false;
    }




}





