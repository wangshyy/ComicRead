package com.comicread.android.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;

import com.comicread.android.data.ComicBean;
import com.comicread.android.db.ComicBeanDao;
import com.comicread.android.db.DaoMaster;
import com.comicread.android.db.DaoSession;

import java.util.List;

public class ComicBeanDaoUtil{
    private DaoMaster.DevOpenHelper devOpenHelper;
    private SQLiteDatabase db;
    private DaoMaster daoMaster;
    private DaoSession daoSession;
    private ComicBeanDao comicBeanDao;

    public ComicBeanDaoUtil(Context context, String dbName) {
        initGreenDao(context,dbName);
    }

    //初始化GreenDao
    private void initGreenDao(Context context,String dbName) {
        devOpenHelper = new DaoMaster.DevOpenHelper(context, dbName);
        db = devOpenHelper.getWritableDatabase();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        comicBeanDao = daoSession.getComicBeanDao();
    }
    //根据漫画名查询数据
    public ComicBean queryComicByName(String name){
        ComicBean queryResultComic = comicBeanDao.queryBuilder().where(ComicBeanDao.Properties.Name.eq(name)).unique();
        return queryResultComic;
    }

    //根据实体类插入数据
    public void insertComicByClass(ComicBean comic){
        comicBeanDao.insert(comic);
    }

    //根据实体类删除数据
    public void deleteComicByClass(ComicBean comic){
        comicBeanDao.delete(comic);
    }

    //查询所有
    public List<ComicBean> queryAll(){
        List<ComicBean> comicList = comicBeanDao.queryBuilder().list();
        return comicList;
    }

}
