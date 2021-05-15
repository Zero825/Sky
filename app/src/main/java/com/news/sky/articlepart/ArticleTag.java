package com.news.sky.articlepart;

import java.util.List;

public class ArticleTag extends ArticlePart {
    private List<String> tagIdList;
    private List<String> tagList;

    public List<String> getTagIdList() {
        return tagIdList;
    }

    public void setTagIdList(List<String> tagIdList) {
        this.tagIdList = tagIdList;
    }

    public List<String> getTagList() {
        return tagList;
    }

    public void setTagList(List<String> tagList) {
        this.tagList = tagList;
    }


}
