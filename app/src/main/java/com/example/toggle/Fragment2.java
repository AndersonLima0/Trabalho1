package com.example.toggle;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Fragment2 extends Fragment {

    Spinner spinner;
    String[] menu = {"Opção 1", "Opção 2","Opção 3"};

    public RadioButton java;
    public RadioButton kotlin;
    public RadioButton js;
    public android.widget.RadioGroup radioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_fragment2, container, false);

        spinner = v.findViewById(R.id.spinner1);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, menu);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String text = parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), text, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        java = v.findViewById(R.id.java);
        kotlin = v.findViewById(R.id.kotlin);
        js = v.findViewById(R.id.js);
        radioGroup = v.findViewById(R.id.radioGroup);

        Button btn1 = (Button) v.findViewById(R.id.submitBtn);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if(java.isChecked()){
                    Snackbar.make(view,"Acertou!",Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                }else{
                    Snackbar.make(view,"Errou '-'",Snackbar.LENGTH_SHORT).setAction("Action",null).show();

                }
            }
        });

        Button btn2 = (Button) v.findViewById(R.id.clearBtn);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radioGroup.clearCheck();
            }
        });
        return v;

    }

    }
