package com.comicread.android.either;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 解决NestedScrollView嵌套ListView之只显示一个item问题
 * 1、自定义Listview继承ListView
 * 2、重写onMeasure方法，
 */
public class NestedListView extends ListView {
    public NestedListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int heightSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, heightSpec);
    }
}
