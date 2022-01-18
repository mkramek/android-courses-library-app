package com.sampleapp.library.view;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.sampleapp.library.entity.Book;

public class BookListAdapter extends ListAdapter<Book, BookViewHolder> {

    public BookListAdapter(@NonNull DiffUtil.ItemCallback<Book> diffCallback) {
        super(diffCallback);
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return BookViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(BookViewHolder holder, int position) {
        Book currentBook = getItem(position);
        holder.bind(currentBook);
    }

    public static class BookDiff extends DiffUtil.ItemCallback<Book> {

        @Override
        public boolean areItemsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Book oldItem, @NonNull Book newItem) {
            return
                    oldItem.getTytul().equals(newItem.getTytul())
                    && oldItem.getAutor().equals(newItem.getAutor())
                    && oldItem.getRokWydania() == newItem.getRokWydania();
        }
    }
}
