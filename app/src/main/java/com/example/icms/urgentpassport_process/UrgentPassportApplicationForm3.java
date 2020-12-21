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
    public Uri urgentpassidfileuri, urgentpassbdcertificateuri;
    TextView urgentpassidfilechooser, urgentpassbirthcertificatefilechooser;
    Button urgentpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urgent_passport_application_form3);
        urgentpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        urgentpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        urgentpassportappform4upload_btn = findViewById(R.id.urgentpassappform4upload_btn);

        urgentpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        urgentpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebdcertificatefile();
            }
        });
    }

    private void chooseidfile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosebdcertificatefile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            urgentpassidfilechooser.setText(path);
            //urgentpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            urgentpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            urgentpassbirthcertificatefilechooser.setText(path1);
            //urgentpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            urgentpassbdcertificateuri = data.getData();
        }
        urgentpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(UrgentPassportApplicationForm3.this, UrgentPassportAppliacationForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}