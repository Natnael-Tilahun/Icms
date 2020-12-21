package com.example.icms.pagerunoutpassport_process;

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

public class PageRunOutPassportApplicationForm3 extends AppCompatActivity {
    public Uri pagerunoutpassidfileuri, pagerunoutbdcertificateuri;
    TextView pagerunoutpassidfilechooser, pagerunoutpassbirthcertificatefilechooser;
    Button pagerunoutpassportappform4upload_btn;
    EditText pagerunoutpassport_oldpassportno_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_run_out_passport_application_form3);
        pagerunoutpassidfilechooser = findViewById(R.id.newpassidfilechooser);
        pagerunoutpassbirthcertificatefilechooser = findViewById(R.id.newpassportbirthcertificatefilechooser);
        pagerunoutpassportappform4upload_btn = findViewById(R.id.pagerunoutappform4upload_btn);
        pagerunoutpassport_oldpassportno_ET = findViewById(R.id.pagerunoutpassport_oldpassportno_ET);

        pagerunoutpassidfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        pagerunoutpassbirthcertificatefilechooser.setOnClickListener(new View.OnClickListener() {
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
            pagerunoutpassidfilechooser.setText(path);
            //pagerunoutpassidfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pagerunoutpassidfileuri = data.getData();
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            pagerunoutpassbirthcertificatefilechooser.setText(path1);
            //pagerunoutpassbirthcertificatefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pagerunoutbdcertificateuri = data.getData();
        }
        pagerunoutpassportappform4upload_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                checkform();
            }
        });
    }

    private void checkform() {
        String pagerunoutpassport_oldpassportno_ET1 = pagerunoutpassport_oldpassportno_ET.getText().toString().trim();
        if (pagerunoutpassport_oldpassportno_ET1.isEmpty()) {
            pagerunoutpassport_oldpassportno_ET.setError("Please insert your old password Number!");
            pagerunoutpassport_oldpassportno_ET.requestFocus();
        } else {
            Intent intent = new Intent(PageRunOutPassportApplicationForm3.this, PageRunOutPassportApplicationForm4.class);
            startActivity(intent);
        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}