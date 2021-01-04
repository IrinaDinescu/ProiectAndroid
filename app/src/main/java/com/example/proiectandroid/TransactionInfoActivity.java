package com.example.proiectandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class TransactionInfoActivity extends AppCompatActivity {

    private TextView tipul_tranzactiei, type;
    private TextView comerciant, trader;
    private TextView cod_comerciant, merchant_code;
    private TextView data, transaction_date;
    private TextView suma, sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_info);

        Intent mIntent = getIntent();
        int transaction_code = mIntent.getIntExtra("code", 0);

        //Log.v("Trans", transaction_code)
//
        String ceva = String.valueOf(transaction_code);
        Toast.makeText(this, ceva, Toast.LENGTH_SHORT).show();

        type = (TextView) findViewById(R.id.tv_transaction_type);
        trader = (TextView) findViewById(R.id.tv_trader);
        merchant_code = (TextView) findViewById(R.id.tv_merchant_code);
        transaction_date = (TextView) findViewById(R.id.tv_date);
        sum = (TextView) findViewById(R.id.tv_sum);


        // ---> cautam baza tranzactia dupa codul in baza de date

    }
}
