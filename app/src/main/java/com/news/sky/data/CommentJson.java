package com.news.sky.data;

import com.news.sky.commentpart.Comment;
import com.news.sky.commentpart.CommentPart;

import java.util.List;

public class CommentJson {

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
}
