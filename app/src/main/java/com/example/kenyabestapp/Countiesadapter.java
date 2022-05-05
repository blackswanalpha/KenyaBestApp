package com.example.kenyabestapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Countiesadapter extends ArrayAdapter<Countydets>  implements Filterable {

    public Countiesadapter(Context context, int resource, List<Countydets> shapeList)
    {
        super(context,resource,shapeList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Countydets shape = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        TextView tv = (TextView) convertView.findViewById(R.id.personName);
        ImageView iv = (ImageView) convertView.findViewById(R.id.shapeImage);

        tv.setText(shape.getName());
        iv.setImageResource(shape.getImage());


        return convertView;
    }

}
