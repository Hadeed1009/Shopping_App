package com.example.laylo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    ImageView home1,category,search1,profile,cart,more;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        home1=findViewById(R.id.home1);
        category=findViewById(R.id.category);
        profile=findViewById(R.id.profile);
        cart= findViewById(R.id.cart);
        more = findViewById(R.id.more);
        home1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("UseCompatLoadingForColorStateLists")
            @Override
            public void onClick(View view) {
                home1.setImageTintList(getResources().getColorStateList(R.color.orange));
                category.setImageTintList(getResources().getColorStateList(R.color.gray));
                profile.setImageTintList(getResources().getColorStateList(R.color.gray));
                cart.setImageTintList(getResources().getColorStateList(R.color.gray));
                more.setImageTintList(getResources().getColorStateList(R.color.gray));
                HomeFragment homeFragment=new HomeFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, homeFragment);
                transaction.commit();
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                category.setImageTintList(getResources().getColorStateList(R.color.orange));
                home1.setImageTintList(getResources().getColorStateList(R.color.gray));
                profile.setImageTintList(getResources().getColorStateList(R.color.gray));
                cart.setImageTintList(getResources().getColorStateList(R.color.gray));
                more.setImageTintList(getResources().getColorStateList(R.color.gray));
                CategoriesFragment categoriesFragment=new CategoriesFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, categoriesFragment);
                transaction.commit();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profile.setImageTintList(getResources().getColorStateList(R.color.orange));
                category.setImageTintList(getResources().getColorStateList(R.color.gray));
                home1.setImageTintList(getResources().getColorStateList(R.color.gray));
                cart.setImageTintList(getResources().getColorStateList(R.color.gray));
                more.setImageTintList(getResources().getColorStateList(R.color.gray));
                ProfileFragment profileFragment=new ProfileFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, profileFragment);
                transaction.commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cart.setImageTintList(getResources().getColorStateList(R.color.orange));
                category.setImageTintList(getResources().getColorStateList(R.color.gray));
                profile.setImageTintList(getResources().getColorStateList(R.color.gray));
                home1.setImageTintList(getResources().getColorStateList(R.color.gray));
                more.setImageTintList(getResources().getColorStateList(R.color.gray));
                CartFragment cartFragment=new CartFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, cartFragment);
                transaction.commit();
            }
        });

        //Currently adding onclick for initial cart fragment view in this button
        more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                more.setImageTintList(getResources().getColorStateList(R.color.orange));
                category.setImageTintList(getResources().getColorStateList(R.color.gray));
                profile.setImageTintList(getResources().getColorStateList(R.color.gray));
                cart.setImageTintList(getResources().getColorStateList(R.color.gray));
                home1.setImageTintList(getResources().getColorStateList(R.color.gray));
//                InitialCartFragment initialCartFragment = new InitialCartFragment();
//                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragmentLayout,initialCartFragment);
//                transaction.commit();
            }
        });
    }
    @Override
    protected void onStart() {
        super.onStart();
        home1.setImageTintList(getResources().getColorStateList(R.color.orange));
        category.setImageTintList(getResources().getColorStateList(R.color.gray));
        profile.setImageTintList(getResources().getColorStateList(R.color.gray));
        cart.setImageTintList(getResources().getColorStateList(R.color.gray));
        more.setImageTintList(getResources().getColorStateList(R.color.gray));
        HomeFragment homeFragment=new HomeFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentLayout, homeFragment);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
    }
}