package com.example.ltudddtuan3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int id_layout;
    ArrayList<Phone> mylist;
    // tao constructor de thay doi cap nhat du lieu

    public MyArrayAdapter(Activity context, int id_layout, ArrayList<Phone> mylist) {
        super(context, id_layout, mylist);
        this.id_layout = id_layout;
        this.context = context;
        this.mylist = mylist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Tao inflacter
        LayoutInflater myinflacter = context.getLayoutInflater();
        //Dat layout len de de tao View
        convertView = myinflacter.inflate(id_layout, null);
        Phone myphone = mylist.get(position);
        ImageView img_phone = convertView.findViewById(R.id.img_phone);
        img_phone.setImageResource(myphone.getImage());
        TextView txt_phone = convertView.findViewById(R.id.txt_phone);
        txt_phone.setText(myphone.getName());
        return convertView;
    }
}
