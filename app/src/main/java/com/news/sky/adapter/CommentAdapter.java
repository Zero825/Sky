package com.news.sky.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.news.sky.binding.OnClickBinding;
import com.news.sky.commentpart.Comment;
import com.news.sky.commentpart.CommentReplyMsg;
import com.news.sky.commentpart.CommentSortMsg;
import com.news.sky.commentpart.Reply;
import com.news.sky.data.CommentJson;
import com.news.sky.commentpart.CommentPart;
import com.news.sky.databinding.ItemCommentBinding;
import com.news.sky.databinding.ItemCommentMsgBinding;
import com.news.sky.databinding.ItemCommentReplyMsgBinding;
import com.news.sky.databinding.ItemReplyBinding;
import com.news.sky.diffutil.CommentPartDiffCallback;

public class CommentAdapter extends ListAdapter<CommentPart, RecyclerView.ViewHolder> {
    private final static String TAG="CommentAdapter";

    public CommentAdapter() {
        super(new CommentPartDiffCallback());
    }

    @Override
    public int getItemViewType(int position) {
        return getItem(position).getType();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==CommentPart.TYPE_COMMENT){
            ItemCommentBinding binding=ItemCommentBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new CommentViewHolder(binding);
        }else if(viewType==CommentPart.TYPE_REPLY){
            ItemReplyBinding binding=ItemReplyBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ReplyViewHolder(binding);
        }else if(viewType==CommentPart.TYPE_REPLY_MSG){
            ItemCommentReplyMsgBinding binding = ItemCommentReplyMsgBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new ReplyMsgViewHolder(binding);
        } else if(viewType==CommentPart.TYPE_SORT_MSG){
            ItemCommentMsgBinding binding=ItemCommentMsgBinding
                    .inflate(LayoutInflater.from(parent.getContext()),parent,false);
            return new CommentMsgViewHolder(binding);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int viewType=holder.getItemViewType();

        if(viewType==CommentPart.TYPE_COMMENT){
            CommentViewHolder commentViewHolder= (CommentViewHolder) holder;
            commentViewHolder.binding.setComment((Comment) getItem(position));
        }else if(viewType==CommentPart.TYPE_REPLY){
            ReplyViewHolder replyViewHolder= (ReplyViewHolder) holder;
            replyViewHolder.binding.setReply((Reply) getItem(position));
        }else if(viewType==CommentPart.TYPE_REPLY_MSG){
            ReplyMsgViewHolder replyMsgViewHolder = (ReplyMsgViewHolder) holder;
            replyMsgViewHolder.binding.setCommentReplyMsg((CommentReplyMsg) getItem(position));
        } else if(viewType==CommentPart.TYPE_SORT_MSG){
            CommentMsgViewHolder commentMsgViewHolder=(CommentMsgViewHolder) holder;
            commentMsgViewHolder.binding.setCommentSortMsg((CommentSortMsg) getItem(position));
        }
    }

    private static class CommentViewHolder extends RecyclerView.ViewHolder{
        ItemCommentBinding binding;
        private OnClickBinding onClickBinding = new OnClickBinding();

        public CommentViewHolder(@NonNull ItemCommentBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
            this.binding.setOnClickBinding(onClickBinding);
        }
    }

    private static class ReplyViewHolder extends RecyclerView.ViewHolder{
        ItemReplyBinding binding;

        public ReplyViewHolder(@NonNull ItemReplyBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    private static class CommentMsgViewHolder extends RecyclerView.ViewHolder{
        ItemCommentMsgBinding binding;


        public CommentMsgViewHolder(@NonNull ItemCommentMsgBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    private static class ReplyMsgViewHolder extends  RecyclerView.ViewHolder{
        ItemCommentReplyMsgBinding binding;

        public ReplyMsgViewHolder(@NonNull ItemCommentReplyMsgBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
