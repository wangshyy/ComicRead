package com.comicread.android.ui.comicdetail;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.comicread.android.R;
import com.comicread.android.databinding.ActivityComicDetailBinding;
import com.comicread.android.either.NestedListView;
import com.comicread.android.gson.DetailStaticNewBean;
import com.comicread.android.ui.read.ReadActivity;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class ComicDetailActivity extends AppCompatActivity {

    private ActivityComicDetailBinding binding;
    private ComicDetailViewModel comicDetailViewModel;
    private List<DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO> chapterList = new ArrayList<>();
   NestedListView comicDetailListView;
    String comicId;
    ChapterAdapter chapterAdapter;
    ImageView comicImageView;
    TextView comicCategoryText;
    Toolbar toolbar;
    ActionBar actionBar;
    CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        comicId = intent.getStringExtra("comic_id");
        init();
        setContentView(binding.getRoot());
    }
    //获取chapter列表
    public void setChapterDTO(String comicId){
        comicDetailViewModel.setChapterList(comicId);
    }
    public void init(){
        comicDetailViewModel = new ViewModelProvider(this).get(ComicDetailViewModel.class);
        binding = ActivityComicDetailBinding.inflate(getLayoutInflater());
        comicDetailListView = binding.comicDetailListView;
        comicImageView = binding.comicImageView;
        comicCategoryText = binding.comicCategoryText;
        collapsingToolbarLayout = binding.collapsingToolbar;
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        actionBar = getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        chapterAdapter = new ChapterAdapter(this,R.layout.comic_detail_item,chapterList);
        comicDetailListView.setAdapter(chapterAdapter);
        setChapterDTO(comicId);
        comicDetailViewModel.getChapterList().observe(this,(value)->{
            chapterList.clear();
            chapterList.addAll(value);
            chapterAdapter.notifyDataSetChanged();
        });

        comicDetailViewModel.getComicImageUri().observe(this,(value)->{
            Glide.with(this).load(value).into(comicImageView);
        });
        comicDetailViewModel.getComicCategory().observe(this,(value)->{
            comicCategoryText.setText(value);
        });
        comicDetailViewModel.getComicName().observe(this,(value)->{
            collapsingToolbarLayout.setTitle(value);
        });

        comicDetailListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String chapterId = chapterList.get(i).getChapter_id();
                Intent intent = new Intent(ComicDetailActivity.this,ReadActivity.class);
                intent.putExtra("chapter_id",chapterId);
                startActivity(intent);
            }
        });

    }
    public class ChapterAdapter extends ArrayAdapter<DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO>{
        int resource;
        public ChapterAdapter(@NonNull Context context, int resource, @NonNull List<DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO> objects) {
            super(context, resource, objects);
            this.resource = resource;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO chapter = getItem(position);
            View view = LayoutInflater.from(getContext()).inflate(resource,parent,false);
            TextView chapterName = view.findViewById(R.id.chapter_name);
            chapterName.setText(chapter.getName());
            return view;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home://返回按钮
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}