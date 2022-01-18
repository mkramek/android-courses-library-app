package com.sampleapp.library;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sampleapp.library.databinding.FragmentFirstBinding;
import com.sampleapp.library.view.BookListAdapter;
import com.sampleapp.library.view.BookViewModel;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        BookListAdapter adapter = new BookListAdapter(new BookListAdapter.BookDiff());
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        binding.bookDisplayView.setAdapter(adapter);
        binding.bookDisplayView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        bookViewModel.getBooks().observe((LifecycleOwner) this.getContext(), adapter::submitList);

        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}