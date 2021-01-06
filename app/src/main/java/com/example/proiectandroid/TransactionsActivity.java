package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.widget.ListView;
import com.example.proiectandroid.classes.TransactionAdapter;
import java.util.List;

public class TransactionsActivity extends AppCompatActivity {

    private ListView transactions_list;
    private TransactionAdapter transactionAdapter;
    private AppDb database;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transactions);
        database = Room.databaseBuilder(getApplicationContext(), AppDb.class, "Transactions").allowMainThreadQueries().build();
        transactions_list = findViewById(R.id.lv_transactions);
        setupAdapter();
    }

    private void setupAdapter() {
        transactionAdapter = new TransactionAdapter(this, getDummyList());
        transactions_list.setAdapter(transactionAdapter);
    }

    private List<Transaction> getDummyList() {


        Transaction t1 = new Transaction("Online", "Uber", "Uber SRL",
                "07/04/2021", -100, 1);
        database.transactionDAO().insertTransaction(t1);
        Transaction t2 = new Transaction("Online", "Uber", "Uber SRL",
                "19/09/2021", -0.22, 2);
        database.transactionDAO().insertTransaction(t2);
        Transaction t3 = new Transaction("Online", "Uber", "Uber SRL",
                "12/12/2021", 99.22, 3);
        database.transactionDAO().insertTransaction(t3);
          List<Transaction> list=database.transactionDAO().getallTransactions();

        return list;

    }
}




// --->Tasks
// creez cateva obiecte transaction
// creez un vector cu obiectele
// testez adapter-ul
// testez infoButton
