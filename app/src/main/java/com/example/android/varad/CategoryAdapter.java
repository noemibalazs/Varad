package com.example.android.varad;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class CategoryAdapter extends FragmentPagerAdapter{
    public static final int POSITION_ZERO = 0;
    public static final int POSITION_ONE = 1;
    public static final int POSITION_TWO = 2;
    public static final int POSITION_THREE = 3;
    public static final int POSITION_FOUR = 4;

    private Context mContext;

    public CategoryAdapter(FragmentManager fm, Context context){
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position){
        if(position == POSITION_ZERO){
            return new HistoryFragment();
        } else if(position == POSITION_ONE){
            return new RestaurantsFragment();
        } else if(position == POSITION_TWO) {
            return new HotelsFragment();
        } else if(position == POSITION_THREE){
            return new SpaFragment();
        }else if (position == POSITION_FOUR){
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
        if (position == POSITION_ZERO){
            return mContext.getString(R.string.fragment_history);
        } else if (position == POSITION_ONE){
            return mContext.getString(R.string.fragment_restaurants);
        } else if(position == POSITION_TWO){
            return mContext.getString(R.string.fragment_hotels);
        }else if (position == POSITION_THREE){
            return mContext.getString(R.string.fragment_spa);
        }else if (position == POSITION_FOUR ){
            return mContext.getString(R.string.fragment_wedding_halls);
        } else {
            return mContext.getString(R.string.fragment_translate);
        }
    }
}