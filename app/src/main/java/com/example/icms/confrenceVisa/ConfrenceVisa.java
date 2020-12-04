package com.example.icms.confrenceVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

import java.util.ArrayList;

public class ConfrenceVisa extends AppCompatActivity {
    Button CV_next_btn;
    Spinner sp_inviting_company_category;
    TextView sp_site_error_TV;
    EditText CV_citizenship_ET;
    ArrayList<String> invitingcompany_arraylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confrence_visa);
        CV_next_btn = findViewById(R.id.CV_next_btn);
        sp_site_error_TV = findViewById(R.id.sp_invitingcompany_error_TV);
        CV_citizenship_ET = findViewById(R.id.CV_citizenship_ET);
        sp_inviting_company_category = findViewById(R.id.CV_inviting_company_category);
        fillArrayList();

        CV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
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

    private void checkform() {
        String citizenship = CV_citizenship_ET.getText().toString().trim();
        if (citizenship.isEmpty()) {
            CV_citizenship_ET.setError("Please insert your citizenship!");
            CV_citizenship_ET.requestFocus();
            return;
        } else if (!(sp_inviting_company_category.getSelectedItemPosition() >= 1)) {
            sp_site_error_TV.setVisibility(View.VISIBLE);
            sp_site_error_TV.setError("please Select a site!");
            sp_site_error_TV.requestFocus();
            return;
        } else {
            sp_site_error_TV.setVisibility(View.GONE);
            Intent intent = new Intent(ConfrenceVisa.this, CV_AppForm2.class);
            startActivity(intent);
            return;
        }
    }

    private void itemSelectionListener() {
        if (sp_inviting_company_category.getSelectedItemPosition() == 1) {
            sp_site_error_TV.setVisibility(View.GONE);
        } else if (sp_inviting_company_category.getSelectedItemPosition() == 2) {
            sp_site_error_TV.setVisibility(View.GONE);
        } else if (sp_inviting_company_category.getSelectedItemPosition() == 3) {
            sp_site_error_TV.setVisibility(View.GONE);
        } else if (sp_inviting_company_category.getSelectedItemPosition() == 4) {
            sp_site_error_TV.setVisibility(View.GONE);
        }
        String inviting_company_category = sp_inviting_company_category.getSelectedItem().toString();
    }

    private void fillArrayList() {
        ArrayAdapter<String> arrayAdaptercamponycategory;
        invitingcompany_arraylist = new ArrayList<>();
        invitingcompany_arraylist.add(0, "Please Select");
        invitingcompany_arraylist.add("Private Company (Registered in Ethiopia)");
        invitingcompany_arraylist.add("Governmental Organizations");
        invitingcompany_arraylist.add("Non -Governmental Organizations (NGO)");
        invitingcompany_arraylist.add("International Organization");
        arrayAdaptercamponycategory = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_textview, invitingcompany_arraylist);
        sp_inviting_company_category.setAdapter(arrayAdaptercamponycategory);

    }
}