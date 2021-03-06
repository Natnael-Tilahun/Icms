package com.example.icms.touristVisaOnarrival;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TV_onarrival_AppForm2 extends AppCompatActivity {
    Button TV_onarrivalappform2next_btn;
    public Uri tvarrivaldatafileUri;
    TextView tvarrivalfilechooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_onarrival__app_form2);
        TV_onarrivalappform2next_btn = findViewById(R.id.TV_onarrivalappform2next_btn);
        tvarrivalfilechooser = findViewById(R.id.tvonlinefilechooser);

        tvarrivalfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }

        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("*/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select PDF file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            tvarrivalfilechooser.setText(path);
            //tvarrivalfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            // tvonlinefilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            tvarrivaldatafileUri = data.getData();

            TV_onarrivalappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(TV_onarrival_AppForm2.this, TV_onarrival_AppForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}