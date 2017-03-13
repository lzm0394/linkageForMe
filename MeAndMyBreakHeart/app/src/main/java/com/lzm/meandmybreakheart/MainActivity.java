package com.lzm.meandmybreakheart;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.lzm.meandmybreakheart.fragment.FragementOne;
import com.lzm.meandmybreakheart.fragment.FragementThree;
import com.lzm.meandmybreakheart.fragment.FragementTwo;
import com.lzm.meandmybreakheart.fragment.adapter.MeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private List<Fragment> fragments;
    private List<String> mWords;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar);
        toolbar.setTitle("你の名字");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initFragment();
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new MeAdapter(getSupportFragmentManager(), fragments, mWords));
        tabLayout.setupWithViewPager(viewPager);

    }

    private void initFragment() {
        mWords = new ArrayList<>();
        mWords.add("二叶");
        mWords.add("三叶");
        mWords.add("四叶");

        fragments = new ArrayList<>();
        fragments.add(new FragementOne());
        fragments.add(new FragementTwo());
        fragments.add(new FragementThree());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Toast.makeText(this, "show....", Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
