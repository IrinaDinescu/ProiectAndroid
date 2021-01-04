package com.example.proiectandroid;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="Users")
public class User {
    @PrimaryKey(autoGenerate = true)
    public int id;
    @ColumnInfo(name="nume_user")
    public String nume;
    public String email;
    public int contCurentLei;
    public int contCurentEuro;
    public int contEconomii;

    public User( String nume,String email, int contCurentLei, int contCurentEuro, int contEconomii) {
        this.nume=nume;
        this.email=email;
        this.contCurentLei = contCurentLei;
        this.contCurentEuro = contCurentEuro;
        this.contEconomii = contEconomii;

    }


    @Override
    public String toString() {
        return "User{"+
                "id=" + id  +
                "nume="+nume+ "email="+email+
                "contCurentLei=" + contCurentLei +
                ", contCurentEuro=" + contCurentEuro +
                ", contEconomii=" + contEconomii +
                '}';
    }
}
