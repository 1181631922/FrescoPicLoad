package com.fanyafeng.frescopicload.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fanyafeng.frescopicload.R;
import com.fanyafeng.frescopicload.BaseActivity;
import com.fanyafeng.frescopicload.util.FrescoUtil;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class BubbleSortActivity extends BaseActivity {
    private SimpleDraweeView sdvBubble;
    private TextView tvBubble;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bubble_sort);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_bubble_sort);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_bubble_sort));
    }

    //初始化UI空间
    private void initView() {
        sdvBubble = (SimpleDraweeView) findViewById(R.id.sdvBubble);
        tvBubble = (TextView) findViewById(R.id.tvBubble);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadGifPicOnNet(sdvBubble, "https://upload.wikimedia.org/wikipedia/commons/3/37/Bubble_sort_animation.gif", 1.19f);
        tvBubble.setText("private static void bubbleSort(int[] ints) {\n" +
                "        for (int i = 0; i < ints.length; i++) {\n" +
                "            for (int j = i; j < ints.length; j++) {\n" +
                "                if (ints[i] > ints[j]) {\n" +
                "                    int temp = ints[i];\n" +
                "                    ints[i] = ints[j];\n" +
                "                    ints[j] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "        for (int i = 0; i < ints.length; i++) {\n" +
                "            System.out.print(ints[i] + \",\");\n" +
                "        }\n" +
                "    }");
    }

}
