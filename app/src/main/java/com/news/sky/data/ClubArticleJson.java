package com.news.sky.data;


import java.util.List;

public class ClubArticleJson {

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


    public static class Result {

        private int clubId;
        private long topicId;
        private String topicTitle;
        private String topicContent;
        private List<ImageURLs> imageURLs;
        private String videoThumbnailURL;
        private String videoOriginURL;
        private String videotitle;
        private long createTime;
        private long updateTime;
        private int praisesCount;
        private int commentsCount;
        private String uiStyles;
        private long userId;
        private int userGroupId;
        private String deviceName;
        private String copyRightType;
        private String subjectId;
        private String headImageURL;
        private boolean isRecommendToQuanZi;
        private boolean isRecommendToGuangChang;
        private boolean isRecommendToGuanZhu;
        private int gameId;
        private int gameScore;
        private String gamePlayState;
        private boolean isRealPlayer;
        private String gamePlayPlatform;
        private String subjectType;

        public void setClubId(int clubId) {
            this.clubId = clubId;
        }
        public int getClubId() {
            return clubId;
        }

        public void setTopicId(long topicId) {
            this.topicId = topicId;
        }
        public long getTopicId() {
            return topicId;
        }

        public void setTopicTitle(String topicTitle) {
            this.topicTitle = topicTitle;
        }
        public String getTopicTitle() {
            return topicTitle;
        }

        public void setTopicContent(String topicContent) {
            this.topicContent = topicContent;
        }
        public String getTopicContent() {
            return topicContent;
        }

        public void setImageURLs(List<ImageURLs> imageURLs) {
            this.imageURLs = imageURLs;
        }
        public List<ImageURLs> getImageURLs() {
            return imageURLs;
        }

        public void setVideoThumbnailURL(String videoThumbnailURL) {
            this.videoThumbnailURL = videoThumbnailURL;
        }
        public String getVideoThumbnailURL() {
            return videoThumbnailURL;
        }

        public void setVideoOriginURL(String videoOriginURL) {
            this.videoOriginURL = videoOriginURL;
        }
        public String getVideoOriginURL() {
            return videoOriginURL;
        }

        public void setVideotitle(String videotitle) {
            this.videotitle = videotitle;
        }
        public String getVideotitle() {
            return videotitle;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }
        public long getCreateTime() {
            return createTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }
        public long getUpdateTime() {
            return updateTime;
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

        public void setUiStyles(String uiStyles) {
            this.uiStyles = uiStyles;
        }
        public String getUiStyles() {
            return uiStyles;
        }

        public void setUserId(long userId) {
            this.userId = userId;
        }
        public long getUserId() {
            return userId;
        }

        public void setUserGroupId(int userGroupId) {
            this.userGroupId = userGroupId;
        }
        public int getUserGroupId() {
            return userGroupId;
        }

        public void setDeviceName(String deviceName) {
            this.deviceName = deviceName;
        }
        public String getDeviceName() {
            return deviceName;
        }

        public void setCopyRightType(String copyRightType) {
            this.copyRightType = copyRightType;
        }
        public String getCopyRightType() {
            return copyRightType;
        }

        public void setSubjectId(String subjectId) {
            this.subjectId = subjectId;
        }
        public String getSubjectId() {
            return subjectId;
        }

        public void setHeadImageURL(String headImageURL) {
            this.headImageURL = headImageURL;
        }
        public String getHeadImageURL() {
            return headImageURL;
        }

        public void setIsRecommendToQuanZi(boolean isRecommendToQuanZi) {
            this.isRecommendToQuanZi = isRecommendToQuanZi;
        }
        public boolean getIsRecommendToQuanZi() {
            return isRecommendToQuanZi;
        }

        public void setIsRecommendToGuangChang(boolean isRecommendToGuangChang) {
            this.isRecommendToGuangChang = isRecommendToGuangChang;
        }
        public boolean getIsRecommendToGuangChang() {
            return isRecommendToGuangChang;
        }

        public void setIsRecommendToGuanZhu(boolean isRecommendToGuanZhu) {
            this.isRecommendToGuanZhu = isRecommendToGuanZhu;
        }
        public boolean getIsRecommendToGuanZhu() {
            return isRecommendToGuanZhu;
        }

        public void setGameId(int gameId) {
            this.gameId = gameId;
        }
        public int getGameId() {
            return gameId;
        }

        public void setGameScore(int gameScore) {
            this.gameScore = gameScore;
        }
        public int getGameScore() {
            return gameScore;
        }

        public void setGamePlayState(String gamePlayState) {
            this.gamePlayState = gamePlayState;
        }
        public String getGamePlayState() {
            return gamePlayState;
        }

        public void setIsRealPlayer(boolean isRealPlayer) {
            this.isRealPlayer = isRealPlayer;
        }
        public boolean getIsRealPlayer() {
            return isRealPlayer;
        }

        public void setGamePlayPlatform(String gamePlayPlatform) {
            this.gamePlayPlatform = gamePlayPlatform;
        }
        public String getGamePlayPlatform() {
            return gamePlayPlatform;
        }

        public void setSubjectType(String subjectType) {
            this.subjectType = subjectType;
        }
        public String getSubjectType() {
            return subjectType;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "clubId=" + clubId +
                    ", topicId=" + topicId +
                    ", topicTitle='" + topicTitle + '\'' +
                    ", topicContent='" + topicContent + '\'' +
                    ", imageURLs=" + imageURLs +
                    ", videoThumbnailURL='" + videoThumbnailURL + '\'' +
                    ", videoOriginURL='" + videoOriginURL + '\'' +
                    ", videotitle='" + videotitle + '\'' +
                    ", createTime=" + createTime +
                    ", updateTime=" + updateTime +
                    ", praisesCount=" + praisesCount +
                    ", commentsCount=" + commentsCount +
                    ", uiStyles='" + uiStyles + '\'' +
                    ", userId=" + userId +
                    ", userGroupId=" + userGroupId +
                    ", deviceName='" + deviceName + '\'' +
                    ", copyRightType='" + copyRightType + '\'' +
                    ", subjectId='" + subjectId + '\'' +
                    ", headImageURL='" + headImageURL + '\'' +
                    ", isRecommendToQuanZi=" + isRecommendToQuanZi +
                    ", isRecommendToGuangChang=" + isRecommendToGuangChang +
                    ", isRecommendToGuanZhu=" + isRecommendToGuanZhu +
                    ", gameId=" + gameId +
                    ", gameScore=" + gameScore +
                    ", gamePlayState='" + gamePlayState + '\'' +
                    ", isRealPlayer=" + isRealPlayer +
                    ", gamePlayPlatform='" + gamePlayPlatform + '\'' +
                    ", subjectType='" + subjectType + '\'' +
                    '}';
        }

        public static class ImageURLs {

            private String url;
            private boolean isGIF;
            private int width;
            private int height;

            public void setUrl(String url) {
                this.url = url;
            }
            public String getUrl() {
                return url;
            }

            public void setIsGIF(boolean isGIF) {
                this.isGIF = isGIF;
            }
            public boolean getIsGIF() {
                return isGIF;
            }

            public void setWidth(int width) {
                this.width = width;
            }
            public int getWidth() {
                return width;
            }

            public void setHeight(int height) {
                this.height = height;
            }
            public int getHeight() {
                return height;
            }

        }
    }

}
