package com.example.fred.tp2_mobilite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;
import com.example.fluxrss.NouvellesData;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private int positionRss;
    private int positionNouvelle;
    private ArrayList<FluxRssData> mesFlux;
    private NouvellesData nouvelle;
    private LectureFlux lf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        lf = new LectureFlux(this);
        Bundle extra = getIntent().getExtras();
        positionRss = extra.getInt("positionrss");
        positionNouvelle = extra.getInt("positionnouvelle");
        mesFlux = lf.Load();
        nouvelle = mesFlux.get(positionRss).nouvelles.get(positionNouvelle);
        int allo = 1;

    }
}
