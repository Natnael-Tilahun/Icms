package com.example.icms.newpassport_process;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NewPassportApplicationForm2 extends AppCompatActivity {
    public Uri fileUri;
    TextView newpassfilechooser;
    Button newpassappform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport_application_form2);
        newpassfilechooser = findViewById(R.id.newpassfilechooser);
        newpassappform2next_btn = findViewById(R.id.newpassappform2next_btn);
        newpassappform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassportApplicationForm2.this, NewPassportApplicationForm3.class);
                startActivity(intent);
            }
        });
        newpassfilechooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }

        });
    }

    private void chooseFile() {
        Intent intent = new Intent();
        intent.setType("pdf/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            fileUri = data.getData();
        }
    }
}