package com.comicread.android.adapter;

import static com.comicread.android.adapter.RecyclerViewAdapter.DB_HISTORY;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.RoundedCorner;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.comicread.android.R;
import com.comicread.android.data.ComicBean;
import com.comicread.android.ui.comicdetail.ComicDetailActivity;
import com.comicread.android.util.ComicBeanDaoUtil;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends RecyclerView.Adapter<GridViewAdapter.ViewHolder>{
    private List<ComicBean> favoriteComicsList = new ArrayList<>();

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView favoriteComicImg;
        private TextView favoriteComicName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            favoriteComicImg = itemView.findViewById(R.id.favorite_comics_img);
            favoriteComicName = itemView.findViewById(R.id.favorite_comics_name);
        }
    }
    public GridViewAdapter(List<ComicBean> comicList){
        favoriteComicsList = comicList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.favorite_comics_item,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ComicBeanDaoUtil comicBeanDao = new ComicBeanDaoUtil(view.getContext(), DB_HISTORY);
                int position = viewHolder.getAdapterPosition();
                ComicBean comic = favoriteComicsList.get(position);
                ComicBean queryResultComic = comicBeanDao.queryComicByName(comic.getName());

                //已存在记录时，更新记录位置
                if (queryResultComic != null){
                    comicBeanDao.deleteComicByClass(comic);
                    comicBeanDao.insertComicByClass(comic);
                } else {
                    comicBeanDao.insertComicByClass(comic);
                }

                Intent intent = new Intent(view.getContext(), ComicDetailActivity.class);
                intent.putExtra("comic_id",comic.getComicId());
                view.getContext().startActivity(intent);
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ComicBean comic = favoriteComicsList.get(position);
        RoundedCorners roundedCorners = new RoundedCorners(20);
        RequestOptions requestOptions = RequestOptions.bitmapTransform(roundedCorners);
        Glide.with(holder.itemView.getContext()).load(Uri.parse(comic.getCover())).apply(requestOptions).into(holder.favoriteComicImg);
        holder.favoriteComicName.setText(comic.getName());
    }

    @Override
    public int getItemCount() {
        return favoriteComicsList.size();
    }
}
