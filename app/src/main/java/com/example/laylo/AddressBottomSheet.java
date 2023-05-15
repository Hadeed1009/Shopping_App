package com.example.laylo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

        TextView cust_firstName, cust_lastName, cust_company, cust_contact, cust_address, cust_city, cust_state , cust_zipCode, cust_country;
        cust_firstName = view.findViewById(R.id.cust_firstName);
        cust_lastName = view.findViewById(R.id.cust_lastName);
        cust_company = view.findViewById(R.id.cust_company);
        cust_contact = view.findViewById(R.id.cust_contact);
        cust_address = view.findViewById(R.id.cust_address);
        cust_city = view.findViewById(R.id.cust_city);
        cust_state = view.findViewById(R.id.cust_state);
        cust_zipCode = view.findViewById(R.id.cust_zipCode);
        cust_country = view.findViewById(R.id.cust_country);



        Confirm_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(TextUtils.isEmpty(cust_firstName.getText())){
//                    cust_firstName.setError("This field cannot be empty");
//                    cust_firstName.requestFocus();
//                } else if (TextUtils.isEmpty(cust_lastName.getText())) {
//                    cust_lastName.setError("This field cannot be empty");
//                    cust_lastName.requestFocus();
//                } else if (TextUtils.isEmpty(cust_address.getText())) {
//                    cust_address.setError("This field cannot be empty");
//                    cust_address.requestFocus();
//                } else if (TextUtils.isEmpty(cust_contact.getText())) {
//                    cust_contact.setError("This field cannot be empty");
//                    cust_contact.requestFocus();
//                } else if (TextUtils.isEmpty(cust_country.getText())) {
//                    cust_country.setError("This field cannot be empty");
//                    cust_country.requestFocus();
//                } else if (TextUtils.isEmpty(cust_state.getText())) {
//                    cust_state.setError("This field cannot be empty");
//                    cust_state.requestFocus();
//                } else if (TextUtils.isEmpty(cust_city.getText())) {
//                    cust_city.setError("This field cannot be empty");
//                    cust_city.requestFocus();
//                } else if (TextUtils.isEmpty(cust_zipCode.getText())) {
//                    cust_zipCode.setError("This field cannot be empty");
//                    cust_zipCode.requestFocus();
//                }else{
                    Bundle bundle = getArguments();
                    int position = bundle.getInt("position");

                    if (position == 0) {
//                        Cart.cartItems.remove(0);
                        Intent intent = new Intent(getContext(), HappyShopping.class);
                        startActivity(intent);
                    }

                    //Adding placed orders in myOrders array for record
//                    ArrayList<cartItem> orders = (ArrayList<cartItem>) Cart.cartItems.clone();
//
//                    //For Items from buyNow, make orders2
//                    Intent intent = new Intent(getContext(), HappyShopping.class);
//                    startActivity(intent);
                }
//            }
        });
        return view;
    }
}