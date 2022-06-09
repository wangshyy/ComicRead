package com.comicread.android.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.comicread.android.adapter.RecyclerViewAdapter;
import com.comicread.android.data.ComicBean;
import com.comicread.android.either.EndlessRecyclerOnScrollListener;
import com.comicread.android.R;
import com.comicread.android.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView homeRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;
    private HomeViewModel homeViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    private Toolbar toolbar;

    //加载更多时，初始请求页码
    int page=2;

    private List<ComicBean> comicList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);

        init();

        return binding.getRoot();
    }

    //初始化控件
    public void init(){
        homeRecyclerView = binding.homeRecyclerView;
        swipeRefreshLayout = binding.swipeRefresh;
        toolbar = binding.toolbar;
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        toolbar.setTitle(R.string.title_home);

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        homeRecyclerView.setLayoutManager(manager);
        recyclerViewAdapter = new RecyclerViewAdapter(comicList);
        homeRecyclerView.setAdapter(recyclerViewAdapter);
        setComicsList();
        swipeRefreshLayout.setColorSchemeResources(androidx.navigation.ui.R.color.design_default_color_primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新时，重新获取ViewModel请求的ComicsDTO
                setComicsList();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        homeRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                Log.d("123","page:"+page);
                Log.d("123",recyclerViewAdapter.getItemCount()+"");
                Log.d("123","comicListSize："+comicList.size());
                setMoreComicsList(page);
                page++;
            }
        });

        homeViewModel.getComicList().observe(getViewLifecycleOwner(),(value)->{
            comicList.clear();
            comicList.addAll(value);
            recyclerViewAdapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    //获取ViewModel请求的ComicsList
    public void setComicsList(){
        homeViewModel.setInitComicList();
    }
    //获取加载更多时请求的的ComicsList
    public void setMoreComicsList(int i){
        homeViewModel.setMoreComicList(i);
    }

}