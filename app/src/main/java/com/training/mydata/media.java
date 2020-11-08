package com.training.mydata;

import java.util.ArrayList;

public class media {
    private static String[] namaMediaSosial = {
            "Facebook", "Whatsapp", "Twitter", "Instagram", "YouTube", "Blogger", "Github", "Discord", "Steam", "Linkedin"
    };

    private static String[] descriptionMediaSosial = {
            "Facebook adalah media sosial di Internet", "Whatsapp adalah media sosial yang bersifat personal", "Twitter adalah media sosial di Internet",
            "Instagram adalah media sosial di Internet", "YouTube adalah media sosial lebih dari Televisi BOOM!!", "Blogger adalah CMS tempat komunitas berdiskusi", "Github adalah website yang menyediakan repository secara GRATIS!!",
            "Discord adalah media sosial yang sering digunakan oleh para GAMERS!!", "Steam adalah software aplikasi yang berfungsi sebagai toko game online", "Linkedin adalah media sosial untuk menambah relasi untuk bekerja"
    };

    private static int[] imageMediaSosial = {
            R.drawable.fb, R.drawable.wa, R.drawable.twt, R.drawable.ig, R.drawable.yt, R.drawable.blog, R.drawable.github, R.drawable.dc, R.drawable.steam, R.drawable.lnkdin
    };

    static ArrayList<mediaSosial> getListData() {
        ArrayList<mediaSosial> list = new ArrayList<>();
        for (int position = 0; position < namaMediaSosial.length; position++) {
            mediaSosial mediaSosial = new mediaSosial();
            mediaSosial.setTitle(namaMediaSosial[position]);
            mediaSosial.setDescription(descriptionMediaSosial[position]);
            mediaSosial.setImage(imageMediaSosial[position]);
            list.add(mediaSosial);
        }
        return list;
    }
}
