package com.example.laylo.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laylo.Modelss.HomeModel;
import com.example.laylo.R;

import java.util.ArrayList;

public class Home_Horizontal_Adapter extends RecyclerView.Adapter<Home_Horizontal_Adapter.viewholder> {

    ArrayList<HomeModel> list;
    Context context;

    int itemCount;

    public Home_Horizontal_Adapter(ArrayList<HomeModel> list, Context context, int itemCount) {
        this.list = list;
        this.context = context;
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_home_horizontal, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        HomeModel model = list.get(position);
        holder.homeHorImage.setImageResource(model.getImage());
        holder.homeHortext.setText(model.getName());
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public class viewholder extends RecyclerView.ViewHolder{

        ImageView homeHorImage;
        TextView homeHortext;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            homeHorImage=itemView.findViewById(R.id.homeVerImage);
            homeHortext=itemView.findViewById(R.id.homeVertext);
        }
    }
}
