package com.luuva.orderfood;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TabHost;

import com.luuva.adapter.CategoryAdapter;
import com.luuva.adapter.FoodAdapter;
import com.luuva.model.Category;
import com.luuva.model.Food;

import java.util.ArrayList;

/**
 * Created by luuva on 3/9/2018.
 */

public class HomeFragment extends Fragment {

    GridView gvCategory;
    ArrayList<Category> categories;
    CategoryAdapter adapter;

    ListView lvFood,lvNearMe;
    ArrayList<Food> foods,foodsNearMe;
    FoodAdapter foodAdapter,nearMeAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);
        gvCategory = view.findViewById(R.id.gvCategory);

        categories = new ArrayList<>();
        categories.add(new Category(1,"Cơm",R.drawable.rice));
        categories.add(new Category(2,"Đồ ăn",R.drawable.food));
        categories.add(new Category(3,"Thức uống",R.drawable.drinks));
        categories.add(new Category(4,"Tráng miệng",R.drawable.fruit));
        categories.add(new Category(5,"Nhà làm",R.drawable.homefood));
        categories.add(new Category(6,"Đồ ăn nhẹ",R.drawable.snacks));

        adapter = new CategoryAdapter(getActivity(),R.layout.gv_item,categories);
        gvCategory.setAdapter(adapter);

        //tab1
        lvFood = view.findViewById(R.id.lvPro);
        foods = new ArrayList<>();

        foods.add(new Food("Cơm gà",20000,"Hòa Khánh"));
        foods.add(new Food("Mỳ Quảng",15000,"Hòa Khánh"));
        foods.add(new Food("Bún Bò",8000,"Hòa Khánh"));
        foods.add(new Food("Bánh Mỳ",10000,"Hòa Khánh"));
        foods.add(new Food("Snack",7000,"Hòa Khánh"));
        foodAdapter = new FoodAdapter(getActivity(),R.layout.lv_item_food,foods);
        lvFood.setAdapter(foodAdapter);

        //tab2
        lvNearMe = view.findViewById(R.id.lvNearMe);
        foodsNearMe = new ArrayList<>();
        foodsNearMe.add(new Food("Bánh xèo",30000,"Cẩm Lệ"));
        foodsNearMe.add(new Food("Bánh đập",20000,"Hòa Vang"));
        foodsNearMe.add(new Food("Cơm sườn",15000,"Hòa Vang"));
        foodsNearMe.add(new Food("Rau câu",13000,"Cẩm Lệ"));
        foodsNearMe.add(new Food("Nước dừa",90000,"Cẩm Lệ"));
        foodsNearMe.add(new Food("Xôi đậu",10000,"Cẩm Lệ"));

        nearMeAdapter = new FoodAdapter(getActivity(),R.layout.lv_item_food,foodsNearMe);
        lvNearMe.setAdapter(nearMeAdapter);

        TabHost tabHost = view.findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tab1 = tabHost.newTabSpec("t1");
        tab1.setIndicator("Đặt nhiều");
        tab1.setContent(R.id.tab1);
        tabHost.addTab(tab1);

        TabHost.TabSpec tab2 = tabHost.newTabSpec("t2");
        tab2.setIndicator("Gần tôi");
        tab2.setContent(R.id.tab2);
        tabHost.addTab(tab2);
        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Food food = foods.get(i);
                Intent intent = new Intent(getActivity(),ProductActivity.class);
/*
                Bundle bundle = new Bundle();
                bundle.putSerializable("food",food);*/
                startActivity(intent);
            }
        });
        gvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
        return view;
    }




}
