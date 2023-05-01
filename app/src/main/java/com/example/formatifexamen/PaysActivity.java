package com.example.formatifexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PaysActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pays);

        ListView lst = (ListView) findViewById(R.id.lstCadeaux);

        DataGateway sqlDG = new DataGateway(this, "Cadeaux", null, 1);
        ArrayList<Cadeau> listParPays= sqlDG.GetEnfantsParPays(getIntent().getStringExtra("pays"));
        CadeauArrayAdapter cadeauArrayAdapter = new CadeauArrayAdapter(this, R.layout.list_cadeaux, listParPays);
        lst.setAdapter(cadeauArrayAdapter);
    }
}