package com.comicread.android.ui.notifications;

import static com.comicread.android.adapter.RecyclerViewAdapter.DB_FAVORITE;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.comicread.android.adapter.GridViewAdapter;
import com.comicread.android.data.ComicBean;
import com.comicread.android.databinding.FragmentFavoritesBinding;
import com.comicread.android.db.ComicBeanDao;
import com.comicread.android.db.DaoMaster;
import com.comicread.android.db.DaoSession;
import com.comicread.android.util.ComicBeanDaoUtil;

import java.util.ArrayList;
import java.util.List;


public class FavoritesFragment extends Fragment {

    private FragmentFavoritesBinding binding;
    private GridViewAdapter gridViewAdapter;
    private RecyclerView favoritesRecycleView;
    private List<ComicBean> favoriteComicList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        init();
        return root;
    }
    private void init(){
        getFavoriteComicsList();
        initRecyclerView();
    }
    private void initRecyclerView(){
        favoritesRecycleView = binding.favoritesRecyclerView;
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        favoritesRecycleView.setLayoutManager(gridLayoutManager);
        gridViewAdapter = new GridViewAdapter(favoriteComicList);
        favoritesRecycleView.setAdapter(gridViewAdapter);
    }
    private void getFavoriteComicsList(){
        ComicBeanDaoUtil comicBeanDaoUtil = new ComicBeanDaoUtil(getContext(),DB_FAVORITE);
        favoriteComicList = comicBeanDaoUtil.queryAll();
    }
}