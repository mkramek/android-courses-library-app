package com.sampleapp.library.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.sampleapp.library.dao.BookDAO;
import com.sampleapp.library.entity.Book;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Book.class}, version = 1, exportSchema = false)
public abstract class BookDatabase extends RoomDatabase {
    public abstract BookDAO bookDAO();

    private static volatile BookDatabase INSTANCE;
    private static final int THREADS = 4;
    static final ExecutorService databaseWriter = Executors.newFixedThreadPool(THREADS);

    private static RoomDatabase.Callback createBooks = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriter.execute(() -> {
                BookDAO dao = INSTANCE.bookDAO();
                dao.deleteAll();

                Book book = new Book("Harry Potter", "J.K. Rowling", 2004);
                dao.insert(book);
                
                book = new Book("Więzień Labiryntu", "Joseph Delaney", 2015);
                dao.insert(book);

                book = new Book("Hobbit", "J.R.R. Tolkien", 2010);
                dao.insert(book);
            });
        }
    };

    static BookDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BookDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(context.getApplicationContext(), BookDatabase.class, "library_db")
                            .addCallback(createBooks)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
