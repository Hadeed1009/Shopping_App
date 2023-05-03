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
import com.example.laylo.R;

import java.util.ArrayList;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.viewholder> {
    ArrayList<CategoryModels> list;
    Context context;

    public Category_Adapter(ArrayList<CategoryModels> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_categories_layout, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        CategoryModels model = list.get(position);
        holder.image_category.setImageResource(model.getImg());
        holder.text_category.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder{
        ImageView image_category;
        TextView text_category;
        public viewholder(@NonNull View itemView) {
            super(itemView);
            image_category=itemView.findViewById(R.id.image_category);
            text_category=itemView.findViewById(R.id.text_category);
        }
    }
}
