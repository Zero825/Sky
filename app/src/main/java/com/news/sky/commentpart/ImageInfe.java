package com.news.sky.commentpart;

public class ImageInfe{
    private String tiny;
    private String small;
    private String origin;
    private String tinysquare;
    private int height;
    private int width;
    private String imageType;

    public String getTiny() {
        return tiny;
    }

    public void setTiny(String tiny) {
        this.tiny = tiny;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getTinysquare() {
        return tinysquare;
    }

    public void setTinysquare(String tinysquare) {
        this.tinysquare = tinysquare;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    @Override
    public String toString() {
        return "ImageInfe{" +
                "tiny='" + tiny + '\'' +
                ", small='" + small + '\'' +
                ", origin='" + origin + '\'' +
                ", tinysquare='" + tinysquare + '\'' +
                ", height=" + height +
                ", width=" + width +
                ", imageType='" + imageType + '\'' +
                '}';
    }
}

