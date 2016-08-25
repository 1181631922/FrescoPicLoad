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
public class CocktaiSortActivity extends BaseActivity {
    private SimpleDraweeView sdvCocktai;
    private TextView tvDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cocktai_sort);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_cocktai_sort);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_cocktai_sort));
    }

    //初始化UI空间
    private void initView() {
        sdvCocktai = (SimpleDraweeView) findViewById(R.id.sdvCocktai);
        tvDesc= (TextView) findViewById(R.id.tvDesc);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadGifPicOnNet(sdvCocktai, "https://upload.wikimedia.org/wikipedia/commons/e/ef/Sorting_shaker_sort_anim.gif", 1.08f);
        tvDesc.setText("private static void cocktailSort(int[] ints) {\n" +
                "        int left = 0;\n" +
                "        int right = ints.length - 1;\n" +
                "        while (left < right) {\n" +
                "            for (int i = left; i < right; i++) {\n" +
                "                if (ints[i] > ints[i + 1]) {\n" +
                "                    int temp = ints[i];\n" +
                "                    ints[i] = ints[i + 1];\n" +
                "                    ints[i + 1] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "            right--;\n" +
                "            for (int j = right; j > left; j--) {\n" +
                "                if (ints[j] < ints[j - 1]) {\n" +
                "                    int temp = ints[j];\n" +
                "                    ints[j] = ints[j - 1];\n" +
                "                    ints[j - 1] = temp;\n" +
                "                }\n" +
                "            }\n" +
                "            left++;\n" +
                "        }\n" +
                "\n" +
                "        for (int i = 0; i < ints.length; i++) {\n" +
                "            System.out.print(ints[i] + \",\");\n" +
                "        }\n" +
                "    }");
    }

}
