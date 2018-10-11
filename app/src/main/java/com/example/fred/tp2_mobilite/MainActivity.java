package com.example.fred.tp2_mobilite;

import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static  ArrayList<FluxRssData> MesFlux;
    static ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //guili guili
        setContentView(R.layout.activity_main);
        setTitle("TP2");
        MesFlux = new ArrayList<FluxRssData>();
        ImageView ajouter = findViewById(R.id.ajouter);
        final EditText libelle = findViewById(R.id.libelle);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (libelle.getText().toString() == ""){
                    return;
                }
                else{
                    FluxRssData nouveauFlux = new FluxRssData(libelle.getText().toString(), "test", BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher_background), 0);
                    MesFlux.add(nouveauFlux);
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
}
