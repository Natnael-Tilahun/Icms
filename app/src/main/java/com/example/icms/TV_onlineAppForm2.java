package com.example.icms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class TV_onlineAppForm2 extends AppCompatActivity {
    Button TV_online_appform2next_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_v_online_app_form2);
        TV_online_appform2next_btn = findViewById(R.id.TV_online_appform2next_btn);
        TV_online_appform2next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TV_onlineAppForm2.this, TV_online_AppForm3.class);
                startActivity(intent);
            }
        });
    }
}