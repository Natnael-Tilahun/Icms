package com.example.icms.damagedpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class DamagedPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView damagedpassidfilechooser, damagedpassbirthcertificatefilechooser;
    Button damagedpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_damaged_passport_application_form3);
        damagedpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        damagedpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        damagedpassportappform4upload_btn = findViewById(R.id.damagedpassupload_btn);
        damagedpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DamagedPassportApplicationForm3.this, DamagedPassportApplicatonForm4.class);
                startActivity(intent);
            }
        });

        damagedpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });

        damagedpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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