package com.example.filebase_baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Regiter extends AppCompatActivity {
    TextView tv_opensingin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);

        tv_opensingin = findViewById(R.id.txt_opensignin);
        tv_opensingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangKy();
            }
        });
    }
    private void MoDangKy()
    {
        Intent intent = new Intent(Regiter.this,Sign_in.class);
        startActivity(intent);
    }
}