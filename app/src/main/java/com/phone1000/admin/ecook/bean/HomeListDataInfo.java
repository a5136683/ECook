package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeListDataInfo {

    /**
     * image : 235860299
     * collectionNum : 1409
     * title : 新疆大盘鸡
     * type : 3
     * userId : 18810688
     * likeNum : 1143
     * userImage : 1427415
     * totalNum :
     * userNick : 孙凯2678399730
     * sortId : 6040
     * id : 17561684
     * time :
     * imageids :
     * desc : 楼下有个新疆馆，偷懒或没时间做饭的时候就爱去蹭蹭，点个大盘鸡，再来几个串，一大杯扎啤准能让我俩吃的肚翻～拍着肚皮走出馆子。
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private String image;
        private int collectionNum;
        private String title;
        private int type;
        private int userId;
        private int likeNum;
        private String userImage;
        private String totalNum;
        private String userNick;
        private int sortId;
        private int id;
        private String time;
        private String imageids;
        private String desc;

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public int getCollectionNum() {
            return collectionNum;
        }

        public void setCollectionNum(int collectionNum) {
            this.collectionNum = collectionNum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getLikeNum() {
            return likeNum;
        }

        public void setLikeNum(int likeNum) {
            this.likeNum = likeNum;
        }

        public String getUserImage() {
            return userImage;
        }

        public void setUserImage(String userImage) {
            this.userImage = userImage;
        }

        public String getTotalNum() {
            return totalNum;
        }

        public void setTotalNum(String totalNum) {
            this.totalNum = totalNum;
        }

        public String getUserNick() {
            return userNick;
        }

        public void setUserNick(String userNick) {
            this.userNick = userNick;
        }

        public int getSortId() {
            return sortId;
        }

        public void setSortId(int sortId) {
            this.sortId = sortId;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getImageids() {
            return imageids;
        }

        public void setImageids(String imageids) {
            this.imageids = imageids;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }
}
