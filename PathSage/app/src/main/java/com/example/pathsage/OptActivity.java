package com.example.pathsage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class OptActivity extends AppCompatActivity {

    EditText t2;
    Button b2;
    String phnnum;

    Long timeoutSeconds = 60L;
    String verificationCode;
    PhoneAuthProvider.ForceResendingToken  resendingToken;
    String otpid;
    FirebaseAuth mAuth;
    ProgressBar progressBar;
    TextView resendOtpTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opt);
        phnnum=getIntent().getStringExtra("mobile");
        t2=(EditText) findViewById(R.id.login_otp);
        b2=(Button) findViewById(R.id.login_next_btn);
        progressBar = findViewById(R.id.login_progress_bar);
        resendOtpTextView = findViewById(R.id.resend_otp_textview);
        mAuth = FirebaseAuth.getInstance();
        initiateOTP(true);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(t2.getText().toString().isEmpty())
            {
                Toast.makeText(getApplicationContext(),"BLANK FIELD CANNOT BE PROCESSED!",Toast.LENGTH_LONG).show();
            }
            else if(t2.getText().toString().length()!=6)
            {
                Toast.makeText(getApplicationContext(),"INVALID OTP",Toast.LENGTH_LONG).show();
            }
            else {
                PhoneAuthCredential credential=PhoneAuthProvider.getCredential(otpid,t2.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
            }
        });
        resendOtpTextView.setOnClickListener((v)->{
            initiateOTP(true);
        });
    }

    /*private void initiateOTP() {
        startResendTimer();
        setInProgress(true);
       PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phnnum, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        otpid = s;
                        resendingToken = forceResendingToken;
                      Toast.makeText(getApplicationContext(),"OTP sent",Toast.LENGTH_LONG).show();
                        setInProgress(false);
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                        signInWithPhoneAuthCredential(phoneAuthCredential) ;
                        setInProgress(false);
                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {
                        Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                        setInProgress(false);
                    }
                });
        // Assuming isResend is a boolean variable indicating whether to resend or not



    }*/
    private void initiateOTP(boolean isResend) {
        startResendTimer();
        setInProgress(true);

        if (isResend && resendingToken != null) {
            // Resend the OTP with the existing resending token
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phnnum, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            otpid = s;
                            resendingToken = forceResendingToken;
                            Toast.makeText(getApplicationContext(), "OTP resent", Toast.LENGTH_LONG).show();
                            setInProgress(false);
                        }

                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInWithPhoneAuthCredential(phoneAuthCredential);
                            setInProgress(false);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            setInProgress(false);
                        }
                    }, resendingToken);
        } else {
            // Regular initiation of OTP without resending token
            PhoneAuthProvider.getInstance().verifyPhoneNumber(
                    phnnum, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                        @Override
                        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                            otpid = s;
                            resendingToken = forceResendingToken;
                            Toast.makeText(getApplicationContext(), "OTP sent", Toast.LENGTH_LONG).show();
                            setInProgress(false);
                        }

                        @Override
                        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                            signInWithPhoneAuthCredential(phoneAuthCredential);
                            setInProgress(false);
                        }

                        @Override
                        public void onVerificationFailed(@NonNull FirebaseException e) {
                            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
                            setInProgress(false);
                        }
                    });
        }
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential)
    {
        setInProgress(true);
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    //  Log.d(TAG, "signInWithCredential:success");
                    setInProgress(false);
                    Intent i=new Intent(OptActivity.this,UsernameActivity.class);
                    i.putExtra("phone",phnnum);
                    startActivity(i);
                   finish();

                } else {
                    // Log.w(TAG,"signInWithCredential:failure",task.getException());

                    Toast.makeText(getApplicationContext(),"Signin Code Error",Toast.LENGTH_LONG).show();
                }
            }
        });

    }
    void startResendTimer(){
        resendOtpTextView.setEnabled(false);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeoutSeconds--;
                resendOtpTextView.setText("Resend OTP in "+timeoutSeconds +" seconds");
                if(timeoutSeconds<=0){
                    timeoutSeconds =60L;
                    timer.cancel();
                    runOnUiThread(() -> {
                        resendOtpTextView.setEnabled(true);
                    });
                }
            }
        },0,1000);
    }
    void setInProgress(boolean inProgress){
        if(inProgress){
            progressBar.setVisibility(View.VISIBLE);
            b2.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            b2.setVisibility(View.VISIBLE);
        }
    }
}