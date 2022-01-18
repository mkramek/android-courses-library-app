package com.sampleapp.library.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.sampleapp.library.R;
import com.sampleapp.library.entity.Book;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private final TextView bookTitle;
    private final TextView bookAuthor;
    private final TextView bookYear;

    private BookViewHolder(View itemView) {
        super(itemView);
        bookTitle = itemView.findViewById(R.id.title_text);
        bookAuthor = itemView.findViewById(R.id.author_text);
        bookYear = itemView.findViewById(R.id.year_text);
    }

    public void bind(Book book) {
        bookTitle.setText(book.getTytul());
        bookAuthor.setText(book.getAutor());
        bookYear.setText(String.valueOf(book.getRokWydania()));
    }

    static BookViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item, parent, false);
        return new BookViewHolder(view);
    }
}
