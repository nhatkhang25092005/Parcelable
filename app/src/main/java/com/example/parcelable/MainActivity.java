package com.example.parcelable;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FoodAdapter foodAdapter;
    private List<Food> foodList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        foodList = new ArrayList<>();
        foodList.add(new Food("Phở", R.drawable.pho, "Phở bò truyền thống với nước dùng đậm đà.", 45000));
        foodList.add(new Food("Bún chả", R.drawable.buncha, "Bún chả Hà Nội thơm ngon, thịt nướng vàng ươm.", 40000));
        foodList.add(new Food("Bánh mì", R.drawable.banhmi, "Bánh mì kẹp thịt, rau sống, nước sốt.", 20000));
        foodList.add(new Food("Cơm tấm", R.drawable.comtam, "Cơm tấm sườn bì chả, trứng ốp la.", 50000));
        foodList.add(new Food("Gỏi cuốn", R.drawable.goicuon, "Gỏi cuốn tôm thịt, nước chấm đậm đà.", 30000));
        foodAdapter = new FoodAdapter(foodList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(foodAdapter);
        // Swipe to delete
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new
        ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(RecyclerView recyclerView,
                                    RecyclerView.ViewHolder viewHolder,
                                RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                foodAdapter.removeItem(viewHolder.getBindingAdapterPosition());
            }
        });
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}