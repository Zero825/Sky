package com.news.sky.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.ArticleActivity;
import com.news.sky.data.ArticleInformation;
import com.news.sky.databinding.ItemArticlePrimaryBinding;
import com.news.sky.databinding.ItemArticleSecondaryBinding;
import com.news.sky.databinding.ItemBannerBinding;
import com.news.sky.diffutil.ArticleDiffCallback;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import static com.news.sky.ArticleActivity.CLUB_ID;
import static com.news.sky.ArticleActivity.CONTENT_ID;

public class ArticleInformationAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG="ArticleInfoAdapter";

    private final static int ITEM_ARTICLE_PRIMARY=0;
    private final static int ITEM_ARTICLE_SECONDARY=1;
    private final static int ITEM_HEADER=2;

    private List<ArticleInformation> data;
    private final BannerViewPagerAdapter bannerViewPagerAdapter;

    public ArticleInformationAdapter() {
        this.data=new ArrayList<>();
        bannerViewPagerAdapter=new BannerViewPagerAdapter();
    }

    @Override
    public int getItemViewType(int position) {

        if(data.get(position).getType()==ArticleInformation.TYPE_HEADER) {
            return ITEM_HEADER;
        }
        if(data.get(position).getPreviewImageUrl().size()>1){
            return ITEM_ARTICLE_SECONDARY;
        }else {
            return ITEM_ARTICLE_PRIMARY;
        }

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(viewType==ITEM_HEADER){
            ItemBannerBinding binding
                    = ItemBannerBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            binding.bannerViewPager.setAdapter(bannerViewPagerAdapter);
            binding.bannerViewPager.setOffscreenPageLimit(3);
            return new BannerViewHolder(binding);
        }

        if(viewType==ITEM_ARTICLE_SECONDARY){
            ItemArticleSecondaryBinding binding
                    = ItemArticleSecondaryBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ArticleViewSecondaryHolder(binding);
        }else {
            ItemArticlePrimaryBinding binding
                    = ItemArticlePrimaryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new ArticleViewPrimaryHolder(binding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {


        if(holder.getItemViewType()==ITEM_ARTICLE_PRIMARY) {
            ArticleViewPrimaryHolder articleViewPrimaryHolder=(ArticleViewPrimaryHolder) holder;
            articleViewPrimaryHolder.binding.setArtilce(data.get(position));
            articleViewPrimaryHolder.articleOnClickListener.setContentId(data.get(position).getContentId());
            articleViewPrimaryHolder.articleOnClickListener.setClubId(data.get(position).getClubId());
        }

        if(holder.getItemViewType()==ITEM_ARTICLE_SECONDARY){
            ArticleViewSecondaryHolder articleViewSecondaryHolder=(ArticleViewSecondaryHolder) holder;
            articleViewSecondaryHolder.binding.setArtilce(data.get(position));
            articleViewSecondaryHolder.articleOnClickListener.setContentId(data.get(position).getContentId());
            articleViewSecondaryHolder.articleOnClickListener.setClubId(data.get(position).getClubId());

        }
    }



    public void submitList(List<ArticleInformation> newData){
        ArticleDiffCallback articleDiffCallback=new ArticleDiffCallback(data,newData);
        DiffUtil.DiffResult diffResult=DiffUtil.calculateDiff(articleDiffCallback);
        this.data=newData;
        diffResult.dispatchUpdatesTo(this);
    }

    public BannerViewPagerAdapter getBannerViewPagerAdapter() {
        return bannerViewPagerAdapter;
    }

    public static class ArticleOnClickListener implements View.OnClickListener{
        private long contentId;
        private long clubId;


        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ArticleActivity.class);
            intent.putExtra(CONTENT_ID,contentId);
            intent.putExtra(CLUB_ID,clubId);
            v.getContext().startActivity(intent);
        }

        public void setClubId(long clubId) {
            this.clubId = clubId;
        }

        public void setContentId(long contentId) {
            this.contentId = contentId;
        }
    }

    public static class BannerViewHolder extends RecyclerView.ViewHolder{
        private ItemBannerBinding binding;

        public BannerViewHolder(ItemBannerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public static class ArticleViewPrimaryHolder extends RecyclerView.ViewHolder{
        private ItemArticlePrimaryBinding binding;
        private ArticleOnClickListener articleOnClickListener;

        public ArticleViewPrimaryHolder(@NonNull ItemArticlePrimaryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.getRoot()
                    .setOnClickListener(articleOnClickListener=new ArticleOnClickListener());
        }
    }

    public static class ArticleViewSecondaryHolder extends RecyclerView.ViewHolder{
        private ItemArticleSecondaryBinding binding;
        private ArticleOnClickListener articleOnClickListener;

        public ArticleViewSecondaryHolder(@NonNull ItemArticleSecondaryBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.getRoot()
                    .setOnClickListener(articleOnClickListener=new ArticleOnClickListener());
        }
    }


}
