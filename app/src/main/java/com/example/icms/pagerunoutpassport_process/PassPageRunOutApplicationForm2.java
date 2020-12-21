package com.example.icms.pagerunoutpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class PassPageRunOutApplicationForm2 extends AppCompatActivity {
    public Uri pagerunoutfileUri;
    TextView pagerunoutpassfilechooser;
    Button pagerunoutpassappform2next_btn, passpagerunout_download_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pass_page_run_out_application_form2);
        pagerunoutpassfilechooser = findViewById(R.id.newpassfilechooser);
        pagerunoutpassappform2next_btn = findViewById(R.id.pagerunoutappform2next_btn);
        passpagerunout_download_btn = findViewById(R.id.passpagerunout_download_btn);

        pagerunoutpassfilechooser.setOnClickListener(new View.OnClickListener() {
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
            String path1 = data.getData().getPath();
            pagerunoutpassfilechooser.setText(path1);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            //pagerunoutpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            pagerunoutfileUri = data.getData();
            pagerunoutpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(PassPageRunOutApplicationForm2.this, PageRunOutPassportApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}