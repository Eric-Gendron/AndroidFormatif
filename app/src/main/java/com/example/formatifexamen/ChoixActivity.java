package com.example.formatifexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class ChoixActivity extends AppCompatActivity {

    EditText txtPays;
    EditText txtNom;
    EditText txtPrenom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix);
        txtPays = (EditText) findViewById(R.id.txtPays);
        txtNom = (EditText) findViewById(R.id.txtNom);
        txtPrenom = (EditText) findViewById(R.id.txtPrenom);

        setOnClickListener();
    }

    private void setOnClickListener() {
        findViewById(R.id.btnEnfantsListe).setOnClickListener(view -> {
            Intent intent = new Intent(this, ListeActivity.class);
            startActivity(intent);
        });

        findViewById(R.id.btnEnfantsPays).setOnClickListener(view -> {
            Intent intent = new Intent(this, PaysActivity.class);
            intent.putExtra("pays", txtPays.getText().toString());
            startActivity(intent);
        });

        findViewById(R.id.btnEnfantNom).setOnClickListener(view -> {
            Intent intent = new Intent(this, NomActivity.class);
            intent.putExtra("nom", txtNom.getText().toString());
            intent.putExtra("prenom", txtPrenom.getText().toString());
            startActivity(intent);
        });
    }
}
