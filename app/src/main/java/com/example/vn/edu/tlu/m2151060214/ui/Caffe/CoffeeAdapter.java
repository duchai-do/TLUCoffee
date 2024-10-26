package com.example.vn.edu.tlu.m2151060214.ui.Caffe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.vn.edu.tlu.m2151060214.R;

import java.util.List;

public class CoffeeAdapter extends RecyclerView.Adapter<CoffeeAdapter.CoffeeViewHolder> {

    private List<CoffeeItem> coffeeList;

    public CoffeeAdapter(List<CoffeeItem> coffeeList) {
        this.coffeeList = coffeeList;
    }

    @NonNull
    @Override
    public CoffeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_coffee, parent, false);
        return new CoffeeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CoffeeViewHolder holder, int position) {
        CoffeeItem coffeeItem = coffeeList.get(position);
        holder.nameTextView.setText(coffeeItem.getName());
        holder.priceTextView.setText(coffeeItem.getPrice());

        // Gán icon cho mỗi món
        holder.iconImageView.setImageResource(coffeeItem.getIconResId());

        holder.orderButton.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Đã đặt: " + coffeeItem.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return coffeeList != null ? coffeeList.size() : 0;
    }

    public static class CoffeeViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView, priceTextView;
        ImageView iconImageView; // ImageView cho icon của món
        Button orderButton;

        public CoffeeViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.coffeeName);
            priceTextView = itemView.findViewById(R.id.coffeePrice);
            iconImageView = itemView.findViewById(R.id.coffeeIcon); // Ánh xạ icon
            orderButton = itemView.findViewById(R.id.orderButton);
        }
    }

    public void updateData(List<CoffeeItem> newCoffeeList) {
        coffeeList = newCoffeeList;
        notifyDataSetChanged();
    }
}
