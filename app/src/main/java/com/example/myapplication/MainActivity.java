package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ViewPagerAdaptor viewPagerAdaptor;
    ViewPager2 viewPager2;
    TabLayout tabLayout;
    ArrayList<String> tabNameList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabNameList.add("전체");
        tabNameList.add("한식");
        tabNameList.add("중식");
        tabNameList.add("양식");
        tabNameList.add("일식");

        viewPagerAdaptor = new ViewPagerAdaptor(this);
        viewPager2 = findViewById(R.id.viewpager2);
        tabLayout = findViewById(R.id.tablayout);

        viewPager2.setAdapter(viewPagerAdaptor);


        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                TextView textView1 = new TextView(MainActivity.this);
                tab.setCustomView(textView1);
                textView1.setText(tabNameList.get(position));
                textView1.setTextSize(15);
                textView1.setTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
                textView1.setTextColor(MainActivity.this.getResources().getColor(R.color.colorPrimaryDark));
                textView1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
                viewPager2.setCurrentItem(tab.getPosition(), true);

            }
        }).attach();




    }
}
