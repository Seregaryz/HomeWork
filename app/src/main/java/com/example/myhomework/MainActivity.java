package com.example.myhomework;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myhomework.R;

public class MainActivity extends AppCompatActivity {

    Button next1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        next1 = (Button)findViewById(R.id.btn_next1);
        next1.setOnClickListener(v -> {
            Intent intent = new Intent(this, com.example.myhomework.SecondActivity.class);
            startActivity(intent);
        });
    }

    public void onButtonClick(View v){

    }
}
