package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.passportrequirement_recyclerview.PassportRequirement;
import com.example.icms.servicefees_recyclerview.ServiceFees;
import com.example.icms.visarequirement_recyclerview.VisaRequirements;

public class GetInformation extends AppCompatActivity {
    Button passrequirements_btn, visarequirements_btn, servicefees_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_information);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Get Information");
        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        passrequirements_btn = findViewById(R.id.passrequirements_btn);
        visarequirements_btn = findViewById(R.id.visarequiremnets_btn);
        servicefees_btn = findViewById(R.id.servicefees_btn);

        passrequirements_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetInformation.this, PassportRequirement.class);
                startActivity(intent);
            }
        });
        visarequirements_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetInformation.this, VisaRequirements.class);
                startActivity(intent);
            }
        });
        servicefees_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GetInformation.this, ServiceFees.class);
                startActivity(intent);
            }
        });

    }
}