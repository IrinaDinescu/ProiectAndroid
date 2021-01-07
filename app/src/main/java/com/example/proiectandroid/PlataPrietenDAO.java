package com.example.proiectandroid;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PlataPrietenDAO {
    @Insert(onConflict= OnConflictStrategy.REPLACE)
    void insertPlata(PlataPrieten plataPrieten);

    @Query("SELECT * FROM PlataPrieten")
    List<PlataPrieten> platiPrieten();

    @Query("SELECT suma FROM PlataPrieten WHERE cod=:Cod")
    double getSuma(int  Cod);
}

