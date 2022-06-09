package com.comicread.android.gson;

import java.util.List;

public class SearchResultBean {

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
            private Integer comicNum;
            private Boolean hasMore;
            private Integer page;
            private List<ComicsDTO> comics;
            private List<?> searchData;

            public Integer getComicNum() {
                return comicNum;
            }

            public void setComicNum(Integer comicNum) {
                this.comicNum = comicNum;
            }

            public Boolean getHasMore() {
                return hasMore;
            }

            public void setHasMore(Boolean hasMore) {
                this.hasMore = hasMore;
            }

            public Integer getPage() {
                return page;
            }

            public void setPage(Integer page) {
                this.page = page;
            }

            public List<ComicsDTO> getComics() {
                return comics;
            }

            public void setComics(List<ComicsDTO> comics) {
                this.comics = comics;
            }

            public List<?> getSearchData() {
                return searchData;
            }

            public void setSearchData(List<?> searchData) {
                this.searchData = searchData;
            }

            public static class ComicsDTO {
                private List<String> tags;
                private String comicId;
                private List<String> bgCategory;
                private String cover;
                private String passChapterNum;
                private String chapterNum;
                private String name;
                private String monthTicket;
                private String clickTotal;
                private String seriesStatus;
                private Integer flag;
                private String author;
                private String description;
                private Long conTag;

                public List<String> getTags() {
                    return tags;
                }

                public void setTags(List<String> tags) {
                    this.tags = tags;
                }

                public String getComicId() {
                    return comicId;
                }

                public void setComicId(String comicId) {
                    this.comicId = comicId;
                }

                public List<String> getBgCategory() {
                    return bgCategory;
                }

                public void setBgCategory(List<String> bgCategory) {
                    this.bgCategory = bgCategory;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public String getPassChapterNum() {
                    return passChapterNum;
                }

                public void setPassChapterNum(String passChapterNum) {
                    this.passChapterNum = passChapterNum;
                }

                public String getChapterNum() {
                    return chapterNum;
                }

                public void setChapterNum(String chapterNum) {
                    this.chapterNum = chapterNum;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getMonthTicket() {
                    return monthTicket;
                }

                public void setMonthTicket(String monthTicket) {
                    this.monthTicket = monthTicket;
                }

                public String getClickTotal() {
                    return clickTotal;
                }

                public void setClickTotal(String clickTotal) {
                    this.clickTotal = clickTotal;
                }

                public String getSeriesStatus() {
                    return seriesStatus;
                }

                public void setSeriesStatus(String seriesStatus) {
                    this.seriesStatus = seriesStatus;
                }

                public Integer getFlag() {
                    return flag;
                }

                public void setFlag(Integer flag) {
                    this.flag = flag;
                }

                public String getAuthor() {
                    return author;
                }

                public void setAuthor(String author) {
                    this.author = author;
                }

                public String getDescription() {
                    return description;
                }

                public void setDescription(String description) {
                    this.description = description;
                }

                public Long getConTag() {
                    return conTag;
                }

                public void setConTag(Long conTag) {
                    this.conTag = conTag;
                }
            }
        }
    }
}
