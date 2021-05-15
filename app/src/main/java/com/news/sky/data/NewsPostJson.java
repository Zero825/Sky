package com.news.sky.data;

import com.google.gson.Gson;

public class NewsPostJson {
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

    public void setRequest(Request request) {
        this.request = request;
    }

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

    public static class Request {

        private String nodeIds;
        private boolean isNeedHDImage;
        private int pageIndex;
        private String topicIds;
        private int pageSize;
        private String cacheMinutes;
        private String order;

        public String getNodeIds() {
            return nodeIds;
        }

        public void setNodeIds(String nodeIds) {
            this.nodeIds = nodeIds;
        }

        public boolean isNeedHDImage() {
            return isNeedHDImage;
        }

        public void setNeedHDImage(boolean needHDImage) {
            isNeedHDImage = needHDImage;
        }

        public int getPageIndex() {
            return pageIndex;
        }

        public void setPageIndex(int pageIndex) {
            this.pageIndex = pageIndex;
        }

        public String getTopicIds() {
            return topicIds;
        }

        public void setTopicIds(String topicIds) {
            this.topicIds = topicIds;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public String getCacheMinutes() {
            return cacheMinutes;
        }

        public void setCacheMinutes(String cacheMinutes) {
            this.cacheMinutes = cacheMinutes;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

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

    public static NewsPostJson getAppNewsListPostJson(){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"nodeIds\":\"1,2,47,4,16,19,30,31,32,33,48,50,51,56,57,59,60\",\"isNeedHDImage\":true,\"pageIndex\":1,\"topicIds\":\"2\",\"pageSize\":20,\"cacheMinutes\":\"1\",\"order\":\"timeDesc\"}}";
        Gson gson=new Gson();
        return gson.fromJson(jsonString, NewsPostJson.class);
    }

    public static NewsPostJson getAppBannerNewsPostJson(){
        String jsonString="{\"app\":\"GSAPP\",\"deviceType\":\"\",\"appVersion\":\"\",\"os\":\"android\",\"osVersion\":\"10\",\"deviceId\":\"\",\"request\":{\"nodeIds\":\"24\",\"isNeedHDImage\":true,\"pageIndex\":1,\"topicIds\":\"\",\"pageSize\":6,\"cacheMinutes\":\"2\",\"order\":\"timeDesc\"}}";
        Gson gson=new Gson();
        return gson.fromJson(jsonString, NewsPostJson.class);
    }
}

