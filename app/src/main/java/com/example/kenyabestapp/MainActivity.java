package com.example.kenyabestapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AlertDialog;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Animation topAnim;
    TextView image;
    private static  int Splash =7000;
    String data = "";
    LinearLayout containerLL;
    FirebaseUser currentUser;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        if (!isConnected(this)) {
            showInternetDialog();
        }else {

            topAnim = AnimationUtils.loadAnimation(this, R.anim.top_anim);
            image = findViewById(R.id.name);
            image.setAnimation(topAnim);
            LazyLoader loader = new LazyLoader(this, 30, 20, ContextCompat.getColor(this, R.color.loader_selected),
                    ContextCompat.getColor(this, R.color.loader_selected),
                    ContextCompat.getColor(this, R.color.loader_selected));
            loader.setAnimDuration(500);
            loader.setFirstDelayDuration(100);
            loader.setSecondDelayDuration(200);
            loader.setInterpolator(new LinearInterpolator());

            mAuth = FirebaseAuth.getInstance();
            if (mAuth != null ) {
                currentUser = mAuth.getCurrentUser();
            }


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    SharedPreferences pref = getSharedPreferences("user", MODE_PRIVATE);
                    String rem = pref.getString("remembe", "");
                    FirebaseUser user = mAuth.getCurrentUser();
                    if (user == null ) {
                        if (rem.equals("true")) {
                            startActivity(new Intent(MainActivity.this, Start.class));
                            overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
                        } else {
                            startActivity(new Intent(MainActivity.this, OnBoarding.class));
                            overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
                        }
//                    Intent intent = new Intent(MainActivity.this, Start.class);
//                    startActivity(intent);
//                    finish();
                    } else {
                        Intent mainIntent = new Intent(MainActivity.this, HomePage.class);
                        mainIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(mainIntent);
                        finish();
                    }

//                Intent in = new Intent(MainActivity.this, OnBoarding.class);
//                startActivity(in);
//                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
//                }


                }
            }, Splash);

        }



    }    private void showInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        View view = LayoutInflater.from(this).inflate(R.layout.dialog, findViewById(R.id.no_internet_layout));
        view.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isConnected(MainActivity.this)) {
                    showInternetDialog();
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        });

        builder.setView(view);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    private boolean isConnected(MainActivity dashboardActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) dashboardActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());
    }

}