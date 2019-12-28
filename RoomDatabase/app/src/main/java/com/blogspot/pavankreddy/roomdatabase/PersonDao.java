package com.blogspot.pavankreddy.roomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface PersonDao
{
    @Insert
    void insert(Person person);

    @Query("select * from person")
    List<Person> getAll();

    @Delete
    void delete(Person person);
}
