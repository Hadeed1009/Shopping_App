package com.example.laylo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.laylo.Adapterss.Category_Adapter;
import com.example.laylo.Modelss.CategoryModels;

import java.util.ArrayList;

public class CategoriesFragment extends Fragment {

    public CategoriesFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_categories, container, false);
        RecyclerView category_recycler=view.findViewById(R.id.category_recycleView);

        ArrayList<CategoryModels> list=new ArrayList<>();
        String a="men1";
        list.add(new CategoryModels(R.drawable.men_category,"MEN"));
        list.add(new CategoryModels(R.drawable.women_category,"WOMEN"));
        list.add(new CategoryModels(R.drawable.kids_category,"KIDS"));

        Category_Adapter adapter=new Category_Adapter(list,getContext());
        category_recycler.setAdapter(adapter);


        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        category_recycler.setLayoutManager(layoutManager);

        return view;
    }
}