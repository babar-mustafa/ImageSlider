package com.image.slider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.image.slider.Model.ImageSliders;

import java.util.List;

/**
 * Created by Dev on 12/01/2018.
 */

public class ImageSliderAdapter extends PagerAdapter {

    private Context mContext;
    private List<ImageSliders> imageList;
    private LayoutInflater inflater;

    public ImageSliderAdapter(Context context, List<ImageSliders> list) {
        mContext = context;
        imageList = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        ViewGroup imageLayout = (ViewGroup) inflater.inflate(R.layout.slider_home, collection, false);
        ((ImageView) imageLayout.findViewById(R.id.imageView)).setImageResource(imageList.get(position).getResId());
//        Toast.makeText(mContext, "<<<<<<<<"+imageList.get(position).getName(), Toast.LENGTH_SHORT).show();

        collection.addView(imageLayout);
        return imageLayout;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return imageList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return imageList.get(position).getName();
    }
}
