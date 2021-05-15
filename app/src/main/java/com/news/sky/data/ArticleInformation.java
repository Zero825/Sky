package com.news.sky.data;

import java.util.List;

public class ArticleInformation {
    public static final int TYPE_HEADER=1;

    private String title;
    private List<String> previewImageUrl;
    private int commentCount;
    private long contentId,time,clubId;
    private int type;

    public ArticleInformation(){
    }

    public ArticleInformation(String title, long time, long contentId, List<String> previewImageUrl, int commentCount,long clubId) {
        this.title = title;
        this.time = time;
        this.contentId = contentId;
        this.previewImageUrl = previewImageUrl;
        this.commentCount = commentCount;
        this.clubId=clubId;
    }

    public long getClubId() {
        return clubId;
    }

    public void setClubId(long clubId) {
        this.clubId = clubId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<String> getPreviewImageUrl() {
        return previewImageUrl;
    }

    public void setPreviewImageUrl(List<String> previewImageUrl) {
        this.previewImageUrl = previewImageUrl;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ArticleInformation{" +
                "title='" + title + '\'' +
                ", previewImageUrl=" + previewImageUrl +
                ", commentCount=" + commentCount +
                ", contentId=" + contentId +
                ", time=" + time +
                ", clubId=" + clubId +
                ", type=" + type +
                '}';
    }
}
