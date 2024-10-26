package com.example.vn.edu.tlu.m2151060214.ui.Juice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class JuiceAdapter extends RecyclerView.Adapter<JuiceAdapter.JuiceViewHolder> {

    private List<Juice> juiceList;

    public JuiceAdapter(List<Juice> juiceList) {
        this.juiceList = juiceList;
    }

    @NonNull
    @Override
    public JuiceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_juice, parent, false);
        return new JuiceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JuiceViewHolder holder, int position) {
        Juice juice = juiceList.get(position);
        holder.nameTextView.setText(juice.getName());
        holder.priceTextView.setText(juice.getPrice() + " đ");
        holder.imageView.setImageResource(juice.getImageResId());
    }

    @Override
    public int getItemCount() {
        return juiceList.size();
    }

    public static class JuiceViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView priceTextView;
        private ImageView imageView;

        public JuiceViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.juice_name);
            priceTextView = itemView.findViewById(R.id.juice_price);
            imageView = itemView.findViewById(R.id.juice_image);
        }
    }
}
