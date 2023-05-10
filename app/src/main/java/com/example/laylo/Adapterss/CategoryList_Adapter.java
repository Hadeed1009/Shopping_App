package com.example.laylo.Adapterss;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laylo.Modelss.CategoryListModel;
import com.example.laylo.Modelss.CategoryModels;
import com.example.laylo.R;

import java.util.ArrayList;

public class CategoryList_Adapter extends RecyclerView.Adapter<CategoryList_Adapter.viewholder>{

    ArrayList<CategoryListModel> list;
    Context context;
    int itemCount;

    public CategoryList_Adapter(ArrayList<CategoryListModel> list, Context context, int itemCount) {
        this.list = list;
        this.context = context;
        this.itemCount = itemCount;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_catogorylist_layout, parent, false);
        return new CategoryList_Adapter.viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        CategoryListModel model = list.get(position);
        holder.catlist_image.setImageResource(model.getImage());
        holder.catlist_name.setText(model.getName());
        holder.catlist_price.setText(model.getPrice());
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView catlist_image;
        TextView catlist_name,catlist_price;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            catlist_image=itemView.findViewById(R.id.catlist_image);
            catlist_name=itemView.findViewById(R.id.catlist_name);
            catlist_price=itemView.findViewById(R.id.catlist_price);
        }

    }
}
