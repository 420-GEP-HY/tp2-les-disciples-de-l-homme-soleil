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
        mesNouvelles = mesflux.get(position).nouvelles;
        ArrayAdapter<NouvellesData> aa = new NouvelleAdapter(getApplicationContext(), 0, mesNouvelles, this, position);
        listView = this.findViewById(R.id.ListeDeNouvelles);
        listView.setAdapter(aa);
    }
    @Override
    public void onResume(){
        super.onResume();
        mesflux = lf.Load();
        UpdateAdapter(mesflux);
    }
    public void UpdateAdapter(ArrayList<FluxRssData> NouveauFlux){
        mesflux = NouveauFlux;
        ArrayAdapter<NouvellesData> aa = new NouvelleAdapter(getApplicationContext(), 0, mesNouvelles, this, position);
        listView = this.findViewById(R.id.ListeDeNouvelles);
        listView.setAdapter(aa);
    }

}
