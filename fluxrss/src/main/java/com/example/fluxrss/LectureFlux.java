package com.example.fluxrss;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class LectureFlux {
    Context appContexte;
    public LectureFlux(Context context)
    {
        appContexte = context;
    }
    public LectureFlux(){}
    public FluxRssData LireFlux(String rssUrlStr)
    {
        FluxRssData flux =  new FluxRssData("test", rssUrlStr, 0);
        DocumentBuilder builder;
        Document dom;
        try {
            builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            dom = builder.parse(rssUrlStr);
            NodeList items = dom.getDocumentElement().getElementsByTagName("item");
            flux.articleNonLus = items.getLength();
            flux.titre = dom.getElementsByTagName("title").item(0).getTextContent();
            flux.uRL = rssUrlStr;
            if(appContexte != null) {
                NodeList nodes = dom.getDocumentElement().getElementsByTagName("image");
                Element elm = (Element) nodes.item(0);
                Node s = elm.getElementsByTagName("url").item(0);
                Node url = s.getFirstChild();
                String strtr = url.getNodeValue();
                Bitmap b = getBitmapFromUrl(new URL(strtr));
                ProxyBitmap pb = new ProxyBitmap(b);
                flux.image = pb;
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flux;
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
        for(int i = 0; i < mesDonnees.size(); i++)
        {
            if(mesDonnees.get(i) == null)
                mesDonnees.remove(i);
        }
        return mesDonnees;
    }
    private Bitmap getBitmapFromUrl(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.connect();

        InputStream input = connection.getInputStream();

        return BitmapFactory.decodeStream(input);
    }
}
