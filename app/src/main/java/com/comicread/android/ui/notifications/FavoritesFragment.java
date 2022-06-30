package com.comicread.android.ui.notifications;

import static com.comicread.android.adapter.RecyclerViewAdapter.DB_FAVORITE;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.comicread.android.R;
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
    private Button deleteBtn;
    private RelativeLayout bottomRL;
    private static List<ComicBean> deleteList = new ArrayList<>();
    private TextView deleteText;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFavoritesBinding.inflate(inflater,container,false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        getFavoriteComicsList();
        initRecyclerView();
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
        //初始化顶部删除按钮
        deleteBtn = getParentFragment().getView().findViewById(R.id.delete_btn);
        bottomRL = getParentFragment().getView().findViewById(R.id.bottom_rl);
        deleteBtn.setOnClickListener((view -> {
            if (deleteBtn.getBackground().getConstantState().equals(getActivity().getDrawable(R.drawable.delete).getConstantState())) {
                bottomRL.setVisibility(View.VISIBLE);
                gridViewAdapter.setIsShowCheckBox(true);
                deleteBtn.setBackgroundResource(R.drawable.cancel);

            } else {
                bottomRL.setVisibility(View.GONE);
                gridViewAdapter.setIsShowCheckBox(false);
                deleteBtn.setBackgroundResource(R.drawable.delete);
            }
        }));
        //初始化底部删除按钮
        deleteText = getParentFragment().getView().findViewById(R.id.delete_text);
        deleteText.setOnClickListener((view -> {
            if (deleteList.size()==0)
                Toast.makeText(getContext(), "请先选择！", Toast.LENGTH_SHORT).show();
            else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getContext());
                dialog.setTitle("删除选中收藏？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        for (ComicBean comic:deleteList){
                            ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(getContext(),DB_FAVORITE);
                            comicBeanDao.deleteComicByClass(comic);
                        }
                        deleteList.clear();
                        getFavoriteComicsList();
                        gridViewAdapter.notifyDataSetChanged();
                        gridViewAdapter.setIsShowCheckBox(false);
                        bottomRL.setVisibility(View.GONE);
                        deleteBtn.setBackgroundResource(R.drawable.delete);
                    }
                });
                dialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                dialog.show();
            }
        }));
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
        favoriteComicList.clear();
        favoriteComicList.addAll(comicBeanDaoUtil.queryAll());
    }

    public static void addDeleteList(ComicBean comic){
        deleteList.add(comic);
    }
    public static void removeDeleteList(ComicBean comic){
        deleteList.remove(comic);
    }
}