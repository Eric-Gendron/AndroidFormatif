package com.example.formatifexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nom;
    EditText password;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = (EditText) findViewById(R.id.txtNom);
        password = (EditText) findViewById(R.id.txtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login(nom.getText().toString(), password.getText().toString());
            }
        });
    }

    public void Login(String nom, String password) {
        if(nom.equals("noel") && password.equals("hohoho")) {
            Intent intent = new Intent(this, ChoixActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(this, "Mauvais nom d'utilisateur ou mot de passe", Toast.LENGTH_SHORT).show();
        }
    }
}
