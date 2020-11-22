package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class VisaServices extends AppCompatActivity {
    Button touristvisaonline_btn, touristvisaonarrival_btn, confrencevisa_btn, investmentvisa_btn,
            foreignbnessfirmempvisa_btn, journalistvisa_btn, ethiopianprivatebnessfirmworkvisa_btn,
            internationalorgworkvisa_btn, govinstitutionshortworkvisa_btn, ngoworkvisa_btn, ethiopiangovempvisa_btn;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visa_services);
//        ActionBar actionBar = getSupportActionBar();
        touristvisaonline_btn = findViewById(R.id.touristvisaonline_btn);
        touristvisaonarrival_btn = findViewById(R.id.touristvisaonarrival_btn);
        confrencevisa_btn = findViewById(R.id.confrencevisa_btn);
        investmentvisa_btn = findViewById(R.id.investmentvisa_btn);
        foreignbnessfirmempvisa_btn = findViewById(R.id.foreign_business_firm_employment_visa_btn);
        journalistvisa_btn = findViewById(R.id.journalistvisa_btn);
        ethiopianprivatebnessfirmworkvisa_btn = findViewById(R.id.ethiopian_private_business_firm_work_visa_btn);
        internationalorgworkvisa_btn = findViewById(R.id.international_organization_work_visa_btn);
        govinstitutionshortworkvisa_btn = findViewById(R.id.government_institutions_short_work_visa_btn);
        ngoworkvisa_btn = findViewById(R.id.ngo_work_visa_btn);
        ethiopiangovempvisa_btn = findViewById(R.id.ethiopian_government_employment_Visa_btn);

        touristvisaonline_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, TouristVisa_online.class);
                startActivity(intent);
            }
        });
        touristvisaonarrival_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, TouristVisa_onArrival.class);
                startActivity(intent);
            }
        });
        confrencevisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, ConfrenceVisa.class);
                startActivity(intent);
            }
        });
        investmentvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, InvestmentVisa.class);
                startActivity(intent);
            }
        });
        foreignbnessfirmempvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, ForeignBusinessFIrmEmploymentVisa_FV.class);
                startActivity(intent);
            }
        });
        journalistvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, JournalistVisa.class);
                startActivity(intent);
            }
        });
        ethiopianprivatebnessfirmworkvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, EthiopianPrivateBusinessFirmWorkVisa_PE.class);
                startActivity(intent);
            }
        });
        internationalorgworkvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, InternationalOrganizationWorkVisa_RI.class);
                startActivity(intent);
            }
        });
        govinstitutionshortworkvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, GovernmentInstitutionsShortWorkVisa_GIV.class);
                startActivity(intent);
            }
        });
        ngoworkvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, NGOWorkVisa_NGO.class);
                startActivity(intent);
            }
        });
        ethiopiangovempvisa_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(VisaServices.this, EthiopianGovernmentEmploymentVisa_GV.class);
                startActivity(intent);
            }
        });

//        actionBar.setTitle("Visa Services");
//        actionBar.setDisplayShowHomeEnabled(true);
//        actionBar.setDisplayHomeAsUpEnabled(true);

    }
}