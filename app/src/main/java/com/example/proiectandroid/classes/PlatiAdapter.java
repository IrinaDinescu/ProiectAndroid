package com.example.proiectandroid.classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectandroid.Plata;
import com.example.proiectandroid.PlataPrietenActivity;
import com.example.proiectandroid.R;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class PlatiAdapter extends BaseAdapter {

    private List<Plata> plati;
    private Context context;
    private LayoutInflater inflater;

    public PlatiAdapter(Context context, List<Plata> plati) {
        this.plati = plati;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return plati.size();
    }

    @Override
    public Object getItem(int position) {
        return plati.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View item = inflater.inflate(R.layout.item_plati, viewGroup, false);
        TextView tv_nume = item.findViewById(R.id.tv_Numeprieten);
        TextView tv_telefon = item.findViewById(R.id.tv_telefon);


        final Plata plata = plati.get(position);
        tv_nume.setText(plata.getNume());
        tv_telefon.setText(plata.getTelefon());


        FloatingActionButton plataButton = item.findViewById(R.id.prietenButton);
        plataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(context, "Transfera catre prieten", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, PlataPrietenActivity.class );
                intent.putExtra("cod", plata.getCodPrieten());
                context.startActivity(intent);

            }
        });


        return item;
    }
}
