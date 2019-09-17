package com.learning.android_tabimpl;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TabLayout myTabLayout;
    ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myTabLayout = findViewById(R.id.myTabLayout);
        myViewPager = findViewById(R.id.myViewPager);

        myTabLayout.setupWithViewPager(myViewPager);
        setUpViewPager(myViewPager);
    }

    public void setUpViewPager(ViewPager viewPager){
        MyViewPageAdapter adapter = new MyViewPageAdapter(getSupportFragmentManager());
        adapter.addFragmentPage(new Page_1(),"Page1");
        adapter.addFragmentPage(new Page_2(),"Page2");
        adapter.addFragmentPage(new Page_3(),"Page3");
        viewPager.setAdapter(adapter);
    }

    class MyViewPageAdapter extends FragmentPagerAdapter{
        private List<Fragment> myFragmentList = new ArrayList<>();
        private List<String> myPageTitle = new ArrayList<>();

        public MyViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        public void addFragmentPage(Fragment fragment, String title){
            myFragmentList.add(fragment);
            myPageTitle.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return myFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return myPageTitle.get(position);
        }
    }
}
