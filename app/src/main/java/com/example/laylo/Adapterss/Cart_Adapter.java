package com.example.laylo.Adapterss;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laylo.CartFragment;
import com.example.laylo.ItemDescription;
import com.example.laylo.Modelss.Cart;
import com.example.laylo.Modelss.CartModel;
import com.example.laylo.Modelss.cartItem;
import com.example.laylo.R;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.viewholder>{
    ArrayList<CartModel> list;
    Context context;
    TextView subTotal,discount,totalAmount;

    public Cart_Adapter(ArrayList<CartModel> list, Context context, TextView Subtotal, TextView Discount, TextView TotalAmount) {
        this.list = list;
        this.context = context;
        this.subTotal = Subtotal;
        this.discount = Discount;
        this.totalAmount = TotalAmount;
    }
    @NonNull
    @Override
    public Cart_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_cart_layout, parent, false);
        return new Cart_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_Adapter.viewholder holder, @SuppressLint("RecyclerView") int position) {
            CartModel model = list.get(position);
            holder.cartItem_img.setImageResource(model.getImg());
            holder.cartItem_name.setText(model.getName());
            String formattedPrice = String.format("%,d",Integer.parseInt(model.getPrice()));
            holder.cartItem_price.setText("Rs: "+formattedPrice);
            holder.cartItem_size.setText(model.getSize());
            holder.cartItem_qty.setText(model.getQuantity());

        //Item Increment Button
        holder.cartItem_incr.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onClick(View v) {
                new Cart();
                for(cartItem findItem : Cart.cartItems){
                    if(findItem.name.equals(model.getName())){
                        int qty = Integer.parseInt(findItem.quantity);
                        int Old_price = Integer.parseInt(findItem.price)/qty; //Actual Price
                        qty = qty+1;
                        int New_price = Old_price*qty;
                        findItem.quantity= Integer.toString(qty); //update quantity
                        findItem.price = Integer.toString(New_price); //update price also
                        notifyDataSetChanged();
                        //applying changes in adapter model
                        model.setQuantity(Integer.toString(qty));
                        model.setPrice(Integer.toString(New_price));
                        //Update Order Details
                        UpdateOrderDetails();
                    }
                }
                //this is only changing the adapter view, not in original list
//                int qty = Integer.parseInt(model.getQuantity());
//                qty++;
//                model.setQuantity(Integer.toString(qty));
//                notifyDataSetChanged();
            }
        });

        //Item Decrement Button
        holder.cartItem_decr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Cart();
                for(cartItem findItem : Cart.cartItems){
                    if(findItem.name.equals(model.getName())){
                        int qty = Integer.parseInt(findItem.quantity);
                        int Old_price = Integer.parseInt(findItem.price)/qty; //Actual Price
                        qty = qty-1;
//                        in case of qty = 0
                        if(qty==0){
                            Cart.cartItems.remove(findItem);
//                            ArrayList<CartModel> newList = new ArrayList<>();
//                            newList = (ArrayList)Cart.cartItems.clone();
////                            Collections.copy(newList,Cart.cartItems);
//                            Cart_Adapter adapter = new Cart_Adapter(newList, context ,subTotal,discount,totalAmount);
//                            adapter.notifyItemRemoved(position);
                            //call cart fragment again
//                            Cart_Adapter add = new Cart_Adapter( list, context,  subTotal,  discount,  totalAmount);
//                            add.notifyItemRemoved(position);
                        }
                        int New_price = Old_price*qty;
                        findItem.quantity= Integer.toString(qty); //update quanitiy
                        findItem.price = Integer.toString(New_price); //update price also
                        notifyDataSetChanged();
//                        notifyItemChanged(position);
//                        applying changes in adapter model
                        model.setQuantity(Integer.toString(qty));
                        model.setPrice(Integer.toString(New_price));
                        //Update Order Details
                        UpdateOrderDetails();
                    }
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView cartItem_img;
        TextView cartItem_name, cartItem_price,cartItem_size,cartItem_qty;
        ImageView cartItem_incr,cartItem_decr;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            cartItem_img = itemView.findViewById(R.id.item_image);
            cartItem_name = itemView.findViewById(R.id.item_name);
            cartItem_price = itemView.findViewById(R.id.item_price);
            cartItem_size = itemView.findViewById(R.id.item_size);
            cartItem_qty = itemView.findViewById(R.id.item_qty);
            cartItem_decr = itemView.findViewById(R.id.decrement);
            cartItem_incr = itemView.findViewById(R.id.increment);
        }
    }

    public void UpdateOrderDetails(){
        int Total = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for(cartItem element : Cart.cartItems){ //loop to iterate through cart
                int Price =Integer.parseInt(element.price);
                Total += Price ;
            }
        }
        subTotal.setText("Rs: "+String.format("%,d",Total)+".00");
        discount.setText("Rs: "+"0.00");
        totalAmount.setText("Rs: "+String.format("%,d",Total)+".00");
    }
}
