package com.news.sky.commentpart;

import java.util.List;

public class Comment extends CommentPart {

    private long comment_id;
    private long create_time;
    private int from;
    private String content;
    private int support_count;
    private String ip_location;
    private long user_id;
    private String nickname;
    private String img_url;
    private String deviceName;
    private int userLevel;
    private String userAuthentication;
    private int userGroupId;
    private int floorNumber;
    private List<ImageInfe> imageInfes;
    private String thirdPlatformBound;
    private List<Reply> replies;
    private int repliesCount;

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getComment_id() {
        return comment_id;
    }

    public void setCreate_time(long create_time) {
        this.create_time = create_time;
    }

    public long getCreate_time() {
        return create_time;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getFrom() {
        return from;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSupport_count(int support_count) {
        this.support_count = support_count;
    }

    public int getSupport_count() {
        return support_count;
    }

    public void setIp_location(String ip_location) {
        this.ip_location = ip_location;
    }

    public String getIp_location() {
        return ip_location;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserAuthentication(String userAuthentication) {
        this.userAuthentication = userAuthentication;
    }

    public String getUserAuthentication() {
        return userAuthentication;
    }

    public void setUserGroupId(int userGroupId) {
        this.userGroupId = userGroupId;
    }

    public int getUserGroupId() {
        return userGroupId;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setImageInfes(List<ImageInfe> imageInfes) {
        this.imageInfes = imageInfes;
    }

    public List<ImageInfe> getImageInfes() {
        return imageInfes;
    }

    public void setThirdPlatformBound(String thirdPlatformBound) {
        this.thirdPlatformBound = thirdPlatformBound;
    }

    public String getThirdPlatformBound() {
        return thirdPlatformBound;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setRepliesCount(int repliesCount) {
        this.repliesCount = repliesCount;
    }

    public int getRepliesCount() {
        return repliesCount;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", create_time=" + create_time +
                ", from=" + from +
                ", content='" + content + '\'' +
                ", support_count=" + support_count +
                ", ip_location='" + ip_location + '\'' +
                ", user_id=" + user_id +
                ", nickname='" + nickname + '\'' +
                ", img_url='" + img_url + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", userLevel=" + userLevel +
                ", userAuthentication='" + userAuthentication + '\'' +
                ", userGroupId=" + userGroupId +
                ", floorNumber=" + floorNumber +
                ", imageInfes=" + imageInfes +
                ", thirdPlatformBound='" + thirdPlatformBound + '\'' +
                ", replies=" + replies +
                ", repliesCount=" + repliesCount +
                '}';
    }
}
