package com.example.laylo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laylo.Adapterss.Cart_Adapter;
import com.example.laylo.Modelss.Cart;
import com.example.laylo.Modelss.CartModel;
import com.example.laylo.Modelss.CategoryListModel;
import com.example.laylo.Modelss.cartItem;

import java.util.ArrayList;

public class CartFragment extends Fragment {
    TextView subTotal,discount,totalAmount;
    int Total=0;
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

        //For Order Details
        subTotal= view.findViewById(R.id.subTotal);
        discount= view.findViewById(R.id.Discount);
        totalAmount= view.findViewById(R.id.totalPrice);

        ArrayList<CartModel> list = new ArrayList<>();
        //In case cart is empty
        if(Cart.cartItems.size()==0)
        {
            InitialCartFragment initialCartFragment = new InitialCartFragment();
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.replace(R.id.fragmentLayout, initialCartFragment);
            transaction.commit();
        }
        else {
            //In case it is not!
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                Cart.cartItems.forEach((item) -> {
                    String imageName = item.image;
                    int resImageId = getResources().getIdentifier(imageName, "drawable", getActivity().getPackageName());
                    list.add(new CartModel(resImageId, item.name, item.size, item.price, item.quantity));
                });
            }
        }

        Cart_Adapter adapter = new Cart_Adapter(list, getContext(),subTotal,discount,totalAmount);
        cart_recycler.setAdapter(adapter);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        cart_recycler.setLayoutManager(layoutManager);

        //Order Details
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            for(cartItem element : Cart.cartItems){ //loop to iterate through cart
                int Price =Integer.parseInt(element.price);
                Total += Price ;
            }
        }
        subTotal.setText("Rs: "+String.format("%,d",Total)+".00");
        discount.setText("Rs: "+"0.00");
        totalAmount.setText("Rs: "+String.format("%,d",Total)+".00");

        Button placeOrder= view.findViewById(R.id.placeOrder);
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to Address fragment

                Bundle bundle = new Bundle();
                bundle.putInt("position",1);
                AddressBottomSheet addressBottomSheet = new AddressBottomSheet();
                addressBottomSheet.setArguments(bundle);
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.fragmentLayout, addressBottomSheet);
                transaction.commit();
            }
        });
        return view;
    }
}