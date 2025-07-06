package com.example.parcelable;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private List<Food> foodList;
    public FoodAdapter(List<Food> foodList) {
        this.foodList = foodList;
    }
    public class FoodViewHolder extends RecyclerView.ViewHolder {
        ImageView foodImageView;
        TextView foodNameTextView;
        public FoodViewHolder(View itemView) {
            super(itemView);
            foodImageView = itemView.findViewById(R.id.foodImageView);
            foodNameTextView = itemView.findViewById(R.id.foodNameTextView);
            itemView.setOnClickListener(v -> {
                int position = getBindingAdapterPosition();
                Food clickedFood = foodList.get(position);
                if (position != RecyclerView.NO_POSITION) {
                    Food food = foodList.get(position);
                    Intent intent = new Intent(itemView.getContext(), DetailActivity.class);
                    intent.putExtra("foodItem", clickedFood);
                    itemView.getContext().startActivity(intent);
                }
            });
        }
    }
    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_food, parent, false);
        return new FoodViewHolder(view);
    }
    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position) {
        Food food = foodList.get(position);
        holder.foodNameTextView.setText(food.getName());
        holder.foodImageView.setImageResource(food.getImage());
    }
    @Override
    public int getItemCount() {
        return foodList.size();
    }
    public void removeItem(int position) {
        foodList.remove(position);
        notifyItemRemoved(position);
    }
}
