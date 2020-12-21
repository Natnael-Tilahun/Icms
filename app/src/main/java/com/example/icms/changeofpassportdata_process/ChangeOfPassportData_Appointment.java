package com.example.icms.changeofpassportdata_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;

public class ChangeOfPassportData_Appointment extends AppCompatActivity {
    Button changeofpassportdata_appointment_next_btn;
    DatePicker changeofpassportdata_date_picker;
    TextView mornning_two_three_TV, afternoon_eight_nine_TV, mornning_three_four_TV, afternoon_ten_eleven_TV,
            morning_four_five_TV, afternoon_eleven_twelve_TV, mornning_five_six_TV, afternoon_nine_ten_TV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_of_passport_data__appointment);
        changeofpassportdata_date_picker = findViewById(R.id.changeofpassportdata_date_picker);
        changeofpassportdata_appointment_next_btn = findViewById(R.id.changeofpassportdata_appointment_next_btn);
        mornning_two_three_TV = findViewById(R.id.mornning_two_three_TV);
        mornning_three_four_TV = findViewById(R.id.mornning_three_four_TV);
        morning_four_five_TV = findViewById(R.id.morning_four_five_TV);
        mornning_five_six_TV = findViewById(R.id.mornning_five_six_TV);
        afternoon_eight_nine_TV = findViewById(R.id.afternoon_eight_nine_TV);
        afternoon_ten_eleven_TV = findViewById(R.id.afternoon_ten_eleven_TV);
        afternoon_eleven_twelve_TV = findViewById(R.id.afternoon_eleven_twelve_TV);
        afternoon_nine_ten_TV = findViewById(R.id.afternoon_nine_ten_TV);
        changeofpassportdata_appointment_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ChangeOfPassportData_Appointment.this, ChangeOfPassDataApplicationForm2.class);
                startActivity(intent);
            }
        });
    }
}