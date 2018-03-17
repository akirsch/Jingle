package com.example.android.jingle;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owner on 3/12/2018.
 */

public class SongsAdapter extends ArrayAdapter<Song> {

    /**
     * Implementation of a custom Adapter
     * The context is used to inflate the layout file, and the list contains the data required
     * to populate into the lists.
     *
     * @param context  The current context. Used to inflate the layout file.
     * @param allSongs A List of Song objects to display in a ListView
     */
    public SongsAdapter(Activity context, ArrayList<Song> allSongs) {
        // Initialize the Adapter's internal storage for the context and the list.
        // As this is a custom Adapter using more than one View, the second argument doesn't need
        // to be used and its value can be 0.
        super(context, 0, allSongs);
    }

    /**
     * Provides a view for an AdapterView
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_list, parent, false);
        }

        // Get the Song object located at this position in the list
        Song currentSong = getItem(position);

        // Find the TextView in the song_list.xml layout with the album name
        TextView albumNameTextView = listItemView.findViewById(R.id.songListSongName);
        // Get the album name from the current Album object and
        // set this text on the album name TextView
        albumNameTextView.setText(currentSong.getmSongTitle());

        // Find the TextView in the song_list.xml layout with the artist name
        TextView artistNameTextView = listItemView.findViewById(R.id.songListArtistName);
        // Get the artist name from the current Album object and
        // set this text on the artist name TextView
        artistNameTextView.setText(currentSong.getmArtist());

        // Find the ImageView in the song_list.xml layout with the ID small_album_cover_view
        ImageView albumCoverView = listItemView.findViewById(R.id.small_album_cover_view);
        // Get the image resource ID from the current Album object and
        // set the image to iconView
        albumCoverView.setImageResource(currentSong.getmAlbumCover());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
