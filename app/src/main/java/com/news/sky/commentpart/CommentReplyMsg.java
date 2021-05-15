package com.news.sky.commentpart;

public class CommentReplyMsg extends CommentPart{
    private long commentId;
    private String msg;

    public CommentReplyMsg() {
        this.setType(TYPE_REPLY_MSG);
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
