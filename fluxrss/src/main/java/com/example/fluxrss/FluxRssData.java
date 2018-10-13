package com.example.fluxrss;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.Serializable;

public class FluxRssData implements Serializable
{
    public String titre;
    String uRL;
    public ProxyBitmap image;
    public int articleNonLus;
    public FluxRssData(String titre, String URL, int articleNonLus){
        this.titre = titre;
        this.uRL = URL;
        this.articleNonLus = articleNonLus;
    }
}