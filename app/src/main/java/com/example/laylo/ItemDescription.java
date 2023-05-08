package com.example.laylo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ItemDescription extends AppCompatActivity {
    DatabaseReference reference;
    ImageView item_image;
    TextView item_name,custombar_text,description,item_price;
    Button btn_buy;
    public static String item_name1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_description);

        item_image=findViewById(R.id.item_image);
        item_name=findViewById(R.id.item_name);
        custombar_text=findViewById(R.id.custombar_text);
        description=findViewById(R.id.description);
        item_price=findViewById(R.id.item_price);
        btn_buy=findViewById(R.id.btn_buy);

        int image = getIntent().getIntExtra("image",0);
        item_image.setImageResource(image);

        reference= FirebaseDatabase.getInstance().getReference("products/men").child("men1");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String name=snapshot.child("name").getValue().toString();
                item_name1=name;
                String desc=snapshot.child("description").getValue().toString();
                String price=snapshot.child("price").getValue().toString();

                item_name.setText(name);
                custombar_text.setText(name);
                description.setText(desc);
                item_price.setText(price);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btn_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(ItemDescription.this)
                        .setMessage("You have selected "+item_name1+" to buy")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                AddressBottomSheet addressBottomSheet=new AddressBottomSheet();
                                addressBottomSheet.show(getSupportFragmentManager(),"AddressBottomSheet");
                                Toast.makeText(ItemDescription.this, "Ok", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Change", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
            }
        });



    }
}