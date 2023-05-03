package com.example.laylo.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laylo.Modelss.CategoryModels;
import com.example.laylo.Modelss.ProfileModel;
import com.example.laylo.R;

import java.util.ArrayList;

public class Profile_Adapter extends RecyclerView.Adapter<Profile_Adapter.viewholder>{
    ArrayList<ProfileModel> list;
    Context context;

    public Profile_Adapter(ArrayList<ProfileModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Profile_Adapter.viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_profile_layout, parent, false);
        return new Profile_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Profile_Adapter.viewholder holder, int position) {
        ProfileModel model = list.get(position);
        holder.image_profile.setImageResource(model.getImage());
        holder.text_profile.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return 0;
    }


    public class viewholder extends RecyclerView.ViewHolder{
        ImageView image_profile;
        TextView text_profile;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image_profile=itemView.findViewById(R.id.image_profile);
            text_profile=itemView.findViewById(R.id.text_profile);
        }
    }
}
