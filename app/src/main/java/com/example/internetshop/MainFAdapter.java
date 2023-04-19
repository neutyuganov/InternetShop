package com.example.internetshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainFAdapter extends ArrayAdapter<JSONObject> {
    int listLayout;
    ArrayList<JSONObject> list;
    Context context;

    public MainFAdapter(Context context, int listLayout, ArrayList<JSONObject> list) {
        super(context, listLayout, list);
        this.context = context;
        this.listLayout = listLayout;
        this.list = list;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(listLayout,parent,false);
        TextView title = itemView.findViewById(R.id.title);
        TextView group = itemView.findViewById(R.id.group);
        TextView price = itemView.findViewById(R.id.price);
        try {
            title.setText(list.get(position).getString("Название"));
            group.setText(list.get(position).getString("ТипТовара"));
            price.setText(list.get(position).getString("Цена"));
        }catch (JSONException e){
            e.printStackTrace();
        }
        return itemView;
    }
}

