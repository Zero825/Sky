                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            package com.news.sky.adapter;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.PointF;
import android.net.Uri;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.github.piasy.biv.indicator.ProgressIndicator;
import com.github.piasy.biv.loader.ImageLoader;
import com.github.piasy.biv.view.BigImageView;
import com.github.piasy.biv.view.GlideImageViewFactory;
import com.news.sky.commentpart.ImageInfe;
import com.news.sky.databinding.ItemBigImageBinding;

import java.io.File;

public class ImageBrowerAdapter extends ListAdapter<ImageInfe, ImageBrowerAdapter.ImageBorwerViewHolder> {

    public ImageBrowerAdapter() {
        super(new DiffUtil.ItemCallback<ImageInfe>() {
            @Override
            public boolean areItemsTheSame(@NonNull ImageInfe oldItem, @NonNull ImageInfe newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull ImageInfe oldItem, @NonNull ImageInfe newItem) {
                return false;
            }
        });
    }

    @NonNull
    @Override
    public ImageBorwerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBigImageBinding binding = ItemBigImageBinding
                .inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ImageBorwerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageBorwerViewHolder holder, int position) {
        holder.binding.bigImageView.showImage(Uri.parse(getItem(position).getOrigin()));
    }

    public static class ImageBorwerViewHolder extends RecyclerView.ViewHolder {
        ItemBigImageBinding binding;


        public ImageBorwerViewHolder(@NonNull ItemBigImageBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            init();
        }

        private void init(){
            binding.bigImageView.setImageViewFactory(new GlideImageViewFactory());
            binding.bigImageView.setProgressIndicator(new ProgressIndicator() {
                @Override
                public View getView(BigImageView parent) {
                    return null;
                }

                @Override
                public void onStart() {
                    binding.indicator.show();
                }

                @Override
                public void onProgress(int progress) {
                    binding.indicator.setProgressCompat(progress,true);
                }

                @Override
                public void onFinish() {
                    binding.indicator.hide();
                }
            });
            binding.bigImageView.setImageLoaderCallback(new ImageLoader.Callback() {
                @Override
                public void onCacheHit(int imageType, File image) {

                }

                @Override
                public void onCacheMiss(int imageType, File image) {

                }

                @Override
                public void onStart() {

                }

                @Override
                public void onProgress(int progress) {

                }

                @Override
                public void onFinish() {

                }

                @Override
                public void onSuccess(File image) {
                    if(binding.bigImageView.getSSIV()!=null){
                        setSSIVListener(binding.bigImageView.getSSIV());
                    }
                }

                @Override
                public void onFail(Exception error) {

                }
            });

            binding.bigImageView.setOnClickListener(v -> ((Activity)v.getContext()).finish());
        }

        private void setSSIVListener(SubsamplingScaleImageView subsamplingScaleImageView){
            subsamplingScaleImageView.setOnImageEventListener(new SubsamplingScaleImageView.OnImageEventListener() {
                @Override
                public void onReady() {
                    letSSIVSmooth(subsamplingScaleImageView);
                }

                @Override
                public void onImageLoaded() {

                }

                @Override
                public void onPreviewLoadError(Exception e) {

                }

                @Override
                public void onImageLoadError(Exception e) {

                }

                @Override
                public void onTileLoadError(Exception e) {

                }

                @Override
                public void onPreviewReleased() {

                }
            });
        }

        private void letSSIVSmooth(SubsamplingScaleImageView subsamplingScaleImageView){
            subsamplingScaleImageView.setMaxScale(5.0f);
            subsamplingScaleImageView.setDoubleTapZoomDuration(300);

            final int LONG_IMAGE_SIZE_RATIO = 2;
            float result = 0.5f;
            int imageWidth = subsamplingScaleImageView.getSWidth();
            int imageHeight = subsamplingScaleImageView.getSHeight();
            int viewWidth = subsamplingScaleImageView.getWidth();
            int viewHeight = subsamplingScaleImageView.getHeight();

            boolean hasZeroValue = false;
            if (imageWidth == 0 || imageHeight == 0 || viewWidth == 0 || viewHeight == 0) {
                result = 0.5f;
                hasZeroValue = true;
            }

            if (!hasZeroValue) {

                result = (float) viewHeight / imageHeight;

            }

            if (!hasZeroValue && (float) imageHeight / imageWidth > LONG_IMAGE_SIZE_RATIO) {
                result = (float) viewWidth / imageWidth;
                // scale at top
                subsamplingScaleImageView
                        .animateScaleAndCenter(result, new PointF(imageWidth / 2, 0))
                        .withEasing(SubsamplingScaleImageView.EASE_OUT_QUAD)
                        .start();
                subsamplingScaleImageView.setDoubleTapZoomScale(result+0.5f);
            }else {
                subsamplingScaleImageView.setDoubleTapZoomScale(result);
            }
        }
    }


}
