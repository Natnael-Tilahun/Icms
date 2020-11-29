package com.example.icms.drawerMenuFragments;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.icms.R;
import com.example.icms.Users;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;
    TextView profile_fullname_TV, profile_email_TV, profile_phone_TV, profile_userid_TV, profile_username_TV;
    String userID;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_profile, container, false);
        profile_fullname_TV = v.findViewById(R.id.profile_fullname_TV);
        profile_email_TV = v.findViewById(R.id.profile_email_TV);
        profile_phone_TV = v.findViewById(R.id.profile_phone_TV);
        profile_userid_TV = v.findViewById(R.id.profile_userid_TV);
        profile_username_TV = v.findViewById(R.id.profile_username_TV);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();


        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Users users = documentSnapshot.toObject(Users.class);
                profile_fullname_TV.setText(documentSnapshot.getString("fullname").trim());
                profile_username_TV.setText(documentSnapshot.getString("fullname").trim());
                profile_email_TV.setText(documentSnapshot.getString("email").trim());
                profile_phone_TV.setText(documentSnapshot.getString("phone").trim());
                profile_userid_TV.setText(documentSnapshot.getString("userID").trim());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error!" + e.toString(), Toast.LENGTH_SHORT).show();
            }

        });
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
//                assert documentSnapshot != null;
//                profile_fullname_TV.setText(documentSnapshot.getString("fullname"));
//                profile_email_TV.setText(documentSnapshot.getString("email"));
//                profile_phone_TV.setText(documentSnapshot.getString("phone"));
//                profile_userid_TV.setText(documentSnapshot.getString("userID"));
//            }
//        });
        return v;

    }
}
