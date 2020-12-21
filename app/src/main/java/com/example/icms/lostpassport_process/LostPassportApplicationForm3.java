package com.example.icms.lostpassport_process;

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

public class LostPassportApplicationForm3 extends AppCompatActivity {
    public Uri lostpassidfileuri, lostpassbdcertificateuri;
    TextView lostpassidfilechooser, lostpassbirthcertificatefilechooser;
    Button lostpassportappform4upload_btn;
    EditText lostpassport_oldpassportno_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost_passport_application_form3);

        lostpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        lostpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        lostpassportappform4upload_btn = findViewById(R.id.lostpassupload_btn);
        lostpassport_oldpassportno_ET = findViewById(R.id.lostpassport_oldpassportno_ET);

        lostpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });
        lostpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            lostpassidfilechooser.setText(path);
            //lostpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            lostpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            lostpassbirthcertificatefilechooser.setText(path1);
            // lostpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            lostpassbdcertificateuri = data.getData();
        }
        lostpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                checkform();
            }
        });
    }

    private void checkform() {
        String lostpassport_oldpassportno_ET1 = lostpassport_oldpassportno_ET.getText().toString().trim();
        if (lostpassport_oldpassportno_ET1.isEmpty()) {
            lostpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            lostpassport_oldpassportno_ET.requestFocus();
        } else {
            Intent intent = new Intent(LostPassportApplicationForm3.this, LostPassportApplicationForm4.class);
            startActivity(intent);
        }
    }


    private void Uploadpdftofirestore(Uri data) {

    }
}