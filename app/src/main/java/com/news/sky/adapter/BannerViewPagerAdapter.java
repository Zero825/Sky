package com.news.sky.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.data.ArticleInformation;
import com.news.sky.databinding.ItemBannerContentBinding;
import com.news.sky.diffutil.ArticleDiffCallback;

import java.util.ArrayList;
import java.util.List;

public class BannerViewPagerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final static String TAG = "ArticleRecyclerViewAdapter";

    private List<ArticleInformation> data;

    public BannerViewPagerAdapter() {
        this.data = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemBannerContentBinding binding
                = ItemBannerContentBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BannerItemViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BannerItemViewHolder bannerItemViewHolder = (BannerItemViewHolder) holder;
        bannerItemViewHolder.binding.setArtilce(data.get(position));
        bannerItemViewHolder.articleOnClickListener.setContentId(data.get(position).getContentId());
        bannerItemViewHolder.articleOnClickListener.setClubId(data.get(position).getClubId());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void submitList(List<ArticleInformation> newData) {
        ArticleDiffCallback articleDiffCallback = new ArticleDiffCallback(data, newData);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(articleDiffCallback);
        this.data = newData;
        diffResult.dispatchUpdatesTo(this);
    }

    public static class BannerItemViewHolder extends RecyclerView.ViewHolder {
        private final ItemBannerContentBinding binding;
        private final ArticleInformationAdapter.ArticleOnClickListener articleOnClickListener;

        public BannerItemViewHolder(@NonNull ItemBannerContentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot()
                    .setOnClickListener(articleOnClickListener = new ArticleInformationAdapter.ArticleOnClickListener());
        }
    }
}
