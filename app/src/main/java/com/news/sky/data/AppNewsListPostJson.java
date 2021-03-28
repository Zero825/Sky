package com.news.sky.data;

import com.google.gson.Gson;

public class AppNewsListPostJson {
    public String app;
    public String deviceType;
    public String appVersion;
    public String os;
    public String osVersion;
    public String deviceId;
    public Request request;

    @Override
    public String toString() {
        return "AppNewsListPostJson{" +
                "app='" + app + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", os='" + os + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", request=" + request +
                '}';
    }

    public class Request {

        public String nodeIds;
        public boolean isNeedHDImage;
        public int pageIndex;
        public String topicIds;
        public int pageSize;
        public String cacheMinutes;
        public String order;

        @Override
        public String toString() {
            return "Request{" +
                    "nodeIds='" + nodeIds + '\'' +
                    ", isNeedHDImage=" + isNeedHDImage +
                    ", pageIndex=" + pageIndex +
                    ", topicIds='" + topicIds + '\'' +
                    ", pageSize=" + pageSize +
                    ", cacheMinutes='" + cacheMinutes + '\'' +
                    ", order='" + order + '\'' +
                    '}';
        }
    }

    public static AppNewsListPostJson getAppNewsListPostJson(){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"nodeIds\":\"1,2,47,4,16,19,30,31,32,33,48,50,51,56,57,59,60\",\"isNeedHDImage\":true,\"pageIndex\":1,\"topicIds\":\"2\",\"pageSize\":20,\"cacheMinutes\":\"1\",\"order\":\"timeDesc\"}}";
        Gson gson=new Gson();
        return gson.fromJson(jsonString,AppNewsListPostJson.class);
    }
}

