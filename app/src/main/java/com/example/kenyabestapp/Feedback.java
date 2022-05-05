package com.example.kenyabestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class Feedback extends AppCompatActivity {
    EditText name,county,  editTextMessage,editTextSubject;
    Button btn,back;
    TextView nam, email, phone;
    ImageView avatartv, covertv;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    final String editTextTo="keepkoech@gmail.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Users");
        nam = findViewById(R.id.username);
        email = findViewById(R.id.comment);
        avatartv = findViewById(R.id.image_profile);
        editTextMessage=(EditText)findViewById(R.id.editText5);
        back = (Button) findViewById(R.id.back);

        if (!isConnected(this)) {
            showInternetDialog();
        } else {

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent showDetail = new Intent(Feedback.this, HomePage.class);
                    startActivity(showDetail);
                    overridePendingTransition(R.anim.no_change, R.anim.slide_down_info);
                }
            });


            Query query = databaseReference.orderByChild("email").equalTo(firebaseUser.getEmail());
            query.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                        String name = "" + dataSnapshot1.child("name").getValue();
                        String emaill = "" + dataSnapshot1.child("email").getValue();
                        String image = "" + dataSnapshot1.child("image").getValue();
                        nam.setText(name);
                        email.setText(emaill);
                        try {
                            Glide.with(Feedback.this).load(image).into(avatartv);
                        } catch (Exception e) {

                        }
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


            btn = (Button) findViewById(R.id.next);

            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    String to = editTextTo;
                    String subject = nam.getText().toString();
                    String message = editTextMessage.getText().toString();


                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{to});
                    email.putExtra(Intent.EXTRA_SUBJECT, subject);
                    email.putExtra(Intent.EXTRA_TEXT, message);

                    //need this to prompts email client only
                    email.setType("message/rfc822");

                    try {
                        startActivity(Intent.createChooser(email, "Send mail..."));
                        finish();

                    } catch (android.content.ActivityNotFoundException ex) {
                        Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                    }

                }

            });

        }
    }
//end
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();

        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(Feedback.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.no_change,R.anim.slide_down_info);
        return;
    }


    private void showInternetDialog() {
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
        builder.setCancelable(false);

        View view = LayoutInflater.from(this).inflate(R.layout.dialog, findViewById(R.id.no_internet_layout));
        view.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isConnected(Feedback.this)) {
                    showInternetDialog();
                } else {
                    startActivity(new Intent(getApplicationContext(), Feedback.class));
                    finish();
                }
            }
        });

        builder.setView(view);

        androidx.appcompat.app.AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    private boolean isConnected(Feedback dashboardActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) dashboardActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());
    }
}