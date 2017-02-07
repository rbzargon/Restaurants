//Adapted from Miwok app
package com.example.android.towntour;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


class VenueAdapter extends ArrayAdapter<Venue> {

    VenueAdapter(Activity context, ArrayList<Venue> venues) {
        super(context, 0, venues);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //check if existing view is being reused, otherwise inflate it
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Venue currentVenue = getItem(position);
        assert currentVenue != null;

        TextView textView = (TextView) listItemView.findViewById(R.id.venue_text_view);
        textView.setText(currentVenue.getVenueName());

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.venue_image_view);

        if(imageView != null) {
            imageView.setImageResource(currentVenue.getImageResourceId());
        }

        return listItemView;
    }
}