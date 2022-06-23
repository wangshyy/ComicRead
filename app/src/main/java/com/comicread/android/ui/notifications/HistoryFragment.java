package com.comicread.android.ui.notifications;

import static com.comicread.android.adapter.RecyclerViewAdapter.DB_HISTORY;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.comicread.android.R;
import com.comicread.android.adapter.RecyclerViewAdapter;
import com.comicread.android.data.ComicBean;
import com.comicread.android.databinding.FragmentHistoryBinding;
import com.comicread.android.util.ComicBeanDaoUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HistoryFragment extends Fragment {

    private FragmentHistoryBinding binding;
    private RecyclerView historyRecyclerView;
    private RecyclerViewAdapter adapter;
    private List<ComicBean> historyComicList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefreshLayout;
    private Button deleteBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        init();
        getHistoryComicList();
        initRecycleView();
        return root;
    }
    private void init(){
        historyRecyclerView = binding.historyRecyclerView;
        swipeRefreshLayout = binding.swipeRefresh;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHistoryComicList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        //初始化删除按钮
        deleteBtn = getParentFragment().getView().findViewById(R.id.delete_cb);//获取父布局删除按钮
        deleteBtn.setOnClickListener((view) -> {
            if (deleteBtn.getBackground().getConstantState().equals(getActivity().getDrawable(R.drawable.delete).getConstantState())) {
                adapter.setIsShowCheckBox(true);
                deleteBtn.setBackgroundResource(R.drawable.done);
            } else {
                adapter.setIsShowCheckBox(false);
                deleteBtn.setBackgroundResource(R.drawable.delete);
            }
        });
    }


    private void getHistoryComicList() {
        ComicBeanDaoUtil comicBeanDaoUtil = new ComicBeanDaoUtil(getContext(),DB_HISTORY);
        historyComicList = comicBeanDaoUtil.queryAll();
        Collections.reverse(historyComicList);//列表倒序
    }
    private void initRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        historyRecyclerView.setLayoutManager(manager);
        adapter = new RecyclerViewAdapter(historyComicList,false);
        historyRecyclerView.setAdapter(adapter);
    }
}