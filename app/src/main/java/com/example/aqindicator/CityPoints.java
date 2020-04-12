package com.example.aqindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class CityPoints extends AppCompatActivity {
    private FloatingActionButton nit;
    private FloatingActionButton ama;
    private FloatingActionButton jai;
    private FloatingActionButton gha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_points);
        getSupportActionBar().hide();
        nit = (FloatingActionButton) findViewById(R.id.nit);
        nit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CityPoints.this, Barchart.class);
                i.putExtra("place", 1);
                i.putExtra("activity", 100);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.no__anim);

            }
        });
        ama = (FloatingActionButton) findViewById(R.id.ama);
        ama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CityPoints.this, Barchart.class);
                i.putExtra("place", 2);
                i.putExtra("activity", 100);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.no__anim);
            }
        });
        jai = (FloatingActionButton) findViewById(R.id.jai);
        jai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CityPoints.this, Barchart.class);
                i.putExtra("place", 3);
                i.putExtra("activity", 100);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.no__anim);
            }
        });
        gha = (FloatingActionButton) findViewById(R.id.gha);
        gha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(CityPoints.this, Barchart.class);
                i.putExtra("place", 4);
                i.putExtra("activity", 100);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.no__anim);
            }
        });

    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(CityPoints.this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
