package com.example.proiectandroid.classes;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.proiectandroid.MainActivity;
import com.example.proiectandroid.R;
import com.example.proiectandroid.TransactionInfoActivity;
import com.example.proiectandroid.TransactionsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import static androidx.core.app.ActivityCompat.startActivityForResult;

public class TransactionAdapter extends BaseAdapter {

    public static int ADD_REQUEST_CODE = 99;

    private ArrayList<Transaction> transactions;
    private Context context;
    private LayoutInflater inflater;

    public TransactionAdapter(Context context, ArrayList<Transaction> transactions) {
        this.transactions = transactions;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return transactions.size();
    }

    @Override
    public Transaction getItem(int position) {
        return transactions.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        View item = inflater.inflate(R.layout.item_tranzactie, viewGroup, false);
        TextView tvTrader = item.findViewById(R.id.tv_transaction_trader);
        TextView tvSum = item.findViewById(R.id.tv_transaction_sum);
        TextView tvDate = item.findViewById(R.id.tv_transaction_date);

        final Transaction transaction = transactions.get(position);
        tvTrader.setText(transaction.getTrader());
        Double sum = transaction.getSum();
        String Sum = sum.toString();
        tvSum.setText(Sum);
        tvDate.setText(transaction.getTransaction_date());

        //info Button
        FloatingActionButton infoButton = item.findViewById(R.id.floatingActionButton);
        infoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                Toast.makeText(context, "infoButton", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, TransactionInfoActivity.class );
                intent.putExtra("code", transaction.getCode());
                context.startActivity(intent);




                // ------> aici sa pun actiunea care deschide TransactionInfoActivity
                // ------> trebuie sa transfer obiectul curent transaction catre TransactionInfoActivity
                // ------> transfer codul tranzactiei si apoi citim din baza de date detaliile tranzactiei corespunzatoare
            }
        });


        return item;
    }
}

