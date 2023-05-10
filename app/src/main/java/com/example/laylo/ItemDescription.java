package com.example.laylo;

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

import com.google.firebase.database.DatabaseReference;

public class ItemDescription extends AppCompatActivity {
    DatabaseReference reference;
    ImageView item_image;
    TextView item_name,custombar_text,item_description1,item_price,item_size;
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
        item_description1=findViewById(R.id.item_description1);
        item_price=findViewById(R.id.item_price);
        item_size=findViewById(R.id.item_size);
        btn_buy=findViewById(R.id.btn_buy);

        int image = getIntent().getIntExtra("image",0);
        item_image.setImageResource(image);

        String name = getIntent().getStringExtra("name");
        item_description1.setText(name);
        item_name1=name;
        custombar_text.setText(name);
        //
        String description = getIntent().getStringExtra("description");
        item_description1.setText(description);

        String size = getIntent().getStringExtra("size");
        item_size.setText(size);

//        int size = getIntent().getIntExtra("size",0);
//        item_image.setImageResource(size);
//


//        reference= FirebaseDatabase.getInstance().getReference("products/men").child("men1");
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                String name=snapshot.child("name").getValue().toString();
//                item_name1=name;
//                String desc=snapshot.child("description").getValue().toString();
//                String price=snapshot.child("price").getValue().toString();
//                String size=snapshot.child("size").getValue().toString();
//
//                item_name.setText(name);
//                custombar_text.setText(name);
//                description.setText(desc);
//                item_price.setText(price);
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

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