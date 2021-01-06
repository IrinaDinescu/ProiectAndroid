package com.example.proiectandroid;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName="Transactions")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    private int code;
    @ColumnInfo(name="type")
    private String type;

    private String trader;
    private String merchant_code;
    private String transaction_date;
    private double sum;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getMerchant_code() {
        return merchant_code;
    }

    public void setMerchant_code(String merchant_code) {
        this.merchant_code = merchant_code;
    }

    public String getTransaction_date() {
        return transaction_date;
    }

    public void setTransaction_date(String transaction_date) {
        this.transaction_date = transaction_date;
    }

    public int getCode() {
        return code;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Transaction(String type, String trader, String merchant_code,
                       String transaction_date, double sum, int code) {
        this.type = type;
        this.trader = trader;
        this.merchant_code = merchant_code;
        this.transaction_date = transaction_date;
        this.sum = sum;
        this.code = code;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", trader='" + trader + '\'' +
                ", merchant_code='" + merchant_code + '\'' +
                ", transaction_date='" + transaction_date + '\'' +
                ", sum=" + sum +
                '}';
    }
}

