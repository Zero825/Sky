package com.news.sky.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.material.chip.Chip;
import com.google.gson.Gson;
import com.news.sky.ArticleActivity;
import com.news.sky.ImageBrowerActivity;
import com.news.sky.articlepart.ArticleHeader;
import com.news.sky.articlepart.ArticleImg;
import com.news.sky.articlepart.ArticleP;
import com.news.sky.articlepart.ArticlePart;
import com.news.sky.articlepart.ArticleTag;
import com.news.sky.databinding.ItemArticleHeaderBinding;
import com.news.sky.databinding.ItemArticleImgBinding;
import com.news.sky.databinding.ItemArticlePBinding;
import com.news.sky.databinding.ItemArticleTagBinding;

import java.util.List;

import static com.news.sky.ArticleActivity.CLUB_ID;
import static com.news.sky.ArticleActivity.CONTENT_ID;
import static com.news.sky.ImageBrowerActivity.IMAGE_LIST;
import static com.news.sky.ImageBrowerActivity.IMAGE_POSITION;


public class ArticleAdapter extends ListAdapter<ArticlePart,RecyclerView.ViewHolder> {
    private final static String TAG="ArticleAdapter";

    public ArticleAdapter() {
        super(new DiffUtil.ItemCallback<ArticlePart>() {
            @Override
            public boolean areItemsTheSame(@NonNull ArticlePart oldItem, @NonNull ArticlePart newItem) {
                return false;
            }

            @Override
            public boolean areContentsTheSame(@NonNull ArticlePart oldItem, @NonNull ArticlePart newItem) {
                return false;
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==ArticlePart.TYPE_HEADER){
            ItemArticleHeaderBinding binding=ItemArticleHeaderBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ArticleHeaderViewHolder(binding);
        }else if(viewType==ArticlePart.TYPE_TAG){
            ItemArticleTagBinding binding=ItemArticleTagBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ArticleTagViewHolder(binding);
        }else if(viewType==ArticlePart.TYPE_IMG){
            ItemArticleImgBinding binding=ItemArticleImgBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ArticleImgViewHolder(binding);
        }else {
            ItemArticlePBinding binding=ItemArticlePBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ArticlePViewHolder(binding);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType=holder.getItemViewType();

        if(viewType==ArticlePart.TYPE_HEADER){
            ((ArticleHeaderViewHolder)holder).binding.setArticleHeader((ArticleHeader) getItem(position));
        }else if(viewType==ArticlePart.TYPE_TAG) {

            ItemArticleTagBinding binding=((ArticleTagViewHolder) holder).binding;
            if(binding.articleTagChips.getChildCount()==0) {
                List<String> tagList = ((ArticleTag)getItem(position)).getTagList();
                Context context = binding.getRoot().getContext();
                for (String tag : tagList) {
                    Chip chip = new Chip(context);
                    chip.setText(tag);
                    binding.articleTagChips.addView(chip);
                }
            }

        }else if(viewType==ArticlePart.TYPE_IMG){
            ArticleImgViewHolder articleImgViewHolder = (ArticleImgViewHolder)holder;
            articleImgViewHolder.binding.setArticleImg((ArticleImg) getItem(position));
            articleImgViewHolder.imageOnClickListener.setArticleImg((ArticleImg) getItem(position));

        }else {
            ((ArticlePViewHolder)holder).binding.setArticleP((ArticleP) getItem(position));
        }
    }

    public static class ImageOnClickListener implements View.OnClickListener{
        private ArticleImg articleImg;
        private Gson gson;

        public ImageOnClickListener() {
            gson = new Gson();
        }

        @Override
        public void onClick(View v) {
            if(articleImg!=null) {
                Intent intent = new Intent(v.getContext(), ImageBrowerActivity.class);
                intent.putExtra(IMAGE_POSITION, articleImg.getPosition());
                intent.putExtra(IMAGE_LIST,gson.toJson(articleImg.getImageInfes()));
                v.getContext().startActivity(intent);
            }
        }

        public void setArticleImg(ArticleImg articleImg) {
            this.articleImg = articleImg;
        }
    }

    private static class ArticlePViewHolder extends RecyclerView.ViewHolder{
        ItemArticlePBinding binding;

        public ArticlePViewHolder(@NonNull ItemArticlePBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    private static class ArticleImgViewHolder extends RecyclerView.ViewHolder{
        ItemArticleImgBinding binding;
        ImageOnClickListener imageOnClickListener = new ImageOnClickListener();

        public ArticleImgViewHolder(@NonNull ItemArticleImgBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.getRoot().setOnClickListener(imageOnClickListener);
        }
    }

    private static class ArticleHeaderViewHolder extends RecyclerView.ViewHolder{
        ItemArticleHeaderBinding binding;

        public ArticleHeaderViewHolder(@NonNull ItemArticleHeaderBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    private static class ArticleTagViewHolder extends RecyclerView.ViewHolder{
        ItemArticleTagBinding binding;

        public ArticleTagViewHolder(@NonNull ItemArticleTagBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }

    }




}
