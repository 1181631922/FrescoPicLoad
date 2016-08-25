package com.fanyafeng.frescopicload.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.receiver.CustomActions;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class MainActivity extends BaseActivity {

    private Receiver receiver = new Receiver();

    class Receiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case CustomActions.ACTION_USER_LOGINED:
                    Log.d("main", "收到广播");
                    context.startActivity(new Intent(MainActivity.this, DialogActivity.class));
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
//        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        toolbar_center_title.setText(getString(R.string.title_activity_main));
    }

    //初始化UI空间
    private void initView() {

    }

    //初始化数据
    private void initData() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(CustomActions.ACTION_USER_LOGINED);
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing()) {
            unregisterReceiver(receiver);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.btnOperate1://app内图片加载
                startActivity(new Intent(this, AppPicLoadActivity.class));
                break;
            case R.id.btnOperate2:
                startActivity(new Intent(this, AppGifPicLoadActivity.class));
                break;
            case R.id.btnOperate3:
                startActivity(new Intent(this, CirclePicActivity.class));
                break;
            case R.id.btnOperate4:
                startActivity(new Intent(this, PicProgressActivity.class));
                break;
            case R.id.btnOperate5:
                startActivity(new Intent(this, CutPicActivity.class));
                break;
            case R.id.btnOperate6:
                startActivity(new Intent(this, DownPicActivity.class));
                break;
            case R.id.btnOperate7:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.btnOperate8:
                startActivity(new Intent(this, MyReceiverActivity.class));
                break;
            case R.id.btnOperate9:
                startActivity(new Intent(this, PicListActivity.class));
                break;
            case R.id.btnOperate10:
                startActivity(new Intent(this, VideoActivity.class));
                break;
            case R.id.btnOperate11:
                startActivity(new Intent(this, BlurPicActivity.class));
                break;
            case R.id.btnOperate12:
                startActivity(new Intent(this, CocktaiSortActivity.class));
                break;
            case R.id.btnOperate13:
                startActivity(new Intent(this, BubbleSortActivity.class));
                break;
        }
    }
}
