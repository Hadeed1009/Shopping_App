package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

public class HappyShopping extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_shopping);

//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
//
//        Thread thread = new Thread(){
//            public void run(){
//                try {
//                    sleep(3000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                finally {
////                    Intent intent = new Intent(HappyShopping.this, CartFragment.class);
////                    startActivity(intent);
//                    CartFragment cartFragment = new CartFragment();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragmentLayout,cartFragment);
//                    transaction.commit();
////                    finish();
//                }
//            }
//        };thread.start();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(HappyShopping.this, MainActivity.class);
        startActivity(intent);
    }
}