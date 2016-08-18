package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.adapter.PicListAdapter;
import com.fanyafeng.frescopicload.bean.PicListBean;
import com.fanyafeng.frescopicload.constant.PicUrlConstants;

import java.util.ArrayList;
import java.util.List;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class PicListActivity extends BaseActivity {
    private RecyclerView rvPicList;

    private PicListAdapter picListAdapter;
    private List<PicListBean> picListBeanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic_list);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_pic_list);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_pic_list));
    }

    //初始化UI空间
    private void initView() {
        rvPicList = (RecyclerView) findViewById(R.id.rvPicList);
//        rvPicList.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
        rvPicList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        picListAdapter = new PicListAdapter(this, picListBeanList);
        rvPicList.setAdapter(picListAdapter);
    }

    //初始化数据
    private void initData() {
        for (int i = 0; i < 10; i++) {
            PicListBean picListBean = new PicListBean();
            picListBean.setPicUrl(PicUrlConstants.imgUrl);
            picListBeanList.add(picListBean);
        }
        picListAdapter.notifyDataSetChanged();

        rvPicList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                switch (newState) {
                    case RecyclerView.SCROLL_STATE_IDLE:
                        Log.d("scroll_idle", "滑动停止");
                        int firstPos = ((LinearLayoutManager) rvPicList.getLayoutManager()).findFirstVisibleItemPosition();
                        int lastPos = ((LinearLayoutManager) rvPicList.getLayoutManager()).findLastVisibleItemPosition();
                        Log.d("recycler_position", "firstPos:" + firstPos + " | lastPos:" + lastPos);

                        View view = rvPicList.getChildAt(firstPos);
                        int[] location = new int[2];
                        view.getLocationInWindow(location);
                        Log.d("location", "location0：" + location[0] + " | location1：" + location[1]);

                        break;
                    case RecyclerView.SCROLL_STATE_DRAGGING:
                        break;
                    case RecyclerView.SCROLL_STATE_SETTLING:
                        break;
                }
            }

        });
    }


}
