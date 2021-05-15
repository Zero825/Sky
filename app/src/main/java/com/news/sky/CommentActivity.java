package com.news.sky;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.billy.android.swipe.SmartSwipe;
import com.billy.android.swipe.SmartSwipeWrapper;
import com.billy.android.swipe.SwipeConsumer;
import com.billy.android.swipe.consumer.StayConsumer;
import com.billy.android.swipe.listener.SimpleSwipeListener;
import com.news.sky.databinding.ActivityCommentBinding;

import static com.billy.android.swipe.SwipeConsumer.DIRECTION_RIGHT;

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
    }

    private void startListen(){
        StayConsumer stayConsumer = new StayConsumer();
        stayConsumer.setOpenDistance(50);
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
