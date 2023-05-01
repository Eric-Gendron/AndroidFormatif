package com.example.formatifexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        ListView lst = (ListView) findViewById(R.id.lstCadeaux);

        DataGateway sqlDG = new DataGateway(this, "Cadeaux", null, 1);
        ArrayList<Cadeau> listDesSages = sqlDG.GetEnfantsSage();
        CadeauArrayAdapter cadeauArrayAdapter = new CadeauArrayAdapter(this, R.layout.list_cadeaux, listDesSages);
        lst.setAdapter(cadeauArrayAdapter);
    }
}