package com.example.filebase_baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnSignIn,btnRegestry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSingin);
        btnRegestry = findViewById(R.id.btnRegister);

        btnRegestry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangKy();
            }
        });

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangNhap();
            }
        });

    }
    private void MoDangKy()
    {
        Intent intent = new Intent(MainActivity.this,Regiter.class);
        startActivity(intent);
    }
    private void MoDangNhap()
    {
        Intent intent = new Intent(MainActivity.this,Sign_in.class);
        startActivity(intent);
    }
}