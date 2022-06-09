package com.comicread.android.ui.dashboard;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.comicread.android.R;
import com.comicread.android.adapter.RecyclerViewAdapter;
import com.comicread.android.data.ComicBean;
import com.comicread.android.databinding.FragmentDashboardBinding;
import com.comicread.android.gson.SearchResultBean;

import java.util.ArrayList;
import java.util.List;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private Toolbar toolbar;
    private EditText searchEditText;
    private Button searchCloseBtn;
    private String searchText;
    private List<ComicBean> mComicList = new ArrayList<>();
    private DashboardViewModel dashboardViewModel;
    private RecyclerView searchRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        init();
        return root;
    }
    private void init(){
        toolbar = binding.toolbar;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_dashboard);

        searchEditText = binding.searchEditText;
        searchEditText.setHint("镇魂");
        searchCloseBtn = binding.searchCloseBtn;
        searchRecyclerView = binding.searchRecyclerView;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        searchRecyclerView.setLayoutManager(linearLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(mComicList);
        searchRecyclerView.setAdapter(recyclerViewAdapter);
        search();
        swipeRefreshLayout = binding.swipeRefresh;

        //下拉刷新
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getmComicList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
    private void search(){
        //监听软键盘回车
        searchEditText.setOnEditorActionListener(new EditText.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH){
                    searchText = searchEditText.getText().toString();
                    getmComicList();
                }
                return false;
            }
        });
    }
    //获取搜索来的列表
    private void getmComicList(){
        if (!searchText.equals("")){
            dashboardViewModel.getComicList(searchText).observe(getViewLifecycleOwner(),(value)->{
                mComicList.addAll(value);
                recyclerViewAdapter.notifyDataSetChanged();
            });
        } else
            Toast.makeText(getContext(), "请输入要搜索漫画！", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}