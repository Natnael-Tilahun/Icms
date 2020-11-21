package com.example.icms.changeofpassportdata_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ChangePassportDataApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView changeofpassdataidfilechooser, changeofpassdatabirthcertificatefilechooser;
    Button changeofpassportdataappform3upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passport_data_application_form3);
        changeofpassdataidfilechooser = findViewById(R.id.newpassidfilechooser);
        changeofpassdatabirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        changeofpassportdataappform3upload_btn = findViewById(R.id.changeofpassdataupload_btn);

        changeofpassportdataappform3upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangePassportDataApplicationForm3.this, ChangeofPassDataApplicatioForm4.class);
                startActivity(intent);
            }
        });

        changeofpassdataidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
        changeofpassdatabirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
    }

    private void choosefile() {
        Intent intent = new Intent();
        intent.setType("pdf/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}