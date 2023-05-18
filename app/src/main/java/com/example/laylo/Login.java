package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextView login_email,login_password;
    Button btn_login,login_signUp;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Initialize Firebase Auth
        mAuth=FirebaseAuth.getInstance();

        // Initialize email and password text views
        login_email=findViewById(R.id.login_email);
        login_password=findViewById(R.id.login_password);

        // Initialize login and sign up buttons
        btn_login=findViewById(R.id.btn_login);
        login_signUp=findViewById(R.id.login_signUp);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }
        });

        login_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Login.this,Register.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!= null){
            startActivity(new Intent(Login.this,MainActivity.class));
        }
    }

    private void loginUser(){
        String email=login_email.getText().toString();
        String password=login_password.getText().toString();

        if (email.isEmpty()){
            login_email.setError("Email is Required");
            login_email.requestFocus();
        } else if (password.isEmpty()){
            login_password.setError("Password is Required");
            login_password.requestFocus();
        } else {
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(task -> {
                if(task.isSuccessful()){
                    Toast.makeText(Login.this, "Logged In", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Login.this,MainActivity.class));
                } else {
                    Toast.makeText(Login.this, "Error: "+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    login_password.setText("");
                    login_email.setText("");
                }
            });
        }
    }
}