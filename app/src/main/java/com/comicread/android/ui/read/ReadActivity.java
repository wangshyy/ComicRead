package com.comicread.android.ui.read;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;

import com.comicread.android.ComicAPI;
import com.comicread.android.R;
import com.comicread.android.gson.ChapterNewBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ReadActivity extends FragmentActivity {
    private List<ChapterNewBean.DataDTO.ReturnDataDTO.ImageListDTO> imageList = new ArrayList<>();
    private ViewPager2 viewPager2;
    private FragmentStateAdapter fragmentStateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        init();
    }

    @Override
    public void onBackPressed() {
        if (viewPager2.getCurrentItem() == 0){
            super.onBackPressed();
        }else{
            finish();
        }

    }

    public void init(){
        viewPager2 = findViewById(R.id.view_pager2);
        fragmentStateAdapter = new ReadFragmentStateAdapter(this);
        Intent intent = getIntent();
        String chapterId = intent.getStringExtra("chapter_id");
        requestChapterNew(chapterId);
        viewPager2.setAdapter(fragmentStateAdapter);

    }

    private class ReadFragmentStateAdapter extends FragmentStateAdapter {
        public ReadFragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new ReadFragment(imageList.get(position).getLocation());
        }

        @Override
        public int getItemCount() {
            return imageList.size();
        }
    }

    //网络请求
    private void requestChapterNew(String chapterId){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.u17.com/v3/appV3_3/android/phone/comic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ComicAPI comicAPI = retrofit.create(ComicAPI.class);
        Call<ChapterNewBean> chapterNewBeanCall = comicAPI.chapterNew("huawei","880M890RC17411SC",
                "5000100","JAT-AL00",chapterId,"55ad025ee6967d57");
        chapterNewBeanCall.enqueue(new Callback<ChapterNewBean>() {
            @Override
            public void onResponse(Call<ChapterNewBean> call, Response<ChapterNewBean> response) {
                imageList.clear();
                imageList.addAll(response.body().getData().getReturnData().getImage_list());
                fragmentStateAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ChapterNewBean> call, Throwable t) {

            }
        });
    }
}