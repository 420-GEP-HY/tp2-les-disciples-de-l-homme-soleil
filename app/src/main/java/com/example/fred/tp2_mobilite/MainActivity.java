package com.example.fred.tp2_mobilite;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static  ArrayList<FluxRssData> MesFlux;
    static ListView listView;
    LectureFlux lf;
    FluxRssData nouveauFlux;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lf = new LectureFlux(this);
        setContentView(R.layout.activity_main);
        setTitle("TP2");
        MesFlux = new ArrayList<FluxRssData>();
        MesFlux = lf.Load();
        UpdateAdapter(MesFlux);
        //Load();
        ImageView ajouter = findViewById(R.id.ajouter);
        final EditText libelle = findViewById(R.id.libelle);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (libelle.getText().toString() == ""){
                    return;
                }
                else{
                    Thread t = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            synchronized (this) {
                                nouveauFlux = lf.LireFlux(libelle.getText().toString());
                            }
                        }
                    });
                    t.start();
                    try {
                        t.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    MesFlux.add(nouveauFlux);
                    lf.Save(MesFlux);
                    //Save(MesFlux);
                    UpdateAdapter(MesFlux);
                }
            }
        });
    }
    public void UpdateAdapter(ArrayList<FluxRssData> NouveauFlux){
        MesFlux = NouveauFlux;
        ArrayAdapter<FluxRssData> aa = new FluxRssAdapter(this, 0, MesFlux, this);
        listView = this.findViewById(R.id.ListeDeRSS);

        listView.setAdapter(aa);
    }
    public void Save(ArrayList<FluxRssData> Flux){
        lf.Save(Flux);
    }
}
