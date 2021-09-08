package com.example.investmentcalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrencyConverter extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.converter_currency);

        /*String coin = spinner.getSelectedItem().toString();
        String coin2 = spinner2.getSelectedItem().toString();
        int number = Integer.parseInt(editTextNumber2.getText().toString());*/
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Currency Converter");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        MaterialSpinner spinnere = (MaterialSpinner) findViewById(R.id.spnFirstCountry);
        MaterialSpinner spinnere2 = (MaterialSpinner) findViewById(R.id.spnFirstCountry2);
        EditText etSecondCurrency = (EditText)findViewById(R.id.etSecondCurrency);
        EditText etFirstCurrency = (EditText)findViewById(R.id.etFirstCurrency);
        Button btnConvert = (Button)findViewById(R.id.btnConvert);
        double number;

        if (etFirstCurrency.getText().toString().matches("")){
            number = 0;
        } else {
             number = Integer.parseInt(etFirstCurrency.getText().toString());

        }
        String item1 = spinnere.getText().toString();
        String item2 =spinnere2.getText().toString();
        spinnere.setItems("Eur", "Usd", "Aud","Cad","Gbp","Inr","Jpy","Rub");
        spinnere.setBackgroundColor(getResources().getColor(R.color.whiteidk));
        spinnere.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                double number = 0;
                if (etFirstCurrency.getText().toString().matches("")){
                    number = 0;



                } else {
                    number = Double.parseDouble(etFirstCurrency.getText().toString());


                }
                String item1 = spinnere.getText().toString();
                String item2 = spinnere2.getText().toString();
                String eur = "Eur";
                String usd = "Usd";
                String aud = "Aud";
                String cad = "Cad";
                String gbp = "Gbp";
                String inr = "Inr";
                String jpy = "Jpy";
                String rub = "Rub";

                DecimalFormat df2 = new DecimalFormat("#.##");
                if (item1.contains(eur) && item2.contains(usd)){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur)  && item2.contains(aud)){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(eur)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(cad)){
                    Double mult = 1.4797;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(gbp)){
                    Double mult = 0.8656;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(inr)){
                    Double mult = 0.01127;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(jpy)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(rub)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(usd) && item2.contains(eur)){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(inr)){
                    Double mult = 0.0135;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(aud)){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(usd)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(cad)){
                    Double mult = 1.2317;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(gbp)){
                    Double mult = 0.7202;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(jpy)){
                    Double mult = 109.339;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(rub)){
                    Double mult = 74.9062  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(aud) &&  item2.contains(aud)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) &&  item2.contains(inr)){
                    Double mult = 0.0175;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(eur)){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(usd)){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(cad)){
                    Double mult = 0.94732;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(gbp)){
                    Double mult = 0.5540;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(jpy)){
                    Double mult = 84.1555 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(rub)){
                    Double mult = 57.6582  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(cad) && item2.contains(eur)){
                    Double mult = 0.67579;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(usd)){
                    Double mult = 0.8121;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(inr)){
                    Double mult = 0.01667;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(aud)){
                    Double mult = 1.0556;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(cad)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(gbp)){
                    Double mult = 0.584964;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(jpy)){
                    Double mult = 88.8325 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(rub)){
                    Double mult = 60.8572  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(gbp) && item2.contains(cad)){
                    Double mult =  1.709;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(eur)){
                    Double mult =  1.155;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(usd)){
                    Double mult =  1.388;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(gbp)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(aud)){
                    Double mult =  1.804;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(inr)){
                    Double mult =  0.009753;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(jpy)){
                    Double mult =  151.817 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(rub)){
                    Double mult =  103.970  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(inr) && item2.contains(inr)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(eur)){
                    Double mult =  88.7198;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(usd)){
                    Double mult =  73.8082 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(aud)){
                    Double mult =  56.8229 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(cad)){
                    Double mult =  59.9593 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(gbp)){
                    Double mult =  102.491;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(jpy)){
                    Double mult =  0.675119;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(rub)){
                    Double mult =  1.01522 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(jpy) && item2.contains(jpy)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(eur)){
                    Double mult =  0.00761065 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(usd)){
                    Double mult =  0.00914621 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(aud)){
                    Double mult =  0.0118820 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(cad)){
                    Double mult =  0.0112584 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(gbp)){
                    Double mult =  0.00658699 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(inr)){
                    Double mult =  0.674983 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(rub)){
                    Double mult =  0.685141  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(rub) && item2.contains(rub)){
                    Double mult =  1.0  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(eur)){
                    Double mult =  0.0111077   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(usd)){
                    Double mult =  0.0133486   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(aud)){
                    Double mult =  0.0173433   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(cad)){
                    Double mult =  0.0164313   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(gbp)){
                    Double mult =  0.00961672 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(inr)){
                    Double mult =  0.984990   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(jpy)){
                    Double mult =  1.45943;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }

        }
                                           });
        spinnere2.setItems("Usd","Aud", "Eur","Cad","Gbp","Inr","Jpy","Rub");

        spinnere2.setBackgroundColor(getResources().getColor(R.color.whiteidk));
        spinnere2.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                double number = 0;
                if (etFirstCurrency.getText().toString().matches("")){
                    number = 0;



                } else {
                    number = Double.parseDouble(etFirstCurrency.getText().toString());


                }
                String item1 = spinnere.getText().toString();
                String item2 =spinnere2.getText().toString();
                String eur = "Eur";
                String usd = "Usd";
                String aud = "Aud";
                String cad = "Cad";
                String gbp = "Gbp";
                String inr = "Inr";
                String jpy = "Jpy";
                String rub = "Rub";
                DecimalFormat df2 = new DecimalFormat("#.##");
                if (item1.contains(eur) && item2.contains(usd)){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur)  && item2.contains(aud)){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(eur)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(cad)){
                    Double mult = 1.4797;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(gbp)){
                    Double mult = 0.8656;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(inr)){
                    Double mult = 0.01127;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(jpy)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(rub)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(usd) && item2.contains(eur)){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(inr)){
                    Double mult = 0.0135;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(aud)){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(usd)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(cad)){
                    Double mult = 1.2317;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(gbp)){
                    Double mult = 0.7202;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(jpy)){
                    Double mult = 109.339;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(rub)){
                    Double mult = 74.9062  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(aud) &&  item2.contains(aud)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) &&  item2.contains(inr)){
                    Double mult = 0.0175;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(eur)){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(usd)){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(cad)){
                    Double mult = 0.94732;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(gbp)){
                    Double mult = 0.5540;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(jpy)){
                    Double mult = 84.1555 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(rub)){
                    Double mult = 57.6582  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(cad) && item2.contains(eur)){
                    Double mult = 0.67579;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(usd)){
                    Double mult = 0.8121;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(inr)){
                    Double mult = 0.01667;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(aud)){
                    Double mult = 1.0556;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(cad)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(gbp)){
                    Double mult = 0.584964;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(jpy)){
                    Double mult = 88.8325 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(rub)){
                    Double mult = 60.8572  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(gbp) && item2.contains(cad)){
                    Double mult =  1.709;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(eur)){
                    Double mult =  1.155;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(usd)){
                    Double mult =  1.388;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(gbp)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(aud)){
                    Double mult =  1.804;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(inr)){
                    Double mult =  0.009753;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(jpy)){
                    Double mult =  151.817 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(rub)){
                    Double mult =  103.970  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(inr) && item2.contains(inr)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(eur)){
                    Double mult =  88.7198;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(usd)){
                    Double mult =  73.8082 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(aud)){
                    Double mult =  56.8229 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(cad)){
                    Double mult =  59.9593 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(gbp)){
                    Double mult =  102.491;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(jpy)){
                    Double mult =  0.675119;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(rub)){
                    Double mult =  1.01522 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(jpy) && item2.contains(jpy)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(eur)){
                    Double mult =  0.00761065 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(usd)){
                    Double mult =  0.00914621 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(aud)){
                    Double mult =  0.0118820 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(cad)){
                    Double mult =  0.0112584 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(gbp)){
                    Double mult =  0.00658699 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(inr)){
                    Double mult =  0.674983 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(rub)){
                    Double mult =  0.685141  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(rub) && item2.contains(rub)){
                    Double mult =  1.0  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(eur)){
                    Double mult =  0.0111077   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(usd)){
                    Double mult =  0.0133486   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(aud)){
                    Double mult =  0.0173433   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(cad)){
                    Double mult =  0.0164313   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(gbp)){
                    Double mult =  0.00961672 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(inr)){
                    Double mult =  0.984990   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(jpy)){
                    Double mult =  1.45943;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
            }
        });

        etFirstCurrency.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                double number = 0;
                if (etFirstCurrency.getText().toString().matches("")){
                    number = 0;



                } else {
                    number = Double.parseDouble(etFirstCurrency.getText().toString());


                }


            }
        });

        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double number = 0;
                if (etFirstCurrency.getText().toString().matches("")){
                     number = 0;



                } else {
                     number = Double.parseDouble(etFirstCurrency.getText().toString());


                }
                String item1 = spinnere.getText().toString();
                String item2 =spinnere2.getText().toString();
                String eur = "Eur";
                String usd = "Usd";
                String aud = "Aud";
                String cad = "Cad";
                String gbp = "Gbp";
                String inr = "Inr";
                String jpy = "Jpy";
                String rub = "Rub";
                DecimalFormat df2 = new DecimalFormat("#.##");
                if (item1.contains(eur) && item2.contains(usd)){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur)  && item2.contains(aud)){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(eur)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(cad)){
                    Double mult = 1.4797;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(gbp)){
                    Double mult = 0.8656;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(inr)){
                    Double mult = 0.01127;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(jpy)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(eur) && item2.equals(rub)){
                    Double mult = 131.418 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(usd) && item2.contains(eur)){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(inr)){
                    Double mult = 0.0135;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(aud)){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.contains(usd)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(cad)){
                    Double mult = 1.2317;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(gbp)){
                    Double mult = 0.7202;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(jpy)){
                    Double mult = 109.339;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(usd) && item2.equals(rub)){
                    Double mult = 74.9062  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(aud) &&  item2.contains(aud)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) &&  item2.contains(inr)){
                    Double mult = 0.0175;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(eur)){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(usd)){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(cad)){
                    Double mult = 0.94732;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(gbp)){
                    Double mult = 0.5540;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(jpy)){
                    Double mult = 84.1555 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(aud) && item2.contains(rub)){
                    Double mult = 57.6582  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(cad) && item2.contains(eur)){
                    Double mult = 0.67579;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(usd)){
                    Double mult = 0.8121;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(inr)){
                    Double mult = 0.01667;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(aud)){
                    Double mult = 1.0556;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(cad)){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(gbp)){
                    Double mult = 0.584964;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(jpy)){
                    Double mult = 88.8325 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(cad) && item2.contains(rub)){
                    Double mult = 60.8572  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(gbp) && item2.contains(cad)){
                    Double mult =  1.709;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(eur)){
                    Double mult =  1.155;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(usd)){
                    Double mult =  1.388;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(gbp)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(aud)){
                    Double mult =  1.804;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(inr)){
                    Double mult =  0.009753;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(jpy)){
                    Double mult =  151.817 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(gbp) && item2.contains(rub)){
                    Double mult =  103.970  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(inr) && item2.contains(inr)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(eur)){
                    Double mult =  88.7198;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(usd)){
                    Double mult =  73.8082 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(aud)){
                    Double mult =  56.8229 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(cad)){
                    Double mult =  59.9593 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(gbp)){
                    Double mult =  102.491;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(jpy)){
                    Double mult =  0.675119;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(inr) && item2.contains(rub)){
                    Double mult =  1.01522 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(jpy) && item2.contains(jpy)){
                    Double mult =  1.0;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(eur)){
                    Double mult =  0.00761065 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(usd)){
                    Double mult =  0.00914621 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(aud)){
                    Double mult =  0.0118820 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(cad)){
                    Double mult =  0.0112584 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(gbp)){
                    Double mult =  0.00658699 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(inr)){
                    Double mult =  0.674983 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(jpy) && item2.contains(rub)){
                    Double mult =  0.685141  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }


                if (item1.contains(rub) && item2.contains(rub)){
                    Double mult =  1.0  ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(eur)){
                    Double mult =  0.0111077   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(usd)){
                    Double mult =  0.0133486   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(aud)){
                    Double mult =  0.0173433   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(cad)){
                    Double mult =  0.0164313   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(gbp)){
                    Double mult =  0.00961672 ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(inr)){
                    Double mult =  0.984990   ;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
                if (item1.contains(rub) && item2.contains(jpy)){
                    Double mult =  1.45943;
                    double peos = (number*mult);
                    etSecondCurrency.setText("" + number + " " + item1 +  " = " + df2.format(peos) + " " + item2);
                }
            }
        });

       /* editTextNumber2.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                int number = Integer.parseInt(editTextNumber2.getText().toString());
                if(editTextNumber2 == null){
                    editTextNumber2.setText(0);
                    number = Integer.parseInt(editTextNumber2.getText().toString());
                }
                String coinn = spinner.getSelectedItem().toString();
                String coinn2 = spinner2.getSelectedItem().toString();
                DecimalFormat df2 = new DecimalFormat("#.##");
                if (coinn.contains("Eur") && coinn2.contains("Usd")){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur")  && coinn2.contains("Aud")){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur") && coinn2.contains("Eur")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Eur")){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Aud")){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Usd")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") &&  coinn2.contains("Aud")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Eur")){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Usd")){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }

            }
        });

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                int number = Integer.parseInt(editTextNumber2.getText().toString());
                if(editTextNumber2 == null){
                    editTextNumber2.setText(0);
                    number = Integer.parseInt(editTextNumber2.getText().toString());
                }
                String coinn = spinner.getSelectedItem().toString();
                String coinn2 = spinner2.getSelectedItem().toString();
                DecimalFormat df2 = new DecimalFormat("#.##");
                if (coinn.contains("Eur") && coinn2.contains("Usd")){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur")  && coinn2.contains("Aud")){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur") && coinn2.contains("Eur")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Eur")){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Aud")){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Usd")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") &&  coinn2.contains("Aud")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Eur")){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Usd")){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                // Your code here
                int number = Integer.parseInt(editTextNumber2.getText().toString());
                if(editTextNumber2 == null){
                    editTextNumber2.setText(0);
                    number = Integer.parseInt(editTextNumber2.getText().toString());
                }
                String coinn = spinner.getSelectedItem().toString();
                String coinn2 = spinner2.getSelectedItem().toString();
                DecimalFormat df2 = new DecimalFormat("#.##");
                if (coinn.contains("Eur") && coinn2.contains("Usd")){
                    Double mult = 1.2057;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur")  && coinn2.contains("Aud")){
                    Double mult = 1.5584;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Eur") && coinn2.contains("Eur")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Eur")){
                    Double mult = 0.8293;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Aud")){
                    Double mult = 1.2930;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Usd") && coinn2.contains("Usd")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") &&  coinn2.contains("Aud")){
                    Double mult = 1.0;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Eur")){
                    Double mult = 0.641640;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
                if (coinn.contains("Aud") && coinn2.contains("Usd")){
                    Double mult = 0.773241;
                    double peos = (number*mult);
                    textView13.setText("" + number + " " + coinn +  " = " + df2.format(peos) + " " + coinn2);
                }
            }*/

          /*  public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });*/

    }
}