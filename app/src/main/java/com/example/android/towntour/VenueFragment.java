// Adapted from udacity/ud839_Miwok
// https://github.com/udacity/ud839_Miwok/blob/d7effcef3bf7fdccdd045c974d67abd5b960fae7/app/src/main/java/com/example/android/miwok/NumbersFragment.java

package com.example.android.towntour;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class VenueFragment extends android.support.v4.app.Fragment {

    ListView listView;
    private int COUNT = 25;

    public VenueFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getArguments();
        String venueName = args.getString("name");
        String venueAddr = args.getString("address");
        int imgResId = args.getInt("img");

        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.venue_list, container, false);

        // Create a list of venues
        final ArrayList<Venue> venues = new ArrayList<Venue>();

        // Fill list with dummy content
        for (int i = 0; i < COUNT; i++){
            venues.add(new Venue(venueName + " " + i,
                                "" + i + " " + venueAddr,
                                imgResId));
        }

          // Create an {@link VenueAdapter}, whose data source is a list of {@link Venue}s. The
        // adapter knows how to create list items for each item in the list.
        VenueAdapter adapter = new VenueAdapter(getActivity(), venues);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list_view, which is declared in the
        // venue_list.xml layout file.
        listView = (ListView)rootView.findViewById(R.id.list_view);

        // Make the {@link ListView} use the {@link VenueAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Venue} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Venue} object at the given position the user clicked on
                Venue clickedVenue = venues.get(position);

                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra("name", clickedVenue.getVenueName());
                intent.putExtra("address", clickedVenue.getItemAddress());
                intent.putExtra("img_resid", clickedVenue.getImageResourceId());
                startActivity(intent);
            }
        });

        return rootView;
    }
}