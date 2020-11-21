package com.example.icms.changeofpassportdata_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.android.material.card.MaterialCardView;

public class ChangeofPassDataApplicatioForm4 extends AppCompatActivity {
    MaterialCardView changeofpassdatapaywithcbebirr_cv, changeofpassdatapaywithcbe_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeof_pass_data_applicatio_form4);
        changeofpassdatapaywithcbebirr_cv = findViewById(R.id.changeofpassdatapaywithcbebirr_cv);
        changeofpassdatapaywithcbe_cv = findViewById(R.id.changeofpassdatapaywithcbe_cv);

        changeofpassdatapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeofPassDataApplicatioForm4.this, ChangeofPassDataPayWithCBEBirr.class);
                startActivity(intent);
            }
        });

        changeofpassdatapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeofPassDataApplicatioForm4.this, ChangeOfPassportDataPayWithCBE.class);
                startActivity(intent);
            }
        });

    }
}