package com.image.slider;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.image.slider.Model.ImageSliders;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initImageSlider();
    }
    private List<ImageSliders> getImageList(){
        List<ImageSliders> imageList = new ArrayList<>();
        imageList.add(new ImageSliders("Logo",R.drawable.exterior));
        imageList.add(new ImageSliders("Steve aoki",R.drawable.exterior));
        imageList.add(new ImageSliders("Dancellenium",R.drawable.exterior));
        return imageList;
    }
    int currentPage = 0;
    int NUM_PAGES = 0;
    private void initImageSlider(){

        //Set the pager with an adapter
        viewPager.setAdapter(new ImageSliderAdapter(MainActivity.this,getImageList()));

        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(viewPager);

        final float density = getResources().getDisplayMetrics().density;

        //Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =getImageList().size();

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });
    }
    private void initViews() {
        viewPager= findViewById(R.id.viewPager);
    }
}
