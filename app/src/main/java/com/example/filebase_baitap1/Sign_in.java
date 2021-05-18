package com.example.filebase_baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Sign_in extends AppCompatActivity {
    TextView tv_openRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        tv_openRegister = findViewById(R.id.txt_openRegister);
        tv_openRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangNhap();
            }
        });

    }
    private void MoDangNhap()
    {
        Intent intent = new Intent(Sign_in.this,Regiter.class);
        startActivity(intent);
    }
}