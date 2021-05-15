package com.news.sky.data;


import com.google.gson.Gson;

public class ClubCommentPostJson {

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

        private long topicId;
        private int repliesMaxCount;
        private int minPraisesCount;
        private String repliesOrder;
        private int pageIndex;
        private int pageSize;
        private String order;
        public void setTopicId(long topicId) {
            this.topicId = topicId;
        }
        public long getTopicId() {
            return topicId;
        }

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

        public void setRepliesOrder(String repliesOrder) {
            this.repliesOrder = repliesOrder;
        }
        public String getRepliesOrder() {
            return repliesOrder;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }
        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }
        public int getPageSize() {
            return pageSize;
        }

        public void setOrder(String order) {
            this.order = order;
        }
        public String getOrder() {
            return order;
        }

    }

    public static ClubCommentPostJson getHotClubCommentPostJson(long id){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"topicId\":\"459615\",\"repliesMaxCount\":5,\"minPraisesCount\":5,\"repliesOrder\":\"timeASC\",\"pageIndex\":\"1\",\"pageSize\":5,\"order\":\"praisesDesc\"}}";
        Gson gson=new Gson();
        ClubCommentPostJson clubCommentPostJson = gson.fromJson(jsonString,ClubCommentPostJson.class);
        clubCommentPostJson.getRequest().setTopicId(id);
        return clubCommentPostJson;
    }

    public static ClubCommentPostJson getMoreClubCommentPostJson(long id,int key){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"topicId\":\"459615\",\"repliesMaxCount\":5,\"minPraisesCount\":0,\"repliesOrder\":\"timeASC\",\"pageIndex\":\"1\",\"pageSize\":5,\"order\":\"createTimeDESC\"}}";
        Gson gson=new Gson();
        ClubCommentPostJson clubCommentPostJson = gson.fromJson(jsonString,ClubCommentPostJson.class);
        clubCommentPostJson.getRequest().setTopicId(id);
        clubCommentPostJson.getRequest().setPageIndex(key);
        return clubCommentPostJson;
    }
}
