package com.sampleapp.library.view;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.sampleapp.library.database.BookRepository;
import com.sampleapp.library.entity.Book;

import java.util.List;

public class BookViewModel extends AndroidViewModel {

    private BookRepository repository;

    private final LiveData<List<Book>> books;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new BookRepository(application);
        books = repository.getBooks();
    }

    public LiveData<List<Book>> getBooks() {
        return repository.getBooks();
    }

    public void addBook(Book book) {
        repository.addBook(book);
    }
}
