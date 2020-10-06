package com.example.icms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawer;
    ActionBarDrawerToggle toogle;
    private CardView passcard, visacard, loccard, infocard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("ICMS");
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        toogle = new ActionBarDrawerToggle
                (this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toogle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        passcard = findViewById(R.id.passcard);
        visacard = findViewById(R.id.visacard);
        loccard = findViewById(R.id.locationcard);
        infocard = findViewById(R.id.informationcard);

//        passcard.setOnClickListener(this);
//        visacard.setOnClickListener(this);
//        loccard.setOnClickListener(this);
//        infocard.setOnClickListener(this);

        HomeFragment fragment = new HomeFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment, "Home");
        transaction.commit();


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notification_menu, menu);
//        MenuItem notification=menu.findItem(R.id.notification);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_home) {
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Home");
            transaction.commit();
        } else if (id == R.id.nav_profile) {
            ProfileFragment fragment = new ProfileFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Profile");
            transaction.commit();
        } else if (id == R.id.nav_track_my_service) {
            ServicestatusFragment fragment = new ServicestatusFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Servicestatus");
            transaction.commit();
        } else if (id == R.id.nav_setting) {
            SettingFragment fragment = new SettingFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Setting");
            transaction.commit();
        } else if (id == R.id.nav_feedback) {
            FeedbackFragment fragment = new FeedbackFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Feedback");
            transaction.commit();
        } else if (id == R.id.nav_about) {
            AboutFragment fragment = new AboutFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "About");
            transaction.commit();
        } else if (id == R.id.nav_logout) {
            LogoutFragment fragment = new LogoutFragment();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment, "Logout");
            transaction.commit();
        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START))
            drawer.closeDrawer(GravityCompat.START);
        else {
            super.onBackPressed();
        }
    }

//    @Override
//    public void onClick(View v) {
//        Intent i;
//        switch (v.getId()){
//            case R.id.passcard:
//                i=new Intent(this,PassportServices.class);
//                startActivity(i);
//                break;
//            case R.id.visacard:
//                i=new Intent(this,PassportServices.class);
//                startActivity(i);
//                break;
//            case R.id.locationcard:
//                i=new Intent(this,PassportServices.class);
//                startActivity(i);
//                break;
//            case R.id.informationcard:
//                i=new Intent(this,PassportServices.class);
//                startActivity(i);
//                break;
//        }
//    }
}
