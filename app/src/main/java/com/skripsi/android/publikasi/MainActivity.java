package com.skripsi.android.publikasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.skripsi.android.publikasi.fragment.HomeFragment;
import com.skripsi.android.publikasi.fragment.ProfileFragment;
import com.skripsi.android.publikasi.fragment.SearchFragment;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportActionBar().show();
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    setActionBarTitle("Publikasi");
                    switchToFragmentHome();
                   return true;
                case R.id.navigation_search:
                    getSupportActionBar().show();
                    getSupportActionBar().setDisplayShowTitleEnabled(false);
                    switchToFragmentSearch();
                    return true;
                case R.id.navigation_profile:
                    switchToFragmentProfile();
                    getSupportActionBar().show();
                    getSupportActionBar().setDisplayShowTitleEnabled(true);
                    setActionBarTitle("Profil");
                    return true;
            }
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        //Untuk inisialisasi fragment pertama kali
        switchToFragmentHome();
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.publikasi_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_settings){
            Log.d(TAG, "onOptionsItemSelected: setting selected");
            
            Intent startSettingsActivity = new Intent(this,SettingsActivity.class);
            startActivity(startSettingsActivity);
            return true;
        }else if (id==R.id.action_logout){
            Log.d(TAG, "onOptionsItemSelected: logout selected");
        }
        return super.onOptionsItemSelected(item);
    }

    //switching fragment

    public void switchToFragmentHome() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new HomeFragment()).commit();
  //      overridePendingTransition(0, 0);
    }

    public void switchToFragmentSearch() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new SearchFragment()).commit();
//        overridePendingTransition(0, 0);

    }

    public void switchToFragmentProfile() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.main_container, new ProfileFragment()).commit();
    //    overridePendingTransition(0, 0);

    }

    public void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }

}
