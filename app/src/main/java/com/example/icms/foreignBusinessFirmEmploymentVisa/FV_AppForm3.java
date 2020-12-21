package com.example.icms.foreignBusinessFirmEmploymentVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class FV_AppForm3 extends AppCompatActivity {
    Button FV_appform3next_btn;
    public Uri fv_photouri, fv_passportcopyuri;
    TextView fv_photochooser, fv_passportcopychooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f_v__app_form3);
        FV_appform3next_btn = findViewById(R.id.FV_appform3next_btn);
        fv_photochooser = findViewById(R.id.fv_photochooser);
        fv_passportcopychooser = findViewById(R.id.fv_passportcopychooser);

        fv_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosephotofile();
            }
        });

        fv_passportcopychooser.setOnClickListener(new View.OnClickListener() {
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
            fv_photochooser.setText(path);
            fv_photouri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            fv_passportcopychooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            fv_passportcopyuri = data.getData();

        }
        FV_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());

                Intent intent = new Intent(FV_AppForm3.this, FV_AppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}