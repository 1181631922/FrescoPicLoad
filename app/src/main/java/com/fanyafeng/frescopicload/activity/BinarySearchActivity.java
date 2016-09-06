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
public class BinarySearchActivity extends BaseActivity {
    private SimpleDraweeView sdvBinary;
    private TextView tvBinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_binary_search);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_binary_search);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_binary_search));
    }

    //初始化UI空间
    private void initView() {
        sdvBinary = (SimpleDraweeView) findViewById(R.id.sdvBinary);
        tvBinary = (TextView) findViewById(R.id.tvBinary);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadPicOnNet(sdvBinary, "https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_search_into_array.png", 1.56557f);
        tvBinary.setText(" public static int binarySearch(int[] srcArray, int des) {\n" +
                "        int low = 0;\n" +
                "        int high = srcArray.length - 1;\n" +
                "        while (low <= high) {\n" +
                "            int middle = low + ((high - low) >> 1);\n" +
                "            if (des == srcArray[middle]) {\n" +
                "                return middle;\n" +
                "            } else if (des < srcArray[middle]) {\n" +
                "                high = middle - 1;\n" +
                "            } else {\n" +
                "                low = middle + 1;\n" +
                "            }\n" +
                "        }\n" +
                "        return -1;\n" +
                "    }\n" +
                "\n" +
                "    public static int binSearch(int Array[], int low, int high, int key) {\n" +
                "        if (low <= high) {\n" +
                "            int middle = (low + high) >> 1;\n" +
                "            if (key == Array[middle]) {\n" +
                "                return middle;\n" +
                "            } else if (key < Array[middle]) {\n" +
                "                return binSearch(Array, low, middle - 1, key);\n" +
                "            } else {\n" +
                "                return binSearch(Array, middle + 1, high, key);\n" +
                "            }\n" +
                "        } else {\n" +
                "            return -1;\n" +
                "        }\n" +
                "    }");
    }

}
