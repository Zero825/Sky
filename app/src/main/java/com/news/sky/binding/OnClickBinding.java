package com.news.sky.binding;

import android.content.Intent;
import android.view.View;

import com.google.gson.Gson;
import com.news.sky.ImageBrowerActivity;
import com.news.sky.commentpart.ImageInfe;

import java.util.List;

import static com.news.sky.ImageBrowerActivity.IMAGE_LIST;
import static com.news.sky.ImageBrowerActivity.IMAGE_POSITION;

public class OnClickBinding {
    private final static String TAG="OnClickBinding";

    private final static Gson gson = new Gson();

    public void onImageClick(View view, int position, List<ImageInfe> imageInfes){
        Intent intent = new Intent(view.getContext(), ImageBrowerActivity.class);
        intent.putExtra(IMAGE_POSITION, position);
        intent.putExtra(IMAGE_LIST,gson.toJson(imageInfes));
        view.getContext().startActivity(intent);
    }
}
