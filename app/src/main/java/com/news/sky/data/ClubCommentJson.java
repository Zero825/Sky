package com.news.sky.data;

import com.news.sky.commentpart.CommentPart;
import com.news.sky.commentpart.Reply;

import java.util.List;

public class ClubCommentJson {

    private int errorCode;
    private String errorMessage;
    private Result result;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setResult(Result result) {
        this.result = result;
    }
    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "CommentJson{" +
                "errorCode=" + errorCode +
                ", errorMessage='" + errorMessage + '\'' +
                ", result=" + result +
                '}';
    }

    public class Result {

        private int commentsCount;
        private List<Comment> comments;

        public void setCommentsCount(int commentsCount) {
            this.commentsCount = commentsCount;
        }
        public int getCommentsCount() {
            return commentsCount;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }
        public List<Comment> getComments() {
            return comments;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "commentsCount=" + commentsCount +
                    ", comments=" + comments +
                    '}';
        }


    }

    public static class Comment extends CommentPart {

        private long commentId;
        private String commentContent;
        private String imageInfes;
        private long createTime;
        private int praisesCount;
        private int commentsCount;
        private long userId;
        private String userName;
        private int userGroupId;
        private int userLevel;
        private String userHeadImageURL;
        private int objectUserId;
        private String objectUserName;
        private String deviceName;
        private int floorNumber;
        private String thirdPlatformBound;
        private List<Reply> replies;

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }
        public long getCommentId() {
            return commentId;
        }

        public void setCommentContent(String commentContent) {
            this.commentContent = commentContent;
        }
        public String getCommentContent() {
            return commentContent;
        }

        public void setImageInfes(String imageInfes) {
            this.imageInfes = imageInfes;
        }
        public String getImageInfes() {
            return imageInfes;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
        public long getCreateTime() {
            return createTime;
        }

        public void setPraisesCount(int praisesCount) {
            this.praisesCount = praisesCount;
        }
        public int getPraisesCount() {
            return praisesCount;
        }

        public void setCommentsCount(int commentsCount) {
            this.commentsCount = commentsCount;
        }
        public int getCommentsCount() {
            return commentsCount;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
        public long getUserId() {
            return userId;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
        public String getUserName() {
            return userName;
        }

        public void setUserGroupId(int userGroupId) {
            this.userGroupId = userGroupId;
        }
        public int getUserGroupId() {
            return userGroupId;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }
        public int getUserLevel() {
            return userLevel;
        }

        public void setUserHeadImageURL(String userHeadImageURL) {
            this.userHeadImageURL = userHeadImageURL;
        }
        public String getUserHeadImageURL() {
            return userHeadImageURL;
        }

        public void setObjectUserId(int objectUserId) {
            this.objectUserId = objectUserId;
        }
        public int getObjectUserId() {
            return objectUserId;
        }

        public void setObjectUserName(String objectUserName) {
            this.objectUserName = objectUserName;
        }
        public String getObjectUserName() {
            return objectUserName;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }
        public String getDeviceName() {
            return deviceName;
        }

        public void setFloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
        }
        public int getFloorNumber() {
            return floorNumber;
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

    }
}
