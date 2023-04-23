package com.news.sky;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.billy.android.swipe.SmartSwipe;
import com.billy.android.swipe.SmartSwipeWrapper;
import com.billy.android.swipe.SwipeConsumer;
import com.billy.android.swipe.consumer.StayConsumer;
import com.billy.android.swipe.listener.SimpleSwipeListener;
import com.news.sky.databinding.ActivityArticleBinding;
import com.news.sky.util.AppUtil;
import com.news.sky.util.UIUtil;

import static com.billy.android.swipe.SwipeConsumer.DIRECTION_RIGHT;

public class ArticleActivity extends AppCompatActivity {
    private final static String TAG="ArticleActivity";

    public final static String CONTENT_ID="content_id";
    public final static String CLUB_ID="club_id";

    private ActivityArticleBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityArticleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        startListen();
    }

    private void init(){
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if(getSupportFragmentManager().findFragmentById(R.id.article_container)==null) {
            ArticleFragment articleFragment=new ArticleFragment();
            articleFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.article_container, articleFragment, articleFragment.getTag())
                    .commit();
        }
        UIUtil.setWindowTransparent(getWindow());
    }

    private void startListen(){
        StayConsumer stayConsumer = new StayConsumer();
        SmartSwipe.wrap(this)
                .addConsumer(stayConsumer)
                .enableHorizontal()
                .addListener(new SimpleSwipeListener(){
                    @Override
                    public void onSwipeOpened(SmartSwipeWrapper wrapper, SwipeConsumer consumer, int direction) {
                        super.onSwipeOpened(wrapper, consumer, direction);
                        if(direction==DIRECTION_RIGHT){
                            openCommentActivity();
                        }else {
                            finish();
                        }
                    }
                });
    }

    public void openCommentActivity(){
        Intent intent=new Intent(this,CommentActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }

}
