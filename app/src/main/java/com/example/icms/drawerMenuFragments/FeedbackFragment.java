package com.example.icms.drawerMenuFragments;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.icms.MainActivity;
import com.example.icms.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FeedbackFragment extends Fragment {
    EditText feedback_fullname_ET, feedback_phone_ET, feedback_email_ET, feedback_feedback_ET;
    Button feedback_submit_btn;

    public FeedbackFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_feedback, container, false);
        feedback_fullname_ET = v.findViewById(R.id.feedback_fullname_ET);
        feedback_phone_ET = v.findViewById(R.id.feedback_phone_ET);
        feedback_email_ET = v.findViewById(R.id.feedback_email_ET);
        feedback_feedback_ET = v.findViewById(R.id.feedback_feedback_ET);
        feedback_submit_btn = v.findViewById(R.id.feedback_submit_btn);
        feedback_submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkform();
            }
        });
        return v;
    }

    private void checkform() {
        String fullname = feedback_fullname_ET.getText().toString();
        String phone = feedback_phone_ET.getText().toString();
        String email = feedback_email_ET.getText().toString();
        String feedback = feedback_feedback_ET.getText().toString();

        if (fullname.isEmpty()) {
            feedback_fullname_ET.setError("Enetr fullname!");
            feedback_fullname_ET.requestFocus();
            return;
        }
        if (email.isEmpty()) {
            feedback_email_ET.setError("Enter your email!");
            feedback_email_ET.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            feedback_email_ET.setError("Please provide valid email!");
            feedback_email_ET.requestFocus();
            return;
        }
        if (phone.isEmpty()) {
            feedback_phone_ET.setError("Enter phone number!");
            feedback_phone_ET.requestFocus();
            return;
        }

        if (feedback.isEmpty()) {
            feedback_feedback_ET.setError("Enter the feedback!");
            feedback_feedback_ET.requestFocus();
            return;
        }
        Toast.makeText(getContext(), "Successfully submited. Thanks to your feedback! ", Toast.LENGTH_LONG).show();
        startActivity(new Intent(getActivity(), MainActivity.class));

    }
}
