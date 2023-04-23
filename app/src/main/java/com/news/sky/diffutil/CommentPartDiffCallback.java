package com.news.sky.diffutil;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;

import com.news.sky.commentpart.Comment;
import com.news.sky.commentpart.CommentPart;
import com.news.sky.commentpart.CommentSortMsg;
import com.news.sky.commentpart.Reply;

import static com.news.sky.commentpart.CommentPart.TYPE_COMMENT;
import static com.news.sky.commentpart.CommentPart.TYPE_REPLY;
import static com.news.sky.commentpart.CommentPart.TYPE_SORT_MSG;


public class CommentPartDiffCallback extends DiffUtil.ItemCallback<CommentPart> {
    private final static String TAG="ArticleDiffCallback";

    @Override
    public boolean areItemsTheSame(@NonNull CommentPart oldItem, @NonNull CommentPart newItem) {
        int oldItemType=oldItem.getType();
        int newItemType=newItem.getType();
        if(oldItemType!=newItemType){
            return false;
        }
        if(newItemType==TYPE_COMMENT){
            return ((Comment) oldItem).getComment_id()==((Comment) newItem).getComment_id();
        }else if(newItemType==TYPE_REPLY){
            return ((Reply) oldItem).getReplyId()==((Reply) newItem).getReplyId();
        }else if(newItemType==TYPE_SORT_MSG){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean areContentsTheSame(@NonNull CommentPart oldItem, @NonNull CommentPart newItem) {
        int oldItemType=oldItem.getType();
        int newItemType=newItem.getType();
        if(oldItemType!=newItemType){
            return false;
        }
        if(newItemType==TYPE_COMMENT){
            return ((Comment) oldItem).getSupport_count()==((Comment) newItem).getSupport_count();
        }else if(newItemType==TYPE_REPLY){
            return ((Reply) oldItem).getPraisesCount()==((Reply) newItem).getPraisesCount();
        }else if(newItemType==TYPE_SORT_MSG){
            return ((CommentSortMsg)oldItem).getMsg().equals(((CommentSortMsg)newItem).getMsg());
        }else {
            return false;
        }
    }
}
