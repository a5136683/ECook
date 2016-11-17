package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/9.
 */

public class TalkViewPagerDataInfo {

    private DataBean data;
    /**
     * data : {"followList":[{"image":"225447105","startTime":0,"endTime":24,"id":45,"type":1,"url":"http://pic.xiaochushuo.com/minisite/mall.ecook.cn.minisite32.html?f=ecook_share"},{"image":"235702755","startTime":0,"endTime":24,"id":162,"type":1,"url":"http://pic.xiaochushuo.com/minisite/minisite81.html?f=ecook_share"},{"image":"235751040","startTime":0,"endTime":24,"id":170,"type":1,"url":"ecook://online?id=1057"},{"image":"235751019","startTime":0,"endTime":24,"id":175,"type":1,"url":"ecook://talktopic?topicname=记忆中的味道"}],"squareList":[{"image":"235702487","startTime":15,"endTime":24,"id":57,"type":0,"url":"http://pic.xiaochushuo.com/minisite/minisite81.html?f=ecook_share"},{"image":"234498393","startTime":0,"endTime":24,"id":155,"type":0,"url":"ecook://talktopic?topicname=早餐"},{"image":"234498710","startTime":0,"endTime":24,"id":165,"type":0,"url":"ecook://talktopic?topicname=晚餐"},{"image":"234498141","startTime":0,"endTime":24,"id":167,"type":0,"url":"ecook://talktopic?topicname=午餐"},{"image":"235716562","startTime":0,"endTime":24,"id":171,"type":0,"url":"ecook://online?id=1057"},{"image":"235751013","startTime":0,"endTime":24,"id":174,"type":0,"url":"ecook://talktopic?topicname=记忆中的味道"}]}
     * state : 200
     * message : 获取成功！
     */

    private String state;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * image : 225447105
         * startTime : 0
         * endTime : 24
         * id : 45
         * type : 1
         * url : http://pic.xiaochushuo.com/minisite/mall.ecook.cn.minisite32.html?f=ecook_share
         */

        private List<FollowListBean> followList;
        /**
         * image : 235702487
         * startTime : 15
         * endTime : 24
         * id : 57
         * type : 0
         * url : http://pic.xiaochushuo.com/minisite/minisite81.html?f=ecook_share
         */

        private List<SquareListBean> squareList;

        public List<FollowListBean> getFollowList() {
            return followList;
        }

        public void setFollowList(List<FollowListBean> followList) {
            this.followList = followList;
        }

        public List<SquareListBean> getSquareList() {
            return squareList;
        }

        public void setSquareList(List<SquareListBean> squareList) {
            this.squareList = squareList;
        }

        public static class FollowListBean {
            private String image;
            private int startTime;
            private int endTime;
            private int id;
            private int type;
            private String url;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getStartTime() {
                return startTime;
            }

            public void setStartTime(int startTime) {
                this.startTime = startTime;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class SquareListBean {
            private String image;
            private int startTime;
            private int endTime;
            private int id;
            private int type;
            private String url;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getStartTime() {
                return startTime;
            }

            public void setStartTime(int startTime) {
                this.startTime = startTime;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
