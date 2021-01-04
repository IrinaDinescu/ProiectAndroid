package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.proiectandroid.classes.Transaction;
import com.example.proiectandroid.classes.TransactionAdapter;

import java.util.ArrayList;

public class TransactionsActivity extends AppCompatActivity {

    private ListView transactions_list;
    private TransactionAdapter transactionAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);

        transactions_list = findViewById(R.id.lv_transactions);
        setupAdapter();
    }

    private void setupAdapter(){
        transactionAdapter = new TransactionAdapter(this, getDummyList());
        transactions_list.setAdapter(transactionAdapter);


    }

    private ArrayList<Transaction> getDummyList(){

        // ----> lista va fi preluata din baza de date
        Transaction t1 = new Transaction("Online", "Uber", "Uber SRL",
                "07/04/2021",-100,1);
        Transaction t2 = new Transaction("Online", "Uber", "Uber SRL",
                "19/09/2021",-0.22,2);
        Transaction t3 = new Transaction("Online", "Uber", "Uber SRL",
                "12/12/2021", 99.22,3);

        ArrayList<Transaction> list = new ArrayList<>();
        list.add(t1);
        list.add(t2);
        list.add(t3);

        return list;

    }
}




// --->Tasks
// creez cateva obiecte transaction
// creez un vector cu obiectele
// testez adapter-ul
// testez infoButton
