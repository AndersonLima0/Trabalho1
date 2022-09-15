package com.example.toggle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Fragment4 extends Fragment {

    GridView gridView;
    String[] gameNames = {"Bordelands", "Kingdom Two Crowns", "Okami"};
    int[] gameImages = {R.drawable.g1, R.drawable.g2, R.drawable.g3};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v  = inflater.inflate(R.layout.fragment_4, container, false);

        gridView = v.findViewById(R.id.gridView);

        GridAdapter gridAdapter = new GridAdapter(getActivity(), gameNames, gameImages);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(), "Clicado", Toast.LENGTH_SHORT).show();
            }
        });


        return v;
    }
}