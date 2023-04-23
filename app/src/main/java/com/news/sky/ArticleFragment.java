package com.news.sky;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.adapter.ArticleAdapter;
import com.news.sky.databinding.FragmentArticleBinding;
import com.news.sky.viewmodels.ArticleViewModel;

import static com.news.sky.ArticleActivity.CLUB_ID;
import static com.news.sky.ArticleActivity.CONTENT_ID;

public class ArticleFragment extends Fragment {
    public final static String TAG="ArticleFragment";

    private FragmentArticleBinding fragmentArticleBinding;
    private ArticleViewModel articleViewModel;
    private PreLoadLayoutManager linearLayoutManager;
    private ArticleAdapter articleAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentArticleBinding=FragmentArticleBinding.inflate(inflater,container,false);
        init();
        startListen();
        return fragmentArticleBinding.getRoot();
    }

    private void init(){
        Bundle bundle = getArguments();
        Log.i(TAG, "init: "+bundle.getLong(CONTENT_ID));
        Log.i(TAG, "init: "+bundle.getLong(CLUB_ID));
        linearLayoutManager= new PreLoadLayoutManager(getContext());
        linearLayoutManager.setExtraLayoutSpace(getResources().getDisplayMetrics().heightPixels);
        articleAdapter=new ArticleAdapter();
        fragmentArticleBinding.articleContent.setLayoutManager(linearLayoutManager);
        fragmentArticleBinding.articleContent.setAdapter(articleAdapter);
        fragmentArticleBinding.articleContent.setHasFixedSize(true);

        articleViewModel = new ViewModelProvider(requireActivity()).get(ArticleViewModel.class);
        articleViewModel.getArticleLiveData(bundle.getLong(CONTENT_ID),bundle.getLong(CLUB_ID))
                .observe(getViewLifecycleOwner(), articleAdapter::submitList);
    }

    private void startListen() {
        fragmentArticleBinding.btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().finish();
            }
        });
        fragmentArticleBinding.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ArticleActivity)requireActivity()).openCommentActivity();
            }
        });
    }

    public static String getTAG() {
        return TAG;
    }

    public static class PreLoadLayoutManager extends LinearLayoutManager{
        private static final int DEFAULT_EXTRA_LAYOUT_SPACE = 600;
        private int extraLayoutSpace = -1;

        public PreLoadLayoutManager(Context context) {
            super(context);
        }

        public PreLoadLayoutManager(Context context, int orientation, boolean reverseLayout) {
            super(context, orientation, reverseLayout);
        }

        public PreLoadLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
            super(context, attrs, defStyleAttr, defStyleRes);
        }

        public int getExtraLayoutSpace() {
            return extraLayoutSpace;
        }

        public void setExtraLayoutSpace(int extraLayoutSpace) {
            this.extraLayoutSpace = extraLayoutSpace;
        }

        @Override
        protected void calculateExtraLayoutSpace(@NonNull RecyclerView.State state, @NonNull int[] extraLayoutSpace) {
            if (this.extraLayoutSpace > 0) {
                extraLayoutSpace[0] = this.extraLayoutSpace;
                extraLayoutSpace[1] = this.extraLayoutSpace;
            }else {
                extraLayoutSpace[0] = DEFAULT_EXTRA_LAYOUT_SPACE;
                extraLayoutSpace[1] = DEFAULT_EXTRA_LAYOUT_SPACE;
            }

        }

    }
}
