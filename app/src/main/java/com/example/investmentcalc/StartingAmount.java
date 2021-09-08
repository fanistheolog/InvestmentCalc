package com.example.investmentcalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdView;

public class StartingAmount extends AppCompatActivity {
    int time = 2021;
    int finale = 0;
    String timee = "Years";
    // variable for our bar chart
    BarChart barChart;

    // variable for our bar data.
    BarData barData;

    // variable for our bar data set.
    BarDataSet barDataSet;
    ArrayList barEntriesArrayList;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        ArrayList barEntriesArrayList;
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
        setContentView(R.layout.amount_starting);
        EditText YearsEditText = (EditText)findViewById(R.id.YearsEditText);
        EditText returnRate = (EditText)findViewById(R.id.returnRate);
        EditText target = (EditText)findViewById(R.id.target);
        EditText contribution = (EditText)findViewById(R.id.contribution);
        TextView timeNeeded = (TextView)findViewById(R.id.TimeNeeded1);

        Button searchButton = (Button)findViewById(R.id.searchButton);

        LinearLayout everything = (LinearLayout)findViewById(R.id.everything2);
        LinearLayout second = (LinearLayout)findViewById(R.id.everything4);
        LinearLayout third = (LinearLayout)findViewById(R.id.everything5);
        LinearLayout fourth = (LinearLayout)findViewById(R.id.everything6);
        barChart = findViewById(R.id.idBarChart);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Starting Amount");
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        AdView mAdView = (AdView)findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double y;
                double x;
                double p;
                int number;
                double totalcon = 0;
                double profit = 0;

                if(YearsEditText.getText().toString().trim().isEmpty() || YearsEditText.getText().toString().trim().length() == 0 ||  YearsEditText.getText().toString().trim().equals("") || YearsEditText.getText().toString().trim() == null)
                {
                    number = 0;
                    YearsEditText.setText("0");
                } else {
                    Double numberr = Double.parseDouble(YearsEditText.getText().toString());
                    number = numberr.intValue();
                }
                if(returnRate.getText().toString().trim().isEmpty() || returnRate.getText().toString().trim().length() == 0 ||  returnRate.getText().toString().trim().equals("") || returnRate.getText().toString().trim() == null)
                {
                    y = 0;
                    returnRate.setText("0");
                } else {
                    y = Double.parseDouble(returnRate.getText().toString());
                }
                if(target.getText().toString().trim().isEmpty() || target.getText().toString().trim().length() == 0 ||  target.getText().toString().trim().equals("") || target.getText().toString().trim() == null)
                {
                    x = 0;
                    target.setText("0");
                }else {
                    x = Double.parseDouble(target.getText().toString());

                }
                if(contribution.getText().toString().trim().isEmpty() || contribution.getText().toString().trim().length() == 0 ||  contribution.getText().toString().trim().equals("") || contribution.getText().toString().trim() == null)
                {
                    p = 0;
                    contribution.setText("0");

                } else {
                    p = Double.parseDouble(contribution.getText().toString());

                }


                double a;
                double g = p;

                everything.removeAllViews();
                second.removeAllViews();
                third.removeAllViews();
                fourth.removeAllViews();
                barChart.setVisibility(view.VISIBLE);
                TextView textt = new TextView(getApplicationContext());
                TextView textt2 = new TextView(getApplicationContext());
                TextView textt3 = new TextView(getApplicationContext());
                TextView textt4 = new TextView(getApplicationContext());

                textt.setTextSize(18);
                textt2.setTextSize(18);
                textt3.setTextSize(18);
                textt4.setTextSize(18);
                textt.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                textt2.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                textt3.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                textt4.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                textt.setTextColor(getResources().getColor(R.color.white));
                textt2.setTextColor(getResources().getColor(R.color.white));
                textt3.setTextColor(getResources().getColor(R.color.white));
                textt4.setTextColor(getResources().getColor(R.color.white));



                textt.setText(""+ timee);


                textt2.setText("End Amount");


                textt3.setText("Contribution");


