package com.example.icms.drawerMenuFragments;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.icms.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Objects;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;
    private StorageReference mFirebaseStorage;
    TextView profile_fullname_TV, profile_email_TV, profile_phone_TV, profile_userid_TV, profile_username_TV;
    public Uri imageUri1;
    ImageView profile_iv1;
    ProgressBar mProgressBar;
    String userID;

    public ProfileFragment() {
        // Required empty public constructor
    }

    SettingFragment mSettingFragment = new SettingFragment();

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
        profile_iv1 = v.findViewById(R.id.profile_iv);

        mAuth = FirebaseAuth.getInstance();
        mFirestore = FirebaseFirestore.getInstance();
        mFirebaseStorage = FirebaseStorage.getInstance().getReference();
        userID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        final DocumentReference documentReference = mFirestore.collection("users").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    String Fullname = documentSnapshot.getString("fullname");
                    String Email = documentSnapshot.getString("email");
                    String Phone = documentSnapshot.getString("Phone");
                    //String Userid=documentSnapshot.getString("userID");
                    profile_fullname_TV.setText(Fullname);
                    profile_email_TV.setText(Email);
                    profile_phone_TV.setText(Phone);
                    profile_userid_TV.setText(userID);

                } else {
                    Toast.makeText(getContext(), "Document doesnot exist", Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getContext(), "Error!", Toast.LENGTH_SHORT).show();
            }

        });
        //UploadTask image_path=mFirebaseStorage.child("Users");
        imageUri1 = mSettingFragment.imageUri;
        profile_iv1.setImageURI(imageUri1);
        return v;
    }
}
