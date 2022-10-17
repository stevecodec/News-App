package com.example.room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    TabItem mhome,mhealth,mtechnology,mscience,mentertainment,msports;
    PagerAdapter pagerAdapter;
    Toolbar mtoolbar;

    String api="e4c34efc09c14b01835f04f306fa82df";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar =findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome= findViewById(R.id.home);
        mscience =findViewById(R.id.science);
        mtechnology= findViewById(R.id.technology);
        mhealth=findViewById(R.id.health);
        mentertainment=findViewById(R.id.entertainment);
        ViewPager viewPager= findViewById(R.id.fragmentContainer);
        tabLayout=findViewById(R.id.include);


        pagerAdapter= new PagerAdapter(getSupportFragmentManager(),6);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition()==0 || tab.getPosition()==1||tab.getPosition()==2|| tab.getPosition()==3|| tab.getPosition()==4||tab.getPosition()==6){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
       // viewPager.addOnAdapterChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}