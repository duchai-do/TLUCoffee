package com.example.vn.edu.tlu.m2151060214.ui.Caffe;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.SearchView;

import com.example.vn.edu.tlu.m2151060214.R;

import java.util.ArrayList;

public class CoffeeFragment extends Fragment {

    private CoffeeViewModel coffeeViewModel; // Đổi tên từ homeViewModel thành coffeeViewModel
    private RecyclerView recyclerView;
    private CoffeeAdapter adapter;
    private SearchView searchView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_coffe, container, false); // Sửa layout thành fragment_coffee

        // Sử dụng CoffeeViewModel
        coffeeViewModel = new ViewModelProvider(this).get(CoffeeViewModel.class);

        recyclerView = root.findViewById(R.id.recyclerView);
        searchView = root.findViewById(R.id.searchView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new CoffeeAdapter(new ArrayList<>());
        recyclerView.setAdapter(adapter);

        // Quan sát danh sách đã lọc từ CoffeeViewModel
        coffeeViewModel.getFilteredList().observe(getViewLifecycleOwner(), filteredList -> {
            adapter.updateData(filteredList);
        });

        // Lắng nghe sự thay đổi trong SearchView để lọc danh sách
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                coffeeViewModel.filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                coffeeViewModel.filter(newText);
                return false;
            }
        });

        return root;
    }
}
