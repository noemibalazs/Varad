package com.example.android.varad;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;


public class CategoryAdapter extends FragmentPagerAdapter{

    private Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context){
        super(fm);
        mContext = context;

    }

    @Override
    public Fragment getItem(int position){
        if(position == 0){
            return new HistoryFragment();
        } else if(position == 1){
            return new RestaurantsFragment();
        } else if(position == 2) {
            return new HotelsFragment();
        } else if(position == 3){
            return new SpaFragment();
        }else if (position == 4){
            return new WeddingHallFragment();}
            else {
            return new RomanFragment();
        }
    }

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.fragment_history);
        } else if (position == 1){
            return mContext.getString(R.string.fragment_restaurants);
        } else if(position == 2){
            return mContext.getString(R.string.fragment_hotels);
        }else if (position == 3){
            return mContext.getString(R.string.fragment_spa);
        }else if (position == 4 ){
            return mContext.getString(R.string.fragment_wedding_halls);
        } else {
            return mContext.getString(R.string.fragment_translate);
        }
    }
}