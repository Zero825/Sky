package com.news.sky.util;

import static com.news.sky.util.AppUtil.timeFormat;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.news.sky.articlepart.ArticleHeader;
import com.news.sky.articlepart.ArticleImg;
import com.news.sky.articlepart.ArticleP;
import com.news.sky.articlepart.ArticlePart;
import com.news.sky.articlepart.ArticleTag;
import com.news.sky.commentpart.Comment;
import com.news.sky.commentpart.CommentPart;
import com.news.sky.commentpart.CommentReplyMsg;
import com.news.sky.commentpart.ImageInfe;
import com.news.sky.commentpart.Reply;
import com.news.sky.data.Article;
import com.news.sky.data.ArticleInformation;
import com.news.sky.data.ArticleJson;
import com.news.sky.data.ClubArticleJson;
import com.news.sky.data.ClubCommentJson;
import com.news.sky.data.CommentJson;
import com.news.sky.data.NewsJson;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataTransform {
    private final static String TAG = "DataTransform";

    public static List<ArticleInformation> appNewsListJsonToArticleInformation(NewsJson newsJson) {
        if (newsJson == null) {
            return new ArrayList<>();
        }
        List<NewsJson.Result> results = newsJson.getResult();
        List<ArticleInformation> articleInformations = new ArrayList<>();
        for (NewsJson.Result result : results) {
            articleInformations.add(
                    new ArticleInformation(
                            result.getTitle(),
                            result.getUpdateTime(),
                            result.getContentId(),
                            result.getThumbnailURLs(),
                            result.getCommentsCount(),
                            getClubIdFromUrl(result.getContentURL()))
            );
        }
        return articleInformations;
    }

    public static long getClubIdFromUrl(String url) {
        long clubId = -1;
        if (url.isEmpty()) {
            return clubId;
        }
        try {
            if (url.contains("club")) {
                String shortUrl = url.substring(url.indexOf("activity"));
                clubId = Long.parseLong(shortUrl.substring(shortUrl.indexOf("/") + 1, shortUrl.indexOf("?")));
            }
        } catch (StringIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return clubId;
    }

    public static Article appArticleJsonToArticle(ArticleJson articleJson) {
        Article article = new Article();
        ArticleJson.Result result = articleJson.getResult().get(0);
        article.setTitle(result.getTitleIntact() == null
                || result.getTitleIntact().isEmpty()
                ? result.getTitle() : result.getTitleIntact());
        article.setUpdateTime(result.getUpdateTime() == null
                || result.getUpdateTime().isEmpty()
                ? result.getUpdateTime() : result.getUpdateTime().replace("T", " "));
        article.setSource(result.getCopyFrom());
        article.setAuthor(result.getAuthor());
        article.setEditor(result.getEditor());
        article.setTagId(result.getTag());
        article.setTagIndex(result.getTag_Index());
        article.setContent(result.getContentIndex());
        return article;
    }

    public static Article clubArticleJsonToArticle(ClubArticleJson clubArticleJson) {
        Article article = new Article();
        ClubArticleJson.Result result = clubArticleJson.getResult();
        article.setTitle(result.getTopicTitle());
        article.setUpdateTime(timeFormat(result.getUpdateTime()));
        article.setSource("");
        article.setAuthor("");
        article.setEditor("");
        article.setTagId("");
        article.setTagIndex("");
        article.setContent(result.getTopicContent());
        return article;
    }

    public static List<ArticlePart> artilceToArticlePart(Article article) {
        List<ArticlePart> articleParts = new ArrayList<>();

        if (article.getContent() == null || article.getContent().isEmpty()) {
            return articleParts;
        }

        Elements articleElements = Jsoup.parse(article.getContent()).body().children();


        ArticleHeader articleHeader = new ArticleHeader();
        articleHeader.setTitle(article.getTitle());
        articleHeader.setUpdateTime(article.getUpdateTime());
        articleHeader.setSource(article.getSource());
        articleHeader.setAuthor(article.getAuthor());
        articleHeader.setEditor(article.getEditor());
        articleHeader.setType(ArticlePart.TYPE_HEADER);

        articleParts.add(articleHeader);

        List<ImageInfe> imageInfes = new ArrayList<>();

        for (Element articleElement : articleElements) {
            if (articleElement.select("img").first() != null) {
                Element imageElement = articleElement.select("img").first();
                Elements imageAElements = imageElement.parent().getElementsByTag("a");
                ImageInfe imageInfe = new ImageInfe();
                imageInfe.setOrigin(imageElement.attr("src"));
                if (imageAElements.size() > 0) {
                    String href = imageAElements.get(0).attr("href");
                    String imageUrlOrigin = href.substring(href.indexOf("?") + 1);

                    if (!imageUrlOrigin.isEmpty()) {
                        imageInfe.setOrigin(imageUrlOrigin);
                        imageInfes.add(imageInfe);
                        continue;
                    }

                }
                String imageUrlOrigin = imageElement.attr("data-origin");
                if (!imageUrlOrigin.isEmpty()) {
                    imageInfe.setOrigin(imageUrlOrigin);
                }
                imageInfes.add(imageInfe);
            }
        }


        int position = 0;
        for (Element articleElement : articleElements) {

            if (articleElement.select("img").first() != null) {
                String imageUrl = articleElement.select("img").first().attr("src");
                //Log.i(TAG, "artilceToArticlePart: "+imageUrl);
                if (!imageUrl.isEmpty()) {

                    ArticleImg articleImg = new ArticleImg();
                    articleImg.setImageUrl(imageUrl);
                    articleImg.setType(ArticlePart.TYPE_IMG);
                    articleImg.setPosition(position);
                    articleImg.setImageInfes(imageInfes);
                    articleParts.add(articleImg);
                    position++;
                }
            }

            String text = articleElement.text();
            //Log.i(TAG, "artilceToArticlePart: "+text);

            if (!text.isEmpty() && !text.equals("[NextPage]")) {

                ArticleP articleP = new ArticleP();
                articleP.setText(text);
                articleP.setType(ArticlePart.TYPE_P);

                articleParts.add(articleP);
            }

        }

        if (!article.getTagIndex().isEmpty()) {
            ArticleTag articleTag = new ArticleTag();
            String[] tagSplit = article.getTagIndex().split("\\|");
            String[] tagIdSplit = article.getTagIndex().split("\\,");
            List<String> tagList = new ArrayList<>(Arrays.asList(tagSplit));
            List<String> tagIdList = new ArrayList<>(Arrays.asList(tagIdSplit));
            articleTag.setTagList(tagList);
            articleTag.setTagIdList(tagIdList);
            articleTag.setType(ArticlePart.TYPE_TAG);

            articleParts.add(articleTag);
        }

        return articleParts;
    }

    public static List<ArticlePart> appArticleJsonToArticlePart(ArticleJson articleJson) {
        return artilceToArticlePart(appArticleJsonToArticle(articleJson));
    }

    public static List<ArticlePart> clubArticleJsonToArticlePart(ClubArticleJson clubArticleJson) {
        return artilceToArticlePart(clubArticleJsonToArticle(clubArticleJson));
    }

    public static List<CommentPart> commentJsonToCommentPart(CommentJson commentJson) {
        List<CommentPart> commentParts = new ArrayList<>();
        List<Comment> comments = commentJson.getResult().getComments();
        for (Comment comment : comments) {
            comment.setType(CommentPart.TYPE_COMMENT);
            commentParts.add(comment);
            List<Reply> replies = comment.getReplies();
            for (Reply reply : replies) {
                reply.setCommentUserName(comment.getNickname());
                reply.setType(CommentPart.TYPE_REPLY);
                commentParts.add(reply);
            }
            if (comment.getRepliesCount() > 5) {
                CommentReplyMsg commentReplyMsg = new CommentReplyMsg();
                commentReplyMsg.setMsg("全部" + comment.getRepliesCount() + "条回复");
                commentReplyMsg.setCommentId(comment.getComment_id());
                commentParts.add(commentReplyMsg);
            }
        }

        return commentParts;
    }

    public static List<CommentPart> clubCommentJsonToCommentPart(ClubCommentJson clubCommentJson) {
        List<CommentPart> commentParts = new ArrayList<>();
        List<ClubCommentJson.Comment> comments = clubCommentJson.getResult().getComments();
        for (ClubCommentJson.Comment comment : comments) {
            Comment normalComment = new Comment();
            normalComment.setComment_id(comment.getCommentId());
            normalComment.setContent(comment.getCommentContent());
            normalComment.setCreate_time(comment.getCreateTime());
            normalComment.setDeviceName(comment.getDeviceName());
            normalComment.setFloorNumber(comment.getFloorNumber());
            normalComment.setImg_url(comment.getUserHeadImageURL());
            normalComment.setNickname(comment.getUserName());
            normalComment.setReplies(comment.getReplies());
            normalComment.setRepliesCount(comment.getCommentsCount());
            normalComment.setSupport_count(comment.getPraisesCount());
            normalComment.setThirdPlatformBound(comment.getThirdPlatformBound());
            normalComment.setUser_id(comment.getUserId());
            normalComment.setUserGroupId(comment.getUserGroupId());
            normalComment.setUserLevel(comment.getUserLevel());
            normalComment.setType(CommentPart.TYPE_COMMENT);
            List<ImageInfe> imageInfes = new ArrayList<>();
            if (!comment.getImageInfes().equals("null")) {
                Log.i(TAG, "clubCommentJsonToCommentPart: " + comment.getImageInfes());
                JsonArray imageInfesArray = JsonParser.parseString(comment.getImageInfes()).getAsJsonArray();
                for (JsonElement imageInfe : imageInfesArray) {
                    Gson gson = new Gson();
                    imageInfes.add(gson.fromJson(imageInfe, ImageInfe.class));
                }
            }
            normalComment.setImageInfes(imageInfes);
            commentParts.add(normalComment);
            List<Reply> replies = comment.getReplies();
            for (Reply reply : replies) {
                reply.setCommentUserName(comment.getUserName());
                reply.setType(CommentPart.TYPE_REPLY);
                commentParts.add(reply);
            }
        }

        return commentParts;
    }
}
