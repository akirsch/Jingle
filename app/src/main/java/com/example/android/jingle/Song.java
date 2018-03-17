package com.example.android.jingle;

/**
 * Created by Owner on 3/10/2018.
 */

public class Song implements Comparable<Song> {
    // Name of the Song
    private String mSongTitle;
    // Name of the Artist
    private String mArtist;
    // Drawable resource ID of album cover
    private int mImageResourceId;

    /**
     * Create a new com.example.android.miwok.Word object.
     *
     * @param songTitle         is the name of the song
     * @param artist            name of the artist the song is by
     * @param albumCoverImageID is the drawable resource containing Image of Album cover for this song
     */
    public Song(String songTitle, String artist, int albumCoverImageID) {
        mSongTitle = songTitle;
        mArtist = artist;
        mImageResourceId = albumCoverImageID;
    }

    /**
     * Get the name of the song.
     */
    public String getmSongTitle() {
        return mSongTitle;
    }

    /**
     * Get the name of the artist.
     */
    public String getmArtist() {
        return mArtist;
    }

    /**
     * Get the name of the album.
     */
    public int getmAlbumCover() {
        return mImageResourceId;
    }

    //implement compareTo method of Comparable interface to enable sorting songs by Song Title
    public int compareTo(Song other) {
        return mSongTitle.compareTo(other.mSongTitle);
    }
}

