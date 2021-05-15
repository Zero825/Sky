package com.news.sky.articlepart;

import com.news.sky.commentpart.ImageInfe;

import java.util.List;

public class ArticleImg extends ArticlePart {

    private String imageUrl;
    private int position;
    private List<ImageInfe> imageInfes;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public List<ImageInfe> getImageInfes() {
        return imageInfes;
    }

    public void setImageInfes(List<ImageInfe> imageInfes) {
        this.imageInfes = imageInfes;
    }
}
