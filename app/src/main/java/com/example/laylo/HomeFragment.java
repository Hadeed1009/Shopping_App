package com.example.laylo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laylo.Adapterss.Category_Adapter;
import com.example.laylo.Adapterss.Home_Horizontal_Adapter;
import com.example.laylo.Adapterss.Home_Vertical_Adapter;
import com.example.laylo.Classess.RecyclerItemClickListener;
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


        //Recycler View for Top Ranking Layout
        RecyclerView rankingLayout=view.findViewById(R.id.rankingLayout);

        ArrayList<HomeModel>list=new ArrayList<>();
//        list.add(new HomeModel(R.drawable.men1,"MEN"));
//        list.add(new HomeModel(R.drawable.men2,"WOMEN"));
//        list.add(new HomeModel(R.drawable.men3,"KIDS"));
//        list.add(new HomeModel(R.drawable.men4, "PK Shirt"));
//        list.add(new HomeModel(R.drawable.men5, "Blue Shirt"));
//        list.add(new HomeModel(R.drawable.men6, "Red Shirt"));
//        list.add(new HomeModel(R.drawable.men7, "Grey Shirt"));
//        list.add(new HomeModel(R.drawable.men8, "White Shirt"));

        Home_Horizontal_Adapter adapter=new Home_Horizontal_Adapter(list,getContext());
        rankingLayout.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rankingLayout.setLayoutManager(layoutManager);

        //Touch lIstner on ranking layout
        rankingLayout.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankingLayout, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                HomeModel homemodel = list.get(position);
                Intent intent = new Intent(getContext(), ItemDescription.class);
                intent.putExtra("image", homemodel.getImage());
                intent.putExtra("text", homemodel.getText());
                startActivity(intent);

                //Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                //Toast.makeText(getContext(), "Item Long Clicked", Toast.LENGTH_SHORT).show();
            }
        }));

        //Recycle view for Just For You Layout
        RecyclerView forYoulayout=view.findViewById(R.id.forYoulayout);

        ArrayList<HomeModel> list2=new ArrayList<>();
        list2.add(new HomeModel(R.drawable.men_category,"MEN"));
        list2.add(new HomeModel(R.drawable.women_category,"WOMEN"));
        list2.add(new HomeModel(R.drawable.kids_category,"KIDS"));
        list2.add(new HomeModel(R.drawable.image1, "PK Shirt"));
        list2.add(new HomeModel(R.drawable.image2, "Blue Shirt"));
        list2.add(new HomeModel(R.drawable.image3, "Red Shirt"));
        list2.add(new HomeModel(R.drawable.image4, "Grey Shirt"));
        list2.add(new HomeModel(R.drawable.image5, "White Shirt"));

        Home_Vertical_Adapter adapter1=new Home_Vertical_Adapter(list2,getContext());
        forYoulayout.setAdapter(adapter1);

        GridLayoutManager layoutManager2 = new GridLayoutManager(getContext(), 2);
        forYoulayout.setLayoutManager(layoutManager2);

        //Touch lIstner on For You layout
        forYoulayout.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), forYoulayout, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                HomeModel homemodel = list2.get(position);
                Intent intent = new Intent(getContext(), ItemDescription.class);
                intent.putExtra("image", homemodel.getImage());
                intent.putExtra("text", homemodel.getText());
                startActivity(intent);

                //Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onLongItemClick(View view, int position) {
                //Toast.makeText(getContext(), "Item Long Clicked", Toast.LENGTH_SHORT).show();
            }
        }));
        return view;
    }
}