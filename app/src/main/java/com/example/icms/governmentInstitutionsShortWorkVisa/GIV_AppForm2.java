package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GIV_AppForm2 extends AppCompatActivity {
    Button GIV_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g_i_v__app_form2);
        GIV_appform2next_btn = findViewById(R.id.GIV_appform2next_btn);
        GIV_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GIV_AppForm2.this, GIV_AppForm.class);
                startActivity(intent);
            }
        });
    }
}