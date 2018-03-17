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
 * Created by Owner on 3/11/2018.
 */

public class AlbumAdapter extends ArrayAdapter<Album> {

    /**
     * Implementation of a custom Adapter
     * The context is used to inflate the layout file, and the list contains the data required
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param musicAlbums A List of Album objects to display in a GridView
     */
    public AlbumAdapter(Activity context, ArrayList<Album> musicAlbums) {
        // Initialize the Adapter's internal storage for the context and the list.
        // As this is a custom Adapter using more than one View, the second argument doesn't need
        // to be used and its value can be 0.
        super(context, 0, musicAlbums);
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
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_list, parent, false);
        }

        // Get the Album object located at this position in the list
        Album currentAlbum = getItem(position);

        // Find the TextView in the album_list.xml layout with the album name
        TextView albumNameTextView = gridItemView.findViewById(R.id.albumName_text_view);
        // Get the album name from the current Album object and
        // set this text on the album name TextView
        albumNameTextView.setText(currentAlbum.getmAlbumName());

        // Find the TextView in the album_list.xml layout with the artist name
        TextView artistNameTextView = gridItemView.findViewById(R.id.artistName_text_view);
        // Get the artist name from the current Album object and
        // set this text on the artist name TextView
        artistNameTextView.setText(currentAlbum.getmArtistName());

        // Find the ImageView in the album_list.xml layout with the ID albumCoverImage
        ImageView albumCoverView = gridItemView.findViewById(R.id.albumCoverImage);
        // Get the image resource ID from the current Album object and
        // set the image to iconView
        albumCoverView.setImageResource(currentAlbum.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the GridView
        return gridItemView;
    }

}
