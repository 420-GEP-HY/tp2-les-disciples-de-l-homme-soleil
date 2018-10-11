package com.example.fred.tp2_mobilite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FluxRssAdapter extends ArrayAdapter<FluxRssData> {
    static ArrayList<FluxRssData> MesFlux;
    Activity ma;
    private Context mContext;
    public FluxRssAdapter(Context context, int resource, ArrayList<FluxRssData> objects, Activity ma){
        super(context, resource, objects);
        this.MesFlux = objects;

        this.ma = ma;
        mContext = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mon_layout, parent, false);
        }
        ImageView imgView = convertView.findViewById(R.id.imgRSS);
        TextView Titre = convertView.findViewById(R.id.TitreRss);
        TextView articleNonLus = convertView.findViewById(R.id.ArticleNonLus);
        ImageButton remove = convertView.findViewById(R.id.Delete);

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MesFlux.remove(MesFlux.get(position));
                ArrayList<FluxRssData> nouveauFlux = new ArrayList<FluxRssData>();
                nouveauFlux.addAll(MesFlux);
                refreshObjects(nouveauFlux);
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lecture = new Intent(ma, LectureActivity.class);
                ma.startActivity(Lecture);
            }
        });
        Titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Lecture = new Intent(ma, LectureActivity.class);
                ma.startActivity(Lecture);
            }
        });
        imgView.setImageBitmap(MesFlux.get(position).image);
        Titre.setText(MesFlux.get(position).titre);
        articleNonLus.setText(String.valueOf(MesFlux.get(position).articleNonLus));

        return convertView;
    }
    public void refreshObjects(List<FluxRssData> objects) {
        this.MesFlux.clear();
        this.MesFlux.addAll(objects);
        ((MainActivity)mContext).UpdateAdapter(MesFlux);
    }

}

