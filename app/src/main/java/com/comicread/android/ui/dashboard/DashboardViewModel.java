package com.comicread.android.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.comicread.android.ComicAPI;
import com.comicread.android.data.ComicBean;
import com.comicread.android.gson.SearchResultBean;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DashboardViewModel extends ViewModel {
    private MutableLiveData<List<ComicBean>> comicList;
    public DashboardViewModel() {
        comicList = new MutableLiveData<>();
    }

    public LiveData<List<ComicBean>> getComicList(String comicName){
        requestSearchResult(comicName);
        return comicList;
    }
    private void requestSearchResult(String comicName){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.u17.com/v3/appV3_3/android/phone/search/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ComicAPI comicAPI = retrofit.create(ComicAPI.class);
        Call<SearchResultBean> searchResultBeanCall = comicAPI.searchResult("xiaomi","7de42d2e","4500102",
                "MI+6", "f5c9b6c9284551ad",comicName);
        searchResultBeanCall.enqueue(new Callback<SearchResultBean>() {
            @Override
            public void onResponse(Call<SearchResultBean> call, Response<SearchResultBean> response) {
                List<SearchResultBean.DataDTO.ReturnDataDTO.ComicsDTO> comicsDTOList = response.body().getData().getReturnData().getComics();
                List<ComicBean> comicBeanList = new ArrayList<>();
                for(SearchResultBean.DataDTO.ReturnDataDTO.ComicsDTO comicsDTO: comicsDTOList){
                    ComicBean comic = new ComicBean(comicsDTO.getCover(),comicsDTO.getName(),comicsDTO.getComicId(),
                            comicsDTO.getDescription(),comicsDTO.getAuthor(),comicsDTO.getTags());
                    comicBeanList.add(comic);
                }

                comicList.setValue(comicBeanList);
                comicList.postValue(comicList.getValue());
            }

            @Override
            public void onFailure(Call<SearchResultBean> call, Throwable t) {

            }
        });
    }
}