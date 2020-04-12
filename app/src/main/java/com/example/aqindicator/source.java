package com.example.aqindicator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class source extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source);
        getSupportActionBar().hide();

        Intent i = getIntent();

        Bundle k = i.getExtras();

        String a = ((String) k.get("source"));
        String b = ((String) k.get("dest"));

        Random rand = new Random();
        final int co = rand.nextInt(500);
        final int no = rand.nextInt(300);
        final int pm = rand.nextInt(200);
        final int pm10 = rand.nextInt(100);

        int nit = (co + no + pm + pm10) / 4;

        final int cog = rand.nextInt(500);
        final int nog = rand.nextInt(300);
        final int pmg = rand.nextInt(200);
        final int pmg10 = rand.nextInt(100);
        int ghadi = (cog + nog + pmg + pmg10) / 4;

        final int coj = rand.nextInt(500);
        final int noj = rand.nextInt(300);
        final int pmj = rand.nextInt(200);
        final int pmj10 = rand.nextInt(100);
        int jai = (coj + noj + pmj + pmj10) / 4;

        final int coa = rand.nextInt(500);
        final int noa = rand.nextInt(300);
        final int pma = rand.nextInt(200);
        final int pma10 = rand.nextInt(100);
        int ama = (coa + noa + pma + pma10) / 4;

        int nit_i = 0;
        String nd;
        String nit_b;
        if (nit <= 51) {
            nit_i = R.drawable.happy;
            nd = "Healhy";
            nit_b = "#95e6b7";
        } else if (nit > 51 && nit <= 100) {
            nit_i = R.drawable.mod;
            nd = "Moderate";
            nit_b = "#f2dd8a";
        } else if (nit > 101 && nit <= 150) {
            nit_i = R.drawable.unhe;
            nd = "Unhealthy";
            nit_b = "#f0b27a";
        } else if (nit > 151 && nit <= 200) {
            nit_i = R.drawable.hazard;
            nd = "Very Bad";
            nit_b = "#f5b7b1";
        } else {
            nit_i = R.drawable.angry;
            nd = "Hazardous";
            nit_b = "#cd6155";
        }

        String ghadi_b, ama_b, jai_b;
        String gd;
        int ghadi_i = 0;
        if (ghadi <= 51) {
            ghadi_i = R.drawable.happy;
            gd = "Healhy";
            ghadi_b = "#95e6b7";
        } else if (ghadi > 51 && ghadi <= 100) {
            ghadi_i = R.drawable.mod;
            gd = "Moderate";
            ghadi_b = "#f2dd8a";
        } else if (ghadi > 101 && ghadi <= 150) {
            ghadi_i = R.drawable.unhe;
            gd = "Unhealthy";
            ghadi_b = "#f0b27a";
        } else if (ghadi > 151 && ghadi <= 200) {
            ghadi_i = R.drawable.hazard;
            gd = "Very Bad";
            ghadi_b = "#f5b7b1";
        } else {
            ghadi_i = R.drawable.angry;
            gd = "Hazardous";
            ghadi_b = "#cd6155";
        }

        String ad;
        int ama_i = 0;
        if (ama <= 51) {
            ama_i = R.drawable.happy;
            ad = "Healthy";
            ama_b = "#95e6b7";
        } else if (ama > 51 && ama <= 100) {
            ama_i = R.drawable.mod;
            ad = "Moderate";
            ama_b = "#f2dd8a";
        } else if (ama > 101 && ama <= 150) {
            ama_i = R.drawable.unhe;
            ad = "Unhealthy";
            ama_b = "#f0b27a";
        } else if (ama > 151 && ama <= 200) {
            ama_i = R.drawable.hazard;
            ad = "Very Bad";
            ama_b = "#f5b7b1";
        } else {
            ama_i = R.drawable.angry;
            ad = "Hazardous";
            ama_b = "#cd6155";
        }

        String jd;
        int jai_i = 0;
        if (jai <= 51) {
            jai_i = R.drawable.happy;
            jd = "Healthy";
            jai_b = "#95e6b7";
        } else if (jai > 51 && jai <= 100) {
            jai_i = R.drawable.mod;
            jd = "Moderate";
            jai_b = "#f2dd8a";
        } else if (jai > 101 && jai <= 150) {
            jai_i = R.drawable.unhe;
            jd = "Unhealthy";
            jai_b = "#f0b27a";

        } else if (jai > 151 && jai <= 200) {
            jai_i = R.drawable.hazard;
            jd = "Very Bad";
            jai_b = "#f5b7b1";
        } else {
            jai_i = R.drawable.angry;
            jd = "Hazardous";
            jai_b = "#cd6155";
        }

        String nits, amas, jais, ghadis;
        if (nit < 100) {
            nits = "0" + nit;
        } else {
            nits = String.valueOf(nit);
        }
        if (ama < 100) {
            amas = "0" + ama;
        } else {
            amas = String.valueOf(ama);
        }
        if (jai < 100) {
            jais = "0" + jai;
        } else {
            jais = String.valueOf(jai);
        }
        if (ghadi < 100) {
            ghadis = "0" + ghadi;
        } else {
            ghadis = String.valueOf(ghadi);
        }
        SimpleDateFormat smp = new SimpleDateFormat("HH:mm a");
        Date date = new Date();
        String time = smp.format(date);
        if (a.equals("NIT") && b.equals("Ghadi Chowk")) {
            final ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara", "Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    nits, amas, jais, ghadis
            };
            final int[] img = new int[]{
                    nit_i, ama_i, jai_i, ghadi_i
            };

            final String[] desc = new String[]{nd, ad,
                    jd, gd};

            final String[] times = new String[]{time, time, time,
                    time
            };

            final String[] back = new String[]{
                    nit_b, ama_b, ghadi_b, jai_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView text = (TextView)adapterView.findViewById(R.id.name);
                    if(text.getText().equals("NIT")){
                    Intent act = new Intent(source.this, Barchart.class);
                    act.putExtra("activity", 200);
                    act.putExtra("co", co);
                    act.putExtra("so", no);
                    act.putExtra("pm", pm);
                    act.putExtra("pm10", pm10);
                    act.putExtra("place", text.getText());
                    startActivity(act);}
                    if(text.getText().equals("Amapaara")){
                        Intent act = new Intent(source.this, Barchart.class);
                        act.putExtra("activity", 200);
                        act.putExtra("co", coa);
                        act.putExtra("so", noa);
                        act.putExtra("pm", pma);
                        act.putExtra("pm10", pma10);
                        act.putExtra("place", text.getText());
                        startActivity(act);}
                    if(text.getText().equals("Jaistambh")){
                        Intent act = new Intent(source.this, Barchart.class);
                        act.putExtra("activity", 200);
                        act.putExtra("co", coj);
                        act.putExtra("so", noj);
                        act.putExtra("pm", pmj);
                        act.putExtra("pm10", pmj10);
                        act.putExtra("place", text.getText());
                        startActivity(act);}
                    if(text.getText().equals("Ghadi Chowk")){
                        Intent act = new Intent(source.this, Barchart.class);
                        act.putExtra("activity", 200);
                        act.putExtra("co", cog);
                        act.putExtra("so", nog);
                        act.putExtra("pm", pmg);
                        act.putExtra("pm10", pmg10);
                        act.putExtra("place", text.getText());
                        startActivity(act);}
                }

            } );

        } else if (a.equals("NIT") && b.equals("Jaistambh")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara", "Jaistambh"};
            final String[] aqi = new String[]{
                    nits, amas, jais
            };
            final int[] img = new int[]{
                    nit_i, ama_i, jai_i
            };

            final String[] desc = new String[]{nd, ad,
                    jd};

            final String[] times = new String[]{time, time, time
            };
            final String[] back = new String[]{
                    nit_b, ama_b, ghadi_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("NIT") && b.equals("Amapaara")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara"};
            final String[] aqi = new String[]{
                    nits, amas
            };
            final int[] img = new int[]{
                    nit_i, ama_i
            };

            final String[] desc = new String[]{nd, ad
            };

            final String[] times = new String[]{time, time
            };

            final String[] back = new String[]{
                    nit_b, ama_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("Amapaara") && b.equals("Jaistambh")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{
                    "Amapaara", "Jaistambh"};
            final String[] aqi = new String[]{ghadis, jais
            };
            final int[] img = new int[]{
                    ama_i, jai_i
            };

            final String[] desc = new String[]{ad,
                    jd};

            final String[] times = new String[]{time, time
            };

            final String[] back = new String[]{
                    ama_b, jai_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);


        } else if (a.equals("Amapaara") && b.equals("Ghadi Chowk")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{
                    "Amapaara", "Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    amas, jais, ghadis
            };
            final int[] img = new int[]{
                    ama_i, jai_i, ghadi_i
            };

            final String[] desc = new String[]{ad,
                    jd, gd};

            final String[] times = new String[]{time, time,
                    time
            };

            final String[] back = new String[]{
                    ama_b, jai_b, ghadi_b
            };
            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("Jaistambh") && b.equals("Ghadi Chowk")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    jais, ghadis
            };
            final int[] img = new int[]{
                    jai_i, ghadi_i
            };

            final String[] desc = new String[]{
                    jd, gd};

            final String[] times = new String[]{time,
                    time
            };

            final String[] back = new String[]{
                    jai_b, ghadi_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("Ghadi Chowk") && b.equals("Jaistambh")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    jais, ghadis
            };
            final int[] img = new int[]{
                    jai_i, ghadi_i
            };

            final String[] desc = new String[]{
                    jd, gd};

            final String[] times = new String[]{time,
                    time
            };

            final String[] back = new String[]{
                    jai_b, ghadi_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("Ghadi Chowk") && b.equals("Amapaara")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{
                    "Amapaara", "Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    ghadis, jais, amas
            };
            final int[] img = new int[]{
                    ama_i, jai_i, ghadi_i
            };

            final String[] desc = new String[]{ad,
                    jd, gd};

            final String[] times = new String[]{time, time,
                    time
            };

            final String[] back = new String[]{
                    ama_b, jai_b, ghadi_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        } else if (a.equals("Ghadi Chowk") && b.equals("NIT")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara", "Jaistambh", "Ghadi Chowk"};
            final String[] aqi = new String[]{
                    nits, ghadis, jais, amas
            };
            final int[] img = new int[]{
                    nit_i, ama_i, jai_i, ghadi_i
            };

            final String[] desc = new String[]{"nd", ad,
                    jd, gd};

            final String[] times = new String[]{time, time, time,
                    time
            };

            final String[] back = new String[]{
                    nit_b, ama_b, ghadi_b, jai_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);


        } else if (a.equals("Jaistambh") && b.equals("NIT")) {

            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara", "Jaistambh"};
            final String[] aqi = new String[]{
                    nits, amas, jais
            };
            final int[] img = new int[]{
                    nit_i, ama_i, jai_i
            };

            final String[] desc = new String[]{nd, ad,
                    jd};

            final String[] times = new String[]{time, time, time
            };

            final String[] back = new String[]{
                    nit_b, ama_b, jai_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);
        } else if (a.equals("Jaistambh") && b.equals("Amapaara")) {

            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{
                    "Amapaara", "Jaistambh"};
            final String[] aqi = new String[]{amas, jais
            };
            final int[] img = new int[]{
                    ama_i, jai_i
            };

            final String[] desc = new String[]{ad,
                    jd};

            final String[] times = new String[]{time, time
            };
            final String[] back = new String[]{
                    ama_b, jai_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);
        } else if (a.equals("Amapaara") && b.equals("NIT")) {
            ListView listView;
            listView = (ListView) findViewById(R.id.list);
            final String[] name = new String[]{"NIT",
                    "Amapaara"};
            final String[] aqi = new String[]{
                    nits, amas
            };
            final int[] img = new int[]{
                    nit_i, ama_i
            };

            final String[] desc = new String[]{nd, ad
            };

            final String[] times = new String[]{time, time
            };

            final String[] back = new String[]{
                    nit_b, ama_b
            };

            List<User> user;
            user = new ArrayList<User>();
            for (int il = 0; il < name.length; il++) {
                User item = new User(name[il], aqi[il], img[il], desc[il], times[il], back[il]);
                user.add(item);

            }


            UserAdaptor adapter = new UserAdaptor(this,
                    R.layout.junctions, user);
            listView.setAdapter(adapter);

        }

    }


    @Override
    public void onBackPressed() {
        Intent i = new Intent(source.this, Route.class);
        startActivity(i);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}
