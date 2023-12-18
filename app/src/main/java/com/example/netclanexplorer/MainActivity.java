package com.example.netclanexplorer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.netclanexplorer.adapter.MyPagerAdapter;
import com.example.netclanexplorer.fragments.BusinessFragment;
import com.example.netclanexplorer.fragments.MerchantFragment;
import com.example.netclanexplorer.fragments.PersonalFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new PersonalFragment());
        fragments.add(new BusinessFragment());
        fragments.add(new MerchantFragment());

        MyPagerAdapter pagerAdapter = new MyPagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> tab.setText(getTabTitle(position))
        ).attach();
    }

    private String getTabTitle(int position) {
        switch (position) {
            case 0:
                return "Personal";
            case 1:
                return "Business";
            case 2:
                return "Merchant";
            default:
                return null;
        }
    }
}