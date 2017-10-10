package com.example.jussi.tyokohtainenriskinarviointi;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.ServerError;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session.SessionManager;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;



public class LoginActivity extends Activity {



    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;
    SessionManager session;
    Boolean params = false;
    Intent intent;
    private String line;
    private String errorMessage;
    private String mPassword;
    private String mEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);
        intent = new Intent(this, FormActivity.class);


        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });


        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();

            }
        });

        TextView registerLink = (TextView) findViewById(R.id.register_link);
        registerLink.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                // session.logout();


            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    /*




/**
 * Attempts to sign in or register the account specified by the login form.
 * If there are form errors (invalid email, missing fields, etc.), the
 * errors are presented and no actual login attempt is made.
 */
    private void attemptLogin() {


        session.createLoginSession(mEmail,mPassword);



        // Reset errors.
        mEmailView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        mEmail = mEmailView.getText().toString();
        mPassword = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;


        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {


            String url = "https://botniamillservice.000webhostapp.com/login.php";


            // Request a string response from the provided URL.
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObj = new JSONObject(response);


                                String error = jsonObj.getString("error");
                                if (error.equals("false")) {
                                    intent.putExtra("email",mEmail);
                                    startActivity(intent);


                                } else {


                                    errorMessage = jsonObj.getString("error_msg");
                                    Log.e("error", errorMessage);
                                    mPasswordView.setError(errorMessage);
                                    mPasswordView.requestFocus();
                                    Toast toast = Toast.makeText(getApplicationContext(), errorMessage, Toast.LENGTH_LONG);
                                }


                            } catch (JSONException e) {
                                e.printStackTrace();
                            }


                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            })

            {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("email", mEmail);
                    params.put("password", mPassword);
                    return params;
                }

            };


            AppController.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);


        }
    }



    @Override
    public void onResume(){
        super.onResume();


        session = new SessionManager(getApplicationContext());



        //Redirect to ForminActivity if user already login
        try {
            if (session.IsLogin()) {
                Log.d("LOGINIS", String.valueOf(session.IsLogin()));
                Intent intent = new Intent(this, FormActivity.class);
                intent.putExtra("email", session.getUserDetails().get("KEY_EMAIL"));
                startActivity(intent);
            }

        }catch (NullPointerException e){
            Log.getStackTraceString(e);
        }

    }




}
























