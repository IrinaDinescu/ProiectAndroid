package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.proiectandroid.classes.PlatiAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlatiActivity extends AppCompatActivity {
    private ListView lista_plati;
    private TextView nr_prieteni;
    private PlatiAdapter platiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plati);

        lista_plati = findViewById(R.id.lv_plati);
        setupAdapter();
        nr_prieteni=findViewById(R.id.tv_numarPrieteni);
        nr_prieteni.setText(String.valueOf(size));
    }

    private void setupAdapter(){
        platiAdapter = new PlatiAdapter(this, Lista());
        lista_plati.setAdapter(platiAdapter);


    }

    private ArrayList<Plata> Lista(){


        Plata p1 = new Plata("Dan Alexandra","0733132421" , 1);
        Plata p2 = new Plata("Ionescu Maria","0756132421" , 2);
        Plata p3 = new Plata("Chiper Teodor","0737192421" , 3);
        Plata p4 = new Plata("Dinescu Irina","0788132421" , 4);
        Plata p5 = new Plata("Dan Oana","0756132421" , 4);
        Plata p6 = new Plata("Dorobantu Marina","0764135221" , 4);
        Plata p7 = new Plata("Draghia Cosmina","0779123421" , 4);
        Plata p8 = new Plata("Popescu Mihai","0748143421" , 4);

        ArrayList<Plata> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);
        lista.add(p5);
        lista.add(p6);
        lista.add(p7);
        lista.add(p8);

        return lista;

    }
    int size=Lista().size();

}
