package com.example.fred.tp2_mobilite;



import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;

import org.junit.Assert;
import org.junit.Test;


import java.util.ArrayList;

public class TestsUnitairesRSS {
    LectureFlux lf = new LectureFlux();
    ArrayList<FluxRssData> MesFlux = new ArrayList<FluxRssData>();
    @Test
    public void CreerFluxRss()
    {
        try {
            //Ajout d'un nouveau flux
            FluxRssData fluxAjout  = lf.LireFlux("https://ici.radio-canada.ca/rss/4159");
            MesFlux.add(fluxAjout);
            Assert.assertEquals(MesFlux.get(MesFlux.size() - 1) , fluxAjout);
        }catch (Exception ex){
            Assert.fail("Impossible d'ajouter un nouveau flux");
        }
    }
}
