package com.news.sky.data;

import com.google.gson.Gson;

public class ArticlePostJson {
    private String app;
    private String deviceType;
    private String appVersion;
    private String os;
    private String osVersion;
    private String deviceId;
    private Request request;

    public Request getRequest() {
        return request;
    }

    @Override
    public String toString() {
        return "AppArticlePostJson{" +
                "app='" + app + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", request=" + request +
                '}';
    }

    private static class Request {

        private String extraFiledNames;
        private String modelFieldNames;
        private String articleId;
        private String appModelFieldNames;
        private int cacheMinutes;

        public String getExtraFiledNames() {
            return extraFiledNames;
        }

        public void setExtraFiledNames(String extraFiledNames) {
            this.extraFiledNames = extraFiledNames;
        }

        public String getModelFieldNames() {
            return modelFieldNames;
        }

        public void setModelFieldNames(String modelFieldNames) {
            this.modelFieldNames = modelFieldNames;
        }

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public String getAppModelFieldNames() {
            return appModelFieldNames;
        }

        public void setAppModelFieldNames(String appModelFieldNames) {
            this.appModelFieldNames = appModelFieldNames;
        }

        public int getCacheMinutes() {
            return cacheMinutes;
        }

        public void setCacheMinutes(int cacheMinutes) {
            this.cacheMinutes = cacheMinutes;
        }

        @Override
        public String toString() {
            return "Request{" +
                    "extraFiledNames='" + extraFiledNames + '\'' +
                    ", modelFieldNames='" + modelFieldNames + '\'' +
                    ", articleId='" + articleId + '\'' +
                    ", appModelFieldNames='" + appModelFieldNames + '\'' +
                    ", cacheMinutes=" + cacheMinutes +
                    '}';
        }
    }

    public static ArticlePostJson getAppArticlePostJson(long articleId){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"extraFiledNames\":\"\",\"modelFieldNames\":\"Tag,Tag_Index,pageNames,Title,Subheading,Author,pcPageURL,CopyFrom,UpdateTime,DefaultPicUrl,GameScore,GameLib,TitleIntact,NodeId,editor,AudioUrl,Content_Index\",\"articleId\":\"1382164\",\"appModelFieldNames\":\"\",\"cacheMinutes\":10}}";
        Gson gson=new Gson();
        ArticlePostJson articlePostJson =gson.fromJson(jsonString, ArticlePostJson.class);
        articlePostJson.request.articleId= String.valueOf(articleId);
        return articlePostJson;
    }
}
