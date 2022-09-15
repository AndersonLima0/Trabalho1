package com.example.toggle;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter
{
    Context context;
    String[] gameNames;
    int[] image;

    LayoutInflater inflater;

    public GridAdapter(Context context, String[] gameNames, int[] image){
        this.context = context;
        this.gameNames = gameNames;
        this.image = image;
    }

    @Override
    public int getCount() {
        return gameNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if(view == null){
            view = inflater.inflate(R.layout.activity_grid_item, null);
        }
        ImageView imageView = view.findViewById(R.id.image);
        TextView textView = view.findViewById(R.id.item_name);

        imageView.setImageResource(image[position]);
        textView.setText(gameNames[position]);

        return view;
    }
}