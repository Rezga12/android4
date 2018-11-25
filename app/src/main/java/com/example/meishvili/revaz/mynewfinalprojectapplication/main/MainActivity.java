package com.example.meishvili.revaz.mynewfinalprojectapplication.main;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.meishvili.revaz.mynewfinalprojectapplication.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private String sessionId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sessionId = getIntent().getStringExtra("id");
        Log.i("Assert",sessionId);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(),this,sessionId);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        Date date = new Date();   // given date
        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(date);   // assigns calendar to given date
        int hr = calendar.get(Calendar.HOUR_OF_DAY); // gets hour in 24h format
        if (hr >= 18 || hr < 6) {
            viewPager.setBackgroundResource(R.drawable.ic_evening_bg);
        }


    }
}
