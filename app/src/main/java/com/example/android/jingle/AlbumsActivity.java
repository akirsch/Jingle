package com.example.android.jingle;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_albums);

        BottomNavigationView navBar = findViewById(R.id.navigationBar);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.album_navigation:
                        Intent albumsIntent = new Intent(AlbumsActivity.this, AlbumsActivity.class);
                        startActivity(albumsIntent);
                        break;
                    case R.id.music_navigation:
                        Intent allSongsIntent = new Intent(AlbumsActivity.this, AllSongsActivity.class);
                        startActivity(allSongsIntent);
                        break;
                }
                return true;
            }
        });
        // initialize array of Album Objects
        ArrayList<Album> musicAlbums = new ArrayList<>();

        musicAlbums.add(new Album(getResources().getString(R.string.Kolot_Name),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.WeAreAMiracle_Name),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Shwekey_2_Name),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Ad_Bli_Di),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.LeShem_Shomaim_Name),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Relax_Name),
                getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Coming_Home_Name),
                getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
        musicAlbums.add(new Album(getResources().getString(R.string.Libi_BaMizrach_Name),
                getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Jouneys2_Name),
                getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
        musicAlbums.add(new Album(getResources().getString(R.string.Boruch_Levine_2_Name),
                getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));


        AlbumAdapter albumAdapter = new AlbumAdapter(this, musicAlbums);

        GridView albumGridView = findViewById(R.id.albumsGridView);
        albumGridView.setAdapter(albumAdapter);

        //set clickListener on GridView to open new Activity when each Album is clicked
        albumGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //get name of album that was clicked
                TextView textView = view.findViewById(R.id.albumName_text_view);
                String albumName = textView.getText().toString();

                //Create explicit Intent to navigate to Now Playing Activity
                //Pass this string with the intent to ensure correct song list is opened in new Activity
                Intent intent = new Intent(AlbumsActivity.this, CurrentAlbumActivity.class);
                intent.putExtra("albumTitle", albumName);
                startActivity(intent);

            }
        });

        // find Toolbar view in layout
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        // Set the Toolbar as Action Bar
        setSupportActionBar(myToolbar);
        // Set title of action bar to appropriate label for this Activity
        getSupportActionBar().setTitle(R.string.AlbumsActivityLabel);
    }
}
