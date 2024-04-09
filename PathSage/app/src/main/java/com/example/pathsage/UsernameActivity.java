package com.example.pathsage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UsernameActivity extends AppCompatActivity {
    String phone;
   // ProgressBar progressBar;
    EditText t3;
    Button btn;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_username);
        t3=(EditText) findViewById(R.id.login_username);
         phone=getIntent().getStringExtra("phone");
       // progressBar = findViewById(R.id.login_progress_bar);
        mAuth = FirebaseAuth.getInstance();
        btn=(Button) findViewById(R.id.login_let_me_in_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUsernameToDatabase();

            }
        });

    }

    private void saveUsernameToDatabase() {

            String username = t3.getText().toString().trim();

            if (username.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Username cannot be empty", Toast.LENGTH_SHORT).show();
            } else {
                // Save the phone number and username to the Firebase Database
                FirebaseDatabase database = FirebaseDatabase.getInstance();
                DatabaseReference userRef = database.getReference("users"); // Change "users" to your desired node

                String userId = mAuth.getCurrentUser().getUid();
                String phoneNumber = phone; // Get the authenticated user's phone number

                // Create a user object with phone number and username
                User user = new User(phoneNumber, username);

                // Use setValue to set the user object in the database, ensuring the phone number is unique
                userRef.child(userId).setValue(user);

                Toast.makeText(getApplicationContext(), "Username saved successfully", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UsernameActivity.this,DetailActivity.class));
                finish();


        }


    }

}