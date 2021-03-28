package com.news.sky.viewmodels;

import android.util.JsonReader;
import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.news.sky.api.GamerSkyApi;
import com.news.sky.api.GamerSkyService;
import com.news.sky.data.AppNewsListJson;
import com.news.sky.data.AppNewsListPostJson;
import com.news.sky.data.Article;
import com.news.sky.util.AppUtil;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainViewModel extends ViewModel {
    private final static String TAG="MainViewModel";

    private MutableLiveData<List<Article>> articleList;

    public MutableLiveData<List<Article>> getArticleList() {
        if(articleList==null){
            articleList=new MutableLiveData<>();
            loadData();
        }
        return articleList;
    }

    private void loadData(){

        GamerSkyApi.create()
                .getAppNewsList(AppNewsListPostJson.getAppNewsListPostJson())
                .enqueue(new Callback<AppNewsListJson>() {
                    @Override
                    public void onResponse(@NotNull Call<AppNewsListJson> call, @NotNull Response<AppNewsListJson> response) {
                        if(response.isSuccessful()){
                            AppNewsListJson appNewsListJson=response.body();
                            articleList.setValue(AppUtil.jsonToArticle(appNewsListJson));
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<AppNewsListJson> call, @NotNull Throwable t) {
                        t.printStackTrace();
                    }
                });
    }

}
