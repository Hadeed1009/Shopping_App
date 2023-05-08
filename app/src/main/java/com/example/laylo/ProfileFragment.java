package com.example.laylo;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.laylo.Adapterss.Home_Horizontal_Adapter;
import com.example.laylo.Modelss.HomeModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        Button profile_logout=view.findViewById(R.id.profile_logout);
        TextView profile_name=view.findViewById(R.id.profile_name);
        TextView profile_email=view.findViewById(R.id.profile_email);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView account_delete=view.findViewById(R.id.account_delete);
        profile_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(getContext())
                        .setMessage("Are you sure you want to logout?")
                        .setPositiveButton("Logout", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                FirebaseAuth.getInstance().signOut();
                                startActivity(new Intent(getContext(),Login.class));
                                getActivity().finish();
                                Toast.makeText(getContext(), "Successfully Logout", Toast.LENGTH_SHORT).show();
                            }
                        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });

        DatabaseReference myRef= FirebaseDatabase.getInstance().getReference("customer").child(FirebaseAuth.getInstance().getCurrentUser().getUid());
        myRef.get().addOnSuccessListener(dataSnapshot -> {
            profile_name.setText(dataSnapshot.child("name").getValue().toString());
        });

        FirebaseAuth auth = FirebaseAuth.getInstance();
        FirebaseUser user = auth.getCurrentUser();
        profile_email.setText(user.getEmail());

        return view;
    }
}