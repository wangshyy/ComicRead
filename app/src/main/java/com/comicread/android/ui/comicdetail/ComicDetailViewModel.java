package com.comicread.android.ui.comicdetail;

import android.content.Intent;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.comicread.android.ComicAPI;
import com.comicread.android.gson.DetailStaticNewBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ComicDetailViewModel extends ViewModel {

    private MutableLiveData<List<DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO>> chapterList;
    private MutableLiveData<String> comicImageUri;
    private MutableLiveData<String> comicCategory;
    private MutableLiveData<String> comicName;
    public ComicDetailViewModel() {
        chapterList = new MutableLiveData<>();
        comicImageUri = new MutableLiveData<>();
        comicCategory = new MutableLiveData<>();
        comicName = new MutableLiveData<>();
    }
    public LiveData<List<DetailStaticNewBean.DataDTO.ReturnDataDTO.ChapterListDTO>> getChapterList(){
        return chapterList;
    }
    public LiveData<String> getComicImageUri(){
        return comicImageUri;
    }
    public LiveData<String> getComicCategory(){
        return comicCategory;
    }
    public LiveData<String> getComicName(){
        return comicName;
    }
    public void setChapterList(String comicId){
        requestComicDetailNewList(comicId);
    }

    public void requestComicDetailNewList(String comicId){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.u17.com/v3/appV3_3/android/phone/comic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ComicAPI comicAPI = retrofit.create(ComicAPI.class);
        Call<DetailStaticNewBean> detailStaticNewBeanCall = comicAPI.detailStaticNew("xiaomi","7de42d2e",
                "4500102","MI+6","f5c9b6c9284551ad",comicId);
        detailStaticNewBeanCall.enqueue(new Callback<DetailStaticNewBean>() {
            @Override
            public void onResponse(Call<DetailStaticNewBean> call, Response<DetailStaticNewBean> response) {
                chapterList.setValue(response.body().getData().getReturnData().getChapter_list());
                comicImageUri.setValue(response.body().getData().getReturnData().getComic().getWideCover());
                comicCategory.setValue(response.body().getData().getReturnData().getComic().getDescription());
                comicName.setValue(response.body().getData().getReturnData().getComic().getName());
            }

            @Override
            public void onFailure(Call<DetailStaticNewBean> call, Throwable t) {

            }
        });

    }

}
