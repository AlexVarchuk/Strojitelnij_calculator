package com.example.olexandr.stroj_calc.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.olexandr.stroj_calc.R;
import com.example.olexandr.stroj_calc.adapter.TabFragmentAdapter;
import com.example.olexandr.stroj_calc.fragment.ConcreteFragment;
import com.example.olexandr.stroj_calc.model.ConcreteModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private ConcreteFragment mConcreteFragment;
    private ViewPager mPager;
    private TabLayout mTabLayout;

    private List<ConcreteModel> partConcrete;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        setCollapseTitle(getBaseContext());
        mConcreteFragment = new ConcreteFragment();


        //setupViewPager(mPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.concrete));
        mTabLayout.addTab(mTabLayout.newTab().setText(R.string.cutting));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //mTabLayout.setupWithViewPager(mPager);
        mPager = (ViewPager) findViewById(R.id.vp_CM);
        final PagerAdapter adapter = new TabFragmentAdapter(getSupportFragmentManager(), mTabLayout.getTabCount());
        mPager.setAdapter(adapter);
        mPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        // setFragment();




    }

    private void setupViewPager(ViewPager mPager) {
        mTabLayout.addTab(mTabLayout.newTab().setText("Бетон"));
        mTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    }

//    private void setFragment() {
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.add(R.id.ll_ForFragment, mConcreteFragment, ConcreteFragment.TAG);
//        transaction.commit();
//
//    }




    private void setCollapseTitle(Context context) {
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.main_collapsing);
        collapsingToolbarLayout.setTitle(getTitle());
        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(context, R.color.primary_text));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
