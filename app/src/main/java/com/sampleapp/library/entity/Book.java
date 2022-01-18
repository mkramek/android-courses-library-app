package com.sampleapp.library.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.sampleapp.library.dao.BookDAO;

import java.util.List;

@Entity(tableName = "ksiazki")
public class Book {
    @PrimaryKey(autoGenerate = true)
    private Long id;
    @ColumnInfo(name = "tytul")
    private String tytul;
    @ColumnInfo(name = "autor")
    private String autor = "Autor nieznany";
    @ColumnInfo(name = "rok_wydania")
    private int rokWydania;
    @ColumnInfo(name = "wydawnictwo")
    private String wydawnictwo;

    public Book(@NonNull String tytul, int rokWydania, String wydawnictwo) {
        this.tytul = tytul;
        this.rokWydania = rokWydania;
        this.wydawnictwo = wydawnictwo;
    }

    public Book(@NonNull String tytul, @NonNull String autor, int rokWydania) {
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
    }

    public Book() {
    }

    public Long getId() {
        return id;
    }

    public String getTytul() {
        return tytul;
    }

    public void setTytul(String tytul) {
        this.tytul = tytul;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getRokWydania() {
        return rokWydania;
    }

    public void setRokWydania(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    public String getWydawnictwo() {
        return wydawnictwo;
    }

    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

