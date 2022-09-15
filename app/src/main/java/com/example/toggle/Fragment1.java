package com.example.toggle;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class Fragment1 extends Fragment {

    public ToggleButton toogleBtn1;
    public EditText editText;

    ArrayList<String> listUsers;
    ListView listViewUsers;
    ArrayAdapter adapter;


    private static final String[] Countries = new String[]{
            "BRASIL", "ESTADOS UNIDOS", "CANADA", "ANGOLA"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.fragment_fragment1, container, false);

        AutoCompleteTextView autoCompleteTextView = v.findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapterAutoC = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, Countries);
        autoCompleteTextView.setAdapter(adapterAutoC);

        //****************** LIST VIEW ****************
        editText = v.findViewById(R.id.edtNome);
        listUsers = new ArrayList<String>();

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listUsers);
        listViewUsers = (ListView) v.findViewById(R.id.listViewUsers);
        listViewUsers.setAdapter(adapter);//conectando lista a fonte de dados
        listViewUsers.setSelector(android.R.color.holo_blue_light);

        listViewUsers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(getActivity(), "" + listUsers.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });

        Button btn1 = (Button) v.findViewById(R.id.addBtn);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String nome = editText.getText().toString();
                editText.setText("");
                listUsers.add(nome);

            }
        });


        return v;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater mInflate) {
       mInflate.inflate(R.menu.example_menu, menu);
       super.onCreateOptionsMenu(menu, mInflate);

    }

}