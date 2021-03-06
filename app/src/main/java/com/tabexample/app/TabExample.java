package com.tabexample.app;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;


public class TabExample extends FragmentActivity implements ActionBar.TabListener {

    ViewPager viewPager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_example);

        // get the ViewPager handle
        viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new MyPageAdapter(getSupportFragmentManager()));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // create the actionBar and sets navigation mode to TABS
        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // create TAB 1
        ActionBar.Tab list_tab = actionBar.newTab();
        list_tab.setText("Event List");
        list_tab.setTabListener(this);

        // create TAB 2
        ActionBar.Tab map_tab = actionBar.newTab();
        map_tab.setText("Event Map");
        map_tab.setTabListener(this);

        // add TABS to actionBar
        actionBar.addTab(list_tab);
        actionBar.addTab(map_tab);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
}

class MyPageAdapter extends FragmentPagerAdapter {

    MyPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0: fragment = new EventListFragment();
                break;
            case 1: fragment = new EventMapFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
