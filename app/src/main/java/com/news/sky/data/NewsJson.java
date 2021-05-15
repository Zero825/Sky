package com.news.sky.data;
import java.util.List;


public class NewsJson {

    private int errorCode;
    private String errorMessage;
    private List<String> watchTimes;
    private int watchTime;
    private List<Result> result;

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

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

    public static class Result {

        private String type;
        private String contentType;
        private long contentId;
        private String title;
        private String description;
        private List<String> thumbnailURLs;
        private String authorName;
        private String authorHeadImageURL;
        private List<String> badges;
        private int readingCount;
        private int commentsCount;
        private String contentURL;
        private int adId;
        private long updateTime;
        private String duration;
        private String sourceName;
        private String childElements;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public long getContentId() {
            return contentId;
        }

        public void setContentId(long contentId) {
            this.contentId = contentId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public List<String> getThumbnailURLs() {
            return thumbnailURLs;
        }

        public void setThumbnailURLs(List<String> thumbnailURLs) {
            this.thumbnailURLs = thumbnailURLs;
        }

        public String getAuthorName() {
            return authorName;
        }

        public void setAuthorName(String authorName) {
            this.authorName = authorName;
        }

        public String getAuthorHeadImageURL() {
            return authorHeadImageURL;
        }

        public void setAuthorHeadImageURL(String authorHeadImageURL) {
            this.authorHeadImageURL = authorHeadImageURL;
        }

        public List<String> getBadges() {
            return badges;
        }

        public void setBadges(List<String> badges) {
            this.badges = badges;
        }

        public int getReadingCount() {
            return readingCount;
        }

        public void setReadingCount(int readingCount) {
            this.readingCount = readingCount;
        }

        public int getCommentsCount() {
            return commentsCount;
        }

        public void setCommentsCount(int commentsCount) {
            this.commentsCount = commentsCount;
        }

        public String getContentURL() {
            return contentURL;
        }

        public void setContentURL(String contentURL) {
            this.contentURL = contentURL;
        }

        public int getAdId() {
            return adId;
        }

        public void setAdId(int adId) {
            this.adId = adId;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getChildElements() {
            return childElements;
        }

        public void setChildElements(String childElements) {
            this.childElements = childElements;
        }

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
