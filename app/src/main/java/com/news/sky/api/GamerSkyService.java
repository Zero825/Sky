package com.news.sky.api;

import com.news.sky.data.ArticleJson;
import com.news.sky.data.ArticlePostJson;
import com.news.sky.data.NewsJson;
import com.news.sky.data.NewsPostJson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GamerSkyService {

    @POST("/v5/getAppNewsList")
    Call<NewsJson> getAppNewsList(@Body NewsPostJson newsPostJson);

    @POST("/v5/getArticle")
    Call<ArticleJson> getAppArticle(@Body ArticlePostJson articlePostJson);
}

