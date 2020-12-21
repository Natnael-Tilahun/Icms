package com.example.icms.newpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NewPassportApplicationForm3 extends AppCompatActivity {
    public Uri idfileuri, bdcertificatefileuri;
    TextView newpassidfilechooser, newpassbirthcertificatefilechooser;
    Button newpassportappform4upload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form3);
        newpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        newpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        newpassportappform4upload_btn = findViewById(R.id.newpassappform4upload_btn);

        //new passport id file chooser
        newpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidFile();
            }
        });

        //new passport birth certificate chooser textview
        newpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebirthcertificateFile();
            }
        });
    }

    private void chooseidFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1);
    }

    private void choosebirthcertificateFile() {
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
            newpassidfilechooser.setText(path);
            idfileuri = data.getData();
            //newpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            // newpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            newpassbirthcertificatefilechooser.setText(path1);
            bdcertificatefileuri = data.getData();
            //newpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            //newpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        newpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(NewPassportApplicationForm3.this, NewPassportApplicationForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}