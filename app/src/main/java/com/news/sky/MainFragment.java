package com.news.sky;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.adapter.ArticleRecyclerViewAdapter;
import com.news.sky.databinding.FragmentMainBinding;
import com.news.sky.viewmodels.MainViewModel;

public class MainFragment extends Fragment {
    private final static String TAG="MainFragment";

    private FragmentMainBinding fragmentMainBinding;
    private MainViewModel mainViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMainBinding=FragmentMainBinding.inflate(inflater,container,false);
        View view=fragmentMainBinding.getRoot();
        init();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMainBinding = null;
    }

    private void init(){
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        ArticleRecyclerViewAdapter articleRecyclerViewAdapter=new ArticleRecyclerViewAdapter();
        fragmentMainBinding.articleRecyclerview.setLayoutManager(linearLayoutManager);
        fragmentMainBinding.articleRecyclerview.setAdapter(articleRecyclerViewAdapter);
        fragmentMainBinding.articleRecyclerview.setHasFixedSize(true);

        mainViewModel=new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mainViewModel.getArticleList().observe(getViewLifecycleOwner(), articleRecyclerViewAdapter::submitList);
    }
}
