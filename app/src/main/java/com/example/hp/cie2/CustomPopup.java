//package com.example.hp.cie2;
//
//import android.content.Intent;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.CollectionReference;
//import com.google.firebase.firestore.FirebaseFirestore;
//
//
//public class CustomPopup extends AppCompatActivity implements View.OnClickListener{
//
//    private FirebaseAuth firebaseAuth;
//    private EditText email;
//    private EditText password;
//    private EditText fname;
//    private EditText lname;
//    private EditText address;
//    private EditText mobile;
//    private EditText enrol;
//    private Button register,pop;
//
//    private FirebaseFirestore db;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_custom_popup);
//
//        db = FirebaseFirestore.getInstance();
//        firebaseAuth=FirebaseAuth.getInstance();
//
//        email = (EditText) findViewById(R.id.email);
//        password = (EditText) findViewById(R.id.password);
//        lname = (EditText) findViewById(R.id.lname);
//        fname = (EditText) findViewById(R.id.fname);
//        address = (EditText) findViewById(R.id.address);
//        mobile = (EditText) findViewById(R.id.mobile);
//        enrol = (EditText) findViewById(R.id.enrol);
//
//
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        if (v.getId() == R.id.register) {
//            Toast.makeText(CustomPopup.this, "Saved", Toast.LENGTH_LONG).show();
//            final String Email = email.getText().toString().trim();
//            final String Password = password.getText().toString().trim();
//            final String Lname = lname.getText().toString().trim();
//            final String Fname = fname.getText().toString().trim();
//            final String Mobile = mobile.getText().toString().trim();
//            final String Address = address.getText().toString().trim();
//            final String Enrol = enrol.getText().toString().trim();
//
//            if (Validate(Email, Password, Lname, Fname, Mobile, Address, Enrol)) {
//                firebaseAuth = FirebaseAuth.getInstance();
//                firebaseAuth.createUserWithEmailAndPassword(Email, Password)
//                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                            @Override
//                            public void onComplete(@NonNull Task<AuthResult> task) {
//                                if (task.isSuccessful()) {
//                                    //Successflly registered
//                                    Toast.makeText(CustomPopup.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                                    //startActivity(new Intent(CustomPopup.this,CustomPopup.class));
//                                    DB(Email, Password, Fname, Lname, Address, Mobile, Enrol, firebaseAuth.getUid());
//                                } else {
//                                    Toast.makeText(CustomPopup.this, "Error:Not Registered", Toast.LENGTH_SHORT).show();
//                                }
//                            }
//                        });
//            }
//        }
//    }
//    private boolean Validate(String e, String p, String fn, String ln, String m, String a, String en) {
//
//        //Validating entries
//        if (TextUtils.isEmpty(e) || TextUtils.isEmpty(p) || TextUtils.isEmpty(fn) || TextUtils.isEmpty(ln) || TextUtils.isEmpty(m) || TextUtils.isEmpty(a) || TextUtils.isEmpty(en)) {
//            Toast.makeText(CustomPopup.this, "Error:Please enter all details", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//        return true;
//    }
//    private void DB(String Email,String Password,String Fname,String Lname,String Address,String Mobile,String Enrol,String document_id){
//        CollectionReference dbUsers = db.collection("users");
//        // Toast.makeText(Registeration.this, "Data Arrived at DB", Toast.LENGTH_SHORT).show();
//
//        Users user = new Users(Email,Password,Fname,Lname,Address,Mobile,Enrol);
//        dbUsers.document(document_id).set(user)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        finish();
//                        Toast.makeText(CustomPopup.this, "Error:Please enter all details", Toast.LENGTH_SHORT).show();
//                        //startActivity(new Intent(MainActivity.this,MainActivity.class));
//
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Toast.makeText(CustomPopup.this,e.getMessage(),Toast.LENGTH_LONG).show();
//                    }
//                });
//
//    }
//
//}
//
