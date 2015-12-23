package com.strangers.traveller;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;

/**
 * Created by root on 17/12/15.
 */
public class ScrollActivity extends FragmentActivity {
    ViewPager viewPager;
    private String TAG="Scroll Activity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "before content");
        setContentView(R.layout.scroll_tab);
        Log.d(TAG, "after content");
        viewPager =(ViewPager) findViewById(R.id.loginTab);
        Log.d(TAG, "after viewpager");
        FragmentManager fragmentManager = getSupportFragmentManager();
        Log.d(TAG, "after fragmwent");
        viewPager.setAdapter(new MyAdapter(fragmentManager));
        Log.d(TAG, "after adapter");
    }

}

class MyAdapter extends FragmentPagerAdapter {

    public MyAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if(position==0){
             fragment= new Register();

        }
        if(position==1){
            fragment=new Register();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position==0)
            return "Login";
        if (position==1)
            return "Register";

        return super.getPageTitle(position);
    }
}