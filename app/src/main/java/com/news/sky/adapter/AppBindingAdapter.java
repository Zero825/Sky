package com.news.sky.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class AppBindingAdapter {
    private final static String TAG="AppBindingAdapter";

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView,String imageUrl){
        Glide.with(imageView).load(imageUrl).into(imageView);
    }

}
