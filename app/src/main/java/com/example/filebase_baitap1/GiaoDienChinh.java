package com.example.filebase_baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class GiaoDienChinh extends AppCompatActivity {
    Button btnfinish;
    ImageButton btnxanh,btnvang,btndbo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giao_dien_chinh);
        btnfinish = findViewById(R.id.btnfinish);
        btnxanh = findViewById(R.id.btnimg_xanh);
        btnvang = findViewById(R.id.btnimg_vang);
        btndbo = findViewById(R.id.btnimg_do);

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                troVe();
            }
        });
        btnxanh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GiaoDienChinh.this,"Mau xanh",Toast.LENGTH_SHORT).show();
            }
        });
        btnvang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GiaoDienChinh.this,"Mau vang",Toast.LENGTH_SHORT).show();
            }
        });
        btndbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(GiaoDienChinh.this,"Mau do",Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void troVe(){
        Intent intent = new Intent(GiaoDienChinh.this,MainActivity.class);
        startActivity(intent);
    }
}