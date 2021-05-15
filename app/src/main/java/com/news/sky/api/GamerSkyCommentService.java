package com.news.sky.api;

import com.news.sky.data.CommentJson;
import com.news.sky.data.CommentPostJson;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GamerSkyCommentService {

    @POST("/appapi/GetArticleCommentWithClubStyle")
    Call<CommentJson> getCommentList(@Body CommentPostJson commentPostJson);
}
