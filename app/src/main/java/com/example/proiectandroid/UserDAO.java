package com.example.proiectandroid;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
     void insertUser(User user);

    @Query("SELECT * FROM Users")
     List<User> getall();

    @Query("SELECT * FROM Users WHERE email=:Email")
     User getuser(String  Email);

}
