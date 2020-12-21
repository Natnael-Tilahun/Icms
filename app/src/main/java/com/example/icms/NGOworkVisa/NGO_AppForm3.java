package com.example.icms.NGOworkVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NGO_AppForm3 extends AppCompatActivity {
    Button NGO_appform3next_btn;
    public Uri ngo_photouri, ngo_passportcopyuri;
    TextView ngo_photochooser, ngo_passportcopychooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o__app_form3);
        NGO_appform3next_btn = findViewById(R.id.NGO_appform3next_btn);
        ngo_photochooser = findViewById(R.id.ngo_photochooser);
        ngo_passportcopychooser = findViewById(R.id.ngo_passportcopychooser);

        ngo_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosphotofile();
            }
        });

        ngo_passportcopychooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosepassportcopyfile();
            }
        });
    }

    private void choosphotofile() {
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
            ngo_photochooser.setText(path);
            ngo_photouri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            ngo_passportcopychooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            ngo_passportcopyuri = data.getData();

        }
        NGO_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(NGO_AppForm3.this, NGO_AppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}