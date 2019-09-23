package com.example.myhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.myhomework.R;

public class FourthActivity extends AppCompatActivity {

    Button next4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        next4 = (Button)findViewById(R.id.btn_next4);
        next4.setOnClickListener(v -> {
            Intent intent = new Intent(this, FifthActivity.class);
            startActivity(intent);
        });
    }
}
