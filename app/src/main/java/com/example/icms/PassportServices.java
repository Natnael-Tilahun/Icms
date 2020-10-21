package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PassportServices extends AppCompatActivity {
    Button newpassport_btn, renewpassport_btn, lostpassport_btn;

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
        renewpassport_btn = findViewById(R.id.renewpassport_btn);
        lostpassport_btn = findViewById(R.id.lostpassport_btn);

        newpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, NewPassport.class);
                startActivity(intent);
            }
        });

        renewpassport_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PassportServices.this, RenewPassport.class);
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
    }

}