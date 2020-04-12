package com.example.aqindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.Spinner;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Route extends AppCompatActivity {


    private Spinner source;
    private Spinner dest;
    private FloatingActionButton walk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route);
        getSupportActionBar().hide();

        source = findViewById(R.id.spinner1);
        String[] items = new String[]{"Source","NIT", "Amapaara", "Jaistambh", "Ghadi Chowk"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spin, items);
        source.setAdapter(adapter);

        dest = findViewById(R.id.spinner2);
        String[] items2 = new String[]{"Destination","NIT", "Amapaara", "Jaistambh", "Ghadi Chowk"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, R.layout.spin, items2);
        dest.setAdapter(adapter2);

        walk = (FloatingActionButton)findViewById(R.id.walk);
        walk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Route.this, source.class);
                i.putExtra("source", String.valueOf(source.getSelectedItem()));
                i.putExtra("dest", String.valueOf(dest.getSelectedItem()));
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.no__anim);
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Route.this, MainActivity.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
