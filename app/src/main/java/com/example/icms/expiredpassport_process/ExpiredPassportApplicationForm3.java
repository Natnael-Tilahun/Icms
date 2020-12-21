package com.example.icms.expiredpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ExpiredPassportApplicationForm3 extends AppCompatActivity {
    public Uri expiredpassidfileuri, expiredpassbdcertificatefileuri;
    TextView expiredpassidfilechooser, expiredpassbirthcertificatefilechooser;
    Button expiredpassportappform4upload_btn;
    EditText expiredpassport_oldpassportno_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expired_passport_application_form3);
        expiredpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        expiredpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        expiredpassportappform4upload_btn = findViewById(R.id.expiredpassupload_btn);
        expiredpassport_oldpassportno_ET = findViewById(R.id.expiredpassport_oldpassportno_ET);

        expiredpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidFile();
            }
        });

        //new passport birth certificate chooser textview
        expiredpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            expiredpassidfilechooser.setText(path);
            expiredpassidfileuri = data.getData();
            //expiredpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            expiredpassbirthcertificatefilechooser.setText(path1);
            expiredpassbdcertificatefileuri = data.getData();
            //expiredpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        expiredpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                checkform();

            }
        });
    }

    private void checkform() {
        String expiredpassport_oldpassportno_ET1 = expiredpassport_oldpassportno_ET.getText().toString().trim();
        if (expiredpassport_oldpassportno_ET1.isEmpty()) {
            expiredpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            expiredpassport_oldpassportno_ET.requestFocus();
        } else {
            Intent intent = new Intent(ExpiredPassportApplicationForm3.this, ExpiredPassportApplicationForm4.class);
            startActivity(intent);
        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}