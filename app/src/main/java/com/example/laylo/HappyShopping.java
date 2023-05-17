package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class HappyShopping extends AppCompatActivity {
    TextView msg;
    ImageView cancel;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_happy_shopping);

        msg=findViewById(R.id.msg);
        String firstName = getIntent().getStringExtra("first_name");
        String lastName = getIntent().getStringExtra("last_name");
        String address = getIntent().getStringExtra("address");
        String city = getIntent().getStringExtra("city");
        String zipCode = getIntent().getStringExtra("zip_code");
        String country = getIntent().getStringExtra("country");

        msg.setText("Thank you "+firstName+" "+lastName+" "+" for shopping with us. Your order will be delivered to "+address+", "+city+", "+zipCode+", "+country+".");

        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(v -> {
            Intent intent = new Intent(HappyShopping.this, MainActivity.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(HappyShopping.this, MainActivity.class);
        startActivity(intent);
    }
}