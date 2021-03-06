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

public class PE_AppForm3 extends AppCompatActivity {
    Button PE_appform3next_btn;
    public Uri pe_photouri, pe_passportcopyuri;
    TextView pe_photochooser, pe_passportcopychooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form3);
        PE_appform3next_btn = findViewById(R.id.PE_appform3next_btn);
        pe_photochooser = findViewById(R.id.pe_photochooser);
        pe_passportcopychooser = findViewById(R.id.pe_passportcopychooser);

        pe_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosephotofile();
            }
        });

        pe_passportcopychooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosepassportcopyfile();
            }
        });
    }

    private void choosephotofile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosepassportcopyfile() {
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
            pe_photochooser.setText(path);
            pe_photouri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            pe_passportcopychooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            pe_passportcopyuri = data.getData();

        }
        PE_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());

                Intent intent = new Intent(PE_AppForm3.this, PE_AppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}