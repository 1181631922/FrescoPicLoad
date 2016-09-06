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
public class HeapSortActivity extends BaseActivity {
    private SimpleDraweeView sdvHeapSort;
    private TextView tvHeapSort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heap_sort);
//这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_heap_sort);

        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_heap_sort));
    }

    //初始化UI空间
    private void initView() {
        sdvHeapSort = (SimpleDraweeView) findViewById(R.id.sdvHeapSort);
        tvHeapSort = (TextView) findViewById(R.id.tvHeapSort);
    }

    //初始化数据
    private void initData() {
        FrescoUtil.loadGifPicOnNet(sdvHeapSort, "https://upload.wikimedia.org/wikipedia/commons/1/1b/Sorting_heapsort_anim.gif", 1.309f);
        tvHeapSort.setText("private static void buildMaxHeapify(int[] data) {\n" +
                "        //没有子节点的才需要创建最大堆，从最后一个的父节点开始\n" +
                "        int startIndex = getParentIndex(data.length - 1);\n" +
                "        //从尾端开始创建最大堆，每次都是正确的堆\n" +
                "        for (int i = startIndex; i >= 0; i--) {\n" +
                "            maxHeapify(data, data.length, i);\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 创建最大堆\n" +
                "     *\n" +
                "     * @param data\n" +
                "     * @param heapSize需要创建最大堆的大小，一般在sort的时候用到，因为最多值放在末尾，末尾就不再归入最大堆了\n" +
                "     * @param index当前需要创建最大堆的位置\n" +
                "     */\n" +
                "    private static void maxHeapify(int[] data, int heapSize, int index) {\n" +
                "        // 当前点与左右子节点比较\n" +
                "        int left = getChildLeftIndex(index);\n" +
                "        int right = getChildRightIndex(index);\n" +
                "\n" +
                "        int largest = index;\n" +
                "        if (left < heapSize && data[index] < data[left]) {\n" +
                "            largest = left;\n" +
                "        }\n" +
                "        if (right < heapSize && data[largest] < data[right]) {\n" +
                "            largest = right;\n" +
                "        }\n" +
                "        //得到最大值后可能需要交换，如果交换了，其子节点可能就不是最大堆了，需要重新调整\n" +
                "        if (largest != index) {\n" +
                "            int temp = data[index];\n" +
                "            data[index] = data[largest];\n" +
                "            data[largest] = temp;\n" +
                "            maxHeapify(data, heapSize, largest);\n" +
                "        }\n" +
                "\n" +
                "        for (int i = 0; i < sort.length; i++) {\n" +
                "            System.out.print(sort[i] + \",\");\n" +
                "        }\n" +
                "        System.out.println();\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 排序，最大值放在末尾，data虽然是最大堆，在排序后就成了递增的\n" +
                "     *\n" +
                "     * @param data\n" +
                "     */\n" +
                "    private static void heapSort(int[] data) {\n" +
                "\n" +
                "        //末尾与头交换，交换后调整最大堆\n" +
                "        for (int i = data.length - 1; i > 0; i--) {\n" +
                "            int temp = data[0];\n" +
                "            data[0] = data[i];\n" +
                "            data[i] = temp;\n" +
                "            maxHeapify(data, i, 0);\n" +
                "        }\n" +
                "\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 父节点位置\n" +
                "     *\n" +
                "     * @param current\n" +
                "     * @return\n" +
                "     */\n" +
                "    private static int getParentIndex(int current) {\n" +
                "        System.out.print(\"ParentIndex:\" + ((current - 1) >> 1));\n" +
                "        return (current - 1) >> 1;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 左子节点position注意括号，加法优先级更高\n" +
                "     *\n" +
                "     * @param current\n" +
                "     * @return\n" +
                "     */\n" +
                "    private static int getChildLeftIndex(int current) {\n" +
                "        return (current << 1) + 1;\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 右子节点position\n" +
                "     *\n" +
                "     * @param current\n" +
                "     * @return\n" +
                "     */\n" +
                "    private static int getChildRightIndex(int current) {\n" +
                "        return (current << 1) + 2;\n" +
                "    }\n" +
                "\n" +
                "    private static void print(int[] data) {\n" +
                "        int pre = -2;\n" +
                "        for (int i = 0; i < data.length; i++) {\n" +
                "            if (pre < (int) getLog(i + 1)) {\n" +
                "                pre = (int) getLog(i + 1);\n" +
                "                System.out.println();\n" +
                "            }\n" +
                "            System.out.print(data[i] + \" |\");\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "    /**\n" +
                "     * 以2为底的对数\n" +
                "     *\n" +
                "     * @param param\n" +
                "     * @return\n" +
                "     */\n" +
                "    private static double getLog(double param) {\n" +
                "        return Math.log(param) / Math.log(2);\n" +
                "    }");
    }

}
