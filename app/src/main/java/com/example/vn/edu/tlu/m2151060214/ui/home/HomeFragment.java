package com.example.vn.edu.tlu.m2151060214.ui.home;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class HomeFragment extends Fragment {

    private com.example.vn.edu.tlu.m2151060214.ui.home.HomeViewModel homeViewModel;
    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sử dụng ViewModel để quản lý dữ liệu
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Quan sát LiveData từ ViewModel để cập nhật RecyclerView
        homeViewModel.getCategoryList().observe(getViewLifecycleOwner(), categories -> {
            // Set adapter cho RecyclerView
            categoryAdapter = new CategoryAdapter(categories, new CategoryAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(Category category) {
                    // Điều hướng sang fragment khác khi click vào loại món
                    switch (category.getName()) {
                        case "Cafe":
                            // Chuyển đến CoffeeFragment
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, new CoffeeFragment())
                                    .addToBackStack(null)
                                    .commit();
                            break;
                        case "Nước trái cây":
                            // Chuyển đến JuiceFragment
                            getParentFragmentManager().beginTransaction()
                                    .replace(R.id.fragment_container, new JuiceFragment())
                                    .addToBackStack(null)
                                    .commit();
                            break;
                        // Thêm các loại món khác tại đây
                    }
                }
            });
            recyclerView.setAdapter(categoryAdapter);
        });

        return root;
    }
}
