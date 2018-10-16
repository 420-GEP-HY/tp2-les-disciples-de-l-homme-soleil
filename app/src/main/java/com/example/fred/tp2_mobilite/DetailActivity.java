package com.example.fred.tp2_mobilite;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.LectureFlux;
import com.example.fluxrss.NouvellesData;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DetailActivity extends AppCompatActivity {

    private int positionRss;
    private int positionNouvelle;
    private ArrayList<FluxRssData> mesFlux;
    private NouvellesData nouvelle;
    private LectureFlux lf;
    private TextView description;
    private TextView titre;
    private TextView lien;
    private ImageView image;
    private VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        lf = new LectureFlux(this);
        description = this.findViewById(R.id.description);
        titre = this.findViewById(R.id.titre);
        image = this.findViewById(R.id.image);
        lien = this.findViewById(R.id.lien);
        Bundle extra = getIntent().getExtras();
        positionRss = extra.getInt("positionrss");
        positionNouvelle = extra.getInt("positionnouvelle");
        mesFlux = lf.Load();
        nouvelle = mesFlux.get(positionRss).nouvelles.get(positionNouvelle);
        description.setText(Html.fromHtml(nouvelle.Description));
        titre.setText(nouvelle.titre);
        if(nouvelle.imageNouvelle != null)
            image.setImageBitmap(nouvelle.imageNouvelle.getBitmap());
        lien.setText(Html.fromHtml("<link>" + nouvelle.lien +"</link>"));

        if(nouvelle.VideoUrl != null)
        {
            final ProgressDialog pd = new ProgressDialog(DetailActivity.this);
            pd.setMessage("La vidéo charge... veuiller patienté.");
            pd.show();
            video = this.findViewById(R.id.video);
            Uri uri = Uri.parse(nouvelle.VideoUrl);
            video.setVideoURI(uri);
            video.start();
            video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    pd.dismiss();
                }
            });
        }
    }
}
