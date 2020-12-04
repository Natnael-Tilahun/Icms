package com.example.icms.governmentInstitutionsShortWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class GovernmentInstitutionsShortWorkVisa_GIV extends AppCompatActivity {
    Button GIV_next_btn;
    EditText GIV_citizenship_ET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_government_institutions_short_work_visa__g_i_v);
        GIV_next_btn = findViewById(R.id.GIV_next_btn);
        GIV_citizenship_ET = findViewById(R.id.GIV_citizenship_ET);

        GIV_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String GIV_citizenship = GIV_citizenship_ET.getText().toString().trim();
        if (GIV_citizenship.isEmpty()) {
            GIV_citizenship_ET.setError("Please insert your CitizenShip!");
            GIV_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(GovernmentInstitutionsShortWorkVisa_GIV.this, GIV_AppForm2.class);
            startActivity(intent);
        }
    }
}