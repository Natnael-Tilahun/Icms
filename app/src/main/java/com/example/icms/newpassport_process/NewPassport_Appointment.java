package com.example.icms.newpassport_process;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewPassport_Appointment extends AppCompatActivity implements View.OnClickListener {
    DatePicker newpassport_date_picker;
    TextView mornning_two_three_TV, afternoon_eight_nine_TV, mornning_three_four_TV, afternoon_ten_eleven_TV,
            morning_four_five_TV, afternoon_eleven_twelve_TV, mornning_five_six_TV, afternoon_nine_ten_TV, date_TV, time_TV;
    Button newpassport_appointment_next_btn;
    String site, city, office, delivery;
    String appointment_date, appintment_time;
    int time;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore mFirestore;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_passport__appointment);
        newpassport_date_picker = findViewById(R.id.newpassport_date_picker);
        newpassport_appointment_next_btn = findViewById(R.id.newpassport_appointment_next_btn);
        mornning_two_three_TV = findViewById(R.id.mornning_two_three_TV);
        mornning_three_four_TV = findViewById(R.id.mornning_three_four_TV);
        morning_four_five_TV = findViewById(R.id.morning_four_five_TV);
        mornning_five_six_TV = findViewById(R.id.mornning_five_six_TV);
        afternoon_eight_nine_TV = findViewById(R.id.afternoon_eight_nine_TV);
        afternoon_ten_eleven_TV = findViewById(R.id.afternoon_ten_eleven_TV);
        afternoon_eleven_twelve_TV = findViewById(R.id.afternoon_eleven_twelve_TV);
        afternoon_nine_ten_TV = findViewById(R.id.afternoon_nine_ten_TV);
        date_TV = findViewById(R.id.date_TV);
        time_TV = findViewById(R.id.time_TV);


        mornning_two_three_TV.setOnClickListener(this);
        mornning_three_four_TV.setOnClickListener(this);
        morning_four_five_TV.setOnClickListener(this);
        mornning_five_six_TV.setOnClickListener(this);
        afternoon_eight_nine_TV.setOnClickListener(this);
        afternoon_nine_ten_TV.setOnClickListener(this);
        afternoon_ten_eleven_TV.setOnClickListener(this);
        afternoon_eleven_twelve_TV.setOnClickListener(this);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            site = extras.getString("site");
            city = extras.getString("city");
            office = extras.getString("office");
            delivery = extras.getString("delivery");
        }

        // final String date=newpassport_date_picker.getDayOfMonth()+"-"+newpassport_date_picker.getMonth()+"-"+newpassport_date_picker.getYear();
        //date_TV.setText(date);

        newpassport_date_picker.setOnDateChangedListener(new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                date_TV.setText("Your Date : " + i2 + "/" + i1 + "/" + i);
                appointment_date = date_TV.getText().toString();
            }
        });
        newpassport_appointment_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String appointment_time=String.valueOf(time);
                Intent intent = new Intent(NewPassport_Appointment.this, NewPassportApplicationForm2.class);
                intent.putExtra("site", site);
                intent.putExtra("city", city);
                intent.putExtra("office", office);
                intent.putExtra("delivery", delivery);
                intent.putExtra("appointment_date", appointment_date);
                intent.putExtra("appintment_time", appintment_time);
                startActivity(intent);
            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.mornning_two_three_TV) {
            time = 2;
            //mornning_two_three_TV.setBackgroundColor(getColor(R.color.black));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.mornning_three_four_TV) {
            time = 3;
            //mornning_three_four_TV.setBackgroundColor(getColor(R.color.black));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.morning_four_five_TV) {
            time = 4;
            //morning_four_five_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.mornning_five_six_TV) {
            time = 5;
            //mornning_five_six_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.afternoon_eight_nine_TV) {
            time = 8;
            //afternoon_eight_nine_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.afternoon_nine_ten_TV) {
            time = 9;
            //afternoon_nine_ten_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.afternoon_ten_eleven_TV) {
            time = 10;
            //afternoon_ten_eleven_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        } else if (view.getId() == R.id.afternoon_eleven_twelve_TV) {
            time = 11;
            //afternoon_eleven_twelve_TV.setBackgroundColor(getColor(R.color.secondarytheme2));
            time_TV.setText("Your Time : " + time + " O'clock");
            appintment_time = String.valueOf(time);
        }
    }
}


//    private void addingDatasToFirestore() {
////        String site = sp_site.getSelectedItem().toString();
////        String city = sp_city.getSelectedItem().toString();
////        String office = sp_office.getSelectedItem().toString();
////        String deliverysite = sp_deliverysite.getSelectedItem().toString();
//        mFirebaseAuth = FirebaseAuth.getInstance();
//        mFirestore = FirebaseFirestore.getInstance();
//        String userID = (mFirebaseAuth.getCurrentUser()).getUid();
//        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
//        Map<String, String> userdata = new HashMap<>();
//        userdata.put("UserID", userID);
//        userdata.put("Select Site", site);
//        userdata.put("Select City", city);
//        userdata.put("Select Office", office);
//        userdata.put("Delivery Site", deliverysite);
////        userdata.put("Appointment Date", "+deliverysite");
////        userdata.put("Completed Form", "form.pdf");
////        userdata.put("Legal ID", "id.jpg");
////        userdata.put("Birth Certificate", "bdcertificate.pdf");
//        mFirestore.collection("Service").document("PassportService").collection("New Passport").document().set(userdata).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if (task.isSuccessful()) {
//                    Toast.makeText(NewPassport_Appointment.this, "Document Successfully submitted", Toast.LENGTH_LONG).show();
//                    Intent intent = new Intent(NewPassport_Appointment.this, NewPassportApplicationForm2.class);
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(NewPassport_Appointment.this, "Error:" + task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//    }
