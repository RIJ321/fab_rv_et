package com.example.rvtest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.rvtest.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        adapter = new Adapter();
        binding.rvTarget.setAdapter(adapter);

        binding.btnFab.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Form.class);
            startActivityForResult(intent, 23);

        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 23 &&resultCode == RESULT_OK){
            adapter.adds(new Model(data.getStringExtra("name"),data.getStringExtra("phone")));
        }

    }
}