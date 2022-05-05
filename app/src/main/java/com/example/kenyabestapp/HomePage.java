package com.example.kenyabestapp;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomePage extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    String myuid;
    ActionBar actionBar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    BottomNavigationView bottomNavigationView;
    String title="Home";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        //actionBar = getSupportActionBar();
        //actionBar.setTitle("Profile Activity");
        firebaseAuth = FirebaseAuth.getInstance();


        if (!isConnected(this)) {
            showInternetDialog();
        } else {
            setUpToolbar();
            navigationView = (NavigationView) findViewById(R.id.navigation_menu);
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:

                            Intent intent = new Intent(HomePage.this, HomePage.class);
                            startActivity(intent);
                            break;

                        case R.id.nav_drawer2:
                            Intent intent1 = new Intent(HomePage.this, EditProfilePage.class);

                            startActivity(intent1);
                            break;
                        case R.id.nav_drawer1:
                            Intent intent2 = new Intent(HomePage.this, Counties.class);

                            startActivity(intent2);
                            break;
                        case R.id.nav_aboutus:
                            Intent intent3 = new Intent(HomePage.this, About.class);
                            startActivity(intent3);
                            break;
                        case R.id.nav_feedback:
                            Intent intent8 = new Intent(HomePage.this, Feedback.class);
                            startActivity(intent8);
                            break;


//Paste your privacy policy link

                        case R.id.nav_settings: {

                            Intent intent9 = new Intent(HomePage.this, Settings.class);
                            startActivity(intent9);

                        }
                        break;
                        case R.id.nav_share: {

                            Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                            sharingIntent.setType("text/plain");
                            String shareBody = "http://play.google.com/store/apps/detail?id=" + getPackageName();
                            String shareSub = "Try now";
                            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                            startActivity(Intent.createChooser(sharingIntent, "Share using"));

                        }
                        break;
                    }
                    return false;
                }
            });

            bottomNavigationView = findViewById(R.id.navigation);
            bottomNavigationView.setOnNavigationItemSelectedListener(selectedListener);
            //actionBar.setTitle("Home");

            // When we open the application first
            // time the fragment should be shown to the user
            // in this case it is home fragment
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.content, fragment, "");
            fragmentTransaction.commit();
        }
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {

                case R.id.nav_home:
                    //actionBar.setTitle("Home");
                    title = "Home";
                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.content, fragment, "");
                    fragmentTransaction.commit();
                    return true;

                case R.id.nav_profile:
                   // actionBar.setTitle("Profile");
                    title = "Profile";
                    ProfileFragment fragment1 = new ProfileFragment();
                    FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction1.replace(R.id.content, fragment1);
                    fragmentTransaction1.commit();
                    return true;

                case R.id.nav_discover:
                    //actionBar.setTitle("Discover");
                    title = "Discover";
                    DiscoverFragment fragment2 = new DiscoverFragment();
                    FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction2.replace(R.id.content, fragment2, "");
                    fragmentTransaction2.commit();
                    return true;



                case R.id.nav_addblogs:
                    // actionBar.setTitle("Add Blogs");
                    title = "Add Blogs";
                    AddBlogsFragment fragment4 = new AddBlogsFragment();
                    FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction4.replace(R.id.content, fragment4, "");
                    fragmentTransaction4.commit();
                    return true;
            }
            return false;
        }
    };


    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(title);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_home, R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();
    }



    private void showInternetDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        View view = LayoutInflater.from(this).inflate(R.layout.dialog, findViewById(R.id.no_internet_layout));
        view.findViewById(R.id.try_again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isConnected(HomePage.this)) {
                    showInternetDialog();
                } else {
                    startActivity(new Intent(getApplicationContext(), HomePage.class));
                    finish();
                }
            }
        });

        builder.setView(view);

        AlertDialog alertDialog = builder.create();

        alertDialog.show();

    }

    private boolean isConnected(HomePage dashboardActivity) {
        ConnectivityManager connectivityManager = (ConnectivityManager) dashboardActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        return (wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected());
    }

}

