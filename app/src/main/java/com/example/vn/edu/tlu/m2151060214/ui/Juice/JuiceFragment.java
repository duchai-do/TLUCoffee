package com.example.vn.edu.tlu.m2151060214.ui.Juice;

puimport android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
public class JuiceFragment extends Fragment {

    private JuiceViewModel juiceViewModel;
    private RecyclerView recyclerView;
    private JuiceAdapter juiceAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_juice, container, false);

        recyclerView = root.findViewById(R.id.recycler_view_juice);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        // Sử dụng ViewModel để quản lý dữ liệu
        juiceViewModel = new ViewModelProvider(this).get(JuiceViewModel.class);

        // Quan sát LiveData từ ViewModel để cập nhật RecyclerView
        juiceViewModel.getJuiceList().observe(getViewLifecycleOwner(), juices -> {
            // Set adapter cho RecyclerView
            juiceAdapter = new JuiceAdapter(juices);
            recyclerView.setAdapter(juiceAdapter);
        });

        return root;
    }
}
