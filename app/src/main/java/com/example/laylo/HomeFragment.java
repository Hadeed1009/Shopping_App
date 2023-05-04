package com.example.laylo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laylo.Adapterss.Category_Adapter;
import com.example.laylo.Adapterss.Home_Horizontal_Adapter;
import com.example.laylo.Modelss.CategoryModels;
import com.example.laylo.Modelss.HomeModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        RecyclerView rankingLayout=view.findViewById(R.id.rankingLayout);

        ArrayList<HomeModel> list=new ArrayList<>();
        list.add(new HomeModel(R.drawable.men_category,"MEN"));
        list.add(new HomeModel(R.drawable.women_category,"WOMEN"));
        list.add(new HomeModel(R.drawable.img,"KIDS"));
        list.add(new HomeModel(R.drawable.image1, "PK Shirt"));
        list.add(new HomeModel(R.drawable.image2, "Blue Shirt"));
        list.add(new HomeModel(R.drawable.image3, "Red Shirt"));
        list.add(new HomeModel(R.drawable.image4, "Grey Shirt"));
        list.add(new HomeModel(R.drawable.image5, "White Shirt"));

        Home_Horizontal_Adapter adapter=new Home_Horizontal_Adapter(list,getContext());
        rankingLayout.setAdapter(adapter);


        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rankingLayout.setLayoutManager(layoutManager);
        return view;
    }
}