package com.example.android.jingle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Owner on 3/9/2018.
 */

public class NowPlaying extends AppCompatActivity {

    String albumName;
    String songName;
    String artistName;
    int albumCoverId;
    // create variable to record if song is currently playing
    Boolean isSongPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nowplaying_activity);

        // get Strings from the Intent that opened this activity
        Bundle bundle = getIntent().getExtras();
        albumName = bundle.getString("albumTitle");
        songName = bundle.getString("songTitle");
        artistName = bundle.getString("artist");
        albumCoverId = bundle.getInt("albumCoverId");

        // set the views in this Activity to display the correct information
        TextView songTitleTextView = findViewById(R.id.nowPlayingSongName);
        songTitleTextView.setText(songName);

        TextView albumArtistNameView = findViewById(R.id.nowPlayingArtistName);
        albumArtistNameView.setText(albumName + getResources().getString(R.string.hyphen) + artistName);

        ImageView imageView = findViewById(R.id.albumCoverImage);
        imageView.setImageResource(albumCoverId);

        // set this Boolean on true, as this activity is opened when a user clicks to play a song
        isSongPlaying = true;

        // find view containing play/pause icon images
        final ImageButton playPauseButton = findViewById(R.id.pause_playButton);
        // set click listener on this to govern the button's behaviour when clicked.
        playPauseButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                if (isSongPlaying){ playPauseButton.setImageResource(R.drawable.ic_play_arrow);
                isSongPlaying = false;
                }
                else playPauseButton.setImageResource(R.drawable.ic_pause);
                isSongPlaying = true;
            }
        });






    }
}
