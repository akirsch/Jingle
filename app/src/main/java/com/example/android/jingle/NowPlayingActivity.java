package com.example.android.jingle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Owner on 3/9/2018.
 */

public class NowPlayingActivity extends AppCompatActivity {

    String albumName;
    String songName;
    String artistName;
    int albumCoverId;
    // create variable to record if song is currently playing
    private Boolean isSongPlaying = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowplaying_activity);

        // get Strings from the Intent that opened this activity
        Bundle bundle = getIntent().getExtras();
        songName = bundle.getString("songTitle");
        artistName = bundle.getString("artist");
        albumCoverId = bundle.getInt("albumCoverId");

        // set the views in this Activity to display the correct information
        TextView songTitleTextView = findViewById(R.id.nowPlayingSongName);
        songTitleTextView.setText(songName);

        TextView albumArtistNameView = findViewById(R.id.nowPlayingArtistName);
        albumArtistNameView.setText(artistName);

        ImageView imageView = findViewById(R.id.albumCoverImage);
        imageView.setImageResource(albumCoverId);


        // find view containing play/pause icon images
        final ImageButton playPauseButton = findViewById(R.id.pause_playButton);
        // set click listener on this to govern the button's behaviour when clicked.
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (isSongPlaying) {
                    playPauseButton.setImageResource(R.drawable.ic_play_arrow);
                    isSongPlaying = false;
                } else {
                    playPauseButton.setImageResource(R.drawable.ic_pause);
                    isSongPlaying = true;
                }
            }
        });


        BottomNavigationView navBar = findViewById(R.id.navigationBar);
        navBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.album_navigation:
                        Intent intent0 = new Intent(NowPlayingActivity.this, AlbumsActivity.class);
                        startActivity(intent0);
                        break;
                    case R.id.music_navigation:
                        Intent intent1 = new Intent(NowPlayingActivity.this, AllSongsActivity.class);
                        startActivity(intent1);
                        break;
                }
                return true;
            }
        });
    }
}
