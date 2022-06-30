package com.comicread.android.ui.notifications;

import static com.comicread.android.adapter.RecyclerViewAdapter.DB_HISTORY;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

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
    private TextView deleteText;
    private RelativeLayout bottomRL;
    private static List<ComicBean> deleteList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHistoryBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }
    @Override
    public void onResume() {
        super.onResume();
        getHistoryComicList();
        initRecycleView();
        init();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (deleteBtn.getBackground().getConstantState().equals(getActivity().getDrawable(R.drawable.cancel).getConstantState())) {
            deleteBtn.setBackgroundResource(R.drawable.delete);
            bottomRL.setVisibility(View.GONE);
        }
    }

    private void init(){
        swipeRefreshLayout = binding.swipeRefresh;
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getHistoryComicList();
                swipeRefreshLayout.setRefreshing(false);
                adapter.notifyDataSetChanged();
            }
        });
        //初始化顶部删除按钮
        deleteBtn = getParentFragment().getView().findViewById(R.id.delete_btn);//获取父布局删除按钮
        bottomRL = getParentFragment().getView().findViewById(R.id.bottom_rl);
        deleteBtn.setOnClickListener((view) -> {
            if (deleteBtn.getBackground().getConstantState().equals(getActivity().getDrawable(R.drawable.delete).getConstantState())) {
                bottomRL.setVisibility(View.VISIBLE);
                adapter.setIsShowCheckBox(true);
                deleteBtn.setBackgroundResource(R.drawable.cancel);

            } else {
                bottomRL.setVisibility(View.GONE);
                adapter.setIsShowCheckBox(false);
                deleteBtn.setBackgroundResource(R.drawable.delete);
            }
        });

        //初始化底部删除按钮
        deleteText = getParentFragment().getView().findViewById(R.id.delete_text);
        deleteText.setOnClickListener((view -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
            dialog.setTitle("删除选中记录？");
            dialog.setCancelable(false);
            dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Log.d("deleteListSize","："+deleteList.size());
                    for (ComicBean comic:deleteList) {
                        ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(getContext(),DB_HISTORY);
                        comicBeanDao.deleteComicByClass(comic);
                    }
                    deleteList.clear();
                    getHistoryComicList();
                    adapter.notifyDataSetChanged();
                    bottomRL.setVisibility(View.GONE);
                    adapter.setIsShowCheckBox(false);
                    deleteBtn.setBackgroundResource(R.drawable.delete);
                }
            });
            dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            dialog.show();
        }));
    }


    private void getHistoryComicList() {
        ComicBeanDaoUtil comicBeanDaoUtil = new ComicBeanDaoUtil(getContext(),DB_HISTORY);
        historyComicList.clear();
        historyComicList.addAll(comicBeanDaoUtil.queryAll());
        Collections.reverse(historyComicList);//列表倒序
    }
    private void initRecycleView() {
        historyRecyclerView = binding.historyRecyclerView;
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        historyRecyclerView.setLayoutManager(manager);
        adapter = new RecyclerViewAdapter(historyComicList,false);
        historyRecyclerView.setAdapter(adapter);
    }
    public static void addDeleteList(ComicBean comic){
        deleteList.add(comic);
        Log.d("deleteListSize","："+deleteList.size());
    }
    public static void removeDeleteList(ComicBean comic){
        deleteList.remove(comic);
        Log.d("deleteListSize","："+deleteList.size());
    }
}