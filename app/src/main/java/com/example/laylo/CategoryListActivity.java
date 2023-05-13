package com.example.laylo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.laylo.Adapterss.CategoryList_Adapter;
import com.example.laylo.Classess.RecyclerItemClickListener;
import com.example.laylo.Modelss.CategoryListModel;

import java.util.ArrayList;

public class CategoryListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        RecyclerView catlist_recycler = findViewById(R.id.catlist_recyclerview);

        ArrayList<CategoryListModel> list = new ArrayList<>();
        ArrayList<CategoryListModel> list1 = new ArrayList<>();

        int CatPosition = getIntent().getIntExtra("position", 0);
        if(CatPosition==0){
            new MenClass();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            MenClass.items.forEach((item) -> {
                String imageName=item.image;
                int resImageId=getResources().getIdentifier(imageName,"drawable",getPackageName());
                list.add(new CategoryListModel(resImageId, item.name, item.price));
                list1.add(new CategoryListModel(resImageId, item.name, item.price,item.size,item.description));
//                list=new ArrayList<>();
                });
            }
        }
        if (CatPosition==1) {
            new WomenClass();
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                WomenClass.items.forEach((item) -> {
                    String imageName = item.image;
                    int resImageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    list.add(new CategoryListModel(resImageId, item.name, item.price));
                    list1.add(new CategoryListModel(resImageId, item.name, item.price, item.size, item.description));
                });
            }
        }
        if(CatPosition==2){
            new KidsClass();
            if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.N){
                KidsClass.items.forEach((item) -> {
                    String imageName = item.image;
                    int resImageId = getResources().getIdentifier(imageName, "drawable", getPackageName());
                    list.add(new CategoryListModel(resImageId, item.name, item.price));
                    list1.add(new CategoryListModel(resImageId, item.name, item.price, item.size, item.description));
                });
            }
        }
//        list1 = new ArrayList<>();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            MenClass.items.forEach((item) -> {
//                String imageName=item.image;
//                int resImageId=getResources().getIdentifier(imageName,"drawable",getPackageName());
//                list.add(new CategoryListModel(resImageId, item.name, item.price));
//                list1.add(new CategoryListModel(resImageId, item.name, item.price,item.size,item.description));
////                list=new ArrayList<>();
//
//            });
//        }

        catlist_recycler.setHasFixedSize(true);
        CategoryList_Adapter adapter1 = new CategoryList_Adapter(list, this,15);
        catlist_recycler.setAdapter(adapter1);

        GridLayoutManager layoutManager2 = new GridLayoutManager(this, 2);
        catlist_recycler.setLayoutManager(layoutManager2);

        catlist_recycler.addOnItemTouchListener(new RecyclerItemClickListener(this, catlist_recycler, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                CategoryListModel model = list1.get(position);
                Intent intent = new Intent(CategoryListActivity.this, ItemDescription.class);
                intent.putExtra("image", model.getImage());
                intent.putExtra("name", model.getName());
                intent.putExtra("price", model.getPrice());
                intent.putExtra("size", model.getSize());
                intent.putExtra("description", model.getDescription());
                intent.putExtra("Position",++position); //item position
                intent.putExtra("position",CatPosition); //category
//                Toast.makeText(CategoryListActivity.this, "hello"+ ++position, Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }

            @Override
            public void onLongItemClick(View view, int position) {

            }

        }));
    }
}