package com.example.formatifexamen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class CadeauArrayAdapter extends ArrayAdapter <Cadeau>{



        public CadeauArrayAdapter(Context context, int ressource, List<Cadeau> Cadeaux) {
            super(context, 0, Cadeaux);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Cadeau cadeau = getItem(position);


            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_cadeaux, parent, false);

            TextView txtCadeau = convertView.findViewById(R.id.txtCadeau);
            TextView txtNom = convertView.findViewById(R.id.txtNom);

            txtCadeau.setText(cadeau.getCadeau());
            txtNom.setText(cadeau.getPrenom() + " " + cadeau.getNom());

            return convertView;
        }

}
