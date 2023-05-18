package com.example.laylo;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
        ArrayList<HomeModel>list1= new ArrayList<>();
        new MenClass();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            MenClass.items.forEach((item) -> {
                String imageName=item.image;
                int resImageId=getResources().getIdentifier(imageName,"drawable",getActivity().getPackageName());
                list.add(new HomeModel(resImageId, item.name));
                list1.add(new HomeModel(resImageId, item.name, item.price, item.size, item.description));
            });
        }

        Home_Horizontal_Adapter adapter=new Home_Horizontal_Adapter(list,getContext(),10);
        rankingLayout.setAdapter(adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rankingLayout.setLayoutManager(layoutManager);

        //Touch lIstner on ranking layout
        rankingLayout.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), rankingLayout, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                HomeModel homemodel = list1.get(position);
                Intent intent = new Intent(getContext(), ItemDescription.class);
                intent.putExtra("image", homemodel.getImage());
                intent.putExtra("name", homemodel.getName());
                intent.putExtra("price", homemodel.getPrice());
                intent.putExtra("size", homemodel.getSize());
                intent.putExtra("description", homemodel.getDescription());
                intent.putExtra("Position", ++position); //item position
                intent.putExtra("position",0); //men category=0
                startActivity(intent);
            }
            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));

        //Recycle view for Just For You Layout
        RecyclerView forYoulayout=view.findViewById(R.id.forYoulayout);

        ArrayList<HomeModel> list2=new ArrayList<>();
        ArrayList<HomeModel> list3=new ArrayList<>();
        new KidsClass();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            KidsClass.items.forEach((item) -> {
                String imageName=item.image;
                int resImageId=getResources().getIdentifier(imageName,"drawable",getActivity().getPackageName());
                list2.add(new HomeModel(resImageId, item.name));
                list3.add(new HomeModel(resImageId, item.name, item.price, item.size, item.description));
            });
        }

        Home_Vertical_Adapter adapter1=new Home_Vertical_Adapter(list2,getContext(),15);
        forYoulayout.setAdapter(adapter1);

        GridLayoutManager layoutManager2 = new GridLayoutManager(getContext(), 2);
        forYoulayout.setLayoutManager(layoutManager2);

        //Touch lIstner on For You layout
        forYoulayout.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), forYoulayout, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                HomeModel homemodel = list3.get(position);
                Intent intent = new Intent(getContext(), ItemDescription.class);
                intent.putExtra("image", homemodel.getImage());
                intent.putExtra("name", homemodel.getName());
                intent.putExtra("price", homemodel.getPrice());
                intent.putExtra("size", homemodel.getSize());
                intent.putExtra("description", homemodel.getDescription());
                intent.putExtra("Position",++position); //item position
                intent.putExtra("position",2); //kids category=2
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }
        }));
        return view;
    }
}