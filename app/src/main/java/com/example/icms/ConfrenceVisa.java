package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ConfrenceVisa extends AppCompatActivity {
    Button CV_next_btn;
    Spinner sp_inviting_company_category;
    ArrayList<String> invitingcompany_arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrence_visa);
        CV_next_btn = findViewById(R.id.CV_next_btn);
        sp_inviting_company_category = findViewById(R.id.CV_inviting_company_category);
        fillArrayList();
        CV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConfrenceVisa.this, CV_AppForm2.class);
                startActivity(intent);
            }
        });
        sp_inviting_company_category.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                itemSelectionListener();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void itemSelectionListener() {

    }

    private void fillArrayList() {
        ArrayAdapter<String> arrayAdaptercamponycategory;
        invitingcompany_arraylist = new ArrayList<>();
        invitingcompany_arraylist.add("Please Select");
        invitingcompany_arraylist.add("Private Company (Registered in Ethiopia)");
        invitingcompany_arraylist.add("Governmental Organizations");
        invitingcompany_arraylist.add("Non -Governmental Organizations (NGO)");
        invitingcompany_arraylist.add("International Organization");
        arrayAdaptercamponycategory = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, invitingcompany_arraylist);
        sp_inviting_company_category.setAdapter(arrayAdaptercamponycategory);

    }
}