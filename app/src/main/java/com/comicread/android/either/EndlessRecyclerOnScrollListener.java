package com.comicread.android.either;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * 封装RecyclerView.OnScrollListener
 * 判断何时下拉加载
 */
public abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener{
    private boolean isSlidingUpward = false;
    private boolean isLoadingMore = false;
    @Override
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        int lastItemPosition = linearLayoutManager.findLastCompletelyVisibleItemPosition();
        int itemCount = linearLayoutManager.getItemCount();
        if (newState == RecyclerView.SCROLL_STATE_IDLE){
            if (lastItemPosition == (itemCount-1) && isSlidingUpward && !isLoadingMore){
                onLoadMore();
                isLoadingMore = true;
            }
        }
        isLoadingMore = false;
    }

    @Override
    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (dy > 0)
            isSlidingUpward = true;
        else
            isSlidingUpward = false;
    }

    public abstract void onLoadMore();
}
