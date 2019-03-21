package com.example.floussiwenmachia;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MasroufAdapter extends ArrayAdapter<NewMasrouf> {
    private ArrayList<NewMasrouf> arrayList;
    private Context ctx;
    private int item;


    public MasroufAdapter(@NonNull Context context, int resource , ArrayList<NewMasrouf> myarray) {
        super(context, resource,myarray);
        this.arrayList=myarray;
        this.ctx=context;
        this.item=resource; }

    @NonNull
    @Override
    public boolean isEnabled(int position)
    {
        return true;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //super.getView(position, convertView, parent);
        convertView= LayoutInflater.from(ctx).inflate(item,parent,false);

        TextView  prix=convertView.findViewById(R.id.valeur);

        TextView  achat=convertView.findViewById(R.id.depense);

        TextView date=convertView.findViewById(R.id.date);
        prix.setText(Float.toString(arrayList.get(position).getValeur()));

        achat.setText(arrayList.get(position).getDepense());
        date.setText(arrayList.get(position).getDate());

        return convertView; }}
