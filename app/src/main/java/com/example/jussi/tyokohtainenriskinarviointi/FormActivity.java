package com.example.jussi.tyokohtainenriskinarviointi;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        TextView tw = (TextView) findViewById(R.id.text1);
        tw.setText("BOTNIA MILL SERVICE");




        TextView tw1 = (TextView) findViewById(R.id.text2);
        tw1.setText("OSA D- TYÖNTEKIJÄN TARKISTUSLISTA");

        TextView tw3 = (TextView) findViewById(R.id.text3);
        tw3.setText("TUNNISTA VAARA-ARVI SEURAUKSET-POISTA RISKI-VÄHENNÄ-SUOJAUDU");

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








          //View tw6 = (TextView) findViewById(R.id.text6);
       // tw6.setText("Ei aiheuta \n vaaraa");



        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_turva1);
       // checkBox.setText("rrrrrrrrrrrrrrr");



        if (checkBox.isChecked()) {
            checkBox.setChecked(false);
            
        }

        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_turva2);
        //checkBox2.setText("yyyyyyyyyyyyyyyyyyy");

        if (checkBox2.isChecked()) {
            checkBox2.setChecked(false);

        }


        final CheckBox checkBox3 = (CheckBox) findViewById(R.id.checkbox_turva3);
        //checkBox2.setText("yyyyyyyyyyyyyyyyyyy");

        if (checkBox3.isChecked()) {
            checkBox3.setChecked(false);

        }

        final CheckBox checkBox4 = (CheckBox) findViewById(R.id.checkbox_turva4);
        //checkBox2.setText("yyyyyyyyyyyyyyyyyyy");

        if (checkBox4.isChecked()) {
            checkBox4.setChecked(false);

        }


    }


    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        //   boolean checked = checkBox.isChecked();
        boolean checked = ((CheckBox) view).isChecked();

        Toast.makeText(this, "painettu", Toast.LENGTH_SHORT).show();



        //  final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox_turva2);

    }
}

