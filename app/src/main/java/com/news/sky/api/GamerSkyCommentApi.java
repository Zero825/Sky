package com.news.sky.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamerSkyCommentApi {
    private static final String TAG="GamerSkyCommentApi";

    private static final String BASE_URL="http://cm.gamersky.com/";
    private static GamerSkyCommentService gamerSkyCommentService;

    public static GamerSkyCommentService create(){
        if(gamerSkyCommentService==null){
            gamerSkyCommentService=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GamerSkyCommentService.class);
        }
        return  gamerSkyCommentService;
    }
}
