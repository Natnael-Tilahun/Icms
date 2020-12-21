package com.example.icms.changeofpassportdata_process;

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

public class ChangePassportDataApplicationForm3 extends AppCompatActivity {
    public Uri changeofpassdataidfileuri, changeofpassdatabdcertificateuri;
    TextView changeofpassdataidfilechooser, changeofpassdatabirthcertificatefilechooser;
    Button changeofpassportdataappform3upload_btn;
    EditText changeofpassdata_oldpassportno_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_passport_data_application_form3);
        changeofpassdataidfilechooser = findViewById(R.id.newpassidfilechooser);
        changeofpassdatabirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        changeofpassportdataappform3upload_btn = findViewById(R.id.changeofpassdataupload_btn);
        changeofpassdata_oldpassportno_ET = findViewById(R.id.changeofpassdata_oldpassportno_ET);

        changeofpassdataidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        changeofpassdatabirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            changeofpassdataidfilechooser.setText(path);
            //changeofpassdataidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            changeofpassdataidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            changeofpassdatabirthcertificatefilechooser.setText(path1);
            //changeofpassdatabirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            changeofpassdatabdcertificateuri = data.getData();
        }
        changeofpassportdataappform3upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                checkform();
            }
        });
    }

    private void checkform() {
        String changeofpassdata_oldpassportno_ET1 = changeofpassdata_oldpassportno_ET.getText().toString().trim();
        if (changeofpassdata_oldpassportno_ET1.isEmpty()) {
            changeofpassdata_oldpassportno_ET.setError("Please insert your old password Number!");
            changeofpassdata_oldpassportno_ET.requestFocus();
        } else {
            Intent intent = new Intent(ChangePassportDataApplicationForm3.this, ChangeofPassDataApplicatioForm4.class);
            startActivity(intent);
        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}