package com.comicread.android;

import com.comicread.android.gson.ChapterNewBean;
import com.comicread.android.gson.RankComicListBean;
import com.comicread.android.gson.DetailStaticNewBean;
import com.comicread.android.gson.SearchResultBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ComicAPI {
    @GET("getRankComicList")
    Call<RankComicListBean> getRankComicList(@Query("period") String period,
                                             @Query("type") String type,
                                             @Query("come_from") String come_from,
                                             @Query("serialNumber") String serialNumber,
                                             @Query("v") String v,
                                             @Query("model") String model,
                                             @Query("android_id") String android_id,
                                             @Query("page") String page);
    @GET("detail_static_new")
    Call<DetailStaticNewBean> detailStaticNew(@Query("come_from") String come_from,
                                                @Query("serialNumber") String serialNumber,
                                                @Query("v") String v,
                                                @Query("model") String model,
                                                @Query("android_id") String android_id,
                                                @Query("comicid") String comicid);
    @GET("chapterNew")
    Call<ChapterNewBean> chapterNew(@Query("come_from") String come_from,
                                    @Query("serialNumber") String serialNumber,
                                    @Query("v") String v,
                                    @Query("model") String model,
                                    @Query("chapter_id") String chapter_id,
                                    @Query("android_id") String android_id);
    @GET("searchResult")
    Call<SearchResultBean> searchResult(@Query("come_from") String come_from,
                                        @Query("serialNumber") String serialNumber,
                                        @Query("v") String v,
                                        @Query("model") String model,
                                        @Query("android_id") String android_id,
                                        @Query("q") String q);
}
