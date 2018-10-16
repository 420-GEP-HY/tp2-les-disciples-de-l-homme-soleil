package com.example.fred.tp2_mobilite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;
import com.example.fluxrss.NouvellesData;

import java.util.ArrayList;

public class LectureActivity extends AppCompatActivity {

    private int position;
    static ArrayList<FluxRssData> mesflux;
    static ArrayList<NouvellesData> mesNouvelles;

    static ListView listView;
    LectureFlux lf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lecture);
        Bundle extra = getIntent().getExtras();
        position = extra.getInt("position");
        setTitle("TP2");
        lf = new LectureFlux(this);
        mesflux = lf.Load();
        mesNouvelles = mesflux.get(0).nouvelles;
        ArrayAdapter<NouvellesData> aa = new NouvelleAdapter(getApplicationContext(), 0, mesNouvelles, this);
        listView = this.findViewById(R.id.ListeDeNouvelles);

        listView.setAdapter(aa);
    }


}
