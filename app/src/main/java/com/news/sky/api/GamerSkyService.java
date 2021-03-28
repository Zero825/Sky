package com.news.sky.api;

import com.google.gson.JsonObject;
import com.news.sky.data.AppNewsListJson;
import com.news.sky.data.AppNewsListPostJson;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GamerSkyService {

    @POST("/v5/getAppNewsList")
    Call<AppNewsListJson> getAppNewsList(@Body AppNewsListPostJson appNewsListPostJson);
}
