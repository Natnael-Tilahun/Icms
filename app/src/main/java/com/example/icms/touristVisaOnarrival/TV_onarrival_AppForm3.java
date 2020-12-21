package com.example.icms.touristVisaOnarrival;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.MainActivity;
import com.example.icms.R;

public class TV_onarrival_AppForm3 extends AppCompatActivity {
    Button TV_onarrival_appform3next_btn;
    public Uri tvarrivalphotofileuri, tvarrivalpassportcopyuri;
    TextView tvarrivalpassportcopychooser, tv_arrival_photochooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_onarrival__app_form3);
        TV_onarrival_appform3next_btn = findViewById(R.id.TV_onarrival_appform3submit_btn);
        tvarrivalpassportcopychooser = findViewById(R.id.tvarrivalpassportcopychooser);
        tv_arrival_photochooser = findViewById(R.id.TV_arrival_photochooser);

        tv_arrival_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseidfile();
            }
        });

        tvarrivalpassportcopychooser.setOnClickListener(new View.OnClickListener() {
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
            tv_arrival_photochooser.setText(path);
            tvarrivalphotofileuri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path1 = data.getData().getPath();
            tvarrivalpassportcopychooser.setText(path1);
            //tvarrivalpassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            tvarrivalpassportcopyuri = data.getData();

        }
        TV_onarrival_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());

                Toast.makeText(TV_onarrival_AppForm3.this, "Successfully Submitted!", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(TV_onarrival_AppForm3.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}