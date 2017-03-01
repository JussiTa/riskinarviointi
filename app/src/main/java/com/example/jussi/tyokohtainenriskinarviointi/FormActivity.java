package com.example.jussi.tyokohtainenriskinarviointi;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.textservice.TextInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class FormActivity extends AppCompatActivity {


    private  boolean[] valintarivi1= new boolean[8];
    private  boolean[] valintarivi2 = new boolean[8];
    private  boolean[] valintarivi3 = new boolean[6];
    private  boolean[] valintarivi4 = new boolean[11];

    private int tyhjä1 =0;
    private int tyhjä2 =0;
    private int tyhjä3 =0;
    private boolean molemmatPohjassa =false;
    private String mEmail;
    private String tehtava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getIntent().getExtras();
        mEmail =bundle.getString("email");
        setContentView(R.layout.activity_form);
  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        TextView tw = (TextView) findViewById(R.id.text1);
        tw.setText("BOTNIA MILL SERVICE");

        EditText et = (EditText) findViewById(R.id.inputText);
        et.setText("Työkohde");
        tehtava= et.getText().toString();





        TextView tw1 = (TextView) findViewById(R.id.text2);
        tw1.setText("OSA D- TYÖNTEKIJÄN TARKISTUSLISTA");

        TextView tw3 = (TextView) findViewById(R.id.text3);
        tw3.setText("TUNNISTA VAARA-ARVIO SEURAUKSET-POISTA RISKI-VÄHENNÄ-SUOJAUDU");

        TextView tw4 = (TextView) findViewById(R.id.text4);
        tw4.setText("VAARJEN TUNNISTAMINEN KOHTEESSA ");

        TextView tw5 = (TextView) findViewById(R.id.text5);
        tw5.setText("Aiheuttaa    Ei aiheuta \nvaaraa         vaaraa");


        TextView tw6 = (TextView) findViewById(R.id.text7);
        tw6.setText("Takertuminen ja puristuminen");
        tw6.setTypeface(null, Typeface.BOLD);

        TextView tw7  = (TextView) findViewById(R.id.text8);
        tw7.setText("-Liikkuvat osat, työkoneet");

        TextView tw8 = (TextView) findViewById(R.id.text9);
        tw8.setText("Raskaat nostot ja taakan kannattelu");
        tw8.setTypeface(null, Typeface.BOLD);
        TextView tw9  = (TextView) findViewById(R.id.text10);
        tw9.setText("Nostoapuvälineet, nostoasento,\n nostoalueen eristäminen ");

        TextView tw10 = (TextView) findViewById(R.id.text11);
        tw10.setText("Liukastuminen ja kompastuminen");
        tw10.setTypeface(null, Typeface.BOLD);
        TextView tw11  = (TextView) findViewById(R.id.text12);
        tw11.setText("-Siisteys ja järjestys työkohteessa ja kulkuteillä,\n liikkuminen työkohteessa");


        TextView tw12 = (TextView) findViewById(R.id.text13);
        tw12.setText("Henkilön ja kappaleiden putoaminen");
        tw12.setTypeface(null, Typeface.BOLD);
        TextView tw13  = (TextView) findViewById(R.id.text14);
        tw13.setText("-Putoamissuojat, henkilönostimien käyttö");

        TextView tw14 = (TextView) findViewById(R.id.text15);
        tw14.setText("Aineiden roiskuminen ja kemikaaleille altistuminen");
        tw14.setTypeface(null, Typeface.BOLD);
        TextView tw15  = (TextView) findViewById(R.id.text16);
        tw15.setText("-Putkistojen ja säiliöiden tyhjentäminen ja täyttö, huoltotyöt");


        TextView tw16 = (TextView) findViewById(R.id.text17);
        tw16.setText("Vahinokäynnistysten esto");
        tw16.setTypeface(null, Typeface.BOLD);
        TextView tw17  = (TextView) findViewById(R.id.text18);
        tw17.setText("-Aineiden- ja energiasyötön katkaiseminen: kemikaalit,\nsähkö, paineilma" +
                ", kaasut, höyryt, vesi ym.\n-turvakytkin, -lukko");


        TextView tw18 = (TextView) findViewById(R.id.text19);
        tw18.setText("Satuttaminen (esim. ruhjeet ja haavat, sormivammat");
        tw18.setTypeface(null, Typeface.BOLD);
        TextView tw19  = (TextView) findViewById(R.id.text20);
        tw19.setText("-Kohteen tai työvälineen vaaralliset osat, terät");


        TextView tw20 = (TextView) findViewById(R.id.text21);
        tw20.setText("Kappaleiden sinkoutuminen (esim. silmävammat)");
        tw20.setTypeface(null, Typeface.BOLD);
        TextView tw21  = (TextView) findViewById(R.id.text22);
        tw21.setText("-Materiaalien työstö, hitsaus, hionta, katkaisu");



        TextView tw22 = (TextView) findViewById(R.id.text23);
        tw22.setText("Hätätilanteen varalta selvitettävä,\nmissä sijaitsee lähin:)");
        tw22.setTypeface(null, Typeface.BOLD);
        TextView tw23  = (TextView) findViewById(R.id.text24);
        tw23.setText(" ensiapuvälineet");
          TextView tw24  = (TextView) findViewById(R.id.text25);
          tw24.setText(" silmäsuihku");
          TextView tw25  = (TextView) findViewById(R.id.text26);
          tw25.setText(" hätäsuihku");
          TextView tw26  = (TextView) findViewById(R.id.text27);
          tw26.setText(" alkusammutusvälineet");
          TextView tw28  = (TextView) findViewById(R.id.text28);
            tw28.setText(" laitteen hätäpysäytyspainike");

          TextView tw29  = (TextView) findViewById(R.id.text29);
          tw29.setText(" työntekijä");





        TextView tw30 = (TextView) findViewById(R.id.text30);
        tw30.setText("Tarvittavat henkilösuojaimet");
        tw30.setTypeface(null, Typeface.BOLD);
        TextView tw31  = (TextView) findViewById(R.id.text31);
        tw31.setText(" turvakengät / -saappaat");
        TextView tw32  = (TextView) findViewById(R.id.text32);
        tw32.setText(" kypärä");
        TextView tw33  = (TextView) findViewById(R.id.text33);
        tw33.setText(" suojalasit");
        TextView tw34  = (TextView) findViewById(R.id.text34);
        tw34.setText(" kuulsuojaimet");
        TextView tw35  = (TextView) findViewById(R.id.text35);
        tw35.setText(" kasvosuoja (visiiri)");

        TextView tw36  = (TextView) findViewById(R.id.text36);
        tw36.setText(" hengityssuoja");
        TextView tw37  = (TextView) findViewById(R.id.text37);
        tw37.setText(" suojakäsineet");
        TextView tw38  = (TextView) findViewById(R.id.text38);
        tw38.setText(" turvavaljaat");
        TextView tw39  = (TextView) findViewById(R.id.text39);
        tw39.setText(" kemikaalisuojavaatetus");
        TextView tw40  = (TextView) findViewById(R.id.text40);
        tw40.setText(" paineilmalaitteet");
        TextView tw41  = (TextView) findViewById(R.id.text41);
        tw41.setText(" huomioliivi");

          Button button = (Button)
          findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendForm();
            }
        });



        TextInfo ti = new TextInfo("Valitse jompi kumpi");
         findViewById(R.id.info);

    }
        //Tässä metodissa tarkistetaan valintaruudut
    public void onCheckboxClicked(View view) {
        Toast toast = Toast.makeText(getBaseContext(),"Valitse jompi kumpi",Toast.LENGTH_SHORT);
        // Is the view now checked?
        //   boolean checked = checkBox.isChecked();
        int id = view.getId();
        Log.d("ID", "luku on  "+id);
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()){
                //Katsotaan läpi ensiksi vasen valintaruuturivi
            case (R.id.checkbox_turva1):
                if(checked) {
                    if (valintarivi2[0]) {
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi1[0]=true;
                    }
                    else{
                        valintarivi1[0] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi1[0] = false;
                    molemmatPohjassa=false;
                }

                break;

            case (R.id.checkbox_turva2):
                if(checked) {
                    if (valintarivi2[1]) {
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi1[1]=true;
                    }
                    else {
                        valintarivi1[1] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi1[1] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva3):
                if(checked) {
                    if (valintarivi2[2]){
                        toast.show();
                        valintarivi1[2]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi1[2] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi1[2] = false;
                    molemmatPohjassa=false;
                }
                break;


            case (R.id.checkbox_turva4):
                if(checked) {
                    if(valintarivi2[3]){
                        toast.show();
                        valintarivi1[3]=true;
                        molemmatPohjassa=true;
                    }
                    else{
                            valintarivi1[3] = true;
                            molemmatPohjassa =false;
                    }
                }
                else {
                    valintarivi1[3] = false;

                    molemmatPohjassa=false;
                }
                    break;



            case (R.id.checkbox_turva5):
                if(checked) {
                    if (valintarivi2[4]) {
                        toast.show();
                        valintarivi1[4]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi1[4] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi1[4] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva6):
                if(checked) {
                    if (valintarivi2[5]){
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi1[5]=true;
                    }

                    else {
                        valintarivi1[5] = true;
                        molemmatPohjassa = false;
                    }
                }
                else {
                    valintarivi1[5] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva7):
                if(checked) {
                    if (valintarivi2[6]) {
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi1[6]=true;
                    }
                    else{
                        valintarivi1[6] = true;
                        molemmatPohjassa=false;
                    }
                }
                else{
                    valintarivi1[6]=false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva8):
                if(checked) {
                    if (valintarivi2[7])
                        toast.show();
                    else valintarivi1[7] = true;
                }
                else {
                    valintarivi1[7] = false;
                    molemmatPohjassa=false;
                }

                break;


                //Tässä tarkastetaan oikea valintarivi

            case (R.id.checkbox_turva9):

                if(checked) {
                    if (valintarivi1[0]) {
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi2[0]=true;
                    }
                    else {
                        valintarivi2[0] = true;
                        molemmatPohjassa=false;
                    }

                    }
                else {
                    valintarivi2[0] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva10):

                if(checked) {
                    if (valintarivi1[1]) {
                        toast.show();
                        molemmatPohjassa=true;
                        valintarivi2[1]=true;
                    }
                    else {
                        valintarivi2[1] = true;
                        molemmatPohjassa=false;
                    }
                    }
                else {
                    valintarivi2[1] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva11):

                if(checked) {
                    if(valintarivi1[2]){
                        toast.show();
                        molemmatPohjassa = true;
                        valintarivi2[2]=true;
                    }
                        else {
                            valintarivi2[2] = true;
                            molemmatPohjassa=false;
                        }
                    }
                else {
                    valintarivi2[2] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva12):

                if(checked) {
                    if (valintarivi1[3]) {
                        toast.show();
                        valintarivi2[3]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi2[3] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {

                    valintarivi2[3] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva13):

                if(checked) {
                    if (valintarivi1[4]) {
                        toast.show();
                        valintarivi2[4]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi2[4] = true;
                        molemmatPohjassa=false;
                        }
                    }


                else {
                    valintarivi2[4] = false;
                    molemmatPohjassa=false;
                    }
                break;

            case (R.id.checkbox_turva14):

                if(checked) {
                    if (valintarivi1[5]) {
                        toast.show();
                        valintarivi2[5]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi2[5] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi2[5] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva15):

                if(checked) {
                    if (valintarivi1[6]) {
                        toast.show();
                        valintarivi2[6]=true;
                        molemmatPohjassa=true;
                    }
                    else {
                        valintarivi2[6] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi2[6] = false;
                    molemmatPohjassa=false;
                }
                break;

            case (R.id.checkbox_turva16):

                if(checked) {
                    if (valintarivi1[7]){
                        toast.show();
                        valintarivi2[7]=true;
                    }
                    else {
                        valintarivi2[7] = true;
                        molemmatPohjassa=false;
                    }
                }
                else {
                    valintarivi2[7] = false;
                    molemmatPohjassa=false;
                }
                break;

            //Vasen alarivi

            case (R.id.checkbox_turva17):

                if(checked)
                    valintarivi3[0] = true;

                else
                    valintarivi3[0]=false;

                break;
            case (R.id.checkbox_turva18):

                if(checked)
                    valintarivi3[1] = true;

                else
                    valintarivi3[1]=false;

                break;
            case (R.id.checkbox_turva19):

                if(checked)
                    valintarivi3[2] = true;

                else
                    valintarivi3[2]=false;

                break;

            case (R.id.checkbox_turva20):

                if(checked)
                    valintarivi3[3] = true;

                else
                    valintarivi3[3]=false;

                break;

            case (R.id.checkbox_turva21):

                if(checked)
                    valintarivi3[4] = true;

                else
                    valintarivi3[4]=false;

                break;


            case (R.id.checkbox_turva22):

                if(checked)
                    valintarivi3[5] = true;

                else
                    valintarivi3[5]=false;

                break;
            //Oikea alarivi

            case (R.id.checkbox_turva23):

                if(checked)
                    valintarivi4[0] = true;

                else
                    valintarivi4[0]=false;

                break;

            case (R.id.checkbox_turva24):

                if(checked)
                    valintarivi4[1] = true;

                else
                    valintarivi4[1]=false;

                break;


            case (R.id.checkbox_turva25):

                if(checked)
                    valintarivi4[2] = true;

                else
                    valintarivi4[2]=false;

                break;

            case (R.id.checkbox_turva26):

                if(checked)
                    valintarivi4[3] = true;

                else
                    valintarivi4[3]=false;

                break;

            case (R.id.checkbox_turva27):

                if(checked)
                    valintarivi4[4] = true;

                else
                    valintarivi4[4]=false;

                break;

            case (R.id.checkbox_turva28):

                if(checked)
                    valintarivi4[5] = true;

                else
                    valintarivi4[5]=false;

                break;


            case (R.id.checkbox_turva29):

                if(checked)
                    valintarivi4[6] = true;

                else
                    valintarivi4[6]=false;

                break;

            case (R.id.checkbox_turva30):

                if(checked)
                    valintarivi4[7] = true;

                else
                    valintarivi4[7]=false;

                break;


            case (R.id.checkbox_turva31):

                if(checked)
                    valintarivi4[8] = true;

                else
                    valintarivi4[8]=false;

                break;

            case (R.id.checkbox_turva32):

                if(checked)
                    valintarivi4[9] = true;

                else
                    valintarivi4[9]=false;

                break;

            case (R.id.checkbox_turva33):

                if(checked)
                    valintarivi4[10] = true;

                else
                    valintarivi4[10]=false;

                break;

        }



        //Toast.makeText(this, "painettu", Toast.LENGTH_SHORT).show();
    }

      public void sendForm(){
          Toast toast = Toast.makeText(getBaseContext(),"Tarkista kaikki kohdat!", Toast.LENGTH_SHORT);

          Toast toast2 = Toast.makeText(getBaseContext(),"Lomake lähetetty!", Toast.LENGTH_SHORT);

          for(int i=0; i<valintarivi1.length;i++) {
              if (!valintarivi1[i] && !valintarivi2[i])
                  tyhjä1++;
          }

          for(int i=0; i<valintarivi1.length;i++) {
              if (valintarivi1[i] && valintarivi2[i])
                  tyhjä1++;
          }


          for(int i=0; i<valintarivi3.length;i++) {
              if (!valintarivi3[i])
                  tyhjä2++;
          }



          for(int i=0; i<valintarivi4.length;i++) {
              if (!valintarivi4[i])
                  tyhjä3++;
          }


          if(tyhjä1 >0||tyhjä2 >0||tyhjä3 >0 ||molemmatPohjassa)
              toast.show();

          else {
              toast2.show();

              tyhjä1 = 0;
              tyhjä2 = 0;
              tyhjä3 = 0;
              molemmatPohjassa = false;
              String url ="http://10.0.2.2/riskinarviointi/Form.php";
              final Intent intent = new Intent(this,LoginActivity.class);

              // Request a string response from the provided URL.
              StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                      new Response.Listener<String>() {
                          @Override
                          public void onResponse(String response) {
                              try {
                                  JSONObject jsonObj = new JSONObject(response);

                                  boolean error = jsonObj.getBoolean("error");
                                  if(!error){
                                      String ok;
                                      ok= jsonObj.getString("ok");
                                      //Redirect to LoginActivity
                                      Toast toast = Toast.makeText(getApplicationContext(),ok,Toast.LENGTH_LONG);
                                      startActivity(intent);
                                  }

                                  else{
                                      String errorMessage;
                                      errorMessage = jsonObj.getString("error_msg");
                                      Toast toast = Toast.makeText(getApplicationContext(),errorMessage,Toast.LENGTH_LONG);

                                  }


                              } catch (JSONException e) {
                                  e.printStackTrace();
                              }


                          }
                      }, new Response.ErrorListener() {
                  @Override
                  public void onErrorResponse(VolleyError error) {
                      //mTextView.setText("That didn't work!");
                      Log.e("ERROR", "cANNOT SAVE USER");
                      Toast toast = Toast.makeText(getApplicationContext(),"Rekisteröinti ei onnistunut:"+error.getMessage(),Toast.LENGTH_LONG);
                      error.printStackTrace();

                  }
              } )

              {

                  @Override
                  protected Map<String,String> getParams(){
                      Map<String,String> params = new HashMap<String, String>();
                      DateFormat df = DateFormat.getDateInstance();
                      params.put("tehtava", tehtava);
                      params.put("email", mEmail);
                      params.put("time", df.format(Calendar.getInstance().getTime()));
                      return params;
                  }

              };

              AppController.getInstance().addToRequestQueue(stringRequest);


          }



          Intent intent = new Intent(this, FormSendedActivity.class);

              startActivity(intent);
          }
      }




