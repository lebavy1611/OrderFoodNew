package com.luuva.orderfood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import com.luuva.adapter.CartAdapter;
import com.luuva.model.Food;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    private ListView lvProductCart;
    private Button btnAddCart, btnSubCart;
    private Spinner spinner;
    private int pos = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        lvProductCart = (ListView) findViewById(R.id.lv_ProductCart);
        ArrayList<Food> arrFood = new ArrayList<>();

        Food food1 = new Food(1,"Hủ tiếu",12000,R.drawable.anh1,"Vinh Nam",1,1);
        Food food2 = new Food(1,"Hủ tiếu",12000,R.drawable.anh1,"Vinh Nam",1,1);
        Food food3 = new Food(1,"Hủ tiếu",12000,R.drawable.anh1,"Vinh Nam",1,1);
        Food food4 = new Food(1,"Hủ tiếu",12000,R.drawable.anh1,"Vinh Nam",1,1);
        Food food5 = new Food(1,"Hủ tiếu",12000,R.drawable.anh1,"Vinh Nam",1,1);

        arrFood.add(food1);
        arrFood.add(food2);
        arrFood.add(food3);
        arrFood.add(food4);
        arrFood.add(food5);

        CartAdapter cartAdapter = new CartAdapter(CartActivity.this, R.layout.lv_food_cart, arrFood);
        lvProductCart.setAdapter(cartAdapter);
    }
}
