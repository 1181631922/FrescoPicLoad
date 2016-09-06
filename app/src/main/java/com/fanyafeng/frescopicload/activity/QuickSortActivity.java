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

import java.net.SocketImpl;

//需要搭配baseactivity，这里默认为baseactivity,并且默认Baseactivity为包名的根目录
public class QuickSortActivity extends BaseActivity {
    private SimpleDraweeView sdvQuickSort;
    private TextView tvQuick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_sort);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_quick_sort);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_quick_sort));
    }

    //初始化UI空间
    private void initView() {
        sdvQuickSort = (SimpleDraweeView) findViewById(R.id.sdvQuickSort);
        tvQuick = (TextView) findViewById(R.id.tvQuick);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadGifPicOnNet(sdvQuickSort, "https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif", 1.31f);
        tvQuick.setText("private static void quickSort(int[] ints, int start, int end) {\n" +
                "        if (start >= end) {\n" +
                "            return;\n" +
                "        }\n" +
                "        int mid = ints[end];\n" +
                "        int left = start;\n" +
                "        int right = end - 1;\n" +
                "        while (left < right) {\n" +
                "            while (ints[left] < mid && left < right) {\n" +
                "                left++;\n" +
                "            }\n" +
                "            while (ints[right] >= mid && left < right) {\n" +
                "                right--;\n" +
                "            }\n" +
                "            swap(ints, left, right);\n" +
                "        }\n" +
                "        if (ints[left] >= ints[end]) {\n" +
                "            swap(ints, left, end);\n" +
                "        } else {\n" +
                "            left++;\n" +
                "        }\n" +
                "        quickSort(ints, start, right - 1);\n" +
                "        quickSort(ints, right + 1, end);\n" +
                "\n" +
                "        for (int i = 0; i < ints.length; i++) {\n" +
                "            System.out.print(ints[i] + \",\");\n" +
                "        }\n" +
                "        System.out.println();\n" +
                "    }\n" +
                "\n" +
                "    private static void swap(int[] ints, int x, int y) {\n" +
                "        int temp = ints[x];\n" +
                "        ints[x] = ints[y];\n" +
                "        ints[y] = temp;\n" +
                "    }");
    }

}
