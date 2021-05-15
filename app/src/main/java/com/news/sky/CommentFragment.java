package com.news.sky;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.adapter.CommentAdapter;
import com.news.sky.databinding.FragmentCommentBinding;
import com.news.sky.viewmodels.CommentViewModel;

import static com.news.sky.ArticleActivity.CLUB_ID;
import static com.news.sky.ArticleActivity.CONTENT_ID;

public class CommentFragment extends Fragment {
    private final static String TAG="CommentFragment";

    private FragmentCommentBinding binding;
    private LinearLayoutManager linearLayoutManager;
    private CommentAdapter commentAdapter;
    private CommentViewModel commentViewModel;
    private int lastFlag=0;
    private int flag=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=FragmentCommentBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        init();
        startListen();
    }

    private void init(){
        Bundle bundle = getArguments();

        linearLayoutManager = new LinearLayoutManager(requireContext());
        commentAdapter = new CommentAdapter();
        binding.commentRecyclerView.setLayoutManager(linearLayoutManager);
        binding.commentRecyclerView.setAdapter(commentAdapter);
        binding.commentRecyclerView.setHasFixedSize(true);

        commentViewModel=new ViewModelProvider(requireActivity()).get(CommentViewModel.class);
        commentViewModel.getCommentList(bundle.getLong(CONTENT_ID),bundle.getLong(CLUB_ID))
                .observe(getViewLifecycleOwner(), commentParts -> commentAdapter.submitList(commentParts));

    }

    private void startListen(){
        binding.commentRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

                if(lastVisibleItemPosition== commentAdapter.getItemCount()-1&&lastVisibleItemPosition!=flag){
                    lastFlag=flag;
                    flag=lastVisibleItemPosition;
                    Thread loadThread=new Thread(() -> {
                        if(!commentViewModel.loadNextData(getArguments().getLong(CONTENT_ID),getArguments().getLong(CLUB_ID))){
                            flag=lastFlag;
                        }
                    });
                    loadThread.start();
                }
            }
        });
    }

    public static String getTAG() {
        return TAG;
    }

}
