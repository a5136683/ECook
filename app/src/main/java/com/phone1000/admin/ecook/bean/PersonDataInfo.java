package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/15.
 */

public class PersonDataInfo {


    /**
     * data : {"collectionSortCount":"0","imageid":"234151125","recipeList":[{"imageid":"234506632","name":"酥松好吃的奶油曲奇的做法","id":"234507306"},{"imageid":"234120818","name":"蔓越莓口味牛轧糖（棉花糖版）","id":"234121382"}],"profile":"PME认证蛋糕师，翻糖糖霜韩式裱花蛋糕培训","sex":"0","fansCount":"547","title":"花语创意烘焙\n","type":"Rookie","collectionSortList":[],"talkCount":"34","medal":"copper","followsCount":"1","recipeCount":"2","id":"233983209"}
     * state : 200
     * message : 获取成功！
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * collectionSortCount : 0
         * imageid : 234151125
         * recipeList : [{"imageid":"234506632","name":"酥松好吃的奶油曲奇的做法","id":"234507306"},{"imageid":"234120818","name":"蔓越莓口味牛轧糖（棉花糖版）","id":"234121382"}]
         * profile : PME认证蛋糕师，翻糖糖霜韩式裱花蛋糕培训
         * sex : 0
         * fansCount : 547
         * title : 花语创意烘焙

         * type : Rookie
         * collectionSortList : []
         * talkCount : 34
         * medal : copper
         * followsCount : 1
         * recipeCount : 2
         * id : 233983209
         */

        private String collectionSortCount;
        private String imageid;
        private String profile;
        private String sex;
        private String fansCount;
        private String title;
        private String type;
        private String talkCount;
        private String medal;
        private String followsCount;
        private String recipeCount;
        private String id;
        private List<RecipeListBean> recipeList;
        private List<?> collectionSortList;

        public String getCollectionSortCount() {
            return collectionSortCount;
        }

        public void setCollectionSortCount(String collectionSortCount) {
            this.collectionSortCount = collectionSortCount;
        }

        public String getImageid() {
            return imageid;
        }

        public void setImageid(String imageid) {
            this.imageid = imageid;
        }

        public String getProfile() {
            return profile;
        }

        public void setProfile(String profile) {
            this.profile = profile;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getFansCount() {
            return fansCount;
        }

        public void setFansCount(String fansCount) {
            this.fansCount = fansCount;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getTalkCount() {
            return talkCount;
        }

        public void setTalkCount(String talkCount) {
            this.talkCount = talkCount;
        }

        public String getMedal() {
            return medal;
        }

        public void setMedal(String medal) {
            this.medal = medal;
        }

        public String getFollowsCount() {
            return followsCount;
        }

        public void setFollowsCount(String followsCount) {
            this.followsCount = followsCount;
        }

        public String getRecipeCount() {
            return recipeCount;
        }

        public void setRecipeCount(String recipeCount) {
            this.recipeCount = recipeCount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<RecipeListBean> getRecipeList() {
            return recipeList;
        }

        public void setRecipeList(List<RecipeListBean> recipeList) {
            this.recipeList = recipeList;
        }

        public List<?> getCollectionSortList() {
            return collectionSortList;
        }

        public void setCollectionSortList(List<?> collectionSortList) {
            this.collectionSortList = collectionSortList;
        }

        public static class RecipeListBean {
            /**
             * imageid : 234506632
             * name : 酥松好吃的奶油曲奇的做法
             * id : 234507306
             */

            private String imageid;
            private String name;
            private String id;

            public String getImageid() {
                return imageid;
            }

            public void setImageid(String imageid) {
                this.imageid = imageid;
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
    }
}

