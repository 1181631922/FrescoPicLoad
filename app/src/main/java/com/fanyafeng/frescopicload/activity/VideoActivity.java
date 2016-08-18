package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;
import com.volokh.danylo.video_player_manager.manager.PlayerItemChangeListener;
import com.volokh.danylo.video_player_manager.manager.SingleVideoPlayerManager;
import com.volokh.danylo.video_player_manager.manager.VideoItem;
import com.volokh.danylo.video_player_manager.manager.VideoPlayerManager;
import com.volokh.danylo.video_player_manager.meta.CurrentItemMetaData;
import com.volokh.danylo.video_player_manager.meta.MetaData;
import com.volokh.danylo.video_player_manager.ui.MediaPlayerWrapper;
import com.volokh.danylo.video_player_manager.ui.VideoPlayerView;
import com.volokh.danylo.visibility_utils.items.ListItem;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class VideoActivity extends BaseActivity implements VideoItem ,MetaData{
    private static final String VIDEO_URL =
//            "http://dn-chunyu.qbox.me/fwb/static/images/home/video/video_aboutCY_A.mp4";
            "http://www.jmzsjy.com/UploadFile/%E5%BE%AE%E8%AF%BE/%E5%9C%B0%E6%96%B9%E9%A3%8E%E5%91%B3%E5%B0%8F%E5%90%83%E2%80%94%E2%80%94%E5%AE%AB%E5%BB%B7%E9%A6%99%E9%85%A5%E7%89%9B%E8%82%89%E9%A5%BC.mp4";


    private VideoPlayerView videoView;
    private SimpleDraweeView videoViewHolder;

    private VideoPlayerManager<MetaData> videoPlayerManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_video);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_video));
    }

    //初始化UI空间
    private void initView() {
        videoView = (VideoPlayerView) findViewById(R.id.videoView);
        videoViewHolder = (SimpleDraweeView) findViewById(R.id.videoViewHolder);
        videoViewHolder.setImageURI(PicUrlConstants.imgUrl);
        videoViewHolder.setOnClickListener(this);
        videoPlayerManager = new SingleVideoPlayerManager(new PlayerItemChangeListener() {
            @Override
            public void onPlayerItemChanged(MetaData currentItemMetaData) {

            }
        });
    }

    //初始化数据
    private void initData() {
        videoView.addMediaPlayerListener(new MediaPlayerWrapper.MainThreadMediaPlayerListener() {
            @Override
            public void onVideoSizeChangedMainThread(int width, int height) {

            }

            @Override
            public void onVideoPreparedMainThread() {
                videoViewHolder.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onVideoCompletionMainThread() {

            }

            @Override
            public void onErrorMainThread(int what, int extra) {

            }

            @Override
            public void onBufferingUpdateMainThread(int percent) {

            }

            @Override
            public void onVideoStoppedMainThread() {
//                videoViewHolder.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public void playNewVideo(MetaData currentItemMetaData, VideoPlayerView player, VideoPlayerManager<MetaData> videoPlayerManager) {
        videoPlayerManager.playNewVideo(currentItemMetaData, player, VIDEO_URL);
    }

    @Override
    public void stopPlayback(VideoPlayerManager videoPlayerManager) {
        videoPlayerManager.stopAnyPlayback();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.videoViewHolder:
                videoPlayerManager.playNewVideo(this, videoView, VIDEO_URL);
                break;
            case R.id.btnStop:
                break;
            case R.id.btnForward:
//                videoView.
                videoPlayerManager.playNewVideo(this, videoView, VIDEO_URL);
                break;
        }
    }
}
