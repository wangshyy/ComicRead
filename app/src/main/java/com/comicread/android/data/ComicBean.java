package com.comicread.android.data;

import java.util.List;

public class ComicBean {

    private String cover;
    private String name;
    private String comicId;
    private String description;
    private String author;
    private List<String> tags;

    public ComicBean(String cover, String name, String comicId, String description, String author, List<String> tags) {
        this.cover = cover;
        this.name = name;
        this.comicId = comicId;
        this.description = description;
        this.author = author;
        this.tags = tags;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
