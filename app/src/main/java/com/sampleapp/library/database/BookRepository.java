package com.sampleapp.library.database;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.sampleapp.library.dao.BookDAO;
import com.sampleapp.library.entity.Book;

import java.util.List;

public class BookRepository {
    private BookDAO bookDAO;
    private LiveData<List<Book>> books;

    public BookRepository(Application application) {
        BookDatabase database = BookDatabase.getDatabase(application);
        bookDAO = database.bookDAO();
    }

    public LiveData<List<Book>> getBooks() {
        return bookDAO.getAll();
    }

    public void addBook(Book book) {
        BookDatabase.databaseWriter.execute(() -> bookDAO.insert(book));
    }

    public void deleteAll() {
        BookDatabase.databaseWriter.execute(() -> bookDAO.deleteAll());
    }
}
