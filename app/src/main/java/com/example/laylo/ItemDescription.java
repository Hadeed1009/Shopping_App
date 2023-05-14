package com.example.laylo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laylo.Modelss.Cart;
import com.example.laylo.Modelss.CartModel;
import com.example.laylo.Modelss.CategoryListModel;
import com.example.laylo.Modelss.cartItem;

import java.util.ArrayList;

//import com.google.firebase.database.DatabaseReference;

public class ItemDescription extends AppCompatActivity {
//  DatabaseReference reference;
    ImageView item_image;
    TextView item_name,custombar_text,item_description1,item_price,item_size,text_cart,text_buy;
    int item_qty=1; // to count item quantity on every button click
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
        text_buy=findViewById(R.id.text_buy);
        text_cart=findViewById(R.id.text_cart);

        int image = getIntent().getIntExtra("image",0);
        item_image.setImageResource(image);

        String name = getIntent().getStringExtra("name");
        item_name.setText(name);
        item_name1=name;
        custombar_text.setText(name);
        //
        String description = getIntent().getStringExtra("description");
        item_description1.setText(description);

        String size = getIntent().getStringExtra("size");
        item_size.setText(size);

        String price = getIntent().getStringExtra("price");
        item_price.setText("Rs: "+price);

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


        //Add To Cart
        text_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add selected items to list
                int position = getIntent().getIntExtra("Position",0); //item position
                int Cat_position = getIntent().getIntExtra("position",0); //category position
                String C_item_position = Integer.toString(position);
                String Str_image="";
                if(Cat_position==0){
                    Str_image = "men"+C_item_position; //cart Item's image name
                }
                if(Cat_position==1){
                    Str_image = "women"+C_item_position; //cart Item's image name
                }
                if(Cat_position==2){
                     Str_image = "kids"+C_item_position; //cart Item's image name
                }
                String Str_qty = Integer.toString(item_qty);
                Cart cart = new Cart();
                cartItem cartitem = new cartItem(Str_image,name,price,size,Str_qty);
                boolean found = false;
                    //check if item is already in cart
                    for(cartItem checkItem : cart.cartItems){
                        if(checkItem.image.equals(cartitem.image)){ //checking the distinct element
                        int New_qty = Integer.parseInt(checkItem.quantity)+1; //increment quantity
                        int Old_price = Integer.parseInt(cartitem.price);
                        int New_price = Old_price*New_qty; //calculate price
                        checkItem.quantity = Integer.toString(New_qty); //update qty
                        checkItem.price = Integer.toString(New_price); //update price
                        found = true;
                        }
                    }
                   if(found==false)
                   {
                       cart.cartItems.add(cartitem);
                   }
//                }
//                else {
//                    System.out.println("entered in add case"+added);
//                    cart.cartItems.add(cartitem);
//                    added=true;
//                }
//                if(cart.cartItems.contains(cartitem)) {
//                    cart.cartItems.clear();
//                    while (cart.cartItems.contains(cartitem)) {
//                        int index = cart.cartItems.indexOf(cartitem);
//                        cart.cartItems.remove(index);
                 //// cart.cartItems.remove(cartitem);
//                    }

//                    item_qty++;
//                    String Str_qty2 = Integer.toString(item_qty);
//                    cartItem cartitem2 = new cartItem(Str_image,name,price,size,Str_qty2);
//                    cart.cartItems.add(cartitem2);
//                }
//                else{
//                    cart.cartItems.add(cartitem);
//                }

//                       cart.menCart.add(C_item_name);
//                        cart.menCart.add(new CartModel(image,R.drawable.increment,R.drawable.decrement,name,size,price,Str_qty));

//                        cart.menCart.add(new CartModel(image,name,size,price,Str_qty));
//                        cart.menCart.add(new CartModel(image,name,size,price,Str_qty));
//                        Toast.makeText(ItemDescription.this,"TT "+cart.menCart, Toast.LENGTH_SHORT).show();
//                        for(CartModel cm: cart.menCart){
//                            System.out.println(cm);
//                        }
//                    case 1:
////                        cart.womenCart.add(C_item_name);
////                        cart.womenCart.add(new CartModel(image,R.drawable.increment,R.drawable.decrement,name,size,price,Str_qty));
//                    case 2:
////                        cart.kidsCart.add(C_item_name);
////                        cart.kidsCart.add(new CartModel(image,R.drawable.increment,R.drawable.decrement,name,size,price,Str_qty));
//                    default:
////                        System.out.println("NO SUCH CATEGORY..");
//                }
//                  Toast.makeText(ItemDescription.this,"hii"+ position, Toast.LENGTH_SHORT).show();
//                item_qty++;
//                String imageName=item.image;
//                int resImageId=getResources().getIdentifier(imageName,"drawable",getPackageName());
//                ArrayList<CartModel> cartList= new ArrayList<>();
//                cartList.add(new CartModel(image, name, size, price, item_qty));

                //show dialog box
                new AlertDialog.Builder(ItemDescription.this)
                        .setMessage("Cart Updated!")
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                 dialog.dismiss();
                            }
                        }).show();
            }
        });

        //Buy Now
        text_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(ItemDescription.this)
                        .setMessage("You have selected "+item_name1+" to buy")
                        .setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Intent intent = new Intent(ItemDescription.this,AddressBottomSheet.class);
//                                  intent.putExtra("Flag",true);
                                AddressBottomSheet addressBottomSheet=new AddressBottomSheet();
                                addressBottomSheet.show(getSupportFragmentManager(),"AddressBottomSheet");
//                                Toast.makeText(ItemDescription.this, "Ok", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("Change", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        })
                        .show();
//                //Buy Now leads to cart directly
//                CartFragment cartFragment = new CartFragment();
//                FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();
//                transaction.replace(R.id.fragmentLayout, cartFragment);
//                transaction.commit();
            }
        });
    }
}