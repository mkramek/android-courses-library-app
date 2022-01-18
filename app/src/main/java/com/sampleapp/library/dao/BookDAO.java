package com.sampleapp.library.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.sampleapp.library.entity.Book;

import java.util.List;

@Dao
public interface BookDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Book book);

    @Query("DELETE FROM ksiazki")
    void deleteAll();

    @Query("SELECT * FROM ksiazki ORDER BY tytul ASC")
    LiveData<List<Book>> getAll();
}
