package com.news.sky.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.data.Article;
import com.news.sky.databinding.ItemArticleBinding;

import java.util.List;

public class ArticleRecyclerViewAdapter extends ListAdapter<Article, ArticleRecyclerViewAdapter.ArticleViewHolder> {
    private final static String TAG="ArticleRecyclerViewAdapter";

    public ArticleRecyclerViewAdapter() {
        super(new ArticleDiffCallback());
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemArticleBinding binding
                =ItemArticleBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ArticleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        ItemArticleBinding binding=((ArticleViewHolder)holder).binding;
        binding.setArtilce(getItem(position));
    }


    public static class ArticleViewHolder extends RecyclerView.ViewHolder{
        public ItemArticleBinding binding;

        public ArticleViewHolder(@NonNull ItemArticleBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    private static class ArticleDiffCallback extends DiffUtil.ItemCallback<Article>{

        @Override
        public boolean areItemsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return oldItem.title.equals(newItem.title);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Article oldItem, @NonNull Article newItem) {
            return false;
        }
    }
}
