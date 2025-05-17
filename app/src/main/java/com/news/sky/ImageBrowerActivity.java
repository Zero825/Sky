package com.news.sky;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupMenu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.news.sky.adapter.ImageBrowerAdapter;
import com.news.sky.commentpart.ImageInfe;
import com.news.sky.databinding.ActivityImageBrowerBinding;
import com.news.sky.util.UIUtil;

import java.util.List;

public class ImageBrowerActivity extends AppCompatActivity {
    private static final String TAG = "ImageBrowerActivity";

    public static final String IMAGE_POSITION = "image_position";
    public static final String IMAGE_LIST = "IMAGE_LIST";

    @ViewPager2.OffscreenPageLimit
    private static final int OFFSCREEN_PAGE_LIMIT = 2;

    private ActivityImageBrowerBinding binding;
    private ImageBrowerAdapter imageBrowerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityImageBrowerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        startListen();
    }

    private void init() {
        UIUtil.setWindowTransparent(getWindow());

        int position = getIntent().getIntExtra(IMAGE_POSITION, 0);
        List<ImageInfe> imageInfes = new Gson()
                .fromJson(getIntent().getStringExtra(IMAGE_LIST)
                        , new TypeToken<List<ImageInfe>>() {
                        }.getType());

        binding.imageViewPager.setOffscreenPageLimit(OFFSCREEN_PAGE_LIMIT);
        imageBrowerAdapter = new ImageBrowerAdapter();
        binding.imageViewPager.setAdapter(imageBrowerAdapter);
        imageBrowerAdapter.submitList(imageInfes);
        binding.imageViewPager.setCurrentItem(position, false);
        binding.textIndicator.setText((position + 1) + "/" + imageBrowerAdapter.getItemCount());
    }

    private void startListen() {
        binding.back.setOnClickListener(v -> finish());
        binding.imageViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.textIndicator.setText((position + 1) + "/" + imageBrowerAdapter.getItemCount());
            }
        });
    }
}
