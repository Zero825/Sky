package com.news.sky.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GamerSkyApi {
    private static final String TAG="GamerSkyApi";

    private static final String BASE_URL="http://appapi2.gamersky.com/";
    private static GamerSkyService gamerSkyService;

    public static GamerSkyService create(){
        if(gamerSkyService==null){
            gamerSkyService=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(GamerSkyService.class);
        }
        return  gamerSkyService;
    }
}
