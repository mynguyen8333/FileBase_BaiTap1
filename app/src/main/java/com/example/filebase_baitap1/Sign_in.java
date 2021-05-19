package com.example.filebase_baitap1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Sign_in extends AppCompatActivity {
    TextView tv_openRegister;
    EditText username,password;
    Button btnSignin;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        tv_openRegister = findViewById(R.id.txt_openRegister);
        username = findViewById(R.id.editname_signin);
        password = findViewById(R.id.editpass_singin);
        btnSignin = findViewById(R.id.btnSignin_signin);
        firebaseAuth = FirebaseAuth.getInstance();


        tv_openRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoDangNhap();
            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isUser();
//                String tex_email = username.getText().toString();
//                String tex_pass = password.getText().toString();
//                if(TextUtils.isEmpty(tex_email)||TextUtils.isEmpty(tex_pass)){
//                    Toast.makeText(Sign_in.this,"Chua nhap du du lieu",Toast.LENGTH_SHORT).show();
//                }else{
//                    login(tex_email,tex_pass);
//                }
            }
        });

    }

    private void login(String tex_email, String tex_pass) {
        firebaseAuth.signInWithEmailAndPassword(tex_email,tex_pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent intent = new Intent(Sign_in.this,GiaoDienChinh.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(Sign_in.this,task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void MoDangNhap()
    {
        Intent intent = new Intent(Sign_in.this,Regiter.class);
        startActivity(intent);
    }

    private void MoGiaoDienChinh()
    {
        Intent intent = new Intent(Sign_in.this,GiaoDienChinh.class);
        startActivity(intent);
    }

//    public void loginUser(View view){
//        isUser();
//    }

    private void isUser() {
        String userEnteredUserName = username.getText().toString().trim();
        String userEnteredPassWord = password.getText().toString().trim();


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("users");

        Query checkUser = reference.orderByChild("name").equalTo(userEnteredUserName);

        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String passwordFromDB = snapshot.child(userEnteredUserName).child("password1").getValue(String.class);
                    System.out.println(passwordFromDB);
                    if(passwordFromDB.equalsIgnoreCase(userEnteredPassWord)){
                        MoGiaoDienChinh();
                    }else{
                        Toast.makeText(Sign_in.this,"Sai mat khau",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Sign_in.this,"Sai ten tai khoan",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}