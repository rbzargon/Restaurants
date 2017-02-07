//Adapted from Udacity ud839_Miwok app
/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.towntour;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.towntour.R;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Word} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }


    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Bundle burger_args = new Bundle();
                burger_args.putString("name", mContext.getString(R.string.restaurant_one));
                burger_args.putString("address", mContext.getString(R.string.restaurant_address_one));
                burger_args.putInt("img", R.drawable.burger);

                VenueFragment burgerFragment = new VenueFragment();
                burgerFragment.setArguments(burger_args);

                return burgerFragment;
            case 1:
                Bundle hotdog_args = new Bundle();
                hotdog_args.putString("name", mContext.getString(R.string.restaurant_two));
                hotdog_args.putString("address", mContext.getString(R.string.restaurant_address_two));
                hotdog_args.putInt("img", R.drawable.hotdog);

                VenueFragment hotdogFragment = new VenueFragment();
                hotdogFragment.setArguments(hotdog_args);

                return hotdogFragment;
            case 2:
                Bundle pizza_args = new Bundle();
                pizza_args.putString("name", mContext.getString(R.string.restaurant_three));
                pizza_args.putString("address", mContext.getString(R.string.restaurant_address_three));
                pizza_args.putInt("img", R.drawable.pizza);

                VenueFragment pizzaFragment = new VenueFragment();
                pizzaFragment.setArguments(pizza_args);

                return pizzaFragment;
            default:
                Bundle mexican_args = new Bundle();
                mexican_args.putString("name", mContext.getString(R.string.restaurant_four));
                mexican_args.putString("address", mContext.getString(R.string.restaurant_address_four));
                mexican_args.putInt("img", R.drawable.mexicanfood);

                VenueFragment mexicanFragment = new VenueFragment();
                mexicanFragment.setArguments(mexican_args);

                return mexicanFragment;
        }
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return mContext.getString(R.string.burgers);
            case 1:
                return mContext.getString(R.string.hotdogs);
            case 2:
                return mContext.getString(R.string.pizza);
            default:
                return mContext.getString(R.string.mexican);
        }
    }
}