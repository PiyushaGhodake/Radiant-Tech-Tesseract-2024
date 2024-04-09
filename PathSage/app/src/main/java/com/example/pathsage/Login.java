package com.example.pathsage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    FirebaseAuth mAuth;
    private DatabaseReference usersRef;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    /*    mAuth = FirebaseAuth.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                         checkUserAuthentication();
            }
        },1000);
    }
    private void checkUserAuthentication() {
        FirebaseUser currentUser = mAuth.getCurrentUser();

        if (currentUser != null) {
            // User is already authenticated, redirect to MainActivity
            startActivity(new Intent(Login.this, MainActivity.class));
        } else {
            // User is not authenticated, redirect to LoginPhnNumActivity
            startActivity(new Intent(Login.this, Dashboard.class));
        }

        finish();
    }*/


                mAuth = FirebaseAuth.getInstance();
                usersRef = FirebaseDatabase.getInstance().getReference().child("users");

                // Check if the user is already logged in
                FirebaseUser currentUser = mAuth.getCurrentUser();

                if (currentUser != null) {
                    // User is already logged in, check if the phone number exists in the database
                    checkPhoneNumberExistence(currentUser.getPhoneNumber());
                } else {
                    // User is not logged in, proceed with the splash screen
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            startActivity(new Intent(Login.this, MainActivity.class));
                            finish();
                        }
                    }, 1000);
                }
            }

            private void checkPhoneNumberExistence(String phoneNumber) {
                usersRef.orderByChild("phoneNumber").equalTo(phoneNumber)
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                if (dataSnapshot.exists()) {
                                    // Phone number exists in the database, go to Dashboard
                                    startActivity(new Intent(Login.this, DetailActivity.class));
                                    finish();
                                } else {
                                    // Phone number does not exist, ask for user's phone number
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                    finish();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                // Handle the error if needed
                            }
                        });
            }


    }
