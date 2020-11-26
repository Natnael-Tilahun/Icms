package com.example.icms.ethiopianPrivateBusinessFirmWorkVisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.icms.R;

public class PE_AppForm5 extends AppCompatActivity {
    CardView PE_visapaywithcbe_cv, PE_visapaywithcbebirr_cv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_e__app_form5);
        PE_visapaywithcbe_cv = findViewById(R.id.PE_visapaywithcbe_cv);
        PE_visapaywithcbebirr_cv = findViewById(R.id.PE_visapaywithcbebirr_cv);
        PE_visapaywithcbe_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PE_AppForm5.this, PE_visapaywithcbe.class);
                startActivity(intent);
            }
        });

        PE_visapaywithcbebirr_cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PE_AppForm5.this, PE_visapaywithcbe.class);
                startActivity(intent);
            }
        });
    }
}