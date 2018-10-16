package com.example.fred.tp2_mobilite;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fluxrss.FluxRssData;
import com.example.fluxrss.NouvellesData;

import java.util.ArrayList;
import java.util.List;


public class NouvelleAdapter extends ArrayAdapter<NouvellesData> {
    static ArrayList<FluxRssData> mesFlux;
    static int positionFlux;
    Activity ma;
    private Context mContext;
    public NouvelleAdapter(@NonNull Context context, int resource, ArrayList<FluxRssData> object, Activity ma, int position) {
        super(context, resource);
        this.mesFlux = object;
        this.positionFlux = position;
        this.ma = ma;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.mon_layout_nouvelle, parent, false);
        }

        ImageView imgView = convertView.findViewById(R.id.imgNouvelle);
        TextView titre = convertView.findViewById(R.id.TitreNouvelle);

        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mesFlux.get(positionFlux).nouvelles.get(position).seen =true;
                ArrayList<FluxRssData> nouveauFlux = new ArrayList<>();
                nouveauFlux.addAll(mesFlux);
            }
        });

        titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mesFlux.get(positionFlux).nouvelles.get(position).seen = true;

            }
        });

        if (mesFlux.get(positionFlux).nouvelles.get(position).imageNouvelle != null){
            imgView.setImageBitmap(mesFlux.get(positionFlux).nouvelles.get(position).imageNouvelle.getBitmap());
        }
        titre.setText(mesFlux.get(positionFlux).nouvelles.get(position).titre);





        return convertView;
    }

    public void refreshObjects(List<FluxRssData> object){
        this.mesFlux.clear();
        this.mesFlux.addAll(object);
        ((MainActivity)mContext).Save(mesFlux);
    }
}
