package com.news.sky.viewmodels;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.news.sky.R;
import com.news.sky.api.GamerSkyCommentApi;
import com.news.sky.api.GamerSkyOtherApi;
import com.news.sky.commentpart.Comment;
import com.news.sky.commentpart.CommentSortMsg;
import com.news.sky.data.ClubCommentJson;
import com.news.sky.data.ClubCommentPostJson;
import com.news.sky.data.CommentJson;
import com.news.sky.data.CommentPostJson;
import com.news.sky.commentpart.CommentPart;
import com.news.sky.util.DataTransform;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import retrofit2.Response;

import static com.news.sky.commentpart.CommentPart.TYPE_SORT_MSG;
import static com.news.sky.data.CommentPostJson.ORDER_PRAISE_DESC;
import static com.news.sky.data.CommentPostJson.ORDER_TIME_DESC;

public class CommentViewModel extends ViewModel {
    private final static String TAG="CommentViewModel";

    private MutableLiveData<List<CommentPart>> commentList;
    private int key=1;

    public MutableLiveData<List<CommentPart>> getCommentList(long contentId,long clubId){
        if(commentList==null){
            commentList=new MutableLiveData<>();

            Thread loadThread=new Thread(()-> {
                List<CommentPart> allCommentList=new ArrayList<>();
                AtomicReference<List<CommentPart>> hotCommentList=new AtomicReference<>();
                AtomicReference<List<CommentPart>> moreCommentList=new AtomicReference<>();
                Thread getHotCommentListThread = new Thread(()->{
                    if(clubId!=-1){
                        hotCommentList.set(getHotClubCommentList(clubId));
                    }else {
                        hotCommentList.set(getHotCommentList(contentId));
                    }
                });
                Thread getMoreCommentListThread = new Thread(()->{
                    if(clubId!=-1){
                        moreCommentList.set(getMoreClubCommentList(clubId));
                    }else {
                        moreCommentList.set(getMoreCommentList(contentId));
                    }

                });
                getHotCommentListThread.start();
                getMoreCommentListThread.start();
                try {
                    getHotCommentListThread.join();
                    getMoreCommentListThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if(hotCommentList.get()!=null) {
                    allCommentList.addAll(hotCommentList.get());
                }
                if(moreCommentList.get()!=null) {
                    allCommentList.addAll(moreCommentList.get());
                }
                commentList.postValue(allCommentList);
            });
            loadThread.start();
        }
        return commentList;
    }

    public boolean loadNextData(long contentId,long clubId){
        key++;
        List<CommentPart> commentParts = new ArrayList<>(commentList.getValue());
        List<CommentPart> tempCommentParts;
        if(clubId!=-1){
            tempCommentParts=getMoreClubCommentList(clubId);
        }else {
            tempCommentParts=getMoreCommentList(contentId);
        }
        if(tempCommentParts==null){
            if(key>1){
                key--;
            }
            return false;
        }
        commentParts.addAll(tempCommentParts);
        commentList.postValue(commentParts);
        return true;
    }

    private List<CommentPart> getHotCommentList(long id){
        Response<CommentJson> response;
        try {
            response=GamerSkyCommentApi.create()
                    .getCommentList(CommentPostJson.getCommentListPostJson(id))
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        if(response.isSuccessful()){
            List<CommentPart> commentParts= DataTransform.commentJsonToCommentPart(response.body());
            List<CommentPart> commentPartsByHeader=new ArrayList<>();
            if(commentParts.size()>0){
                CommentSortMsg commentSortMsg=new CommentSortMsg();
                commentSortMsg.setMsg("热门评论");
                commentSortMsg.setType(TYPE_SORT_MSG);
                commentPartsByHeader.add(commentSortMsg);
            }
            commentPartsByHeader.addAll(commentParts);
            return commentPartsByHeader;
        }else {
            return new ArrayList<>();
        }
    }

    private List<CommentPart> getMoreCommentList(long id){
        Response<CommentJson> response;
        try {
            response=GamerSkyCommentApi.create()
                    .getCommentList(CommentPostJson.getMoreCommentListPostJson(id,key))
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        if(response.isSuccessful()){
            List<CommentPart> commentParts= DataTransform.commentJsonToCommentPart(response.body());
            List<CommentPart> commentPartsByHeader=new ArrayList<>();
            if(commentParts.size()>0&&key==1){
                CommentSortMsg commentSortMsg=new CommentSortMsg();
                commentSortMsg.setMsg("全部评论");
                commentSortMsg.setType(TYPE_SORT_MSG);
                commentPartsByHeader.add(commentSortMsg);
            }
            commentPartsByHeader.addAll(commentParts);
            return commentPartsByHeader;
        }else {
            return null;
        }
    }

    private List<CommentPart> getHotClubCommentList(long id){
        Response<ClubCommentJson> response;
        try {
            response= GamerSkyOtherApi.create()
                    .getClubComment(ClubCommentPostJson.getHotClubCommentPostJson(id))
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

        if(response.isSuccessful()){
            List<CommentPart> commentParts= DataTransform.clubCommentJsonToCommentPart(response.body());
            List<CommentPart> commentPartsByHeader=new ArrayList<>();
            if(commentParts.size()>0){
                CommentSortMsg commentSortMsg=new CommentSortMsg();
                commentSortMsg.setMsg("热门评论");
                commentSortMsg.setType(TYPE_SORT_MSG);
                commentPartsByHeader.add(commentSortMsg);
            }
            commentPartsByHeader.addAll(commentParts);
            return commentPartsByHeader;
        }else {
            return new ArrayList<>();
        }
    }

    private List<CommentPart> getMoreClubCommentList(long id){
        Response<ClubCommentJson> response;
        try {
            response= GamerSkyOtherApi.create()
                    .getClubComment(ClubCommentPostJson.getMoreClubCommentPostJson(id,key))
                    .execute();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        if(response.isSuccessful()){
            List<CommentPart> commentParts= DataTransform.clubCommentJsonToCommentPart(response.body());
            List<CommentPart> commentPartsByHeader=new ArrayList<>();
            if(commentParts.size()>0&&key==1){
                CommentSortMsg commentSortMsg=new CommentSortMsg();
                commentSortMsg.setMsg("全部评论");
                commentSortMsg.setType(TYPE_SORT_MSG);
                commentPartsByHeader.add(commentSortMsg);
            }
            commentPartsByHeader.addAll(commentParts);
            return commentPartsByHeader;
        }else {
            return null;
        }
    }
}