                textt4.setText("Profit");
                textt.setBackgroundResource(R.color.greyy);
                textt2.setBackgroundResource(R.color.greyy);
                textt3.setBackgroundResource(R.color.greyy);
                textt4.setBackgroundResource(R.color.greyy);
                second.addView(textt2);
                third.addView(textt3);
                everything.addView(textt);
                fourth.addView(textt4);
                LinearLayout line2 = null;
                LinearLayout line = null;
                a=g+((y/100)*g);
                DecimalFormat df2 = new DecimalFormat("#.##");

                for(int i=0; i <= x; i++) {

                    BigDecimal bd = new BigDecimal(a).setScale(2, RoundingMode.HALF_UP);
                    TextView text = new TextView(getApplicationContext());
                    TextView text2 = new TextView(getApplicationContext());
                    TextView text3 = new TextView(getApplicationContext());
                    TextView text4 = new TextView(getApplicationContext());
                    text.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                    text2.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                    text3.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                    text4.setTypeface(ResourcesCompat.getFont(getApplicationContext(), R.font.convergence));
                    text.setTextColor(getResources().getColor(R.color.white));
                    text2.setTextColor(getResources().getColor(R.color.white));
                    text3.setTextColor(getResources().getColor(R.color.white));
                    text4.setTextColor(getResources().getColor(R.color.white));


                    totalcon = totalcon + p;
                    profit = a - totalcon;
                    if (profit > 1000000000) {
                        profit = 1000000000;
                    }
                    BigDecimal profit2 = new BigDecimal(profit).setScale(2, RoundingMode.HALF_UP);
                    BigDecimal bd2 = new BigDecimal(profit).setScale(2, RoundingMode.HALF_UP);
                    double newInput2 = bd2.doubleValue();
                    text4.setText("" + (newInput2));



                    text2.setText("" + (i + time));


                    text.setPadding(0, 0, 0, 0);
                    double newInput = bd.doubleValue();
                    if (newInput > 1000000000) {
                        newInput = 1000000000;
                    }
                    text.setText("$" + (newInput));
                    if (i >= x) {
                        finale = i;
                        timeNeeded.setVisibility(View.VISIBLE);
                        timeNeeded.setText("You will need to invest $" + (df2.format((number - newInput))) + " at the beginning to reach the target.");
                    }




                    if (totalcon > 1000000000) {
                        totalcon = 1000000000;
                    }

                    text3.setText("" + (df2.format(totalcon)));

                    if (i%2 == 0){

                        text.setBackgroundResource(R.drawable.rounded_edges);
                        text2.setBackgroundResource(R.drawable.rounded_edges);
                        text3.setBackgroundResource(R.drawable.rounded_edges);
                        text4.setBackgroundResource(R.drawable.rounded_edges);
                    } else {
                        text.setBackgroundResource(R.color.whiteee);
                        text2.setBackgroundResource(R.color.whiteee);
                        text3.setBackgroundResource(R.color.whiteee);
                        text4.setBackgroundResource(R.color.whiteee);
                    }

                    second.addView(text);
                    third.addView(text3);
                    everything.addView(text2);
                    fourth.addView(text4);

                    a = (a + p) + ((y / 100) * (a + p));

                }
                // initializing variable for bar chart.
                double b = 0;
                b=g+((y/100)*g);



                // calling method to get bar entries.
                barEntriesArrayList = new ArrayList<>();
                for(int i=0; i <= x; i++){
                    if (b > 1000000000){
                        b = 1000000000;
                    }
                    BigDecimal bd = new BigDecimal(b).setScale(2, RoundingMode.HALF_UP);
                    double newInput = bd.doubleValue();
                    float f = (float)newInput;
                    barEntriesArrayList.add(new BarEntry((i+1), f));
                    b = (b+p)+((y/100)*(b+p));

                }
                // adding new entry to our array list with bar
                // entry and passing x and y axis value to it

                // creating a new bar data set.
                barDataSet = new BarDataSet(barEntriesArrayList, "Investment Growth Over the Years");

                // creating a new bar data and
                // passing our bar data set.
                barData = new BarData(barDataSet);

                // below line is to set data
                // to our bar chart.
                barChart.setData(barData);

                // adding color to our bar data set.
                barDataSet.setColors(getResources().getColor(R.color.blue));

                // setting text color.
                barDataSet.setValueTextColor(Color.BLACK);

                // setting text size
                barDataSet.setValueTextSize(14f);
                barChart.getDescription().setEnabled(false);
            }
        });

    }
}