package com.example.kenyabestapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Counties extends AppCompatActivity {

    public static ArrayList<Countydets> countiesList = new ArrayList<Countydets>();
    Countiesadapter adapter;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    private ListView listView;
    Button btn;
    SearchView searchView;
    String title ="Counties";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counties);

        setupData();
        setUpList();
        setUpOnclickListener();
        setUpToolbar();

        navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_home:

                        Intent intent = new Intent(Counties.this,HomePage.class);
                        startActivity(intent);
                        break;

                    case R.id.nav_drawer1:
                        Intent intent1 = new Intent(Counties.this, Counties.class);

                        startActivity(intent1);
                        break;
                    case R.id.nav_drawer2:
                        Intent intent2 = new Intent(Counties.this, EditProfilePage.class);

                        startActivity(intent2);
                        break;
                    case R.id.nav_aboutus:
                        Intent intent3 = new Intent(Counties.this, About.class);
                        startActivity(intent3);
                        break;
                    case R.id.nav_feedback:
                        Intent intent8 = new Intent(Counties.this, Feedback.class);
                        startActivity(intent8);
                        break;

//Paste your privacy policy link

                    case  R.id.nav_settings:{

                        Intent intent9 = new Intent(Counties.this, Settings.class);
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
    }

    public void darkbutton(View view) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

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
        overridePendingTransition(R.anim.no_change,R.anim.slide_down_info);
    }

    private void setupData()
    {
        Countydets Mombasa = new Countydets("0","Mombasa", R.drawable.mombasaimg);
        countiesList.add(Mombasa);
        Countydets 	Kwale = new Countydets("1","Kwale", R.drawable.kwaleimg);
        countiesList.add(Kwale);
        Countydets 	Kilifi = new Countydets("2","Kilifi", R.drawable.kilifiimg);
        countiesList.add(Kilifi);
        Countydets TanaRiver= new Countydets("3","Tana River", R.drawable.tanarimgs);
        countiesList.add(TanaRiver);
        Countydets Lamu= new Countydets("4","Lamu", R.drawable.lamuimgs);
        countiesList.add(Lamu);
        Countydets TaitaTaveta= new Countydets("5","TaitaTaveta", R.drawable.taitatavetaimgs);
        countiesList.add(TaitaTaveta);
        Countydets Garissa= new Countydets("6","Garissa", R.drawable.garrisaimgs);
        countiesList.add(Garissa);
        Countydets 	Wajir= new Countydets("7","Wajir", R.drawable.wajirimgs);
        countiesList.add(Wajir);
        Countydets Mandera= new Countydets("8","Mandera", R.drawable.manderaimgs);
        countiesList.add(Mandera);
        Countydets Marsabit= new Countydets("9","Marsabit", R.drawable.marsabitimgs);
        countiesList.add(Marsabit);
        Countydets Isiolo= new Countydets("10","Isiolo", R.drawable.isioloimgs);
        countiesList.add(Isiolo);
        Countydets Meru= new Countydets("11","Meru", R.drawable.meruimgs);
        countiesList.add(Meru);
        Countydets TharakaNithi= new Countydets("12","Tharaka-Nithi", R.drawable.tharakanithiimgs);
        countiesList.add(TharakaNithi);
        Countydets Embu= new Countydets("13","Embu", R.drawable.embuimgs);
        countiesList.add(Embu);
        Countydets Kitui= new Countydets("14","Kitui", R.drawable.kituimgs);
        countiesList.add(Kitui);
        Countydets Machakos= new Countydets("15","Machakos", R.drawable.machakosimgs);
        countiesList.add(Machakos);
        Countydets Makueni= new Countydets("16","Makueni", R.drawable.makueniimgs);
        countiesList.add(Makueni);
        Countydets Nyandarua= new Countydets("17","Nyandarua", R.drawable.nyandaruaimgs);
        countiesList.add(Nyandarua);
        Countydets Nyeri= new Countydets("18","Nyeri", R.drawable.nyeriimgs);
        countiesList.add(Nyeri);
        Countydets Kirinyaga= new Countydets("19","Kirinyaga", R.drawable.krinyagaimgs);
        countiesList.add(Kirinyaga);
        Countydets Muranga= new Countydets("20","Murang'a", R.drawable.murangaimgs);
        countiesList.add(Muranga);
        Countydets Kiambu= new Countydets("21","Kiambu", R.drawable.kiambuimgs);
        countiesList.add(Kiambu);
        Countydets Turkana= new Countydets("22","Turkana", R.drawable.turkanaimgs);
        countiesList.add(Turkana);
        Countydets WestPokot= new Countydets("23","West Pokot", R.drawable.westpokotimgs);
        countiesList.add(WestPokot);
        Countydets Samburu= new Countydets("24","Samburu", R.drawable.samburuimgs);
        countiesList.add(Samburu);
        Countydets TransNzoia= new Countydets("25","Trans Nzoia", R.drawable.transnzoiaimgs);
        countiesList.add(TransNzoia);
        Countydets UasinGishu= new Countydets("26","Uasin Gishu", R.drawable.uasingishuimgs);
        countiesList.add(UasinGishu);
        Countydets ElgeyoMarakwet= new Countydets("27","Elgeyo-Marakwet", R.drawable.elgeyomarakwetimgs);
        countiesList.add(ElgeyoMarakwet);

        Countydets Nandi= new Countydets("28","Nandi", R.drawable.nandiimgs);
        countiesList.add(Nandi);
        Countydets Baringo= new Countydets("29","Baringo", R.drawable.baringoimgs);
        countiesList.add(Baringo);
        Countydets Laikipia= new Countydets("30","Laikipia", R.drawable.laikipiaimgs);
        countiesList.add(Laikipia);
        Countydets Nakuru= new Countydets("31","Nakuru", R.drawable.nakuruimgs);
        countiesList.add(Nakuru);
        Countydets Narok= new Countydets("32","Narok", R.drawable.narokimgs);
        countiesList.add(Narok);
        Countydets Kajiado= new Countydets("33","Kajiado", R.drawable.kajiadoimgs);
        countiesList.add(Kajiado);
        Countydets Kericho= new Countydets("34","Kericho", R.drawable.kerichoimgs);
        countiesList.add(Kericho);
        Countydets Bomet= new Countydets("35","Bomet", R.drawable.bometimgs);
        countiesList.add(Bomet);
        Countydets Kakamega= new Countydets("36","Kakamega", R.drawable.kakamegaimgs);
        countiesList.add(Kakamega);
        Countydets Vihiga= new Countydets("37","Vihiga", R.drawable.vihigaimgs);
        countiesList.add(Vihiga);
        Countydets Bungoma= new Countydets("38","Bungoma", R.drawable.bungomaimgs);
        countiesList.add(Bungoma);
        Countydets Busia= new Countydets("39","Busia", R.drawable.busiaimgs);
        countiesList.add(Busia);
        Countydets Siaya= new Countydets("40","Siaya", R.drawable.siayaimgs);
        countiesList.add(Siaya);
        Countydets Kisumu= new Countydets("41","Kisumu", R.drawable.kisumuimgs);
        countiesList.add(Kisumu);
        Countydets HomaBay= new Countydets("42","Homa Bay", R.drawable.homabayimgs);
        countiesList.add(HomaBay);
        Countydets Migori= new Countydets("43","Migori", R.drawable.migoriimgs);
        countiesList.add(Migori);
        Countydets Kisii= new Countydets("44","Kisii", R.drawable.kisiiimgs);
        countiesList.add(Kisii);
        Countydets Nyamira= new Countydets("45","Nyamira", R.drawable.nyamiraimgs);
        countiesList.add(Nyamira);
        Countydets Nairobi = new Countydets("46","Nairobi", R.drawable.nairobiimgs);
        countiesList.add(Nairobi);





    }
    private void setUpList() {
        listView = (ListView) findViewById(R.id.listview);


        adapter = new Countiesadapter(getApplicationContext(), 0, countiesList);
        listView.setAdapter(adapter);
        listView.setTextFilterEnabled(true);
    }
    private void setUpOnclickListener()
    {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l)
            {
                Countydets selectShape = (Countydets) (listView.getItemAtPosition(position));
                Intent showDetail = new Intent(getApplicationContext(), Venues.class);
                showDetail.putExtra("id",selectShape.getId());


                startActivity(showDetail);
                overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
            }
        });

    }
}
