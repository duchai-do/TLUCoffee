package com.example.vn.edu.tlu.m2151060214.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<Category>> categoryList;

    public HomeViewModel() {
        categoryList = new MutableLiveData<>();
        loadCategories();
    }

    public LiveData<List<Category>> getCategoryList() {
        return categoryList;
    }

    private void loadCategories() {
        // Đây là danh sách loại món giả lập
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("Cafe", R.drawable.ic_cafe)); // Tên và ảnh loại món
        categories.add(new Category("Nước trái cây", R.drawable.ic_juice));
        categories.add(new Category("Trà đặc biệt", R.drawable.ic_tea));
        // Thêm các loại món khác
        categoryList.setValue(categories);
    }
}
