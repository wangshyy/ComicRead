package com.comicread.android.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.comicread.android.ComicAPI;
import com.comicread.android.gson.RankComicListBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO>> mComicList;
    private int x=0;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mComicList = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO>> getComicList(){
        requestRankComicList(1);
        return mComicList;
    }
    public LiveData<List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO>> getMoreComicList(int i) {
        requestRankComicList(i);
        return mComicList;
    }

    public void requestRankComicList(int i){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.u17.com/v3/appV3_3/android/phone/list/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ComicAPI comicAPI = retrofit.create(ComicAPI.class);
        Call<RankComicListBean> comicListData = comicAPI.getRankComicList("total","2","xiaomi","7de42d2e",
                "450010","MI+6","f5c9b6c9284551ad",i+"");
        //执行异步操作
        comicListData.enqueue(new Callback<RankComicListBean>() {
            @Override
            public void onResponse(Call<RankComicListBean> call, Response<RankComicListBean> response) {
//                mText.setValue(response.body().getData().getReturnData().getComics().get(0).getDescription());
                mComicList.setValue(response.body().getData().getReturnData().getComics());
//                mText.setValue(response.body().getData().getReturnData().getComics().get(0).getDescription());
                x++;
                Log.d("123","请求次数:"+x);
            }

            @Override
            public void onFailure(Call<RankComicListBean> call, Throwable t) {

            }
        });
    }


}