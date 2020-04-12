package com.example.aqindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class Opening extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_opening);
        textView = (TextView)findViewById(R.id.teo);
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {

                startActivity(new Intent(Opening.this, MainActivity.class));
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }, secondsDelayed * 2000);

        getSupportActionBar().hide();
    }
}
