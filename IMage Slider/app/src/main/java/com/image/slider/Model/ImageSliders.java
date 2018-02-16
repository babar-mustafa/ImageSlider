package com.image.slider.Model;

import android.support.annotation.DrawableRes;

/**
 * Created by Dev on 15/02/2018.
 */

public class ImageSliders {
    private String name;

    //optional @DrawableRes
    @DrawableRes
    private int resId;

    public ImageSliders(String name, int resId) {
        this.name = name;
        this.resId = resId;
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public int getResId() {
        return resId;
    }
    //getters and setters

}