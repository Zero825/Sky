package com.news.sky.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamerSkyOtherApi {
    private static final String TAG="GamerSkyOtherApi";

    private static final String BASE_URL="http://i.gamersky.com/";
    private static GamerSkyOtherService gamerSkyOtherService;

    public static GamerSkyOtherService create(){
        if(gamerSkyOtherService==null){
            gamerSkyOtherService=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GamerSkyOtherService.class);
        }
        return  gamerSkyOtherService;
    }


}
