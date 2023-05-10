package com.example.laylo;

import com.example.laylo.Modelss.Item;

import java.util.ArrayList;

public class MenClass {
    Item item1 = new Item("men1","Black shirt", "1200", "32", "Casual men's full sleeve black shirt");
    Item item2 = new Item("men2","White shirt", "2200", "30", "Casual Men's Slim-fit Button-down Shirt White");
    Item item3 = new Item("men3","Dark Blue shirt", "2200", "30", "Casual Men's Slim-fit Button-down Shirt Dark Blue");
    Item item4 = new Item("men4","Grey shirt", "2200", "30", "Casual Men's Slim-fit Button-down Shirt Grey");
    Item item5 = new Item("men5","Teal shirt", "2200", "34", "Casual Men's Slim-fit Button-down Shirt Teal");
    Item item6 = new Item("men6","Light Blue shirt", "2200", "32", "Casual Men's Slim-fit Button-down Shirt Light Blue");
    Item item7 = new Item("men7","Beige shirt", "2200", "33", "Casual Men's Slim-fit Button-down Shirt Beige");
    Item item8 = new Item("men8","Marine Blue T-Shirt", "1800", "30", "Crew Neck short sleeve cotton T-Shirt Marine Blue");
    Item item9 = new Item("men9","Black T-shirt", "1800", "32", "Crew Neck short sleeve cotton T-Shirt Black");
    Item item10 = new Item("men10","Beige T-Shirt", "1800", "34", "Crew Neck Short Sleeve cotton T-Shirt Beige");
    Item item11 = new Item("men11","Grey T-Shirt", "1800", "30", "Crew Neck Short Sleeve Cotton T-Shirt Grey");
    Item item12 = new Item("men12","Orange T-Shirt", "2000", "29", "Sunset Cross Regular T-Shirt Orange Red");
    Item item13 = new Item("men13","Black Red T-Shirt", "2000", "30", "Icon Wings Regular T-Shirt Black Red");
    Item item14 = new Item("men14","White Red T-Shirt", "2000", "32", "Icon Wings Regular T-Shirt White Red");
    Item item15 = new Item("men15","Black Orange T-Shirt", "2000", "32", "Stitch Cross Over T-Shirt Black Orange");

    static ArrayList<Item> items = new ArrayList<>();

    MenClass(){
        items.add(item1);
        items.add(item2);
        items.add(item3);
        items.add(item4);
        items.add(item5);
        items.add(item6);
        items.add(item7);
        items.add(item8);
        items.add(item9);
        items.add(item10);
        items.add(item11);
        items.add(item12);
        items.add(item13);
        items.add(item14);
        items.add(item15);

    }

}
