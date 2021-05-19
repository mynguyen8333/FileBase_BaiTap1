package com.example.filebase_baitap1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Regiter extends AppCompatActivity {
    TextView tv_opensingin;
    EditText edit_name,edit_email,edit_password,edit_password_1;
    Button btnregister;

    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regiter);
        edit_name = findViewById(R.id.edit_name);
        edit_email = findViewById(R.id.edit_email);

        edit_password = findViewById(R.id.editpassword);
        edit_password_1 = findViewById(R.id.edit_password1);

        btnregister = findViewById(R.id.btn_acty_register);

        tv_opensingin = findViewById(R.id.txt_opensignin);
        tv_opensingin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangKy();
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rootNode = FirebaseDatabase.getInstance();
                //reference = rootNode.getReference();
                reference = rootNode.getReference("users");
                String name = edit_name.getText().toString();
                String email = edit_email.getText().toString();
                String password = edit_password.getText().toString();
                String password1 = edit_password_1.getText().toString();
                //int i = ramdomNumber();

                UserHelperClass helperClass = new UserHelperClass(name,email,password,password1);
                reference.child(name).setValue(helperClass);
                Toast.makeText(Regiter.this,"Dang ki thanh cong",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void MoDangKy()
    {
        Intent intent = new Intent(Regiter.this,Sign_in.class);
        startActivity(intent);
    }
    private int ramdomNumber()
    {
        int i = (int) Math.random();
        return i;
    }
}