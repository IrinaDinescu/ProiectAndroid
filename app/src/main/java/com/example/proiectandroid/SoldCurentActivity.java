package com.example.proiectandroid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;



public class SoldCurentActivity extends AppCompatActivity {
public TextView et_contCurentLei;
public TextView et_contCurentEuro;
public TextView tv_contEconomii;
public AppDb database;
public User user=null;
public Button btnPlati;
public static int ADD_REQUEST_CODE=100;
public double contCurentLei;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_curent);

        database= Room.databaseBuilder(getApplicationContext(),AppDb.class,"User").allowMainThreadQueries().build();
       initializareComponente();
       User u=new User("alisss21","danalisa1999@gmail.com",200032.320,500.30,50032.0);
        database.userDAO().insertUser(u);
        user=database.userDAO().getuser("danalisa1999@gmail.com");
        Log.v("user1",user.toString());
        contCurentLei=database.userDAO().getContCurent(1);
       // Log.v("ceva",String.valueOf(database.userDAO().getContCurent(1)));
        //Log.v("test",String.valueOf(u.contCurentLei));
        et_contCurentLei.setText(String.valueOf(user.contCurentLei));
        et_contCurentEuro.setText(String.valueOf(user.contCurentEuro));
        tv_contEconomii.setText(String.valueOf(user.contEconomii));

        btnPlati = findViewById(R.id.bt_plati);
        btnPlati.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Intent intent = new Intent(MainActivity.this, HomeActivity.class );
                Intent intent = new Intent(SoldCurentActivity.this, PlatiActivity.class );
//                intent.putExtra("message",String.valueOf(user));
                startActivityForResult(intent, ADD_REQUEST_CODE);
            }
        });

    }
    private void initializareComponente(){
        et_contCurentLei=findViewById(R.id.tvcontLEI);
        et_contCurentEuro=findViewById(R.id.tvcontEURO);
        tv_contEconomii=findViewById(R.id.contEconomii);

    }


}