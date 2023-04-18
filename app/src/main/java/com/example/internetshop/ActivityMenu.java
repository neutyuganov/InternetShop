package com.example.internetshop;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ActivityMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new MainFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;

            switch (item.getItemId()) {
                case R.id.navigation_main:
                    if(selectedFragment == new MainFragment()){
                        return false;
                    }
                    else selectedFragment = new MainFragment();
                    break;
                case R.id.navigation_cart:
                    selectedFragment = new CartFragment();
                    break;
                case R.id.navigation_chat:
                    selectedFragment = new ChatFragment();
                    break;
                case R.id.navigation_info:
                    selectedFragment = new InfoFragment();
                    break;
                case R.id.navigation_user:
                    selectedFragment = new UserFragment();
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();

            return true;

        }
    };
}