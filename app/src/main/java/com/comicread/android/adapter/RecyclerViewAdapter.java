package com.comicread.android.adapter;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.comicread.android.R;
import com.comicread.android.data.ComicBean;
import com.comicread.android.db.ComicBeanDao;
import com.comicread.android.db.DaoMaster;
import com.comicread.android.db.DaoSession;
import com.comicread.android.ui.comicdetail.ComicDetailActivity;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_FOOTER = 1;
    List<ComicBean> mComicList;
    private ComicBeanDao comicBeanDao;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage;
        TextView comicName;
        TextView comicCategory;
        TextView comicSynopsis;
        Button collectionBtn;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.main_image);
            comicName = itemView.findViewById(R.id.comic_name);
            comicCategory = itemView.findViewById(R.id.comic_category);
            comicSynopsis = itemView.findViewById(R.id.comic_synopsis);
            collectionBtn = itemView.findViewById(R.id.collection_btn);
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

    public RecyclerViewAdapter(List<ComicBean> comicList) {
        mComicList = comicList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == TYPE_NORMAL) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item,parent,false);
            final ViewHolder homeViewHolder = new ViewHolder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = homeViewHolder.getAdapterPosition();
                    ComicBean comic = mComicList.get(position);
                    Intent intent = new Intent(v.getContext(), ComicDetailActivity.class);
                    intent.putExtra("comic_id",comic.getComicId());
                    v.getContext().startActivity(intent);

                }
            });
            homeViewHolder.collectionBtn.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    initGreenDao(view);
                    int position = homeViewHolder.getAdapterPosition();
                    ComicBean comicBean = mComicList.get(position);

                    if (homeViewHolder.collectionBtn.getText().equals("收藏")){
                        comicBeanDao.insert(comicBean);
                        homeViewHolder.collectionBtn.setText("已收藏");
                        Toast.makeText(view.getContext(), "收藏成功！", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(view.getContext(), "已收藏！", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            return homeViewHolder;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_item_footer,parent,false);
            final FooterViewHolder footerViewHolder = new FooterViewHolder(view);
            return footerViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder) {
            ComicBean comic = mComicList.get(position);
            RoundedCorners roundedCorners = new RoundedCorners(20);
            RequestOptions options = RequestOptions.bitmapTransform(roundedCorners);
            Glide.with(holder.itemView.getContext()).load(Uri.parse(comic.getCover())).apply(options).into(((ViewHolder) holder).mainImage);
            ((ViewHolder) holder).comicName.setText(comic.getName());
            ((ViewHolder) holder).comicCategory.setText(comic.getTags());
            ((ViewHolder) holder).comicSynopsis.setText(comic.getDescription());
            initGreenDao(holder.itemView);

            ComicBean queryResultComic = queryComicByName(comic.getName());
            if (queryResultComic != null){
                ((ViewHolder) holder).collectionBtn.setText("已收藏");
            }else {
                ((ViewHolder) holder).collectionBtn.setText("收藏");
            }
        }else if (holder instanceof FooterViewHolder){
            if (mComicList.size()>0) {
                ((FooterViewHolder) holder).loadMoreText.setText("加载中...");
            }
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

    private void initGreenDao(View view) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(view.getContext(), "favorites.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        DaoSession daoSession = daoMaster.newSession();
        comicBeanDao = daoSession.getComicBeanDao();
    }
    //通过name查询
    private ComicBean queryComicByName(String name){
        ComicBean queryResultComic = comicBeanDao.queryBuilder().where(ComicBeanDao.Properties.Name.eq(name)).unique();
        return queryResultComic;
    }
}
