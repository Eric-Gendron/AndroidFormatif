package com.example.formatifexamen;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataGateway extends SQLiteOpenHelper {
    private SQLiteDatabase db;


    public DataGateway(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //creation de la table
        sqLiteDatabase.execSQL("create table if not exists cadeau (nom text, prenom text, pays text, codePostal text, age integer, cadeau text, niveauSagesse integer)");
        //insertion de données
        sqLiteDatabase.execSQL("insert into cadeau values ('Pierre', 'Jean', 'Canada', 'J4B 2T3', 12, 'Lego', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Dupont', 'Sophie', 'France', '75001', 8, 'Barbie', 9)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Martin', 'Lucas', 'France', '69001', 7, 'Playmobil', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Smith', 'Emma', 'United States', '10001', 9, 'LEGO', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Garcia', 'Diego', 'Spain', '28001', 11, 'Nerf', 6)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Kumar', 'Raj', 'India', '110001', 10, 'Hot Wheels', 9)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Chen', 'Yong', 'China', '100000', 6, 'Transformers', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Yamamoto', 'Akira', 'Japan', '100-0001', 5, 'Plushies', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Hansen', 'Lars', 'Norway', '0101', 7, 'Football', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Olsen', 'Maja', 'Denmark', '1050', 8, 'Barbie', 9)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Berg', 'Nina', 'Sweden', '10110', 6, 'Lego', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Gonzalez', 'Andres', 'Mexico', '01000', 10, 'Roblox Gift Card', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Zhang', 'Wei', 'China', '210000', 6, 'Beyblades', 6)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Lopez', 'Maria', 'Spain', '28001', 9, 'Barbie Dreamhouse', 9)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Silva', 'Pedro', 'Portugal', '1000-200', 11, 'Nintendo Switch', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Almeida', 'Sofia', 'Portugal', '1000-200', 5, 'My Little Pony', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Ramos', 'Juan', 'Chile', '7500000', 12, 'Electric Scooter', 6)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Park', 'Min-jun', 'South Korea', '03169', 8, 'Puzzle', 7)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Lee', 'Ji-woo', 'South Korea', '03058', 7, 'Action Figures', 8)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Nguyen', 'Quang', 'Vietnam', '100000', 9, 'Rubik Cube', 9)");
        sqLiteDatabase.execSQL("insert into cadeau values ('Tran', 'Thuy', 'Vietnam', '70000', 11, 'Barbie House', 6)");

        db = sqLiteDatabase;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void AddToDB(String nom, String prenom, String pays, String codePostal, int age, String cadeau, int NS){

    }


    public ArrayList<Cadeau> GetEnfantsSage(){
        ArrayList<Cadeau> cadeauList = new ArrayList<Cadeau>();
        Cursor cursor = db.rawQuery("select * from cadeau where niveauSagesse > 5", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String nom = cursor.getString(0);
            String prenom = cursor.getString(1);
            String pays = cursor.getString(2);
            String codePostal = cursor.getString(3);
            int age = cursor.getInt(4);
            String cadeau = cursor.getString(5);
            int NS = cursor.getInt(6);
            Cadeau cadeauTMP = new Cadeau(nom, prenom, pays, codePostal, age, cadeau, NS, this);
            cadeauList.add(cadeauTMP);
            cursor.moveToNext();
        }
        return cadeauList;
    }

    public ArrayList<Cadeau> GetEnfantsParPays(String _pays){
        ArrayList<Cadeau> cadeauList = new ArrayList<Cadeau>();
        Cursor cursor = db.rawQuery("select * from cadeau where pays = '"+ _pays +"'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String nom = cursor.getString(0);
            String prenom = cursor.getString(1);
            String pays = cursor.getString(2);
            String codePostal = cursor.getString(3);
            int age = cursor.getInt(4);
            String cadeau = cursor.getString(5);
            int NS = cursor.getInt(6);
            Cadeau cadeauTMP = new Cadeau(nom, prenom, pays, codePostal, age, cadeau, NS, this);
            cadeauList.add(cadeauTMP);
            cursor.moveToNext();
        }
        return cadeauList;
    }

    public ArrayList<Cadeau> GetEnfantsParNom(String Nom, String Prenom){
        ArrayList<Cadeau> cadeauList = new ArrayList<Cadeau>();
        Cursor cursor = db.rawQuery("select * from cadeau where nom = '"+ Nom +"' and prenom = '" + Prenom + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            String nom = cursor.getString(0);
            String prenom = cursor.getString(1);
            String pays = cursor.getString(2);
            String codePostal = cursor.getString(3);
            int age = cursor.getInt(4);
            String cadeau = cursor.getString(5);
            int NS = cursor.getInt(6);
            Cadeau cadeauTMP = new Cadeau(nom, prenom, pays, codePostal, age, cadeau, NS, this);
            cadeauList.add(cadeauTMP);
            cursor.moveToNext();
        }
        return cadeauList;
    }
}
