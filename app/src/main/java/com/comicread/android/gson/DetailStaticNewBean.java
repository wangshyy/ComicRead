package com.comicread.android.gson;

import java.util.List;

public class DetailStaticNewBean {

    private Integer code;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private Integer stateCode;
        private String message;
        private ReturnDataDTO returnData;
        private ComicDTO comic;

        public Integer getStateCode() {
            return stateCode;
        }

        public void setStateCode(Integer stateCode) {
            this.stateCode = stateCode;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public ReturnDataDTO getReturnData() {
            return returnData;
        }

        public void setReturnData(ReturnDataDTO returnData) {
            this.returnData = returnData;
        }

        public ComicDTO getComic() {
            return comic;
        }

        public void setComic(ComicDTO comic) {
            this.comic = comic;
        }

        public static class ReturnDataDTO {
            private List<ChapterListDTO> chapter_list;
            private Integer commentCount;

            public List<ChapterListDTO> getChapter_list() {
                return chapter_list;
            }

            public void setChapter_list(List<ChapterListDTO> chapter_list) {
                this.chapter_list = chapter_list;
            }

            public Integer getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(Integer commentCount) {
                this.commentCount = commentCount;
            }

            public static class ChapterListDTO {
                private String name;
                private String image_total;
                private String chapter_id;
                private Integer type;
                private String size;
                private Integer pass_time;
                private String release_time;
                private String zip_high_webp;
                private String vip_images;
                private Integer publish_time;
                private Integer chapterIndex;
                private String smallPlaceCover;
                private Integer is_new;
                private Boolean has_locked_image;
                private String index;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getImage_total() {
                    return image_total;
                }

                public void setImage_total(String image_total) {
                    this.image_total = image_total;
                }

                public String getChapter_id() {
                    return chapter_id;
                }

                public void setChapter_id(String chapter_id) {
                    this.chapter_id = chapter_id;
                }

                public Integer getType() {
                    return type;
                }

                public void setType(Integer type) {
                    this.type = type;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public Integer getPass_time() {
                    return pass_time;
                }

                public void setPass_time(Integer pass_time) {
                    this.pass_time = pass_time;
                }

                public String getRelease_time() {
                    return release_time;
                }

                public void setRelease_time(String release_time) {
                    this.release_time = release_time;
                }

                public String getZip_high_webp() {
                    return zip_high_webp;
                }

                public void setZip_high_webp(String zip_high_webp) {
                    this.zip_high_webp = zip_high_webp;
                }

                public String getVip_images() {
                    return vip_images;
                }

                public void setVip_images(String vip_images) {
                    this.vip_images = vip_images;
                }

                public Integer getPublish_time() {
                    return publish_time;
                }

                public void setPublish_time(Integer publish_time) {
                    this.publish_time = publish_time;
                }

                public Integer getChapterIndex() {
                    return chapterIndex;
                }

                public void setChapterIndex(Integer chapterIndex) {
                    this.chapterIndex = chapterIndex;
                }

                public String getSmallPlaceCover() {
                    return smallPlaceCover;
                }

                public void setSmallPlaceCover(String smallPlaceCover) {
                    this.smallPlaceCover = smallPlaceCover;
                }

                public Integer getIs_new() {
                    return is_new;
                }

                public void setIs_new(Integer is_new) {
                    this.is_new = is_new;
                }

                public Boolean getHas_locked_image() {
                    return has_locked_image;
                }

                public void setHas_locked_image(Boolean has_locked_image) {
                    this.has_locked_image = has_locked_image;
                }

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }
            }
        }

        public static class ComicDTO {
            private String name;
            private String comic_id;
            private Integer is_vip;
            private String short_description;
            private Integer accredit;
            private String type;
            private String description;
            private String cate_id;
            private String thread_id;
            private Integer series_status;
            private Integer last_update_time;
            private Integer status;
            private String week_more;
            private String affiche;
            private String last_update_week;
            private String wideCover;
            private String cover;
            private String ori;
            private List<String> theme_ids;
            private List<ClassifyTagsDTO> classifyTags;
            private AuthorDTO author;
            private String wideColor;
            private List<String> tagList;
            private String ticket_desc;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getComic_id() {
                return comic_id;
            }

            public void setComic_id(String comic_id) {
                this.comic_id = comic_id;
            }

            public Integer getIs_vip() {
                return is_vip;
            }

            public void setIs_vip(Integer is_vip) {
                this.is_vip = is_vip;
            }

            public String getShort_description() {
                return short_description;
            }

            public void setShort_description(String short_description) {
                this.short_description = short_description;
            }

            public Integer getAccredit() {
                return accredit;
            }

            public void setAccredit(Integer accredit) {
                this.accredit = accredit;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getCate_id() {
                return cate_id;
            }

            public void setCate_id(String cate_id) {
                this.cate_id = cate_id;
            }

            public String getThread_id() {
                return thread_id;
            }

            public void setThread_id(String thread_id) {
                this.thread_id = thread_id;
            }

            public Integer getSeries_status() {
                return series_status;
            }

            public void setSeries_status(Integer series_status) {
                this.series_status = series_status;
            }

            public Integer getLast_update_time() {
                return last_update_time;
            }

            public void setLast_update_time(Integer last_update_time) {
                this.last_update_time = last_update_time;
            }

            public Integer getStatus() {
                return status;
            }

            public void setStatus(Integer status) {
                this.status = status;
            }

            public String getWeek_more() {
                return week_more;
            }

            public void setWeek_more(String week_more) {
                this.week_more = week_more;
            }

            public String getAffiche() {
                return affiche;
            }

            public void setAffiche(String affiche) {
                this.affiche = affiche;
            }

            public String getLast_update_week() {
                return last_update_week;
            }

            public void setLast_update_week(String last_update_week) {
                this.last_update_week = last_update_week;
            }

            public String getWideCover() {
                return wideCover;
            }

            public void setWideCover(String wideCover) {
                this.wideCover = wideCover;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getOri() {
                return ori;
            }

            public void setOri(String ori) {
                this.ori = ori;
            }

            public List<String> getTheme_ids() {
                return theme_ids;
            }

            public void setTheme_ids(List<String> theme_ids) {
                this.theme_ids = theme_ids;
            }

            public List<ClassifyTagsDTO> getClassifyTags() {
                return classifyTags;
            }

            public void setClassifyTags(List<ClassifyTagsDTO> classifyTags) {
                this.classifyTags = classifyTags;
            }

            public AuthorDTO getAuthor() {
                return author;
            }

            public void setAuthor(AuthorDTO author) {
                this.author = author;
            }

            public String getWideColor() {
                return wideColor;
            }

            public void setWideColor(String wideColor) {
                this.wideColor = wideColor;
            }

            public List<String> getTagList() {
                return tagList;
            }

            public void setTagList(List<String> tagList) {
                this.tagList = tagList;
            }

            public String getTicket_desc() {
                return ticket_desc;
            }

            public void setTicket_desc(String ticket_desc) {
                this.ticket_desc = ticket_desc;
            }

            public static class AuthorDTO {
                private String avatar;
                private String name;
                private String id;

                public String getAvatar() {
                    return avatar;
                }

                public void setAvatar(String avatar) {
                    this.avatar = avatar;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            public static class ClassifyTagsDTO {
                private String name;
                private String argName;
                private Integer argVal;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArgName() {
                    return argName;
                }

                public void setArgName(String argName) {
                    this.argName = argName;
                }

                public Integer getArgVal() {
                    return argVal;
                }

                public void setArgVal(Integer argVal) {
                    this.argVal = argVal;
                }
            }
        }
    }
}
