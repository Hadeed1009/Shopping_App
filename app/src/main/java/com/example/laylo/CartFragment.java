package com.example.laylo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laylo.Adapterss.Cart_Adapter;
import com.example.laylo.Modelss.CartModel;

import java.util.ArrayList;

public class CartFragment extends Fragment {

    public CartFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_cart, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView cart_recycler=view.findViewById(R.id.cart_recycler);

        ArrayList<CartModel> list = new ArrayList<>();
        list.add(new CartModel(R.drawable.kids_category,R.drawable.increment,R.drawable.decrement,"One Cutie has been added to your cart!","2 years old","RS 1349.00","1"));
        list.add(new CartModel(R.drawable.women_category,R.drawable.increment,R.drawable.decrement,"Beautiful!","20+ years old","RS 2349.00","4"));
        list.add(new CartModel(R.drawable.image3,R.drawable.increment,R.drawable.decrement,"Hehehehe!","30 years old","RS 1349.00","2"));
//        list.add(new CartModel(R.drawable.kids_category,R.drawable.increment,R.drawable.decrement,"One Cutie has been added to your cart!","2 years old","RS 1349.00","1"));
//        list.add(new CartModel(R.drawable.women_category,R.drawable.increment,R.drawable.decrement,"Beautiful!","20+ years old","RS 2349.00","4"));
//        list.add(new CartModel(R.drawable.image3,R.drawable.increment,R.drawable.decrement,"Hehehehe!","30 years old","RS 1349.00","2"));
//        list.add(new CartModel(R.drawable.kids_category,R.drawable.increment,R.drawable.decrement,"One Cutie has been added to your cart!","2 years old","RS 1349.00","1"));
//        list.add(new CartModel(R.drawable.women_category,R.drawable.increment,R.drawable.decrement,"Beautiful!","20+ years old","RS 2349.00","4"));
//        list.add(new CartModel(R.drawable.image3,R.drawable.increment,R.drawable.decrement,"Hehehehe!","30 years old","RS 1349.00","2"));

        Cart_Adapter adapter= new Cart_Adapter(list,getContext());
        cart_recycler.setAdapter(adapter);

        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        cart_recycler.setLayoutManager(layoutManager);

        return view;
    }
}