package com.comicread.android.gson;

import java.util.List;

public class ChapterNewBean {

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
            private String chapter_id;
            private String type;
            private String zip_file_high;
            private List<ImageListDTO> image_list;
            private List<?> unlock_image;

            public String getChapter_id() {
                return chapter_id;
            }

            public void setChapter_id(String chapter_id) {
                this.chapter_id = chapter_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getZip_file_high() {
                return zip_file_high;
            }

            public void setZip_file_high(String zip_file_high) {
                this.zip_file_high = zip_file_high;
            }

            public List<ImageListDTO> getImage_list() {
                return image_list;
            }

            public void setImage_list(List<ImageListDTO> image_list) {
                this.image_list = image_list;
            }

            public List<?> getUnlock_image() {
                return unlock_image;
            }

            public void setUnlock_image(List<?> unlock_image) {
                this.unlock_image = unlock_image;
            }

            public static class ImageListDTO {
                private String location;
                private String image_id;
                private String width;
                private String height;
                private String total_tucao;
                private String webp;
                private String type;
                private String img05;
                private String img50;
                private List<ImagesDTO> images;
                private List<String> imHeightArr;

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getImage_id() {
                    return image_id;
                }

                public void setImage_id(String image_id) {
                    this.image_id = image_id;
                }

                public String getWidth() {
                    return width;
                }

                public void setWidth(String width) {
                    this.width = width;
                }

                public String getHeight() {
                    return height;
                }

                public void setHeight(String height) {
                    this.height = height;
                }

                public String getTotal_tucao() {
                    return total_tucao;
                }

                public void setTotal_tucao(String total_tucao) {
                    this.total_tucao = total_tucao;
                }

                public String getWebp() {
                    return webp;
                }

                public void setWebp(String webp) {
                    this.webp = webp;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getImg05() {
                    return img05;
                }

                public void setImg05(String img05) {
                    this.img05 = img05;
                }

                public String getImg50() {
                    return img50;
                }

                public void setImg50(String img50) {
                    this.img50 = img50;
                }

                public List<ImagesDTO> getImages() {
                    return images;
                }

                public void setImages(List<ImagesDTO> images) {
                    this.images = images;
                }

                public List<String> getImHeightArr() {
                    return imHeightArr;
                }

                public void setImHeightArr(List<String> imHeightArr) {
                    this.imHeightArr = imHeightArr;
                }

                public static class ImagesDTO {
                    private String id;
                    private String sort;
                    private String width;
                    private String height;
                    private String img50;
                    private String img05;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getSort() {
                        return sort;
                    }

                    public void setSort(String sort) {
                        this.sort = sort;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getImg50() {
                        return img50;
                    }

                    public void setImg50(String img50) {
                        this.img50 = img50;
                    }

                    public String getImg05() {
                        return img05;
                    }

                    public void setImg05(String img05) {
                        this.img05 = img05;
                    }
                }
            }
        }
    }
}
