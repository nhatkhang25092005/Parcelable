package com.example.parcelable;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetailActivity extends AppCompatActivity {
    ImageView img_detail;
    TextView txt_detail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        img_detail = findViewById(R.id.img_detail);
        txt_detail = findViewById(R.id.txt_detail);



        Food food = getIntent().getParcelableExtra("foodItem");

        if (food != null) {
            img_detail.setImageResource(food.getImage());
            String detailText = "Ten mon an:"+food.getName()+
                    "\nMo ta:"+food.getDesciption()+
                    "\nGia:"+food.getPrice()+"VND";
            txt_detail.setText(detailText);
            SharedPreferences prefs  = getSharedPreferences("LastViewedFood", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("lastViewedFood",food.getName());
            editor.apply();
        }

    }
}