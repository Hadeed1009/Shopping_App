package com.example.laylo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.laylo.Modelss.Cart;
import com.example.laylo.Modelss.cartItem;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class AddressBottomSheet extends BottomSheetDialogFragment {

    public AddressBottomSheet() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_address_bottom_sheet, container, false);
        Button Confirm_button = view.findViewById(R.id.btn_save);
        Confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Adding placed orders in myOrders array for record
                ArrayList<cartItem> orders = (ArrayList<cartItem>) Cart.cartItems.clone();

                //For Items from buyNow, make orders2
                Intent intent = new Intent(getContext(), HappyShopping.class);
                startActivity(intent);
            }
        });
        return view;
    }
}