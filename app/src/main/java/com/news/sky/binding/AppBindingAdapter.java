package com.news.sky.binding;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.databinding.BindingAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.gson.Gson;
import com.news.sky.ImageBrowerActivity;
import com.news.sky.R;
import com.news.sky.commentpart.ImageInfe;
import com.news.sky.pagetransformer.ZoomOutPageTransformer;
import com.news.sky.util.AppUtil;

import java.util.List;

import static com.news.sky.ImageBrowerActivity.IMAGE_LIST;
import static com.news.sky.ImageBrowerActivity.IMAGE_POSITION;

public class AppBindingAdapter {
    private final static String TAG="AppBindingAdapter";

    public final static int ROUNDING_RADIUS = 8;
    public final static int ROUNDING_RADIUS_SMALL = 4;

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView,String imageUrl){
        if(imageUrl==null||imageUrl.isEmpty()){
            return;
        }
        RequestBuilder<Drawable> requestBuilder = Glide.with(imageView)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade());
        if(imageUrl.contains(".gif")){
            requestBuilder = requestBuilder.transform(new RoundedCorners(ROUNDING_RADIUS_SMALL));
        }else {
            requestBuilder = requestBuilder.transform(new CenterCrop(),new RoundedCorners(ROUNDING_RADIUS));
        }
        requestBuilder.into(imageView);
    }

    @BindingAdapter("imageUrlCircleCrop")
    public static void setImageUrlCircleCrop(ImageView imageView,String imageUrl){
        if(imageUrl==null||imageUrl.isEmpty()){
            return;
        }
        Glide.with(imageView)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade())
                .transform(new CircleCrop()).into(imageView);
    }

    @BindingAdapter("imageUrlNoRound")
    public static void setImageUrlNoRound(ImageView imageView,String imageUrl){
        if(imageUrl==null||imageUrl.isEmpty()){
            return;
        }
        RequestBuilder<Drawable> requestBuilder = Glide.with(imageView)
                .load(imageUrl)
                .transition(DrawableTransitionOptions.withCrossFade());
        if(!imageUrl.contains(".gif")){
            requestBuilder = requestBuilder.transform(new CenterCrop());
        }
        requestBuilder.into(imageView);
    }

    @BindingAdapter("imageUrlNoCrop")
    public static void setImageUrlNoCrop(ImageView imageView, String imageUrl){
        if(imageUrl==null||imageUrl.isEmpty()){
            return;
        }
        Glide.with(imageView)
                .load(imageUrl)
                .addListener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        int imageWidth = resource.getIntrinsicWidth();
                        int imageHeight = resource.getIntrinsicHeight();
                        ViewGroup.LayoutParams params = imageView.getLayoutParams();
                        params.height = (int) ((float) imageView.getWidth() / imageWidth * imageHeight);
                        Glide.with(imageView)
                                .load(imageUrl)
                                .transition(DrawableTransitionOptions.withCrossFade())
                                .transform(new RoundedCorners(ROUNDING_RADIUS_SMALL))
                                .into(imageView);
                        return false;
                    }
                }).preload();

    }


    @BindingAdapter("zoomOutPageTransformer")
    public static void setZoomOutPageTransformer(ViewPager2 viewPager2,boolean pageTransformer){
        if(pageTransformer){
            viewPager2.setPageTransformer(new ZoomOutPageTransformer());
        }
    }


}
