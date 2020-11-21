package com.example.icms.urgentpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class UrgentPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView urgentpassidfilechooser, urgentpassbirthcertificatefilechooser;
    Button urgentpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_passport_application_form3);
        urgentpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        urgentpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        urgentpassportappform4upload_btn = findViewById(R.id.urgentpassappform4upload_btn);
        urgentpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UrgentPassportApplicationForm3.this, UrgentPassportAppliacationForm4.class);
                startActivity(intent);
            }
        });

        urgentpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
        urgentpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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