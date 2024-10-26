package com.example.vn.edu.tlu.m2151060214.ui.Juice;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class JuiceViewModel extends ViewModel {

    private MutableLiveData<List<Juice>> juiceList;

    public JuiceViewModel() {
        juiceList = new MutableLiveData<>();
        loadJuices();
    }

    public LiveData<List<Juice>> getJuiceList() {
        return juiceList;
    }

    private void loadJuices() {
        // Giả lập dữ liệu danh sách các loại nước trái cây
        List<Juice> juices = new ArrayList<>();
        juices.add(new Juice("Nước Cam", 30000, R.drawable.ic_orange_juice));
        juices.add(new Juice("Nước Táo", 35000, R.drawable.ic_apple_juice));
        juices.add(new Juice("Sinh Tố Dâu", 40000, R.drawable.ic_strawberry_smoothie));
        // Thêm các loại nước trái cây khác
        juiceList.setValue(juices);
    }
}
