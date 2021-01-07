package com.example.proiectandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PlataPrieten")
public class PlataPrieten {
    @PrimaryKey(autoGenerate = true)
   public int cod;
   public double suma;
    public String detaliiPlata;

    public PlataPrieten(double suma,String detaliiPlata) {
        this.suma = suma;
        this.detaliiPlata = detaliiPlata;

    }

    @Override
    public String toString() {
        return "PlataPrieten{" +
                "cod=" + cod +
                ", numePrieten='" + detaliiPlata + '\'' +
                ", suma=" + suma +
                '}';
    }
}
