package com.example.android.jingle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Owner on 3/9/2018.
 */

public class NowPlayingActivity extends AppCompatActivity {

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
        songName = bundle.getString(Constants.SONG_TITLE);
        artistName = bundle.getString(Constants.ARTIST);
        albumCoverId = bundle.getInt(Constants.ALBUM_COVER_ID);

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
                        Intent albumsIntent = new Intent(NowPlayingActivity.this, AlbumsActivity.class);
                        startActivity(albumsIntent);
                        break;
                    case R.id.music_navigation:
                        Intent allSongsIntent = new Intent(NowPlayingActivity.this, AllSongsActivity.class);
                        startActivity(allSongsIntent);
                        break;
                }
                return true;
            }
        });

        // find Toolbar view in layout
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        // Set the Toolbar as Action Bar
        setSupportActionBar(myToolbar);
        // Set title of action bar to appropriate label for this Activity
        getSupportActionBar().setTitle(R.string.NowPlayingActivityLabel);
        // enable up navigation to parent activity
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * This method will cause the app to navigate back to the Activity that started the Now Playing
     * Activity
     *
     * @param item the up icon arrow
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
