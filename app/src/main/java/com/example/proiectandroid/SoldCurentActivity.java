package com.example.proiectandroid;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import java.util.List;


public class SoldCurentActivity extends AppCompatActivity {
private TextView et_contCurentLei;
private TextView et_contCurentEuro;
private TextView tv_contEconomii;
private AppDb database;
private User user=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sold_curent);

        database= Room.databaseBuilder(getApplicationContext(),AppDb.class,"User").allowMainThreadQueries().build();
       initializareComponente();
         database.userDAO().insertUser(new User("alisss21","danalisa1999@gmail.com",20000,5000,5000));
        user=database.userDAO().getuser("danalisa1999@gmail.com");
        Log.v("user1",user.toString());
        List<User> users=database.userDAO().getall();
        for(User user:users){
            Log.v("all_users",user.toString());
        }

        et_contCurentLei.setText(String.valueOf(user.contCurentLei));
        et_contCurentEuro.setText(String.valueOf(user.contCurentEuro));
        tv_contEconomii.setText(String.valueOf(user.contEconomii));


    }
    private void initializareComponente(){
        et_contCurentLei=findViewById(R.id.tvcontLEI);
        et_contCurentEuro=findViewById(R.id.tvcontEURO);
        tv_contEconomii=findViewById(R.id.contEconomii);

    }

}