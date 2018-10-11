package com.example.fluxrss;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class LectureFlux {
    Context appContexte;
    public LectureFlux(Context context)
    {
        appContexte = context;
    }
    public void Save(ArrayList<FluxRssData> Flux){
        try{
            FileOutputStream fos = appContexte.getApplicationContext().openFileOutput("FluxRssData", Context.MODE_PRIVATE);
            ObjectOutputStream od = new ObjectOutputStream(fos);
            od.writeObject(Flux);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<FluxRssData> Load(){
        ArrayList<FluxRssData> mesDonnees = new ArrayList<>();
        try{
            FileInputStream fis = appContexte.getApplicationContext().openFileInput("FluxRssData");
            ObjectInputStream is = new ObjectInputStream(fis);
            //MesFlux = (ArrayList<FluxRssData>) is.readObject();
            mesDonnees = (ArrayList<FluxRssData>) is.readObject();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //UpdateAdapter(MesFlux);
        return mesDonnees;
    }
}
