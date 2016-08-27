package com.example.lysuytry.itemprice;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Ly Suytry on 7/31/2016.
 */
public class FragmentAdapter extends FragmentPagerAdapter{
    Context c;
    public FragmentAdapter(Context c, FragmentManager fm)
    {
        super(fm);
        this.c=c;
    }

    @Override

    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0: return c.getResources().getString(R.string.Beverage);
            case 1: return c.getResources().getString(R.string.Goods);
            case 2: return c.getResources().getString(R.string.Beer);
            case 3: return c.getResources().getString(R.string.InfantMilk);
            case 4: return c.getResources().getString(R.string.FreshMilk);
            default: return null;
        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0: return new BeverageFragment();
            case 1: return new GoodsFragment();
            case 2: return new BeerFragment();
            case 3: return new InfantMilkFragment();
            case 4: return new FreshMilkFragment();
            default: return null;
        }

    }

}
