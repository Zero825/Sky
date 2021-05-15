package com.news.sky.data;

import com.google.gson.Gson;

public class CommentPostJson {
    public final static String ORDER_TIME_DESC="createTimeDESC";
    public final static String ORDER_PRAISE_DESC="praiseDESC";

    private String app;
    private String deviceType;
    private String appVersion;
    private String os;
    private String osVersion;
    private String deviceId;
    private Request request;
    public void setApp(String app) {
        this.app = app;
    }
    public String getApp() {
        return app;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    public String getDeviceType() {
        return deviceType;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }
    public String getAppVersion() {
        return appVersion;
    }

    public void setOs(String os) {
        this.os = os;
    }
    public String getOs() {
        return os;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }
    public String getOsVersion() {
        return osVersion;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }
    public String getDeviceId() {
        return deviceId;
    }

    public void setRequest(Request request) {
        this.request = request;
    }
    public Request getRequest() {
        return request;
    }

    public static class Request {

        private int repliesMaxCount;
        private int minPraisesCount;
        private int pageIndex;
        private long articleId;
        private int pageSize;
        private int cacheMinutes;
        private String order;


        public void setRepliesMaxCount(int repliesMaxCount) {
            this.repliesMaxCount = repliesMaxCount;
        }
        public int getRepliesMaxCount() {
            return repliesMaxCount;
        }

        public void setMinPraisesCount(int minPraisesCount) {
            this.minPraisesCount = minPraisesCount;
        }
        public int getMinPraisesCount() {
            return minPraisesCount;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }
        public int getPageIndex() {
            return pageIndex;
        }

        public void setArticleId(long articleId) {
            this.articleId = articleId;
        }
        public long getArticleId() {
            return articleId;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
        public int getPageSize() {
            return pageSize;
        }

        public void setCacheMinutes(int cacheMinutes) {
            this.cacheMinutes = cacheMinutes;
        }
        public int getCacheMinutes() {
            return cacheMinutes;
        }

        public void setOrder(String order) {
            this.order = order;
        }
        public String getOrder() {
            return order;
        }

    }

    public static CommentPostJson getCommentListPostJson(long articleId){
        String jsonString = "{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"repliesMaxCount\":5,\"minPraisesCount\":5,\"pageIndex\":\"1\",\"articleId\":\"1383219\",\"pageSize\":5,\"cacheMinutes\":10,\"order\":\"praiseDESC\"}}";
        Gson gson=new Gson();
        CommentPostJson commentPostJson = gson.fromJson(jsonString, CommentPostJson.class);
        commentPostJson.request.articleId = articleId;
        return commentPostJson;
    }

    public static CommentPostJson getMoreCommentListPostJson(long articleId,int key){
        String jsonString = "{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"repliesMaxCount\":5,\"minPraisesCount\":0,\"pageIndex\":\"1\",\"articleId\":\"1383219\",\"pageSize\":20,\"cacheMinutes\":10,\"order\":\"createTimeDESC\"}}";
        Gson gson=new Gson();
        CommentPostJson commentPostJson = gson.fromJson(jsonString, CommentPostJson.class);
        commentPostJson.request.articleId = articleId;
        commentPostJson.request.pageIndex=key;
        return commentPostJson;
    }


}
