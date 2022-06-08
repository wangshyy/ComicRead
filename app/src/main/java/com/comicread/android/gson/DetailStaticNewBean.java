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

        public static class ReturnDataDTO {
            private List<ChapterListDTO> chapter_list;
            private List<OtherWorksDTO> otherWorks;
            private CommentDTO comment;
            private ComicDTO comic;
            private List<HtmlsDTO> htmls;
            private String tongRenCover;
            private String showPageName;

            public List<ChapterListDTO> getChapter_list() {
                return chapter_list;
            }

            public void setChapter_list(List<ChapterListDTO> chapter_list) {
                this.chapter_list = chapter_list;
            }

            public List<OtherWorksDTO> getOtherWorks() {
                return otherWorks;
            }

            public void setOtherWorks(List<OtherWorksDTO> otherWorks) {
                this.otherWorks = otherWorks;
            }

            public CommentDTO getComment() {
                return comment;
            }

            public void setComment(CommentDTO comment) {
                this.comment = comment;
            }

            public ComicDTO getComic() {
                return comic;
            }

            public void setComic(ComicDTO comic) {
                this.comic = comic;
            }

            public List<HtmlsDTO> getHtmls() {
                return htmls;
            }

            public void setHtmls(List<HtmlsDTO> htmls) {
                this.htmls = htmls;
            }

            public String getTongRenCover() {
                return tongRenCover;
            }

            public void setTongRenCover(String tongRenCover) {
                this.tongRenCover = tongRenCover;
            }

            public String getShowPageName() {
                return showPageName;
            }

            public void setShowPageName(String showPageName) {
                this.showPageName = showPageName;
            }

            public static class CommentDTO {
                private List<CommentListDTO> commentList;
                private Integer commentCount;

                public List<CommentListDTO> getCommentList() {
                    return commentList;
                }

                public void setCommentList(List<CommentListDTO> commentList) {
                    this.commentList = commentList;
                }

                public Integer getCommentCount() {
                    return commentCount;
                }

                public void setCommentCount(Integer commentCount) {
                    this.commentCount = commentCount;
                }

                public static class CommentListDTO {
                    private String comment_id;
                    private Integer user_id;
                    private String content;
                    private String create_time;
                    private String floor;
                    private String is_delete;
                    private String is_up;
                    private String thread_id;
                    private String total_reply;
                    private String is_choice;
                    private Integer praise_total;
                    private String ticket_id;
                    private String cate;
                    private String object_type;
                    private String content_filter;
                    private Integer ticketNum;
                    private Integer gift_num;
                    private String gift_img;
                    private UserDTO user;
                    private List<?> imageList;
                    private Integer comic_id;
                    private String create_time_str;

                    public String getComment_id() {
                        return comment_id;
                    }

                    public void setComment_id(String comment_id) {
                        this.comment_id = comment_id;
                    }

                    public Integer getUser_id() {
                        return user_id;
                    }

                    public void setUser_id(Integer user_id) {
                        this.user_id = user_id;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }

                    public String getCreate_time() {
                        return create_time;
                    }

                    public void setCreate_time(String create_time) {
                        this.create_time = create_time;
                    }

                    public String getFloor() {
                        return floor;
                    }

                    public void setFloor(String floor) {
                        this.floor = floor;
                    }

                    public String getIs_delete() {
                        return is_delete;
                    }

                    public void setIs_delete(String is_delete) {
                        this.is_delete = is_delete;
                    }

                    public String getIs_up() {
                        return is_up;
                    }

                    public void setIs_up(String is_up) {
                        this.is_up = is_up;
                    }

                    public String getThread_id() {
                        return thread_id;
                    }

                    public void setThread_id(String thread_id) {
                        this.thread_id = thread_id;
                    }

                    public String getTotal_reply() {
                        return total_reply;
                    }

                    public void setTotal_reply(String total_reply) {
                        this.total_reply = total_reply;
                    }

                    public String getIs_choice() {
                        return is_choice;
                    }

                    public void setIs_choice(String is_choice) {
                        this.is_choice = is_choice;
                    }

                    public Integer getPraise_total() {
                        return praise_total;
                    }

                    public void setPraise_total(Integer praise_total) {
                        this.praise_total = praise_total;
                    }

                    public String getTicket_id() {
                        return ticket_id;
                    }

                    public void setTicket_id(String ticket_id) {
                        this.ticket_id = ticket_id;
                    }

                    public String getCate() {
                        return cate;
                    }

                    public void setCate(String cate) {
                        this.cate = cate;
                    }

                    public String getObject_type() {
                        return object_type;
                    }

                    public void setObject_type(String object_type) {
                        this.object_type = object_type;
                    }

                    public String getContent_filter() {
                        return content_filter;
                    }

                    public void setContent_filter(String content_filter) {
                        this.content_filter = content_filter;
                    }

                    public Integer getTicketNum() {
                        return ticketNum;
                    }

                    public void setTicketNum(Integer ticketNum) {
                        this.ticketNum = ticketNum;
                    }

                    public Integer getGift_num() {
                        return gift_num;
                    }

                    public void setGift_num(Integer gift_num) {
                        this.gift_num = gift_num;
                    }

                    public String getGift_img() {
                        return gift_img;
                    }

                    public void setGift_img(String gift_img) {
                        this.gift_img = gift_img;
                    }

                    public UserDTO getUser() {
                        return user;
                    }

                    public void setUser(UserDTO user) {
                        this.user = user;
                    }

                    public List<?> getImageList() {
                        return imageList;
                    }

                    public void setImageList(List<?> imageList) {
                        this.imageList = imageList;
                    }

                    public Integer getComic_id() {
                        return comic_id;
                    }

                    public void setComic_id(Integer comic_id) {
                        this.comic_id = comic_id;
                    }

                    public String getCreate_time_str() {
                        return create_time_str;
                    }

                    public void setCreate_time_str(String create_time_str) {
                        this.create_time_str = create_time_str;
                    }

                    public static class UserDTO {
                        private String face;
                        private String nickname;
                        private String group_user;
                        private Integer is_author;
                        private Integer other_comic_author;
                        private Integer vip_level;
                        private String user_title;
                        private Integer grade;

                        public String getFace() {
                            return face;
                        }

                        public void setFace(String face) {
                            this.face = face;
                        }

                        public String getNickname() {
                            return nickname;
                        }

                        public void setNickname(String nickname) {
                            this.nickname = nickname;
                        }

                        public String getGroup_user() {
                            return group_user;
                        }

                        public void setGroup_user(String group_user) {
                            this.group_user = group_user;
                        }

                        public Integer getIs_author() {
                            return is_author;
                        }

                        public void setIs_author(Integer is_author) {
                            this.is_author = is_author;
                        }

                        public Integer getOther_comic_author() {
                            return other_comic_author;
                        }

                        public void setOther_comic_author(Integer other_comic_author) {
                            this.other_comic_author = other_comic_author;
                        }

                        public Integer getVip_level() {
                            return vip_level;
                        }

                        public void setVip_level(Integer vip_level) {
                            this.vip_level = vip_level;
                        }

                        public String getUser_title() {
                            return user_title;
                        }

                        public void setUser_title(String user_title) {
                            this.user_title = user_title;
                        }

                        public Integer getGrade() {
                            return grade;
                        }

                        public void setGrade(Integer grade) {
                            this.grade = grade;
                        }
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
                private List<String> posterCovers;
                private String ori;
                private List<String> theme_ids;
                private List<ClassifyTagsDTO> classifyTags;
                private AuthorDTO author;
                private ShareDTO share;
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

                public List<String> getPosterCovers() {
                    return posterCovers;
                }

                public void setPosterCovers(List<String> posterCovers) {
                    this.posterCovers = posterCovers;
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

                public ShareDTO getShare() {
                    return share;
                }

                public void setShare(ShareDTO share) {
                    this.share = share;
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

                public static class ShareDTO {
                    private String title;
                    private String content;
                    private String cover;
                    private String url;

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getContent() {
                        return content;
                    }

                    public void setContent(String content) {
                        this.content = content;
                    }

                    public String getCover() {
                        return cover;
                    }

                    public void setCover(String cover) {
                        this.cover = cover;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
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

            public static class OtherWorksDTO {
                private String comicId;
                private String coverUrl;
                private String name;
                private String passChapterNum;

                public String getComicId() {
                    return comicId;
                }

                public void setComicId(String comicId) {
                    this.comicId = comicId;
                }

                public String getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(String coverUrl) {
                    this.coverUrl = coverUrl;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPassChapterNum() {
                    return passChapterNum;
                }

                public void setPassChapterNum(String passChapterNum) {
                    this.passChapterNum = passChapterNum;
                }
            }

            public static class HtmlsDTO {
                private Integer linkType;
                private String title;
                private String content;
                private String cover;
                private List<ExtDTO> ext;

                public Integer getLinkType() {
                    return linkType;
                }

                public void setLinkType(Integer linkType) {
                    this.linkType = linkType;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public List<ExtDTO> getExt() {
                    return ext;
                }

                public void setExt(List<ExtDTO> ext) {
                    this.ext = ext;
                }

                public static class ExtDTO {
                    private String key;
                    private String val;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }

                    public String getVal() {
                        return val;
                    }

                    public void setVal(String val) {
                        this.val = val;
                    }
                }
            }
        }
    }
}
