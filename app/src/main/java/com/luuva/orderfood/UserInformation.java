package com.luuva.orderfood;


import android.content.Intent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import android.widget.TextView;

/**
 * Created by NhuongPH on 3/24/2018.
 */

public class UserInformation extends AppCompatActivity {
    TextView ttB;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_information);
        ttB = findViewById(R.id.tvBack);
        ttB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}

