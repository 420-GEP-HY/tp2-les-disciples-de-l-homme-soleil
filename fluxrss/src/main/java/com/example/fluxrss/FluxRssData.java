package com.example.fluxrss;

import android.graphics.Bitmap;

import java.io.Serializable;

public class FluxRssData implements Serializable
{
    public String titre;
    String uRL;
    public ProxyBitmap image;
    public int articleNonLus;
    public FluxRssData(String titre, String URL, Bitmap image, int articleNonLus){
        this.titre = titre;
        this.uRL = URL;
        this.image = new ProxyBitmap(image);
        this.articleNonLus = articleNonLus;
    }
}