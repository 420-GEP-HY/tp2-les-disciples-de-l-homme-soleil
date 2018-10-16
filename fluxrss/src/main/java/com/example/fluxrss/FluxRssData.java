package com.example.fluxrss;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.Serializable;
import java.util.ArrayList;

public class FluxRssData implements Serializable
{
    public String titre;
    String uRL;
    public ProxyBitmap image;
    public int articleNonLus;
    public ArrayList<NouvellesData> nouvelles;
    public FluxRssData(String titre, String URL, int articleNonLus){
        this.titre = titre;
        this.uRL = URL;
        this.articleNonLus = articleNonLus;
    }
}