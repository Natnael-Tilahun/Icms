package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.changeofpassportdata_process.ChangeOfPassportData;
import com.example.icms.damagedpassport_process.DamagedPassport;
import com.example.icms.expiredpassport_process.ExpiredPassport;
import com.example.icms.lostpassport_process.LostPassport;
import com.example.icms.newpassport_process.NewPassport;
import com.example.icms.pagerunoutpassport_process.PageRunOutPassport;
import com.example.icms.urgentpassport_process.UrgentPassport;

public class PassportServices extends AppCompatActivity {
    Button newpassport_btn, expiredpassport_btn, pagerunoutpassport_btn, damagedpassport_btn, lostpassport_btn, changeofpassportdata_btn, validpassport_btn, urgentpassport_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passport_services);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("passport services");

        assert actionBar != null;
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        newpassport_btn = findViewById(R.id.newpassport_btn);
        expiredpassport_btn = findViewById(R.id.expiredpassport_btn);
        pagerunoutpassport_btn = findViewById(R.id.passport_page_runout_btn);
        damagedpassport_btn = findViewById(R.id.damaged_passport_btn);
        lostpassport_btn = findViewById(R.id.lostpassport_btn);
        changeofpassportdata_btn = findViewById(R.id.change_of_passport_data_btn);
//        validpassport_btn=findViewById(R.id.valid_passport_btn);
        urgentpassport_btn = findViewById(R.id.urgent_passport_btn);

        newpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, NewPassport.class);
                startActivity(intent);
            }
        });

        expiredpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, ExpiredPassport.class);
                startActivity(intent);
            }
        });
        pagerunoutpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, PageRunOutPassport.class);
                startActivity(intent);
            }
        });
        damagedpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, DamagedPassport.class);
                startActivity(intent);
            }
        });
        lostpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inetent = new Intent(PassportServices.this, LostPassport.class);
                startActivity(inetent);
            }
        });
        changeofpassportdata_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, ChangeOfPassportData.class);
                startActivity(intent);
            }
        });
//        validpassport_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(PassportServices.this, ValidPassport.class);
//                startActivity(intent);
//            }
//        });
        urgentpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, UrgentPassport.class);
                startActivity(intent);
            }
        });
    }

}