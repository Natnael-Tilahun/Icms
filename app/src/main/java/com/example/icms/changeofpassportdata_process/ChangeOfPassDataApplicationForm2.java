package com.example.icms.changeofpassportdata_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ChangeOfPassDataApplicationForm2 extends AppCompatActivity {
    public Uri changeofpassdatafileUri;
    TextView changeofpassdatafilechooser;
    Button changeofpassdataappform2next_btn, changeofpassdatadownload_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_of_pass_data_application_form2);
        changeofpassdatafilechooser = findViewById(R.id.newpassfilechooser);
        changeofpassdataappform2next_btn = findViewById(R.id.changeofpassdataappform2next_btn);
        changeofpassdatadownload_btn = findViewById(R.id.changeofpassdatadownload_btn);

        changeofpassdatafilechooser.setOnClickListener(new View.OnClickListener() {
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
            changeofpassdatafilechooser.setText(path);
            //newpassfilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")+1));
            //changeofpassdatafilechooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/")));
            changeofpassdatafileUri = data.getData();
            changeofpassdataappform2next_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uploadpdftofirestore(data.getData());
                    Intent intent = new Intent(ChangeOfPassDataApplicationForm2.this, ChangePassportDataApplicationForm3.class);
                    startActivity(intent);
                }
            });

        }
    }

    private void Uploadpdftofirestore(Uri data) {

    }
}

