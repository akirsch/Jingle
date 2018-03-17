package com.example.android.jingle;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Owner on 3/12/2018.
 */

public class CurrentAlbumActivity extends AppCompatActivity {

    ListView listView;
    private String albumName;
    private ArrayList<Song> albumSongList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_album);

        // get album name of selected Album from Bundle
        Bundle bundle = getIntent().getExtras();
        albumName = bundle.getString("albumTitle");

        //find the listView in the XML file
        listView = findViewById(R.id.currentAlbumSongsList);

        // display correct song list for chosen album
        final ArrayList<Song> songsInAlbum = makeAlbumSongList();

        //set songs adapter to populate the listView with the correct songs
        SongsAdapter songsAdapter = new SongsAdapter(this, songsInAlbum);

        listView.setAdapter(songsAdapter);

        //set clickListener on the list view to open the Now Playing Activity when each songs is clicked
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //get name of song that was clicked
                String songName = songsInAlbum.get(position).getmSongTitle();

                //get name of artist that was clicked
                String artistName = songsInAlbum.get(position).getmArtist();

                // get Id of image view containing correct album cover
                int albumCoverId = songsInAlbum.get(position).getmAlbumCover();

                //Create explicit Intent to navigate to Now Playing Activity
                //Pass this string with the intent to ensure correct song list is opened in new Activity
                Intent intent = new Intent(CurrentAlbumActivity.this, NowPlayingActivity.class);
                intent.putExtra("songTitle", songName);
                intent.putExtra("artist", artistName);
                intent.putExtra("albumCoverId", albumCoverId);
                startActivity(intent);

            }
        });
    }

    public ArrayList<Song> makeAlbumSongList() {

        albumSongList = new ArrayList<>();

        if (albumName.equals(getString(R.string.Kolot_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Kolot_Track_10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_kolot_cover));
        }
        if (albumName.equals(getString(R.string.WeAreAMiracle_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));
            albumSongList.add(new Song(getResources().getString(R.string.WeAreAMiracle_Track11),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.weareamiracle_cover));

        }
        if (albumName.equals(getString(R.string.Shwekey_2_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Shwekey2_Track11),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_2_cover));

        }
        if (albumName.equals(getString(R.string.Ad_Bli_Di))) {
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track11),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track12),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Ad_Bli_Di_Track13),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_ad_bli_di_cover));
        }

        if (albumName.equals(getString(R.string.LeShem_Shomaim_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track11),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track12),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));
            albumSongList.add(new Song(getResources().getString(R.string.LShem_Shomaim_Track13),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.shwekey_leshem_shamaim_cover));

        }
        if (albumName.equals(getString(R.string.Relax_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track1),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track2),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track3),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track4),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track5),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track6),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track7),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track8),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track9),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track10),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track11),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track12),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track13),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track14),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track15),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track16),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track17),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track18),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track19),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track20),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track21),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track22),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track23),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track24),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Relax_Track25),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.relax_cover));

        }
        if (albumName.equals(getString(R.string.Coming_Home_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track1),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track2),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track3),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track4),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track5),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track6),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track7),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track8),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track9),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));
            albumSongList.add(new Song(getResources().getString(R.string.Coming_Home_Track10),
                    getResources().getString(R.string.Shalsheles), R.drawable.shalsheles_coming_home));

        }
        if (albumName.equals(getString(R.string.Libi_BaMizrach_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track1),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track2),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track3),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track4),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track5),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track6),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track7),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track8),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track9),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track10),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Libi_BaMizrach_Track11),
                    getResources().getString(R.string.Yaakov_Shwekey), R.drawable.yaakov_shwekey_libi_cover));
        }
        if (albumName.equals(getString(R.string.Jouneys2_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track1),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track2),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track3),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track4),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track5),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track6),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track7),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track8),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track9),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));
            albumSongList.add(new Song(getResources().getString(R.string.Jouneys2_Track10),
                    getResources().getString(R.string.Abie_Rotneberg), R.drawable.abie_rotenberg_journeys_2_cover));

        }
        if (albumName.equals(getString(R.string.Boruch_Levine_2_Name))) {
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track1),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track2),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track3),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track4),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track5),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track6),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track7),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track8),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track9),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
            albumSongList.add(new Song(getResources().getString(R.string.Boruch_Levine_2_Track10),
                    getResources().getString(R.string.Boruch_Levine), R.drawable.boruch_levine_2));
        }

        return albumSongList;


    }
}

