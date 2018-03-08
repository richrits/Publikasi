package com.skripsi.android.publikasi;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    switchToFragmentHome();
                    return true;
                case R.id.navigation_search:
                    switchToFragmentSearch();
                    return true;
                case R.id.navigation_profile:
                    switchToFragmentProfile();
                    return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Untuk inisialisasi fragment pertama kali
        switchToFragmentHome();
    }


    //switching fragment

    public void switchToFragmentHome() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
    }

    public void switchToFragmentSearch() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new SearchFragment()).commit();
    }

    public void switchToFragmentProfile() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new ProfileFragment()).commit();
    }
}
