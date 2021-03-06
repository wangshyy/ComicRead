package com.comicread.android.ui.home;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.comicread.android.ComicAPI;
import com.comicread.android.data.ComicBean;
import com.comicread.android.gson.RankComicListBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private MutableLiveData<List<ComicBean>> mComicList;
    private int x=0;
    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mComicList = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }
    public LiveData<List<ComicBean>> getComicList(){
        return mComicList;
    }

    public void setInitComicList() {
        requestRankComicList(1, INIT);
    }

    public void setMoreComicList(int i) {
        requestRankComicList(i, APPEND);
    }

    // 0初始化，1新增
    final int INIT = 0;
    final int APPEND = 1;
    public void requestRankComicList(int i, int type){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.u17.com/v3/appV3_3/android/phone/list/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ComicAPI comicAPI = retrofit.create(ComicAPI.class);
        Call<RankComicListBean> comicListBeanCall = comicAPI.getRankComicList("total","2","xiaomi","7de42d2e",
                "450010","MI+6","f5c9b6c9284551ad",i+"");
        //执行异步操作
        comicListBeanCall.enqueue(new Callback<RankComicListBean>() {
            @Override
            public void onResponse(Call<RankComicListBean> call, Response<RankComicListBean> response) {
//                mText.setValue(response.body().getData().getReturnData().getComics().get(0).getDescription());
                List<RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO> comicsDTOList = response.body().getData().getReturnData().getComics();
                List<ComicBean> comicBeanList = new ArrayList<>();
                for (RankComicListBean.DataDTO.ReturnDataDTO.ComicsDTO comicsDTO : comicsDTOList){
                    ComicBean comic = new ComicBean(comicsDTO.getCover(),comicsDTO.getName(),
                            comicsDTO.getComicId(),comicsDTO.getDescription(),comicsDTO.getAuthor(),comicsDTO.getTags().get(0));
                    comicBeanList.add(comic);
                }
                if (type == INIT) {
                    mComicList.setValue(comicBeanList);
                }
                else {
                    //获取当前值并添加..
                    mComicList.getValue().addAll(comicBeanList);
                    //数据改变，通知到observe回调
                    mComicList.postValue(mComicList.getValue());
                }
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