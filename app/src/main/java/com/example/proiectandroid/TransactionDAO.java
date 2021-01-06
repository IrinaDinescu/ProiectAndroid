package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TransactionDAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertTransaction(Transaction transaction);

    @Query("SELECT * FROM Transactions")
    List<Transaction> getallTransactions();


}
