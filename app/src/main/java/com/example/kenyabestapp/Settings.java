package com.example.kenyabestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Settings extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    TextView privacy,appinfo, terms;
    Button logOut;
    String title ="Settings";
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setUpToolbar();

        firebaseAuth = FirebaseAuth.getInstance();


        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:

                        Intent intent = new Intent(Settings.this,HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_drawer2:
                        Intent intent1 = new Intent(Settings.this, EditProfilePage.class);

                        startActivity(intent1);
                        break;
                    case R.id.nav_drawer1:
                        Intent intent2 = new Intent(Settings.this, Counties.class);

                        startActivity(intent2);
                        break;
                    case R.id.nav_aboutus:
                        Intent intent3 = new Intent(Settings.this, About.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_feedback:
                        Intent intent8 = new Intent(Settings.this, Feedback.class);
                        startActivity(intent8);
                        break;


//Paste your privacy policy link

                    case  R.id.nav_settings:{

                        Intent intent9 = new Intent(Settings.this, Settings.class);
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



        privacy = findViewById(R.id.privacy);
        privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp = new Intent(Settings.this, Privacy.class);

                startActivity(intentp);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });
       terms = findViewById(R.id.terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentt = new Intent(Settings.this, Terms.class);

                startActivity(intentt);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });

        appinfo = findViewById(R.id.appinfo);
        appinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentp = new Intent(Settings.this, AppInfo.class);

                startActivity(intentp);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });

        logOut =findViewById(R.id.buttonLogout);
        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
               Intent intr = new Intent(Settings.this, MainActivity.class);startActivity(intr);

            }
        });




    }


    public void setUpToolbar() {
        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setTitle(title);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.County, R.string.County);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.black));
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
         overridePendingTransition(R.anim.toleft, R.anim.toright);
         return;
    }
}



