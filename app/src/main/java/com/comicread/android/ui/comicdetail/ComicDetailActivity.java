package com.comicread.android.ui.comicdetail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.comicread.android.R;
import com.comicread.android.databinding.ActivityComicDetailBinding;

public class ComicDetailActivity extends AppCompatActivity {

    private ActivityComicDetailBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityComicDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        String comicId = intent.getStringExtra("comic_id");

    }

}