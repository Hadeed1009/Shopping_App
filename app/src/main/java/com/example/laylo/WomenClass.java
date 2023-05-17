package com.example.laylo;

import com.example.laylo.Modelss.Item;

import java.util.ArrayList;

public class WomenClass {
    Item item1 = new Item("women1", "White Embroidered Kurta", "5000", "43", "Sophisticated white canvas adorned with elegant embroidery that makes it a perfect pick for the season outing");
    Item item2 = new Item("women2", "Yellow Embroidered Kurta", "6000", "43", "A beautiful yellow canvas decorated with elegant embroidery and finished with lace & button embellishments that makes it a fine addition to your everyday collection.");
    Item item3 = new Item("women3", "Purple Digital Printed Kurta", "4000", "44", "Revel in the beauty of this sheer lilac silhouette uplifted with fine print and elegant lace that sets the mood for an everyday contemporary look.");
    Item item4 = new Item("women4", "Green Lawn 2Pcs Printed Kurta with Trouser", "7000", "39", "Articulated on fine lawn fabric with beautiful botanical print, this two-piece duo is a must have for your casual out and about this season.");
    Item item5 = new Item("women5", "Maroon Lawn 2Pcs Printed Kurta with Trouser", "7000", "43", "Two-piece printed ensemble featuring elegant design that make it a perfect pick for the season.");
    Item item6 = new Item("women6", "Beige Lawn 2Pcs Printed Kurta with Trouser", "7000", "39", "Two-piece printed ensemble featuring elegant design that make it a perfect pick for the season.");
    Item item7 = new Item("women7", "Grey 2Pcs Embroidered Kurta with Trouser", "8000", "39", "A subtly crafted two-piece design composed of elegant embroidery on shirt and finished off the look with embroidered pants");
    Item item8 = new Item("women8", "Navy Blue 2PCs Embroidered Kurta with Trouser", "8000", "42", "A subtly crafted two-piece design composed of elegant embroidery on shirt and finished off the look with embroidered pants.");
    Item item9 = new Item("women9", "Mustard 2Pcs Embroidered Kurta with Trouser", "9000", "44", "A subtly crafted two-piece design composed of elegant embroidery on shirt and finished off the look with embroidered pants.");
    Item item10 = new Item("women10", "Mustard Dyed Embroidered Kurta", "5000", "34", "Adorn this meticulously designed sleek green kurta embedded with fine embroidery and laces to add elegance to your look");
    Item item11 = new Item("women11", "Navy Blue Dyed Embroidered Kurta", "5000", "43", "Sophisticated navy blue kurta embedded with fine embroidery to add elegance to your look.");
    Item item12 = new Item("women12", "Purple Dyed Embroidered Kurta", "5000", "44", "Beautiful purple ensemble layered with exquisite embroidery that makes it easy to channel for a fine evening or a formal event.");
    Item item13 = new Item("women13", "Peach Dyed Embroidered Kurta", "5000", "43", "Casted with suave embroideries laid on fine color palette this mesmerising one-piece is a fine pick for casual evening or a formal gathering.");
    Item item14 = new Item("women14", "Turquoise Dyed Embroidered Kurta", "5000", "44", "Beautiful turquoise ensemble layered with exquisite embroidery that makes it easy to channel for a fine evening or a formal event.");
    Item item15 = new Item("women15", "Blue Embroidered Kurta", "6000", "42", "A contemporary cut envisioned with fine gardenia print that adds the beauty of modern look to your everyday style.");

    static ArrayList<Item> items = new ArrayList<>();

    WomenClass() {
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