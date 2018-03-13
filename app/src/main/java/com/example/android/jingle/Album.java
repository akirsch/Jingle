package com.example.android.jingle;

/**
 * Created by Owner on 3/10/2018.
 */

public class Album {

    // Name of the Album
    private String mAlbumName;

    // Name of the Artist
    private String mArtistName;

    // Drawable resource ID
    private int mImageResourceId;

    /**
     * Create a new com.example.android.miwok.Word object.
     *
     * @param albumName is the name of the album
     * @param artistName name of the artist the song is by
     * @param imageResourceId is the id of the resource containing image of album cover
     *
     */
    public Album(String albumName, String artistName, int imageResourceId)
    {
        mAlbumName = albumName;
        mArtistName = artistName;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the name of the album
     */
    public String getmAlbumName() {
        return mAlbumName;
    }

    /**
     * Get the name of the artist
     */
    public String getmArtistName() {
        return mArtistName;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


}

