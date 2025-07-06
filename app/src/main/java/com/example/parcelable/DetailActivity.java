package com.example.parcelable;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
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
    Button btn_call,btn_map,btn_web;
    @SuppressLint("QueryPermissionsNeeded")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detail);
        img_detail = findViewById(R.id.img_detail);
        txt_detail = findViewById(R.id.txt_detail);
        btn_call = findViewById(R.id.btn_call);
        btn_map = findViewById(R.id.btn_map);
        btn_web = findViewById(R.id.btn_web);



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

        //Call Feature =)
        btn_call.setOnClickListener(v -> {
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:0123456789"));
            startActivity(callIntent);
        });


        //See map feature (~.~)
        btn_map.setOnClickListener(v -> {
            String geoUri = "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California";
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(geoUri));
            mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
        });

        btn_web.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW);
            webIntent.setData(Uri.parse("https://www.google.com"));
            startActivity(webIntent);
        });
        }

}