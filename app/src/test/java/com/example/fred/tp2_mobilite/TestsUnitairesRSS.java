package com.example.fred.tp2_mobilite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class TestsUnitairesRSS {

    Context c;
    LectureFlux lf = new LectureFlux();
    List<FluxRssData> MesFlux = new ArrayList<FluxRssData>();

    @Test
    public void CreerFluxRss()
    {
        try {
            //Ajout d'un nouveau flux
            FluxRssData fluxAjout  = new FluxRssData("testccccdddddaaa", "http::/testaaabbbccc" , 0);
            MesFlux.add(fluxAjout);
            Assert.assertEquals(MesFlux.get(MesFlux.size() - 1) , fluxAjout);
        }catch (Exception ex){
            Assert.fail("Impossible d'ajouter un nouveau flux");
        }
    }

    @Test
    public void NombreElementArrayList()
    {
        try {
            //Ajout d'un nouveau flux
            MesFlux.add(new FluxRssData("testccccdddddaaa", "http::/testaaabbbccc", 0));
            MesFlux.add(new FluxRssData("testccccdddd", "http::/testaaabb", 0));
            MesFlux.add(new FluxRssData("testccccdddddaaahfhgf", "http::/testaaabbbcccgfhf", 0));
            MesFlux.add(new FluxRssData("testccccdddddaaafhgfg", "http::/testaaabbbcccfhgrth", 0));

            Assert.assertEquals( 4 , MesFlux.size());
        }catch (Exception ex){
            Assert.fail("Nombre d'élément invalide");
        }
    }

    @Test
    public void removeFlux()
    {
        try{
            MesFlux.add(new FluxRssData("testccccdddddaaa", "http::/testaaabbbccc", 0));
            MesFlux.add(new FluxRssData("testccccdddd", "http::/testaaabb", 0));
            MesFlux.remove(0);
            Assert.assertEquals(1 , MesFlux.size());

        }catch(Exception ex){
            Assert.fail("Impossioble d'ffectuer l'opération");
        }
    }

    @Test
    public void sauvegardeFlux()
    {
        ArrayList<FluxRssData> data = new ArrayList<FluxRssData>();
        try{
            data.add(new FluxRssData("testccccdddddaaa", "http::/testaaabbbccc",  0));
            lf.Save(data);
            Assert.assertEquals(0 , data.size());

        }catch(Exception ex){
            Assert.fail("Impossible de sauvegarder");
        }
    }


}