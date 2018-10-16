package com.example.fluxrss;

import java.io.Serializable;

public class NouvellesData implements Serializable {
    public String titre;
    public String Description;
    public boolean seen;
    public ProxyBitmap imageNouvelle;
    public String urlPage;

    public NouvellesData(String titre, String Description){
        this.titre = titre;
        this.Description = Description;
    }
}
