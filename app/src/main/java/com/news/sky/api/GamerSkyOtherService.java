package com.news.sky.api;

import com.news.sky.data.ClubArticleJson;
import com.news.sky.data.ClubArticlePostJson;
import com.news.sky.data.ClubCommentJson;
import com.news.sky.data.ClubCommentPostJson;
import com.news.sky.data.CommentJson;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface GamerSkyOtherService {

    @POST("/appapi/v5/getClubTopicCommentsList")
    Call<ClubCommentJson> getClubComment(@Body ClubCommentPostJson clubCommentPostJson);

    @POST("/appapi/v5/getClubTopic")
    Call<ClubArticleJson> getClubArticle(@Body ClubArticlePostJson clubArticlePostJson);
}
