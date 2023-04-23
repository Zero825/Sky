package com.news.sky;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.billy.android.swipe.SmartSwipe;
import com.billy.android.swipe.SmartSwipeWrapper;
import com.billy.android.swipe.SwipeConsumer;
import com.billy.android.swipe.consumer.StayConsumer;
import com.billy.android.swipe.listener.SimpleSwipeListener;
import com.news.sky.databinding.ActivityCommentBinding;
import com.news.sky.util.AppUtil;
import com.news.sky.util.UIUtil;

public class CommentActivity extends AppCompatActivity {
    private final static String TAG="CommentActivity";

    private ActivityCommentBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityCommentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        startListen();
    }

    private void init(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if(getSupportFragmentManager().findFragmentById(R.id.comment_container)==null) {
            CommentFragment commentFragment=new CommentFragment();
            commentFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.comment_container, commentFragment, commentFragment.getTag())
                    .commit();
        }
        UIUtil.setWindowTransparent(getWindow());
    }

    private void startListen(){
        StayConsumer stayConsumer = new StayConsumer();
        SmartSwipe.wrap(this)
                .addConsumer(stayConsumer)
                .enableLeft()
                .addListener(new SimpleSwipeListener(){
                    @Override
                    public void onSwipeOpened(SmartSwipeWrapper wrapper, SwipeConsumer consumer, int direction) {
                        super.onSwipeOpened(wrapper, consumer, direction);
                        finish();
                    }
                });
    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

}
