package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeItemDataInfo {


    /**
     * hasVideo : false
     * imageid : 16721501
     * materialList : [{"dosage":"150克","contentid":"16721497","mwikipediaid":"","name":"肉馅","ordernum":1,"id":"1283953","version":0},{"dosage":"150克","contentid":"16721497","mwikipediaid":"","name":"猪皮冻","ordernum":2,"id":"1283954","version":0},{"dosage":"300克","contentid":"16721497","mwikipediaid":"","name":"面粉","ordernum":3,"id":"1283955","version":0},{"dosage":"3克","contentid":"16721497","mwikipediaid":"","name":"酵母","ordernum":4,"id":"1283956","version":0},{"dosage":"150ＭＬ","contentid":"16721497","mwikipediaid":"","name":"温水","ordernum":5,"id":"1283957","version":0},{"dosage":"适量","contentid":"16721497","mwikipediaid":"","name":"葱","ordernum":6,"id":"1283958","version":0},{"dosage":"一小块","contentid":"16721497","mwikipediaid":"","name":"姜","ordernum":7,"id":"1283959","version":0},{"dosage":"适量","contentid":"16721497","mwikipediaid":"","name":"白芝麻","ordernum":8,"id":"1283960","version":0},{"dosage":"适量","contentid":"16721497","mwikipediaid":"","name":"黑芝麻","ordernum":9,"id":"1283961","version":0},{"dosage":"2小勺","contentid":"16721497","mwikipediaid":"","name":"盐","ordernum":10,"id":"1283962","version":0},{"dosage":"小半碗","contentid":"16721497","mwikipediaid":"","name":"煎包子用的水","ordernum":11,"id":"1283963","version":0},{"dosage":"1勺","contentid":"16721497","mwikipediaid":"","name":"生抽","ordernum":12,"id":"1283964","version":0}]
     * description : 每到冬天，就想吃生煎包子，底煎得脆脆的，肉馅必须有汤汁，一口咬下去，要小心控制好牙齿的力度，以免把嘴给烫破了，最好拿个勺子接住喷涌而出的肉汤，有技巧地吃完馅儿，再咔嚓咔嚓地吃掉焦脆的底儿，吃货的冬天就是容易满足。
     * stepList : [{"imageid":"16721524","contentid":"16721497","details":"把姜片和葱丝，泡在水里，揉捏一会，就成了葱姜水。","ordernum":1,"id":"1046238","time":0,"version":0},{"imageid":"16721568","contentid":"16721497","details":"把水倒入猪肉馅，目的是为了去腥味。","ordernum":2,"id":"1046243","time":0,"version":0},{"imageid":"16721578","contentid":"16721497","details":"猪肉和皮冻的比例是1：1。","ordernum":3,"id":"1046245","time":0,"version":0},{"imageid":"16721547","contentid":"16721497","details":"加盐，一勺生抽调味，再加入白芝麻。","ordernum":4,"id":"1046240","time":0,"version":0},{"imageid":"16721599","contentid":"16721497","details":"300克面粉,3克酵母粉，加入150ＭＬ温水，揉成团。","ordernum":5,"id":"1046247","time":0,"version":0},{"imageid":"16721560","contentid":"16721497","details":"发酵半小时以上，到原来面团的两倍大小，用手指按一个坑不会反弹。","ordernum":6,"id":"1046242","time":0,"version":0},{"imageid":"16721589","contentid":"16721497","details":"分割成小剂子。","ordernum":7,"id":"1046246","time":0,"version":0},{"imageid":"16721571","contentid":"16721497","details":"用擀面杖擀出面皮。","ordernum":8,"id":"1046244","time":0,"version":0},{"imageid":"16721534","contentid":"16721497","details":"加入馅料包成小包子。","ordernum":9,"id":"1046239","time":0,"version":0},{"imageid":"16721552","contentid":"16721497","details":"不粘锅加油，热锅温油，加入小包子，煎到底部金黄。","ordernum":10,"id":"1046241","time":0,"version":0},{"imageid":"16721605","contentid":"16721497","details":"准备半碗温水，分两次，每次加一半，水能盖住小包子的底即可，每次加好水后，都盖上锅盖，让蒸气焖煮。","ordernum":11,"id":"1046248","time":0,"version":0},{"imageid":"16721507","contentid":"16721497","details":"准备一点面粉调的水，在最后开盖时，倒入锅中，让水份蒸发，把底部煎到金黄。","ordernum":12,"id":"1046236","time":0,"version":0},{"imageid":"16721518","contentid":"16721497","details":"最后撒上黑芝麻和葱花。","ordernum":13,"id":"1046237","time":0,"version":0}]
     * authorid : 22322737
     * version : 0
     * url : http://www.ecook.cn/ecook/viewContent.shtml?id=16721497
     * tags : 包子,午餐,晚餐
     * gettime : 2016年
     * tipList : []
     * authorname : 梁顺顺
     * name : 生煎包子
     * id : 16721497
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        private boolean hasVideo;
        private String imageid;
        private String description;
        private String authorid;
        private String version;
        private String url;
        private String tags;
        private String gettime;
        private String authorname;
        private String name;
        private String id;
        /**
         * dosage : 150克
         * contentid : 16721497
         * mwikipediaid :
         * name : 肉馅
         * ordernum : 1
         * id : 1283953
         * version : 0
         */

        private List<MaterialListBean> materialList;
        /**
         * imageid : 16721524
         * contentid : 16721497
         * details : 把姜片和葱丝，泡在水里，揉捏一会，就成了葱姜水。
         * ordernum : 1
         * id : 1046238
         * time : 0
         * version : 0
         */

        private List<StepListBean> stepList;
        private List<?> tipList;

        public boolean isHasVideo() {
            return hasVideo;
        }

        public void setHasVideo(boolean hasVideo) {
            this.hasVideo = hasVideo;
        }

        public String getImageid() {
            return imageid;
        }

        public void setImageid(String imageid) {
            this.imageid = imageid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getGettime() {
            return gettime;
        }

        public void setGettime(String gettime) {
            this.gettime = gettime;
        }

        public String getAuthorname() {
            return authorname;
        }

        public void setAuthorname(String authorname) {
            this.authorname = authorname;
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

        public List<MaterialListBean> getMaterialList() {
            return materialList;
        }

        public void setMaterialList(List<MaterialListBean> materialList) {
            this.materialList = materialList;
        }

        public List<StepListBean> getStepList() {
            return stepList;
        }

        public void setStepList(List<StepListBean> stepList) {
            this.stepList = stepList;
        }

        public List<?> getTipList() {
            return tipList;
        }

        public void setTipList(List<?> tipList) {
            this.tipList = tipList;
        }

        public static class MaterialListBean {
            private String dosage;
            private String contentid;
            private String mwikipediaid;
            private String name;
            private int ordernum;
            private String id;
            private int version;

            public String getDosage() {
                return dosage;
            }

            public void setDosage(String dosage) {
                this.dosage = dosage;
            }

            public String getContentid() {
                return contentid;
            }

            public void setContentid(String contentid) {
                this.contentid = contentid;
            }

            public String getMwikipediaid() {
                return mwikipediaid;
            }

            public void setMwikipediaid(String mwikipediaid) {
                this.mwikipediaid = mwikipediaid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getOrdernum() {
                return ordernum;
            }

            public void setOrdernum(int ordernum) {
                this.ordernum = ordernum;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }
        }

        public static class StepListBean {
            private String imageid;
            private String contentid;
            private String details;
            private int ordernum;
            private String id;
            private int time;
            private int version;

            public String getImageid() {
                return imageid;
            }

            public void setImageid(String imageid) {
                this.imageid = imageid;
            }

            public String getContentid() {
                return contentid;
            }

            public void setContentid(String contentid) {
                this.contentid = contentid;
            }

            public String getDetails() {
                return details;
            }

            public void setDetails(String details) {
                this.details = details;
            }

            public int getOrdernum() {
                return ordernum;
            }

            public void setOrdernum(int ordernum) {
                this.ordernum = ordernum;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public int getTime() {
                return time;
            }

            public void setTime(int time) {
                this.time = time;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }
        }
    }
}
