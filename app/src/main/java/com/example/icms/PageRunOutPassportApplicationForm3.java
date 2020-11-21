package com.example.icms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PageRunOutPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri;
    TextView pagerunoutpassidfilechooser, pagerunoutpassbirthcertificatefilechooser;
    Button pagerunoutpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_run_out_passport_application_form3);
        pagerunoutpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        pagerunoutpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        pagerunoutpassportappform4upload_btn = findViewById(R.id.pagerunoutappform4upload_btn);
        pagerunoutpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageRunOutPassportApplicationForm3.this, PageRunOutPassportApplicationForm4.class);
                startActivity(intent);
            }
        });

        pagerunoutpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });

        pagerunoutpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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