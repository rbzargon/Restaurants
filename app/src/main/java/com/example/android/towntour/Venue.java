//Adapted from Udacity customAdapter
//Copyright (C) 2016 THE Android Open Source Project
//Licensed under the Apache License, Version 2.0 (the "License);
package com.example.android.towntour;

class Venue {

    private String venueName;
    private String venueAddress;
    private int imageResourceId;

    Venue(String venueName, String itemAddress, int imageResourceId) {
        this.venueName = venueName;
        this.venueAddress = itemAddress;
        this.imageResourceId = imageResourceId;
    }

    String getVenueName() {
        return venueName;
    }

    String getItemAddress() {
        return venueAddress;
    }

    int getImageResourceId() {
        return imageResourceId;
    }
}