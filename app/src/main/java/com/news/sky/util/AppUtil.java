package com.news.sky.util;

import com.news.sky.data.AppNewsListJson;
import com.news.sky.data.Article;

import java.util.ArrayList;
import java.util.List;

public class AppUtil {

    public static List<Article> jsonToArticle(AppNewsListJson appNewsListJson){
        List<AppNewsListJson.Result> results=appNewsListJson.result;
        List<Article> articles=new ArrayList<>();
        for(AppNewsListJson.Result result:results){
            articles.add(new Article(result.title,
                    String.valueOf(result.updateTime),
                    String.valueOf(result.contentId),
                    result.thumbnailURLs,
                    result.commentsCount));
        }
        return articles;
    }
}
