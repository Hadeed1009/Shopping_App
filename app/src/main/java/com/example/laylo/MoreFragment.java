package com.example.laylo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MoreFragment extends Fragment {
    TextView Person1, Person2,Person3,Person4, email1, email2, email3, email4;
    public MoreFragment() {
        // Required empty public constructor
    }
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_more, container, false);

        Person1 = view.findViewById(R.id.Person1);
        Person2 = view.findViewById(R.id.Person2);
        Person3 = view.findViewById(R.id.Person3);
        Person4 = view.findViewById(R.id.Person4);
        email1 = view.findViewById(R.id.email1);
        email2 = view.findViewById(R.id.email2);
        email3 = view.findViewById(R.id.email3);
        email4 = view.findViewById(R.id.email4);

        Person1.setText("Hadeed Naeem Haider");
        email1.setText("hadeednaeem10@gmail.com");
        Person2.setText("Hafsa Khalid");
        email2.setText("leo.hafsakhalid@gmail.com");
        Person3.setText("Saleha Faisal");
        email3.setText("Salehafaisal123@outlook.com");
        Person4.setText("Kanwal Shahzadi");
        email4.setText("skanwal940@gmail.com");
        return view;
    }
}