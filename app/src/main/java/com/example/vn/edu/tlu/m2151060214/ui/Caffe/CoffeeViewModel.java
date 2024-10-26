package com.example.vn.edu.tlu.m2151060214.ui.Caffe;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.vn.edu.tlu.m2151060214.R;

import java.util.ArrayList;
import java.util.List;

public class CoffeeViewModel extends ViewModel {

    private MutableLiveData<List<CoffeeItem>> coffeeList;
    private MutableLiveData<List<CoffeeItem>> filteredList;

    public CoffeeViewModel() {
        coffeeList = new MutableLiveData<>();
        filteredList = new MutableLiveData<>();

        // Khởi tạo dữ liệu danh sách món với icon cho từng loại cà phê
        List<CoffeeItem> initialList = new ArrayList<>();
        initialList.add(new CoffeeItem("AMERICANO", "49.000 đ", R.drawable.ic_americano));
        initialList.add(new CoffeeItem("CAPPUCCINO", "45.000 đ", R.drawable.ic_cappuccino));
        initialList.add(new CoffeeItem("ESPRESSO SỮA ĐÁ", "39.000 đ", R.drawable.ic_espresso));
        initialList.add(new CoffeeItem("MOCHA ĐÁ", "49.000 đ", R.drawable.ic_mocha));
        initialList.add(new CoffeeItem("CAFE ĐEN ĐÁ", "29.000 đ", R.drawable.ic_black_coffee));

        coffeeList.setValue(initialList);
        filteredList.setValue(new ArrayList<>(initialList));
    }

    public LiveData<List<CoffeeItem>> getFilteredList() {
        return filteredList;
    }

    public void filter(String query) {
        List<CoffeeItem> currentList = coffeeList.getValue();
        if (currentList == null) return;

        List<CoffeeItem> newFilteredList = new ArrayList<>();
        if (query.isEmpty()) {
            newFilteredList.addAll(currentList);
        } else {
            query = query.toLowerCase();
            for (CoffeeItem item : currentList) {
                if (item.getName().toLowerCase().contains(query)) {
                    newFilteredList.add(item);
                }
            }
        }
        filteredList.setValue(newFilteredList);
    }
}
