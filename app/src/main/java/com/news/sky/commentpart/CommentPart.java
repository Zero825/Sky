package com.news.sky.commentpart;

public class CommentPart {
    public final static int TYPE_COMMENT = 0;
    public final static int TYPE_REPLY = 1;
    public final static int TYPE_SORT_MSG=2;
    public final static int TYPE_REPLY_MSG=3;


    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
