package com.example.a2502009715_mcs_uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Section extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_section);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(Section.this);
        bottomNavigationView.setSelectedItemId(R.id.home_tab);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        HomeFragment home_fragment = new HomeFragment();
        Match match_fragment = new Match();
        History history_fragment = new History();
        switch (item.getItemId()) {
            case R.id.home_tab:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, home_fragment).commit();
                return true;
            case R.id.match_tab:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, match_fragment).commit();
                return true;
            case R.id.history_tab:
                getSupportFragmentManager().beginTransaction().replace(R.id.flFragment, history_fragment).commit();
                return true;
        }

        return false;
    }
}