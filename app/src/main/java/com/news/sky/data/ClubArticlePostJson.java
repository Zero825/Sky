package com.news.sky.data;


import com.google.gson.Gson;

public class ClubArticlePostJson {

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
        public void setTopicId(long topicId) {
            this.topicId = topicId;
        }
        public long getTopicId() {
            return topicId;
        }

    }

    public static ClubArticlePostJson getClubArticlePostJson(long id){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"topicId\":\"459615\"}}";
        Gson gson=new Gson();
        ClubArticlePostJson clubArticlePostJson = gson.fromJson(jsonString,ClubArticlePostJson.class);
        clubArticlePostJson.getRequest().setTopicId(id);
        return clubArticlePostJson;
    }

}
