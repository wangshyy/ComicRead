package com.comicread.android.gson;

import android.net.Uri;

import java.util.List;

public class RankComicListBean {

    private Integer code;
    private String msg;
    private DataDTO data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
            private List<ComicsDTO> comics;
            private List<RankTabDTO> rankTab;
            private List<MoreRankOptionListDTO> moreRankOptionList;
            private DefaultParameterDTO defaultParameter;
            private Integer page;
            private Boolean hasMore;

            public List<ComicsDTO> getComics() {
                return comics;
            }

            public void setComics(List<ComicsDTO> comics) {
                this.comics = comics;
            }

            public List<RankTabDTO> getRankTab() {
                return rankTab;
            }

            public void setRankTab(List<RankTabDTO> rankTab) {
                this.rankTab = rankTab;
            }

            public List<MoreRankOptionListDTO> getMoreRankOptionList() {
                return moreRankOptionList;
            }

            public void setMoreRankOptionList(List<MoreRankOptionListDTO> moreRankOptionList) {
                this.moreRankOptionList = moreRankOptionList;
            }

            public DefaultParameterDTO getDefaultParameter() {
                return defaultParameter;
            }

            public void setDefaultParameter(DefaultParameterDTO defaultParameter) {
                this.defaultParameter = defaultParameter;
            }

            public Integer getPage() {
                return page;
            }

            public void setPage(Integer page) {
                this.page = page;
            }

            public Boolean getHasMore() {
                return hasMore;
            }

            public void setHasMore(Boolean hasMore) {
                this.hasMore = hasMore;
            }

            public static class DefaultParameterDTO {
                private String defaultPeriod;
                private Integer defaultType;

                public String getDefaultPeriod() {
                    return defaultPeriod;
                }

                public void setDefaultPeriod(String defaultPeriod) {
                    this.defaultPeriod = defaultPeriod;
                }

                public Integer getDefaultType() {
                    return defaultType;
                }

                public void setDefaultType(Integer defaultType) {
                    this.defaultType = defaultType;
                }
            }

            public static class ComicsDTO {
                private String cover;
                private String name;
                private String comicId;
                private String description;
                private String author;
                private List<String> tags;

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

            public static class RankTabDTO {
                private String title;
                private Integer val;
                private List<RankOptionListDTO> rankOptionList;
                private String defaultValue;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public Integer getVal() {
                    return val;
                }

                public void setVal(Integer val) {
                    this.val = val;
                }

                public List<RankOptionListDTO> getRankOptionList() {
                    return rankOptionList;
                }

                public void setRankOptionList(List<RankOptionListDTO> rankOptionList) {
                    this.rankOptionList = rankOptionList;
                }

                public String getDefaultValue() {
                    return defaultValue;
                }

                public void setDefaultValue(String defaultValue) {
                    this.defaultValue = defaultValue;
                }

                public static class RankOptionListDTO {
                    private String name;
                    private String argVal;

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getArgVal() {
                        return argVal;
                    }

                    public void setArgVal(String argVal) {
                        this.argVal = argVal;
                    }
                }
            }

            public static class MoreRankOptionListDTO {
                private String name;
                private String argVal;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArgVal() {
                    return argVal;
                }

                public void setArgVal(String argVal) {
                    this.argVal = argVal;
                }
            }
        }
    }
}
