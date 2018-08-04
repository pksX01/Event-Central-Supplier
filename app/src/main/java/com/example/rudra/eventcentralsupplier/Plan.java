package com.example.rudra.eventcentralsupplier;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import static android.text.Html.fromHtml;



public class Plan extends AppCompatActivity {
    ViewPager mViewPager;
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        String name11=getSharedPreferences("MyPref",Context.MODE_PRIVATE).getString("name_key",null);
        Toast.makeText(Plan.this,name11,Toast.LENGTH_LONG).show();
        Toolbar myToolbar=(Toolbar) findViewById(R.id.tool);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setTitle("Select a plan");
        getSupportActionBar().setTitle(fromHtml("<font color='#ffffff'>Select a Plan</font>"));
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mViewPager=(ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(new SamplePagerAdapter(getSupportFragmentManager()));

    }
    public class SamplePagerAdapter extends FragmentPagerAdapter {

        public SamplePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            /** Show a Fragment based on the position of the current screen */
            if (position == 0) {
                return new trail_plan();
            }
            else if (position == 1)
                return new pro_plan();
            else
                return new featured_plan();

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }
    }

}
