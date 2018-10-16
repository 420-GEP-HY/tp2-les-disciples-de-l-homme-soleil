package com.example.fred.tp2_mobilite;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URL;
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
            FluxRssData fluxAjout = new FluxRssData("test" , "http://www.lapresse.ca/rss.php" , 0);
            MesFlux.add(fluxAjout);
            Assert.assertEquals(MesFlux.get(MesFlux.size() - 1) , fluxAjout);

    }

    @Test
    public void NombreElementArrayList()
    {
        try {
            //Ajout d'un nouveau flux
            FluxRssData fluxAjout1 = new FluxRssData("test" , "http://www.lapresse.ca/rss.php" , 0);
            MesFlux.add(fluxAjout1);
            FluxRssData fluxAjout2 = new FluxRssData("test" , "http://rss.slashdot.org/Slashdot/slashdotMain" , 0);
            MesFlux.add(fluxAjout2);
            FluxRssData fluxAjout3 = new FluxRssData("test" , "https://www.commentcamarche.net/rss/ " , 0);
            MesFlux.add(fluxAjout3);
            FluxRssData fluxAjout4 = new FluxRssData("test" , "http://www.developpez.com/index/rss " , 0);
            MesFlux.add(fluxAjout4);

            Assert.assertEquals( 4 , MesFlux.size());
        }catch (Exception ex){
            Assert.fail("Nombre d'élément invalide");
        }
    }

    @Test
    public void removeFlux()
    {
        try{

            FluxRssData fluxAjout1 = new FluxRssData("test" , "http://www.lapresse.ca/rss.php" , 0);
            MesFlux.add(fluxAjout1);
            FluxRssData fluxAjout2 = new FluxRssData("test" , "http://rss.slashdot.org/Slashdot/slashdotMain" , 0);
            MesFlux.add(fluxAjout2);
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

    @Test
    public void testerURL()
    {
        try{
            FluxRssData fluxAjout = lf.LireFlux( "http://www.lapresse.ca/rss.php");
            Assert.assertEquals(true , lf.isValid(fluxAjout.uRL));
        }catch (Exception ex){
            Assert.fail("Une exception est levée");
        }
    }


}