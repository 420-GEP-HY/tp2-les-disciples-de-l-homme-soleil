package com.example.fred.tp2_mobilite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.fluxrss.NouvellesData;

import java.util.ArrayList;
import java.util.List;


public class NouvelleAdapter extends ArrayAdapter<NouvellesData> {
    static ArrayList<NouvellesData> mesNouvelles;
    private int positionRSS;
    Activity ma;
    private Context mContext;
    public NouvelleAdapter(Context context, int resource, ArrayList<NouvellesData> objects, Activity ma, int position){
        super(context, resource, objects);
        this.mesNouvelles = objects;
        this.ma = ma;
        this.mContext = context;
        this.positionRSS = position;
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

                mesNouvelles.get(position).seen =true;
                ArrayList<NouvellesData> nouveauFlux = new ArrayList<>();
                nouveauFlux.addAll(mesNouvelles);

                Intent Detail = new Intent(getContext(), DetailActivity.class);
                Detail.putExtra("nouvelle", mesNouvelles.get(position));
                ma.startActivity(Detail);
            }
        });

        titre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mesNouvelles.get(position).seen = true;

                Intent Detail = new Intent(getContext(), DetailActivity.class);
                Detail.putExtra("nouvelle", mesNouvelles.get(position));
                ma.startActivity(Detail);
            }
        });

        if (mesNouvelles.get(position).imageNouvelle != null){
            imgView.setImageBitmap(mesNouvelles.get(position).imageNouvelle.getBitmap());
        }
        titre.setText(mesNouvelles.get(position).titre);
        return convertView;
    }

    public void refreshObjects(List<NouvellesData> object){
        this.mesNouvelles.clear();
        this.mesNouvelles.addAll(object);
        //((MainActivity)mContext).Save(mesFlux);
    }
}
