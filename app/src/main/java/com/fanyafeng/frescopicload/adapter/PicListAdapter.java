package com.fanyafeng.frescopicload.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.bean.PicListBean;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;

import java.util.List;

/**
 * Author： fanyafeng
 * Data： 16/8/16 17:28
 * Email: fanyafeng@live.cn
 */
public class PicListAdapter extends RecyclerView.Adapter<PicListAdapter.PicListViewHolder> {
    private Context context;
    private List<PicListBean> picListBeanList;

    public PicListAdapter(Context context, List<PicListBean> picListBeanList) {
        this.context = context;
        this.picListBeanList = picListBeanList;
    }

    @Override
    public PicListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_piclist_layout, parent, false);
        return new PicListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PicListViewHolder holder, int position) {
        PicListBean picListBean = picListBeanList.get(position);
        holder.sdvPicItem.setImageURI(picListBean.getPicUrl());
    }

    @Override
    public int getItemCount() {
        return picListBeanList.size();
    }

    class PicListViewHolder extends RecyclerView.ViewHolder {
        SimpleDraweeView sdvPicItem;
        VideoPlayerView videoItem;

        public PicListViewHolder(View itemView) {
            super(itemView);
            sdvPicItem = (SimpleDraweeView) itemView.findViewById(R.id.sdvPicItem);
            videoItem = (VideoPlayerView) itemView.findViewById(R.id.videoItem);
        }
    }
}
