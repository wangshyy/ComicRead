package com.comicread.android.adapter;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
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
import com.comicread.android.util.ComicBeanDaoUtil;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_FOOTER = 1;
    public static final String DB_FAVORITE = "favorites.db";
    public static final String DB_HISTORY = "history.db";
    private boolean addFooter = false;
    //默认不显示checkbox
    private boolean isShowCheckBox = false;
    List<ComicBean> mComicList;


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mainImage;
        TextView comicName;
        TextView comicCategory;
        TextView comicSynopsis;
        Button collectionBtn;
        CheckBox deleteCb;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.main_image);
            comicName = itemView.findViewById(R.id.comic_name);
            comicCategory = itemView.findViewById(R.id.comic_category);
            comicSynopsis = itemView.findViewById(R.id.comic_synopsis);
            collectionBtn = itemView.findViewById(R.id.collection_btn);
            deleteCb = itemView.findViewById(R.id.delete_cb);
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

    public RecyclerViewAdapter(List<ComicBean> comicList,boolean addFooter) {
        mComicList = comicList;
        this.addFooter = addFooter;
    }

    public void setIsShowCheckBox(boolean b){
        isShowCheckBox = b;
        notifyDataSetChanged();
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
                    ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(view.getContext(), DB_HISTORY);
                    int position = homeViewHolder.getAdapterPosition();
                    ComicBean comic = mComicList.get(position);
                    ComicBean queryResultComic = comicBeanDao.queryComicByName(comic.getName());

                    //已存在记录时，更新记录位置
                    if (queryResultComic != null){
                        comicBeanDao.deleteComicByClass(comic);
                        comicBeanDao.insertComicByClass(comic);
                    } else {
                        comicBeanDao.insertComicByClass(comic);
                    }

                    Intent intent = new Intent(v.getContext(), ComicDetailActivity.class);
                    intent.putExtra("comic_id",comic.getComicId());
                    v.getContext().startActivity(intent);

                }
            });
            //收藏按钮
            homeViewHolder.collectionBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(view.getContext(), DB_FAVORITE);
                    int position = homeViewHolder.getAdapterPosition();
                    ComicBean comic = mComicList.get(position);

                    if (homeViewHolder.collectionBtn.getText().equals("收藏")){
                        comicBeanDao.insertComicByClass(comic);
                        homeViewHolder.collectionBtn.setText("已收藏");
                        Toast.makeText(view.getContext(), "收藏成功！", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(view.getContext(), "已收藏！", Toast.LENGTH_SHORT).show();
                    }
                }
            });



//            homeViewHolder.deleteCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//                    int position = homeViewHolder.getAdapterPosition();
//                    ComicBean comic = mComicList.get(position);
//                    if (b) {
//                        ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(view.getContext(), DB_HISTORY);
//                        comicBeanDao.deleteComicByClass(comic);
//                    }
//                }
//            });
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
            ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(holder.itemView.getContext(),DB_FAVORITE);

            ComicBean queryResultComic = comicBeanDao.queryComicByName(comic.getName());
            if (queryResultComic != null){
                ((ViewHolder) holder).collectionBtn.setText("已收藏");
            }else {
                ((ViewHolder) holder).collectionBtn.setText("收藏");
            }
            //复选框显示/隐藏
            if (isShowCheckBox)
                ((ViewHolder) holder).deleteCb.setVisibility(View.VISIBLE);
            else
                ((ViewHolder) holder).deleteCb.setVisibility(View.GONE);

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
        if (addFooter == true)
            return mComicList.size()+1;
        else
            return mComicList.size();
    }

}
