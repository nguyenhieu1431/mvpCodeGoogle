package com.example.daggersample.post.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.daggersample.R;
import com.example.daggersample.post.Post;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 03/03/17.
 */

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostVh> {
    private List<Post> mPosts = new ArrayList<>();

    @Override
    public PostVh onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_post, parent, false);
        return new PostVh(view);
    }

    @Override
    public void onBindViewHolder(PostVh holder, int position) {
        holder.onBind(mPosts.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mPosts.size();
    }

    public void setData(List<Post> posts) {
        this.mPosts = posts;
    }

    public void clear() {
        mPosts.clear();
        notifyDataSetChanged();
    }

    // Add a list of items
    public void addAll(List<Post> list) {
        mPosts.addAll(list);
        notifyDataSetChanged();
    }

    class PostVh extends RecyclerView.ViewHolder {
        private TextView titleTv, desTv;

        public PostVh(View itemView) {
            super(itemView);
            titleTv = (TextView) itemView.findViewById(R.id.title_tv);
            desTv = (TextView) itemView.findViewById(R.id.des_tv);
        }

        public void onBind(Post post, int position) {
            titleTv.setText(post.getTitle());
            desTv.setText(post.getBody());
        }
    }
}
