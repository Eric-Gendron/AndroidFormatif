package com.example.formatifexamen;

import java.sql.Array;

public class Cadeau {

    private String Nom;
    private String Prenom;
    private String Pays;
    private String CodePostal;
    private int Age;
    private String Cadeau;
    private int NS;
    private DataGateway DG;

    public Cadeau(String nom, String prenom, String pays, String codePostal, int age, String cadeau, int NiveauSagesse, DataGateway Datagateway) {
        this.Nom = nom;
        this.Prenom = prenom;
        this.Pays = pays;
        this.CodePostal = codePostal;
        this.Age = age;
        this.Cadeau = cadeau;
        this.NS = NiveauSagesse;
        this.DG = Datagateway;
    }



    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getPays() {
        return Pays;
    }

    public void setPays(String pays) {
        Pays = pays;
    }

    public String getCodePostal() {
        return CodePostal;
    }

    public void setCodePostal(String codePostal) {
        CodePostal = codePostal;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getCadeau() {
        return Cadeau;
    }

    public void setCadeau(String cadeau) {
        Cadeau = cadeau;
    }

    public int getNiveauSagesse() {
        return NS;
    }

    public void setNiveauSagesse(int NS) {
        this.NS = NS;
    }

    public void AddCadeau(){
        DG.AddToDB(
                this.Nom,
                this.Prenom,
                this.Pays,
                this.CodePostal,
                this.Age,
                this.Cadeau,
                this.NS
        );
    }

}
