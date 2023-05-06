package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDescription extends AppCompatActivity {
    ImageView item_image;
    TextView item_name,custombar_text;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        item_image=findViewById(R.id.item_image);
        item_name=findViewById(R.id.item_name);
        custombar_text=findViewById(R.id.custombar_text);

        String text = getIntent().getStringExtra("text");
        int image = getIntent().getIntExtra("image",0);

        item_name.setText(text);
        item_image.setImageResource(image);
        custombar_text.setText(text);

    }
}