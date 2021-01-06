package com.example.proiectandroid;

public class Plata {
    private int codPrieten;
    private String nume;
    private String telefon;

    public Plata(String nume, String telefon,int codPrieten) {
        this.codPrieten=codPrieten;
        this.nume = nume;
        this.telefon = telefon;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public int getCodPrieten() {
        return codPrieten;
    }

    public void setCodPrieten(int codPrieten) {
        this.codPrieten = codPrieten;
    }
}
