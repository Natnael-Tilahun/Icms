package com.example.icms.touristVisaOnline;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class TV_online_AppForm3 extends AppCompatActivity {
    Button TV_online_appform3next_btn;
    public Uri tvonlinephotofileuri, tvonlinepassportcopyuri;
    TextView tvonlinepassportcopychooser, TV_online_photochooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online__app_form3);
        TV_online_appform3next_btn = findViewById(R.id.TV_online_appform3next_btn);
        tvonlinepassportcopychooser = findViewById(R.id.tvonlinepassportcopychooser);
        TV_online_photochooser = findViewById(R.id.TV_online_photochooser);

        TV_online_photochooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosephoto();
            }
        });

        tvonlinepassportcopychooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosepassportcopy();
            }
        });
    }

    private void choosephoto() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    private void choosepassportcopy() {
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
            TV_online_photochooser.setText(path);
            //TV_online_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            tvonlinephotofileuri = data.getData();

        }
        if (requestCode == 2 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            tvonlinepassportcopychooser.setText(path);
            //tvonlinepassportcopychooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
            tvonlinepassportcopyuri = data.getData();
        }
        TV_online_appform3next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(TV_online_AppForm3.this, TV_onlineAppForm4.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}