package com.news.sky.data;

import java.util.ArrayList;
import java.util.List;

public class Article {
    public String title,time,href;
    public List<String> previewImageUrl;
    public int commentCount;

    public Article(String title, String time, String href, List<String> previewImageUrl, int commentCount) {
        this.title = title;
        this.time = time;
        this.href = href;
        this.previewImageUrl = previewImageUrl;
        this.commentCount = commentCount;
    }

    public static List<Article> getTestData(){
        List<Article> result=new ArrayList<>();
        result.add(new Article("1","2","", new ArrayList<>(),11));
        result.add(new Article("2","2","", new ArrayList<>(),11));
        result.add(new Article("3","2","", new ArrayList<>(),11));
        result.add(new Article("4","2","", new ArrayList<>(),11));
        result.add(new Article("5","2","", new ArrayList<>(),11));
        result.add(new Article("6","2","", new ArrayList<>(),11));
        result.add(new Article("7","2","", new ArrayList<>(),11));
        result.add(new Article("8","2","", new ArrayList<>(),11));
        result.add(new Article("9","2","", new ArrayList<>(),11));
        return result;
    }
}
