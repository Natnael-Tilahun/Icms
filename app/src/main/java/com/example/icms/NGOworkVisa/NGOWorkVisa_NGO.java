package com.example.icms.NGOworkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class NGOWorkVisa_NGO extends AppCompatActivity {
    Button NGO_next_btn;
    EditText NGO_citizenship_ET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n_g_o_work_visa__n_g_o);
        NGO_next_btn = findViewById(R.id.NGO_next_btn);
        NGO_citizenship_ET = findViewById(R.id.NGO_citizenship_ET);

        NGO_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
    }

    private void checkform() {
        String NGO_citizenship = NGO_citizenship_ET.getText().toString().trim();
        if (NGO_citizenship.isEmpty()) {
            NGO_citizenship_ET.setError("Please insert your CitizenShip!");
            NGO_citizenship_ET.requestFocus();
        } else {
            Intent intent = new Intent(NGOWorkVisa_NGO.this, NGO_AppForm2.class);
            startActivity(intent);
        }
    }
}