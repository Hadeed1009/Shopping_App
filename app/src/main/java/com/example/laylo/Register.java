package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Register extends AppCompatActivity {
    FirebaseAuth mAuth;
    FirebaseDatabase database;
    DatabaseReference myRef;
    Button signup;
    TextView reg_name,reg_email,reg_password,reg_confirmPassword,reg_login,reg_address;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        reg_name=findViewById(R.id.reg_name);
        reg_email=findViewById(R.id.reg_email);
        reg_password=findViewById(R.id.reg_password);
        reg_confirmPassword=findViewById(R.id.reg_confirmPassword);
        signup=findViewById(R.id.btn_signUp);
        reg_login=findViewById(R.id.reg_login);
        reg_address=findViewById(R.id.reg_address);

        mAuth=FirebaseAuth.getInstance();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });

        reg_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Register.this,Login.class));
            }
        });
    }
    public void createUser(){
        String name=reg_name.getText().toString();
        String mail=reg_email.getText().toString();
        String pass=reg_password.getText().toString();
        String confirmpass=reg_confirmPassword.getText().toString();
        String address=reg_address.getText().toString();
        if(TextUtils.isEmpty(name)) {
            reg_name.setError("Name is Required");
            reg_name.requestFocus();
        } else if(TextUtils.isEmpty(mail)){
            reg_email.setError("Email is Required");
            reg_email.requestFocus();
        } else if (TextUtils.isEmpty(pass)){
            reg_password.setError("Password is Required");
            reg_password.requestFocus();
        } else if (pass.length()<6){
            reg_password.setError("Password must be greater than 6 characters");
            reg_password.requestFocus();
        } else if (TextUtils.isEmpty(confirmpass)){
            reg_confirmPassword.setError("Password is Required");
            reg_confirmPassword.requestFocus();
        } else {
            mAuth.createUserWithEmailAndPassword(mail,pass).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Register.this, "User Created", Toast.LENGTH_SHORT).show();
                    database=FirebaseDatabase.getInstance();
                    myRef=database.getReference("customer");
                    myRef.child(mAuth.getCurrentUser().getUid()).child("name").setValue(name);
                    myRef.child(mAuth.getCurrentUser().getUid()).child("address").setValue(address);

                    Intent intent=new Intent(Register.this,MainActivity.class);
                    startActivity(intent);
                    finish();

                } else {
                    Toast.makeText(Register.this, "Error!"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}