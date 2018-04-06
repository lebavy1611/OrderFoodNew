package com.luuva.orderfood;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.luuva.adapter.FoodAdapter;
import com.luuva.model.Food;

import java.util.ArrayList;

@SuppressLint("Registered")
public class ProductActivity extends AppCompatActivity {
    private ListView lvFood;
    private Button btnXem;
    private Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        lvFood = findViewById(R.id.lv_Product);
        final ArrayList<Food> arrFood = new ArrayList<>();

        Food food1 = new Food(1, "Hủ tiếu", 12000, R.drawable.anh1, "Vinh Nam", 1, 1);
        Food food2 = new Food(2, "Hủ tiếu1", 13000, R.drawable.anh2, "Vinh Nam", 1, 1);
        Food food3 = new Food(3, "Hủ tiếu2", 14000, R.drawable.anh3, "Vinh Nam", 1, 1);
        Food food4 = new Food(4, "Hủ tiếu3", 15000, R.drawable.anh4, "Vinh Nam", 1, 1);
        Food food5 = new Food(5, "Hủ tiếu4", 16000, R.drawable.anh5, "Vinh Nam", 1, 1);

        arrFood.add(food1);
        arrFood.add(food2);
        arrFood.add(food3);
        arrFood.add(food4);
        arrFood.add(food5);

        FoodAdapter productAdapter = new FoodAdapter(ProductActivity.this, R.layout.lv_item_food, arrFood);
        lvFood.setAdapter(productAdapter);
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Food food = arrFood.get(i);
                Intent intent = new Intent(ProductActivity.this, FoodDetail.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("food", food);
                intent.putExtra("packageFood", bundle);
                startActivity(intent);
            }
        });
    }
}


