package com.example.icms.newpassport_process;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.icms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class NewPassport_Appointment extends AppCompatActivity {
    DatePicker newpassport_date_picker;
    TextView mornning_two_three_TV, afternoon_eight_nine_TV, mornning_three_four_TV, afternoon_ten_eleven_TV,
            morning_four_five_TV, afternoon_eleven_twelve_TV, mornning_five_six_TV, afternoon_nine_ten_TV, date_TV;
    Button newpassport_appointment_next_btn;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore mFirestore;

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

        newpassport_appointment_next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(NewPassport_Appointment.this, NewPassportApplicationForm2.class);
                startActivity(intent);
            }
        });

        //showpicker();
        date_TV = findViewById(R.id.date_TV);
        //newpassport_date_picker.setMaxDate(12);
//        int day=newpassport_date_picker.getDayOfMonth();
//        int month=newpassport_date_picker.getMonth();
//        int year=newpassport_date_picker.getYear();
//       date_TV.setText("date: "+day+"/"+ month+"/"+year);

    }


//    private void showpicker() {
//        newpassport_date_picker=new DatePickerDialog(this,this,
//            Calendar.getInstance().get(Calendar.YEAR),
//            Calendar.getInstance().get(Calendar.MONTH),
//            Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
//    }

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
}