package com.comicread.android.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.comicread.android.ui.comicdetail.ComicDetailActivity;
import com.comicread.android.R;
import com.comicread.android.databinding.FragmentHomeBinding;
import com.comicread.android.gson.RankComicListBean;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView homeRecyclerView;
    private Adapter adapter;
    private HomeViewModel homeViewModel;
    private SwipeRefreshLayout swipeRefreshLayout;
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_FOOTER = 1;
    int page=2;//初始化加载更多时的请求页码
    private List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO> comicList = new ArrayList<>();

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

        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        homeRecyclerView.setLayoutManager(manager);
        adapter = new Adapter(comicList);
        homeRecyclerView.setAdapter(adapter);
        getComicsDTO();
        swipeRefreshLayout.setColorSchemeResources(androidx.navigation.ui.R.color.design_default_color_primary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新时，重新获取ViewModel请求的ComicsDTO
                getComicsDTO();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        homeRecyclerView.addOnScrollListener(new EndlessRecyclerOnScrollListener() {
            @Override
            public void onLoadMore() {
                Log.d("123","page:"+page);
                Log.d("123",adapter.getItemCount()+"");
                Log.d("123","comicListSize："+comicList.size());
                getMoreComicsDTO(page);
            }
        });

        homeViewModel.getComicList().observe(getViewLifecycleOwner(),(value)->{
            comicList.clear();
            comicList.addAll(value);
            adapter.notifyDataSetChanged();
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    //获取ViewModel请求的ComicsDTO
    public void getComicsDTO(){
        homeViewModel.getInitComicList();
    }
    //获取加载更多时请求的的ComicsDTO
    public void getMoreComicsDTO(int i){
        homeViewModel.getMoreComicList(i);
    }

    //创建recyclerview适配器
    class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO> mComicList;
        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView mainImage;
            TextView comicName;
            TextView comicCategory;
            TextView comicSynopsis;
            Button collectionComic;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                mainImage = itemView.findViewById(R.id.main_image);
                comicName = itemView.findViewById(R.id.comic_name);
                comicCategory = itemView.findViewById(R.id.comic_category);
                comicSynopsis = itemView.findViewById(R.id.comic_synopsis);
                collectionComic = itemView.findViewById(R.id.collection_comic);
            }
        }
        class FooterViewHolder extends RecyclerView.ViewHolder{
            View footerView;
            TextView loadMoreText;
            public FooterViewHolder(@NonNull View itemView) {
                super(itemView);
                footerView = itemView;
                loadMoreText = itemView.findViewById(R.id.load_more);
            }
        }

        public Adapter(List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO> comicList) {
            mComicList = comicList;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == TYPE_NORMAL) {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.home_item,parent,false);
                final ViewHolder viewHolder = new ViewHolder(view);
                viewHolder.mainImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int position = viewHolder.getAdapterPosition();
                        RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO comicList = mComicList.get(position);
                        Intent intent = new Intent(getContext(), ComicDetailActivity.class);
                        intent.putExtra("comic_id",comicList.getComicId());
                        startActivity(intent);
                    }
                });
                return (ViewHolder) viewHolder;
            } else {
                View view = LayoutInflater.from(getContext()).inflate(R.layout.home_item_footer,parent,false);
                final FooterViewHolder footerViewHolder = new FooterViewHolder(view);
                return footerViewHolder;
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof ViewHolder) {
                RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO comicList = mComicList.get(position);
                RoundedCorners roundedCorners = new RoundedCorners(20);
                RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
                Glide.with(getContext()).load(Uri.parse(comicList.getCover())).apply(options).into(((ViewHolder) holder).mainImage);
                ((ViewHolder) holder).comicName.setText(comicList.getName());
                ((ViewHolder) holder).comicCategory.setText(comicList.getTags().get(0));
                ((ViewHolder) holder).comicSynopsis.setText(comicList.getDescription());
            }else if (holder instanceof FooterViewHolder){
                ((FooterViewHolder) holder).loadMoreText.setText("加载中...");
            }
        }

        @Override
        public int getItemViewType(int position) {
            if (position==mComicList.size()){
                return TYPE_FOOTER;
            }else{
                return TYPE_NORMAL;
            }
        }

        @Override
        public int getItemCount() {
            return mComicList.size()+1;
        }
    }

    /**
     * 封装RecyclerView.OnScrollListener
     * 判断何时下拉加载
     */
    private abstract class EndlessRecyclerOnScrollListener extends RecyclerView.OnScrollListener{
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
            isSlidingUpward = dy>0;
        }

        public abstract void onLoadMore();
    }
}