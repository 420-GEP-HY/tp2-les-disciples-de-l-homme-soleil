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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lf = new LectureFlux(this);
        setContentView(R.layout.activity_main);
        setTitle("TP2");
        MesFlux = new ArrayList<FluxRssData>();
        MesFlux = lf.Load();
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
                    FluxRssData nouveauFlux = new FluxRssData(libelle.getText().toString(), "test", BitmapFactory.decodeResource(getResources(), R.drawable.x), 0);
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
    //public void Save(ArrayList<FluxRssData> Flux){
    //    try{
    //        FileOutputStream fos = getApplicationContext().openFileOutput("FluxRssData", Context.MODE_PRIVATE);
    //        ObjectOutputStream od = new ObjectOutputStream(fos);
    //        od.writeObject(Flux);
    //    } catch (FileNotFoundException e) {
    //        e.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    }
    //}
    //public void Load(){
    //    try{
    //        FileInputStream fis = getApplicationContext().openFileInput("FluxRssData");
    //        ObjectInputStream is = new ObjectInputStream(fis);
    //        MesFlux = (ArrayList<FluxRssData>) is.readObject();
    //    }
    //    catch (FileNotFoundException e) {
    //        e.printStackTrace();
    //    } catch (IOException e) {
    //        e.printStackTrace();
    //    } catch (ClassNotFoundException e) {
    //        e.printStackTrace();
    //    }
    //    UpdateAdapter(MesFlux);
    //}
}
