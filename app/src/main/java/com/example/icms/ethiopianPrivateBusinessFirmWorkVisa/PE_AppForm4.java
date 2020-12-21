package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class PE_AppForm4 extends AppCompatActivity {
    Button PE_appform4next_btn;
    public Uri pe_applicationletteruri, pe_tincertificateuri, pe_bissinesslicenceuri, pe_employmentcontractagrrementuri;
    TextView pe_applicationletterchooser, pe_tincertificatechooser, pe_bissinesslicencechooser, pe_employmentcontractagrrementchooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form4);
        PE_appform4next_btn = findViewById(R.id.PE_appform4next_btn);

        pe_applicationletterchooser = findViewById(R.id.pe_applicationletterchooser);
        pe_tincertificatechooser = findViewById(R.id.pe_tincertificatechooser);
        pe_bissinesslicencechooser = findViewById(R.id.pe_bissinesslicencechooser);
        pe_employmentcontractagrrementchooser = findViewById(R.id.pe_employmentcontractagrrementchooser);

        pe_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseapplicationletterfile();
            }
        });

        pe_tincertificatechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosetincertificatefile();
            }
        });
        pe_bissinesslicencechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosebussinesslicencefile();
            }
        });
        pe_employmentcontractagrrementchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseemploymentcontractagrrementfile();
            }
        });
    }

    private void chooseapplicationletterfile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosetincertificatefile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 2);
    }

    private void choosebussinesslicencefile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 3);
    }

    private void chooseemploymentcontractagrrementfile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 4);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            pe_applicationletterchooser.setText(path);
            pe_applicationletteruri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            pe_tincertificatechooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pe_tincertificateuri = data.getData();

        }
        if (requestCode == 3 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path2 = data.getData().getPath();
            pe_bissinesslicencechooser.setText(path2);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pe_bissinesslicenceuri = data.getData();

        }
        if (requestCode == 4 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path3 = data.getData().getPath();
            pe_employmentcontractagrrementchooser.setText(path3);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pe_employmentcontractagrrementuri = data.getData();

        }
        PE_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());

                Intent intent = new Intent(PE_AppForm4.this, PE_AppForm5.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}