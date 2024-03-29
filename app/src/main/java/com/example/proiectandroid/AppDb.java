package com.example.proiectandroid;
import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities ={User.class,Transaction.class,PlataPrieten.class},version = 1,exportSchema = false)
public abstract class AppDb extends RoomDatabase
{
    public abstract  UserDAO userDAO();
    public abstract TransactionDAO transactionDAO();
    public abstract  PlataPrietenDAO plataPrietenDAO();
}
