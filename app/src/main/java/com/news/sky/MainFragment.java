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

import com.news.sky.adapter.ArticleInformationAdapter;
import com.news.sky.databinding.FragmentMainBinding;
import com.news.sky.viewmodels.MainViewModel;

public class MainFragment extends Fragment {
    private final static String TAG="MainFragment";

    private FragmentMainBinding fragmentMainBinding;
    private MainViewModel mainViewModel;
    private LinearLayoutManager linearLayoutManager;
    private ArticleInformationAdapter articleInformationAdapter;
    private int lastFlag=0;
    private int flag=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentMainBinding=FragmentMainBinding.inflate(inflater,container,false);
        return fragmentMainBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        startListen();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        fragmentMainBinding = null;
    }

    private void init(){

        linearLayoutManager=new LinearLayoutManager(getContext());
        articleInformationAdapter =new ArticleInformationAdapter();
        fragmentMainBinding.articleRecyclerView.setLayoutManager(linearLayoutManager);
        fragmentMainBinding.articleRecyclerView.setAdapter(articleInformationAdapter);
        fragmentMainBinding.articleRecyclerView.setHasFixedSize(true);

        fragmentMainBinding.articleSwipeRefreshLayout.setColorSchemeColors(requireContext().getResources().getColor(R.color.primary_color_3));

        mainViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        mainViewModel.getBannerList().observe(getViewLifecycleOwner(), articleInformationAdapter.getBannerViewPagerAdapter()::submitList);
        mainViewModel.getArticleList().observe(getViewLifecycleOwner(), articleInformationAdapter::submitList);


    }

    private void startListen(){
        fragmentMainBinding.articleSwipeRefreshLayout.setOnRefreshListener(() -> {
            flag=0;
            lastFlag=0;
            Thread loadThread=new Thread(()->{
                if(mainViewModel.refreshData()){

                }else {

                }
                fragmentMainBinding.articleSwipeRefreshLayout.post(()->{
                    fragmentMainBinding.articleSwipeRefreshLayout.setRefreshing(false);
                });
            });
            loadThread.start();
        });
        fragmentMainBinding.articleRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
                if(lastVisibleItemPosition== articleInformationAdapter.getItemCount()-1&&lastVisibleItemPosition!=flag){
                    flag=lastVisibleItemPosition;
                    lastFlag=flag;
                    Thread loadThread=new Thread(() -> {
                        if(!mainViewModel.loadNextData()){
                            flag=lastFlag;
                        }
                    });
                    loadThread.start();
                }
            }
        });
    }
}
