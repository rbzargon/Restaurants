package com.example.android.towntour;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

//Shows detail of a venue
public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String venueName = getIntent().getStringExtra("name");
        String venueAddress = getIntent().getStringExtra("address");
        int img_resid = getIntent().getIntExtra("img_resid", 0);

        ((TextView)findViewById(R.id.name_detail)).setText(venueName);
        ((TextView)findViewById(R.id.address_detail)).setText(venueAddress);
        ((ImageView)findViewById(R.id.img_detail)).setImageResource(img_resid);
    }
}
