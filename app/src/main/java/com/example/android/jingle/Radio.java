package com.example.android.jingle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;


public class Radio extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_activity);

        BottomNavigationView navBar = findViewById(R.id.navigationBar);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.album_navigation:
                        Intent intent0 = new Intent(Radio.this, Albums.class);
                        startActivity(intent0);
                        break;
                    case R.id.music_navigation:
                        Intent intent1 = new Intent(Radio.this, AllSongs.class);
                        startActivity(intent1);
                        break;
                    case R.id.radio_navigation:
                        Intent intent2 = new Intent(Radio.this, Radio.class);
                        startActivity(intent2);
                        break;
                }
                return true;
            }
        });
    }

}
