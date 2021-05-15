package com.news.sky.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.news.sky.api.GamerSkyApi;
import com.news.sky.api.GamerSkyOtherApi;
import com.news.sky.data.ArticleJson;
import com.news.sky.data.ArticlePostJson;
import com.news.sky.articlepart.ArticlePart;
import com.news.sky.data.ClubArticleJson;
import com.news.sky.data.ClubArticlePostJson;
import com.news.sky.util.DataTransform;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ArticleViewModel extends ViewModel {
    private final static String TAG="ArticleViewModel";

    private MutableLiveData<List<ArticlePart>> articleLiveData;

    public MutableLiveData<List<ArticlePart>> getArticleLiveData(long contentId,long clubId) {
        if(articleLiveData==null){
            articleLiveData = new MutableLiveData<>();
            if(clubId!=-1){
                getClubArticle(clubId);
            }else {
                getArticle(contentId);
            }
            return articleLiveData;
        }
        return articleLiveData;
    }

    private void getArticle(long id){
        GamerSkyApi.create()
                .getAppArticle(ArticlePostJson.getAppArticlePostJson(id))
                .enqueue(new Callback<ArticleJson>() {
                    @Override
                    public void onResponse(@NotNull Call<ArticleJson> call, @NotNull Response<ArticleJson> response) {
                        if(response.isSuccessful()){
                            articleLiveData.setValue(DataTransform.appArticleJsonToArticlePart(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(@NotNull Call<ArticleJson> call, @NotNull Throwable t) {

                    }
                });
    }

    private void getClubArticle(long id){
        GamerSkyOtherApi.create()
                .getClubArticle(ClubArticlePostJson.getClubArticlePostJson(id))
                .enqueue(new Callback<ClubArticleJson>() {
                    @Override
                    public void onResponse(Call<ClubArticleJson> call, Response<ClubArticleJson> response) {
                        articleLiveData.setValue(DataTransform.clubArticleJsonToArticlePart(response.body()));
                    }

                    @Override
                    public void onFailure(Call<ClubArticleJson> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
    }
}
