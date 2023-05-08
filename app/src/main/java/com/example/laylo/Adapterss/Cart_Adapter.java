package com.example.laylo.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laylo.Modelss.CartModel;
import com.example.laylo.Modelss.CategoryModels;
import com.example.laylo.R;

import java.util.ArrayList;

public class Cart_Adapter extends RecyclerView.Adapter<Cart_Adapter.viewholder>{
    ArrayList<CartModel> list;
    Context context;

    public Cart_Adapter(ArrayList<CartModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Cart_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_cart_layout, parent, false);
        return new Cart_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Cart_Adapter.viewholder holder, int position) {
        CartModel model = list.get(position);
        holder.image_cart.setImageResource(model.getImg());
        holder.text_cart.setText(model.getText());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView image_cart;
        TextView text_cart;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image_cart=itemView.findViewById(R.id.item_image);
            text_cart=itemView.findViewById(R.id.item_text);
        }
    }
}
