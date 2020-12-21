package com.example.icms.ethiopianGovernmentEmploymentVisa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GV_AppForm4 extends AppCompatActivity {
    Button GV_appform4next_btn;
    public Uri gv_applicationletteruri;
    TextView gv_applicationletterchooser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_v__app_form4);
        GV_appform4next_btn = findViewById(R.id.GV_appform4next_btn);
        gv_applicationletterchooser = findViewById(R.id.gv_applicationletterchooser);

        gv_applicationletterchooser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                choosefile();
            }
        });
    }

    private void choosefile() {
        Intent intents = new Intent();
        intents.setType("*/*");
        intents.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intents, "Select PDF file"), 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable final Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {
            String path = data.getData().getPath();
            gv_applicationletterchooser.setText(path);
            gv_applicationletteruri = data.getData();
            //tv_arrival_photochooser.setText(data.getDataString().substring(data.getDataString().lastIndexOf("/") + 1));
        }
        GV_appform4next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uploadpdftofirestore(data.getData());
                Intent intent = new Intent(GV_AppForm4.this, GV_AppForm5.class);
                startActivity(intent);
            }
        });
    }

    private void Uploadpdftofirestore(Uri data) {
    }
}