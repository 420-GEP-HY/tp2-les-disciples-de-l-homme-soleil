package com.example.fred.tp2_mobilite;

import android.graphics.Bitmap;

import java.io.Serializable;

public class FluxRssData implements Serializable
{
    String titre;
    String uRL;
    Bitmap image;
    int articleNonLus;
    public FluxRssData(String titre, String URL, Bitmap image, int articleNonLus){
        this.titre = titre;
        this.uRL = URL;
        this.image = image;
        this.articleNonLus = articleNonLus;
    }
}
