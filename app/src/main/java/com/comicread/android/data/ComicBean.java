package com.comicread.android.data;

import org.greenrobot.greendao.annotation.Entity;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class ComicBean {

    private String cover;
    @Id
    private String name;
    private String comicId;
    private String description;
    private String author;
    private String tags;



    @Generated(hash = 598414780)
    public ComicBean(String cover, String name, String comicId, String description,
            String author, String tags) {
        this.cover = cover;
        this.name = name;
        this.comicId = comicId;
        this.description = description;
        this.author = author;
        this.tags = tags;
    }

    @Generated(hash = 1877764603)
    public ComicBean() {
    }

    

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComicId() {
        return comicId;
    }

    public void setComicId(String comicId) {
        this.comicId = comicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
