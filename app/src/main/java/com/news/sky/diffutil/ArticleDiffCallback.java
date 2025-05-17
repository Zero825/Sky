package com.news.sky.diffutil;

import androidx.recyclerview.widget.DiffUtil;

import com.news.sky.data.ArticleInformation;

import java.util.List;

public class ArticleDiffCallback extends DiffUtil.Callback {
    private final static String TAG = "ArticleDiffCallback";

    private final List<ArticleInformation> oldData;
    private final List<ArticleInformation> newData;

    public ArticleDiffCallback(List<ArticleInformation> oldData, List<ArticleInformation> newData) {
        this.oldData = oldData;
        this.newData = newData;
    }

    @Override
    public int getOldListSize() {
        return oldData.size();
    }

    @Override
    public int getNewListSize() {
        return newData.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return newData.get(newItemPosition).getContentId() == oldData.get(oldItemPosition).getContentId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        ArticleInformation oldThing = oldData.get(oldItemPosition);
        ArticleInformation newThing = newData.get(newItemPosition);
        return oldThing.getCommentCount() == newThing.getCommentCount()
                && oldThing.getTime() == newThing.getTime()
                && oldThing.getTitle().equals(newThing.getTitle());
    }
}
