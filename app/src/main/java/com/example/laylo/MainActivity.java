package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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
            @Override
            public void onClick(View view) {
                HomeFragment homeFragment=new HomeFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, homeFragment);
                transaction.commit();
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CategoriesFragment categoriesFragment=new CategoriesFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, categoriesFragment);
                transaction.commit();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProfileFragment profileFragment=new ProfileFragment();
                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentLayout, profileFragment);
                transaction.commit();
            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
        HomeFragment homeFragment=new HomeFragment();
        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragmentLayout, homeFragment);
        transaction.commit();
    }
}