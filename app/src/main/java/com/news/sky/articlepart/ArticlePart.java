package com.news.sky.articlepart;

public class ArticlePart{
    public final static int TYPE_P = 0;
    public final static int TYPE_IMG = 1;
    public final static int TYPE_HEADER = 2;
    public final static int TYPE_TAG = 3;

    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
