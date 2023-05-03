package com.example.laylo;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.laylo.Adapterss.Category_Adapter;
import com.example.laylo.Adapterss.Profile_Adapter;
import com.example.laylo.Modelss.CategoryModels;
import com.example.laylo.Modelss.ProfileModel;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView profile_recycler=view.findViewById(R.id.profile_recycleView);

        ArrayList<ProfileModel> list=new ArrayList<>();
        list.add(new ProfileModel(R.drawable.order, "My Orders"));
        list.add(new ProfileModel(R.drawable.favorite, "Favourites"));
        list.add(new ProfileModel(R.drawable.address, "My Addresses"));
        list.add(new ProfileModel(R.drawable.settings, "Settings"));

        Profile_Adapter adapter=new Profile_Adapter(list,getContext());
        profile_recycler.setAdapter(adapter);


        LinearLayoutManager layoutManager=new LinearLayoutManager(getContext());
        profile_recycler.setLayoutManager(layoutManager);


        return view;
    }
}