package com.news.sky.pagetransformer;

import android.util.Log;
import android.view.View;

import androidx.viewpager2.widget.ViewPager2;

import com.news.sky.R;

public class BannerTransformer implements ViewPager2.PageTransformer {
    private final static String TAG = "BannerTransformer";

    public void transformPage(View view, float position) {
        float offset = view.getContext().getResources().getDimension(R.dimen.banner_offset);
        float translationX = - position * offset;
        view.setTranslationX(translationX);
    }
}

