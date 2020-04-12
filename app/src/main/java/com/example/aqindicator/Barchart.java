package com.example.aqindicator;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import static com.example.aqindicator.R.*;

public class Barchart extends AppCompatActivity {

    private ImageView img;
    private LinearLayout li;
    private TextView text;
    private TextView ind;
    private TextView time;

    int decide = 0;
    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_barchart);
        getSupportActionBar().hide();
        Intent i = getIntent();
        Bundle bo = i.getExtras();
        BarChart barChart = (BarChart) findViewById(id.barchart);
        int ac = 0;
        ac = (int)bo.get("activity");
        decide = ac;
        if(ac == 100) {
            int des = 0;

            des = (int) bo.get("place");

            ArrayList<BarEntry> entries = new ArrayList<>();
            Random rand = new Random();
            int a = rand.nextInt(500);
            int b = rand.nextInt(300);
            int c = rand.nextInt(200);
            int d = rand.nextInt(100);
            entries.add(new BarEntry(a, 0));
            entries.add(new BarEntry(b, 1));
            entries.add(new BarEntry(c, 2));
            entries.add(new BarEntry(d, 3));


            BarDataSet bardataset = new BarDataSet(entries, "Pollutants");


            ArrayList<String> labels = new ArrayList<String>();
            labels.add("PM2.5");
            labels.add("PM10");
            labels.add("CO");
            labels.add("SO2");


            BarData data = new BarData(labels, bardataset);
            barChart.setData(data);// set the data and list of labels into chart
            barChart.setDrawBarShadow(true);
            if (des == 1) {
                barChart.setDescription("AQI of NIT");
            } else if (des == 2) {
                barChart.setDescription("AQI of Amapara");
            } else if (des == 3) {
                barChart.setDescription("AQI of Jaistambh");
            } else {
                barChart.setDescription("AQI of Ghadi Chowk");
            }
            // set the description
            bardataset.setColors(ColorTemplate.PASTEL_COLORS);
            barChart.setBackgroundColor(Color.parseColor("#d7dbdd"));
            barChart.animateY(2000);

            img = (ImageView) findViewById(id.img);
            li = (LinearLayout) findViewById(id.li);
            text = (TextView) findViewById(id.aq);
            ind = (TextView) findViewById(id.ind);
            time = (TextView) findViewById(R.id.time);

            SimpleDateFormat smp = new SimpleDateFormat("HH:mm a");
            Date date = new Date();
            time.setText((smp.format(date)));

            int aqi = (a + b + c + d) / 4;
            if (aqi < 100) {
                text.setText("0" + aqi);
            } else {
                text.setText(String.valueOf(aqi));
            }

            if (aqi <= 51) {
                img.setBackgroundColor(Color.parseColor("#95e6b7"));
                img.setImageDrawable(getResources().getDrawable(R.drawable.happy));
                li.setBackgroundColor(Color.parseColor("#abebc6"));
                ind.setText("Good");

            } else if (aqi > 51 && aqi <= 100) {
                img.setBackgroundColor(Color.parseColor("#f2dd8a"));
                img.setImageDrawable(getResources().getDrawable(drawable.mod));
                li.setBackgroundColor(Color.parseColor("#f9e79f"));
                ind.setText("Moderate");
            } else if (aqi > 101 && aqi <= 150) {
                img.setBackgroundColor(Color.parseColor("#f0a460"));
                img.setImageDrawable(getResources().getDrawable(drawable.unhe));
                li.setBackgroundColor(Color.parseColor("#f0b27a"));
                ind.setText("Unhealthy");
            } else if (aqi > 151 && aqi <= 200) {
                img.setBackgroundColor(Color.parseColor("#f7a8a1"));
                img.setImageDrawable(getResources().getDrawable(drawable.hazard));
                li.setBackgroundColor(Color.parseColor("#f5b7b1"));
                ind.setText("Very Bad");
            } else {
                img.setBackgroundColor(Color.parseColor("#a93226"));
                img.setImageDrawable(getResources().getDrawable(drawable.angry));
                li.setBackgroundColor(Color.parseColor("#cd6155"));
                ind.setText("Hazardous");
            }
        }
        else if(ac == 200){
            int a = (int)bo.get("co");
            int b = (int)bo.get("so");
            int c = (int)bo.get("pm");
            int d = (int)bo.get("pm10");

            ArrayList<BarEntry> entries = new ArrayList<>();
            entries.add(new BarEntry(a, 0));
            entries.add(new BarEntry(b, 1));
            entries.add(new BarEntry(c, 2));
            entries.add(new BarEntry(d, 3));

            BarDataSet bardataset = new BarDataSet(entries, "Pollutants");


            ArrayList<String> labels = new ArrayList<String>();
            labels.add("PM2.5");
            labels.add("PM10");
            labels.add("CO");
            labels.add("SO2");

            BarData data = new BarData(labels, bardataset);
            barChart.setData(data);// set the data and list of labels into chart
            barChart.setDrawBarShadow(true);
            barChart.setDescription("AQI of " + bo.get("place"));

            bardataset.setColors(ColorTemplate.PASTEL_COLORS);
            barChart.setBackgroundColor(Color.parseColor("#d7dbdd"));
            barChart.animateY(2000);

            img = (ImageView) findViewById(id.img);
            li = (LinearLayout) findViewById(id.li);
            text = (TextView) findViewById(id.aq);
            ind = (TextView) findViewById(id.ind);
            time = (TextView) findViewById(R.id.time);

            SimpleDateFormat smp = new SimpleDateFormat("HH:mm a");
            Date date = new Date();
            time.setText((smp.format(date)));

            int aqi = (a + b + c + d) / 4;
            if (aqi < 100) {
                text.setText("0" + aqi);
            } else {
                text.setText(String.valueOf(aqi));
            }

            if (aqi <= 51) {
                img.setBackgroundColor(Color.parseColor("#95e6b7"));
                img.setImageDrawable(getResources().getDrawable(R.drawable.happy));
                li.setBackgroundColor(Color.parseColor("#abebc6"));
                ind.setText("Good");

            } else if (aqi > 51 && aqi <= 100) {
                img.setBackgroundColor(Color.parseColor("#f2dd8a"));
                img.setImageDrawable(getResources().getDrawable(drawable.mod));
                li.setBackgroundColor(Color.parseColor("#f9e79f"));
                ind.setText("Moderate");
            } else if (aqi > 101 && aqi <= 150) {
                img.setBackgroundColor(Color.parseColor("#f0a460"));
                img.setImageDrawable(getResources().getDrawable(drawable.unhe));
                li.setBackgroundColor(Color.parseColor("#f0b27a"));
                ind.setText("Unhealthy");
            } else if (aqi > 151 && aqi <= 200) {
                img.setBackgroundColor(Color.parseColor("#f7a8a1"));
                img.setImageDrawable(getResources().getDrawable(drawable.hazard));
                li.setBackgroundColor(Color.parseColor("#f5b7b1"));
                ind.setText("Very Bad");
            } else {
                img.setBackgroundColor(Color.parseColor("#a93226"));
                img.setImageDrawable(getResources().getDrawable(drawable.angry));
                li.setBackgroundColor(Color.parseColor("#cd6155"));
                ind.setText("Hazardous");
            }
        }
    }


}
