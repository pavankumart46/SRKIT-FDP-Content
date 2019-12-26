package com.blogspot.pavankreddy.tabsfornavigation;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    ViewPager vp;
    TabLayout tl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vp = findViewById(R.id.viewpager);
        tl = findViewById(R.id.tablayout);
        vp.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tl.setupWithViewPager(vp);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new RedFragment();
                case 1:
                    return new GreenFragment();
                case 2:
                    return new BlueFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "RED";
                case 1:
                    return "GREEN";
                case 2:
                    return "BLUE";
            }
            return super.getPageTitle(position);
        }
    }
}
