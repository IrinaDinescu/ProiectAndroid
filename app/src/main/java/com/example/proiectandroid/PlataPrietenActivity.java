package com.example.proiectandroid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proiectandroid.classes.TransactionAdapter;

import java.util.List;

public class PlataPrietenActivity extends AppCompatActivity {
    private Button btn_plateste;
    private TextView numePrieten;
    private EditText et_suma, et_detaliiPlata;
    private AppDb database;
 //   public double contCurentLei;

//ushf


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plata_prieten);
        initializareComponente();
        Intent mIntent = getIntent();
        database = Room.databaseBuilder(this, AppDb.class, "PlataPrieten").allowMainThreadQueries().build();
    //    String str = mIntent.getStringExtra("message");

      //  Log.v("test2",str);
        btn_plateste = findViewById(R.id.plateste);
        btn_plateste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            showDialog(v);
            }

        });
        String nume = mIntent.getStringExtra("nume");
        numePrieten=findViewById(R.id.numePrieten);
        numePrieten.setText(nume);
     database=Room.databaseBuilder(getApplicationContext(),AppDb.class,"Users").allowMainThreadQueries().build();
//        contCurentLei=database.userDAO().getContCurent(1);
//        Log.v("ceva",String.valueOf(contCurentLei));
    }


    private void showDialog(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
        builder.setCancelable(true);
        builder.setTitle("Confirmare plata");
        builder.setMessage("Sunteti sigur ca vreti sa realizati aceasta plata?");
        builder.setPositiveButton("Confirm",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (validare()) {

                            inserareClient();

                        }
//             Log.v("test4",String.valueOf(getIntent().getSerializableExtra("message")));
                    }

                });

        builder.setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void initializareComponente(){
        et_suma=findViewById(R.id.sumaPlata);
        et_detaliiPlata=findViewById(R.id.detaliiPlata);
        btn_plateste=findViewById(R.id.plateste);

    }

    private boolean validare(){
        if(et_suma.getText().toString().isEmpty()){
            Toast.makeText(this,getString(R.string.sumaGresita), Toast.LENGTH_LONG).show();
            return false;
        }
        if(et_detaliiPlata.getText().toString().isEmpty()){
            Toast.makeText(this,getString(R.string.detaliiGresite), Toast.LENGTH_LONG).show();
            return false;}
        else return true;

    }

    private void inserareClient(){
            String detalii=et_detaliiPlata.getText().toString();
            double suma=Double.parseDouble(et_suma.getText().toString());

        PlataPrieten plataPrieten =new PlataPrieten(suma, detalii);
        database.plataPrietenDAO().insertPlata(plataPrieten);
        Toast.makeText(this, " Plata a fost realizata cu succes!", Toast.LENGTH_LONG).show();

    }

//    private List<PlataPrieten> listaPlata(){
//        List<PlataPrieten> list=database.plataPrietenDAO().platiPrieten();
//
//        return list;
//    }

}