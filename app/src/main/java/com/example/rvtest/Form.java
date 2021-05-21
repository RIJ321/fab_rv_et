package com.example.rvtest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.rvtest.databinding.ActivityFormBinding;
import com.example.rvtest.databinding.ActivityMainBinding;

public class Form extends AppCompatActivity {


    ActivityFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        inits();

    }

    private void inits() {
        binding.btnSave.setOnClickListener(v -> {
            String name = binding.etName.getText().toString().trim();
            String phoneNum = binding.etPhoneNum.getText().toString().trim();

            if (name.isEmpty() && phoneNum.isEmpty()) {
                binding.etName.setError("Ввведите имя");
                binding.etPhoneNum.setError("Ввведите номер");
            }else{
                Intent intent = new Intent(Form.this,MainActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("phone",phoneNum);
                setResult(RESULT_OK,intent);
                finish();
            }
        });


    }
}