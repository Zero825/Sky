package com.news.sky.data;
import java.util.List;


public class AppNewsListJson {

    public int errorCode;
    public String errorMessage;
    public List<String> watchTimes;
    public int watchTime;
    public List<Result> result;

    @Override
    public String toString() {
        return "AppNewsListJson{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", watchTimes=" + watchTimes +
                ", watchTime=" + watchTime +
                ", result=" + result +
                '}';
    }

    public class Result {

        public String type;
        public String contentType;
        public long contentId;
        public String title;
        public String description;
        public List<String> thumbnailURLs;
        public String authorName;
        public String authorHeadImageURL;
        public List<String> badges;
        public int readingCount;
        public int commentsCount;
        public String contentURL;
        public int adId;
        public long updateTime;
        public String duration;
        public String sourceName;
        public String childElements;

        @Override
        public String toString() {
            return "Result{" +
                    "type='" + type + '\'' +
                    ", contentType='" + contentType + '\'' +
                    ", contentId=" + contentId +
                    ", title='" + title + '\'' +
                    ", description='" + description + '\'' +
                    ", thumbnailURLs=" + thumbnailURLs +
                    ", authorName='" + authorName + '\'' +
                    ", authorHeadImageURL='" + authorHeadImageURL + '\'' +
                    ", badges=" + badges +
                    ", readingCount=" + readingCount +
                    ", commentsCount=" + commentsCount +
                    ", contentURL='" + contentURL + '\'' +
                    ", adId=" + adId +
                    ", updateTime=" + updateTime +
                    ", duration='" + duration + '\'' +
                    ", sourceName='" + sourceName + '\'' +
                    ", childElements='" + childElements + '\'' +
                    '}';
        }
    }

}
