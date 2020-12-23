package com.example.icms.drawerMenuFragments;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.icms.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class SettingFragment<StorageReference> extends Fragment {
    TextView changefullname_tv, changeemail_tv, changepassword_tv, changephone_tv, changeprofilepic_tv,
            changefullnamedialog_ET, testname;
    Button changeusernamedialogsave_btn, changeusernamedialogcancel_btn;
    Button changeemaildialogsave_btn, changeemaildialogcancel_btn;
    Button changephonedialogsave_btn, changephonedialogcancel_btn;
    ImageView profile_iv;
    public Uri imageUri;
    Dialog mDialog;
    String user_id;
    private StorageReference mStorageReference;
    private FirebaseAuth mFirebaseAuth;
    private FirebaseFirestore mFirebaseFirestore;

    public SettingFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_setting, container, false);
        changefullname_tv = v.findViewById(R.id.changefullname_tv);
        changeemail_tv = v.findViewById(R.id.changeemail_tv);
        changepassword_tv = v.findViewById(R.id.chanegpaassword_tv);
        changephone_tv = v.findViewById(R.id.changephone_tv);
        changeprofilepic_tv = v.findViewById(R.id.changeprofilepic_tv);
        testname = v.findViewById(R.id.testname);

        changefullnamedialog_ET = v.findViewById(R.id.changeusernamedialog_ET);
        profile_iv = v.findViewById(R.id.profile_iv);

        changeusernamedialogsave_btn = v.findViewById(R.id.changeusernamedialogsave_btn);
        changeusernamedialogcancel_btn = v.findViewById(R.id.changeusernamedialogcancel_btn);

        changeemaildialogsave_btn = v.findViewById(R.id.changeemaildialogsave_btn);
        changeemaildialogcancel_btn = v.findViewById(R.id.changeemaildialogcancel_btn);

        changephonedialogsave_btn = v.findViewById(R.id.changephonedialogsave_btn);
        changephonedialogcancel_btn = v.findViewById(R.id.changephonedialogcancel_btn);

        mFirebaseAuth = FirebaseAuth.getInstance();
        user_id = mFirebaseAuth.getCurrentUser().getUid();

//        mFirebaseFirestore=FirebaseFirestore.getInstance();
//        mStorageReference=FirebaseS

        //fullname setting dialog
        changefullname_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomchangefullnamedialog();
            }
        });

        //phone setting dialog
        changephone_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomchangephonedialog();
            }
        });

        changeemail_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomchangeemaildialog();
            }
        });

        changepassword_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showcustomchangepassworddialog();
            }
        });

        changeprofilepic_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE) !=
                            PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getContext(), "Permission Denied!", Toast.LENGTH_LONG).show();
                        ActivityCompat.requestPermissions((Activity) getContext(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                    } else {
                        chooseImage();
                    }
                } else {
                    chooseImage();
                }
            }
        });
        return v;
    }
    //Methods

    private void chooseImage() {
        Intent OpenIntentGallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(OpenIntentGallery, 1000);
    }

    private void showcustomchangefullnamedialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.changeusername_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(true);
        dialog.show();

        final EditText fullnam = dialog.findViewById(R.id.changeusernamedialog_ET);
        final Button save = dialog.findViewById(R.id.changeusernamedialogsave_btn);
        final Button cancel = dialog.findViewById(R.id.changeusernamedialogcancel_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = fullnam.getText().toString();
                if (fullname.isEmpty()) {
                    fullnam.setError("Fullname is empty!");
                    fullnam.requestFocus();
                    Toast.makeText(getContext(), "Fullname is empty", Toast.LENGTH_LONG).show();
                } else {
                    testname.setText(fullname);
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void showcustomchangeemaildialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.changeemail_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        final EditText email = dialog.findViewById(R.id.changeemaildialog_ET);
        final Button save = dialog.findViewById(R.id.changeemaildialogsave_btn);
        final Button cancel = dialog.findViewById(R.id.changeemaildialogcancel_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailaddress = email.getText().toString();
                if (emailaddress.isEmpty()) {
                    email.setError("Email is empty!");
                    email.requestFocus();
                    Toast.makeText(getContext(), "Email is empty!", Toast.LENGTH_LONG).show();
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailaddress).matches()) {
                    email.setError("Please provide valid email!");
                    email.requestFocus();
                } else {
                    testname.setText(emailaddress);
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void showcustomchangepassworddialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.setContentView(R.layout.changepassword_dialog);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        final EditText oldpass = dialog.findViewById(R.id.changepasswordialogoldpass_ET);
        final EditText newpass = dialog.findViewById(R.id.changepasswordialognewpass_ET);
        final EditText confpass = dialog.findViewById(R.id.changepasswordialogconfirmpass_ET);
        final Button save = dialog.findViewById(R.id.changepassworddialogsave_btn);
        final Button cancel = dialog.findViewById(R.id.changepassworddialogcancel_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = oldpass.getText().toString();
                String newpassword = newpass.getText().toString();
                String confirmpassword = confpass.getText().toString();
                if (password.isEmpty()) {
                    oldpass.setError("Old password is empty!");
                    oldpass.requestFocus();
                    Toast.makeText(getContext(), "Old Password is empty!", Toast.LENGTH_LONG).show();
                } else if (newpassword.isEmpty()) {
                    newpass.setError("New Password is empty!");
                    newpass.requestFocus();
                    Toast.makeText(getContext(), "New Password is empty!", Toast.LENGTH_LONG).show();
                } else if (newpassword.length() < 6) {
                    newpass.setError("Minimum password length should be 6 characters!");
                    newpass.requestFocus();
                } else if (confirmpassword.isEmpty()) {
                    confpass.setError("Confirm Password is empty!");
                    confpass.requestFocus();
                    Toast.makeText(getContext(), "Confirm Password is empty!", Toast.LENGTH_LONG).show();
                } else if (!newpassword.matches(confirmpassword)) {
                    confpass.setError("Password didnn't match!");
                    confpass.requestFocus();
                    Toast.makeText(getContext(), "Password didnn't match!", Toast.LENGTH_LONG).show();
                } else {
                    testname.setText(newpassword);
                    dialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void showcustomchangephonedialog() {
        final Dialog mDialog = new Dialog(getContext());
        // mDialog = new Dialog(getContext());
        mDialog.setContentView(R.layout.changephone_dialog);
        mDialog.setCanceledOnTouchOutside(false);
        mDialog.show();
        final EditText phone = mDialog.findViewById(R.id.changephonedialog_ET);
        final Button save = mDialog.findViewById(R.id.changephonedialogsave_btn);
        final Button cancel = mDialog.findViewById(R.id.changephonedialogcancel_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phoneno = phone.getText().toString();
                if (phoneno.isEmpty()) {
                    phone.setError("Phone number is empty!");
                    phone.requestFocus();
                    Toast.makeText(getContext(), "Phone Number is empty!", Toast.LENGTH_LONG).show();
                } else if (phoneno.length() < 10) {
                    phone.setError("Minimum phone number length should be 10 characters!");
                    phone.requestFocus();
                } else {
                    testname.setText(phoneno);
                    mDialog.dismiss();
                }
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDialog.dismiss();
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            Uri imageUri = data.getData();
            profile_iv.setImageURI(imageUri);
        }
    }
}
