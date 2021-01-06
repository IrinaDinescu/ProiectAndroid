package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StatisticsActivity extends AppCompatActivity {
    private ListView lv_transaction;
    private AppDb database;

    @Override 
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        database = Room.databaseBuilder(this, AppDb.class, "Transactions").allowMainThreadQueries().build();
        lv_transaction=findViewById(R.id.id_transaction);
        ArrayAdapter<Transaction> adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, database.transactionDAO().getallTransactions());
        lv_transaction.setAdapter((adapter));

    }
}