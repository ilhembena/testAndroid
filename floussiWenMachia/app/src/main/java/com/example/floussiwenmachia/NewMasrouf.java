package com.example.floussiwenmachia;

public class NewMasrouf {
    private String depense;
    private String date;
    private float valeur;
   private  int id;
    public NewMasrouf() {
    }


    public NewMasrouf(String depense, String date, float valeur) {
        this.depense = depense;
        this.date = date;
        this.valeur = valeur;
    }

    public NewMasrouf(String depense, float valeur) {
        this.depense = depense;

        this.valeur = valeur;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepense() {
        return depense;
    }

    public String getDate() {
        return date;
    }

    public float getValeur() {
        return valeur;
    }

    public void setDepense(String depense) {
        this.depense = depense;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setValeur(float val) {
        this.valeur = val;
    }
}
