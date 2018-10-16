package com.example.fred.tp2_mobilite;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.fluxrss.NouvellesData;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

public class DetailActivity extends AppCompatActivity {

    private NouvellesData nouvelle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
    }
}
