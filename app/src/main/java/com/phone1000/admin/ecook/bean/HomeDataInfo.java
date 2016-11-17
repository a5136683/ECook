package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/11.
 */

public class HomeDataInfo{

    /**
     * bannerList : [{"image":"235783864","url":"ecook://online?id=1060"},{"image":"235773252","url":"http://pic.xiaochushuo.com/minisite/mall.ecook.cn.minisite82.html?f=ecook_share"},{"image":"235754898","url":"ecook://talktopic?topicname=网厨更新，评论送福利"},{"image":"235751221","url":"ecook://talktopic?topicname=记忆中的味道"},{"image":"235624785","url":"http://pic.xiaochushuo.com/minisite/minisite81.html?f=ecook_share"}]
     * recommendUserList : [{"uid":"235090598","imageid":"235091978","profile":"对于好吃又美貌的食物永不厌倦","title":"甜颜蜜语"},{"uid":"235612533","imageid":"235614431","profile":"有梦想的吃货","title":"楠楠"},{"uid":"234856096","imageid":"235237187","profile":"慢生活。愛美食。","title":"小C"},{"uid":"235291554","imageid":"235291805","profile":"烘焙是一种生活态度\n静蜜萱烘焙教室 创始人","title":"静蜜萱"},{"uid":"234788254","imageid":"234788391","profile":"ANGLEMON cake是我一生为止奋斗的事业。","title":"啊忠"},{"uid":"5935466","imageid":"235217654","profile":"「Be Myself、be Happy。","title":"  顿妈。"},{"uid":"234322700","imageid":"234322982","profile":"蛋糕定制，活动茶歇，西点教程","title":"左道西点-荣荣"},{"uid":"234324131","imageid":"234452934","profile":"荷家臻品美食课堂","title":"荷家臻品\u2014韩"},{"uid":"4167716","imageid":"4167718","profile":"人以食为天，我想做个吃货，吃遍天下美食","title":"小龙女_qq_956115"},{"uid":"23770403","imageid":"223252699","profile":"追求完美、注重生活品质、喜欢美食美感、愿意和喜欢美食的亲们互相交流和学习😊🌹💤☕️","title":"踏月色而来~"},{"uid":"226090125","imageid":"35934740","profile":"热爱美食，热爱分享","title":"蝶舞九天"},{"uid":"235021559","imageid":"235026122","profile":"追随它多年永不离弃爱甜品。裱花蛋糕老师。","title":"杭州酷德-俊奇"},{"uid":"234979565","imageid":"234979919","profile":"做烘焙，我是认真的！","title":"酷德教育刘老嘿"},{"uid":"23723909","imageid":"223312661","profile":"转载请注明出处，谢谢！","title":"菜菜籽麻麻酱"},{"uid":"225613569","imageid":"235179636","profile":"一入烘焙深似海，从此毛爷爷是路人～","title":"郑小姐私房烘焙"},{"uid":"232833361","imageid":"232833660","profile":"行动，用心，包容。微信bst1886","title":"烘焙私教焙焙"},{"uid":"233065090","imageid":"234704585","profile":"国家高级西点技师","title":"语希"},{"uid":"29029801","imageid":"225741201","profile":"十年不变的坚持","title":"Sammy"},{"uid":"32498916","imageid":"234139208","profile":" 爱生活，爱美食","title":"Evarty"},{"uid":"228842263","imageid":"232942027","profile":"爱运动 爱美食 更爱健康。","title":"甜说掌柜"}]
     * buttonList : [{"imageId":"223364865","num":1,"id":1,"state":1,"title":"签到","url":""},{"imageId":"223364873","num":2,"id":2,"state":1,"title":"商城","url":"http://mall.ecook.cn/category/list?f=ecook_show_mine"},{"imageId":"223364874","num":3,"id":3,"state":1,"title":"视频","url":""},{"imageId":"223364878","num":4,"id":4,"state":1,"title":"活动","url":""}]
     * idList : [6027,6026,6025,6024,6022,6021,6019,6018,6016,6013,6012,6011,6010,6008,6007,6005,6004,6003,6002,6000,5998,5997,5995,5994,5993,5992,5991,5990,5989,5988,5987,5986,5985,5984,5983,5981,5979,5978,5975,5974,5973,5972,5970,5969,5968,5966,5965,5964,5963,5962,5961,5959,5958,5957,5955,5954,5953,5951,5950,5948,5946,5945,5944,5943,5942,5941,5939,5938,5937,5936,5935,5934,5932,5931,5929,5928,5927,5926,5923,5922,5920,5919,5917,5916,5915,5913,5912,5910,5909,5908,5907,5906,5905,5904,5902,5901,5900,5897,5896,5895,5894,5893,5892,5891,5890,5889,5888,5887,5886,5885,5884,5883,5882,5881,5880,5879,5878,5877,5876,5875,5874,5873,5872,5871,5870,5869,5868,5867,5866,5865,5864,5863,5862,5861,5860,5859,5858,5857,5856,5855,5854,5853,5852,5851,5850,5849,5848,5847,5846,5845,5844,5843,5842,5841,5840,5839,5838,5837,5836,5835,5834,5833,5832,5831,5830,5829,5828,5827,5826,5825,5824,5823,5822,5821,5820,5819,5818,5817,5816,5815,5814,5813,5811,5810,5809,5807,5806,5805,5804,5803,5802,5801,5800,5799,5798,5797,5796,5795,5794,5793,5792,5791,5790,5789,5788,5787,5786,5785,5784,5783,5782,5781,5780,5779,5778,5777,5776,5775,5774,5773,5772,5771,5770,5769,5768,5766,5764,5762,5761,5759,5758,5756,5755,5754,5753,5752,5751,5750,5749,5748,5747,5746,5745,5744,5743,5742,5741,5740,5739,5738,5736,5735,5734,5733,5732,5730,5729,5727,5726,5725,5724,5723,5722,5721,5720,5719,5718,5717,5716,5715,5714,5712,5711,5710,5709,5708,5706,5705,5704,5703,5702,5700,5699,5698,5696,5695,5694,5693,5692,5691,5689,5688,5687,5686,5685,5683,5682,5681,5680,5679,5678,5677,5676,5675,5674,5673,5672,5671,5670,5669,5668,5667,5666,5665,5664,5663,5662,5661,5660,5659,5658,5657,5656,5655,5654,5653,5652,5651,5650,5649,5648,5647,5646,5645,5644,5643,5642,5641,5640,5639,5638,5637,5636,5635,5633,5632,5631,5630,5629,5628,5626,5625,5624,5623,5622,5621,5620,5619,5618,5617,5616,5615,5614,5613,5612,5611,5610,5609,5608,5607,5606,5605,5604,5603,5602,5601,5600,5599,5597,5596,5595,5594,5593,5592,5591,5590,5589,5588,5587,5586,5585,5584,5583,5582,5581,5580,5579,5578,5577,5576,5575,5574,5573,5572,5571,5570,5568,5567,5566,5565,5564,5563,5562,5561,5560,5559,5558,5557,5556,5555,5554,5553,5552,5551,5550,5549,5547,5546,5545,5544,5543,5542,5541,5540,5539,5538,5537,5536,5535,5534,5533,5532,5531,5530,5529,5528,5527,5526,5525,5524,5523,5522,5521,5520,5519,5518,5517,5516,5515,5514,5513,5512,5511,5510,5509,5508,5507,5506,5505,5504,5503,5502,5501,5500,5499,5498,5497,5496,5495,5494,5493,5492,5491,5490,5489,5487,5486,5485,5484,5483,5482,5480,5479,5478,5477,5476,5475,5474]
     * desc : {"talkDesc":"晒美食，晒生活，玩活动","recipeDesc":"写菜谱能得500厨币哟"}
     */

    private DataBean data;
    /**
     * data : {"bannerList":[{"image":"235783864","url":"ecook://online?id=1060"},{"image":"235773252","url":"http://pic.xiaochushuo.com/minisite/mall.ecook.cn.minisite82.html?f=ecook_share"},{"image":"235754898","url":"ecook://talktopic?topicname=网厨更新，评论送福利"},{"image":"235751221","url":"ecook://talktopic?topicname=记忆中的味道"},{"image":"235624785","url":"http://pic.xiaochushuo.com/minisite/minisite81.html?f=ecook_share"}],"recommendUserList":[{"uid":"235090598","imageid":"235091978","profile":"对于好吃又美貌的食物永不厌倦","title":"甜颜蜜语"},{"uid":"235612533","imageid":"235614431","profile":"有梦想的吃货","title":"楠楠"},{"uid":"234856096","imageid":"235237187","profile":"慢生活。愛美食。","title":"小C"},{"uid":"235291554","imageid":"235291805","profile":"烘焙是一种生活态度\n静蜜萱烘焙教室 创始人","title":"静蜜萱"},{"uid":"234788254","imageid":"234788391","profile":"ANGLEMON cake是我一生为止奋斗的事业。","title":"啊忠"},{"uid":"5935466","imageid":"235217654","profile":"「Be Myself、be Happy。","title":"  顿妈。"},{"uid":"234322700","imageid":"234322982","profile":"蛋糕定制，活动茶歇，西点教程","title":"左道西点-荣荣"},{"uid":"234324131","imageid":"234452934","profile":"荷家臻品美食课堂","title":"荷家臻品\u2014韩"},{"uid":"4167716","imageid":"4167718","profile":"人以食为天，我想做个吃货，吃遍天下美食","title":"小龙女_qq_956115"},{"uid":"23770403","imageid":"223252699","profile":"追求完美、注重生活品质、喜欢美食美感、愿意和喜欢美食的亲们互相交流和学习😊🌹💤☕️","title":"踏月色而来~"},{"uid":"226090125","imageid":"35934740","profile":"热爱美食，热爱分享","title":"蝶舞九天"},{"uid":"235021559","imageid":"235026122","profile":"追随它多年永不离弃爱甜品。裱花蛋糕老师。","title":"杭州酷德-俊奇"},{"uid":"234979565","imageid":"234979919","profile":"做烘焙，我是认真的！","title":"酷德教育刘老嘿"},{"uid":"23723909","imageid":"223312661","profile":"转载请注明出处，谢谢！","title":"菜菜籽麻麻酱"},{"uid":"225613569","imageid":"235179636","profile":"一入烘焙深似海，从此毛爷爷是路人～","title":"郑小姐私房烘焙"},{"uid":"232833361","imageid":"232833660","profile":"行动，用心，包容。微信bst1886","title":"烘焙私教焙焙"},{"uid":"233065090","imageid":"234704585","profile":"国家高级西点技师","title":"语希"},{"uid":"29029801","imageid":"225741201","profile":"十年不变的坚持","title":"Sammy"},{"uid":"32498916","imageid":"234139208","profile":" 爱生活，爱美食","title":"Evarty"},{"uid":"228842263","imageid":"232942027","profile":"爱运动 爱美食 更爱健康。","title":"甜说掌柜"}],"buttonList":[{"imageId":"223364865","num":1,"id":1,"state":1,"title":"签到","url":""},{"imageId":"223364873","num":2,"id":2,"state":1,"title":"商城","url":"http://mall.ecook.cn/category/list?f=ecook_show_mine"},{"imageId":"223364874","num":3,"id":3,"state":1,"title":"视频","url":""},{"imageId":"223364878","num":4,"id":4,"state":1,"title":"活动","url":""}],"idList":[6027,6026,6025,6024,6022,6021,6019,6018,6016,6013,6012,6011,6010,6008,6007,6005,6004,6003,6002,6000,5998,5997,5995,5994,5993,5992,5991,5990,5989,5988,5987,5986,5985,5984,5983,5981,5979,5978,5975,5974,5973,5972,5970,5969,5968,5966,5965,5964,5963,5962,5961,5959,5958,5957,5955,5954,5953,5951,5950,5948,5946,5945,5944,5943,5942,5941,5939,5938,5937,5936,5935,5934,5932,5931,5929,5928,5927,5926,5923,5922,5920,5919,5917,5916,5915,5913,5912,5910,5909,5908,5907,5906,5905,5904,5902,5901,5900,5897,5896,5895,5894,5893,5892,5891,5890,5889,5888,5887,5886,5885,5884,5883,5882,5881,5880,5879,5878,5877,5876,5875,5874,5873,5872,5871,5870,5869,5868,5867,5866,5865,5864,5863,5862,5861,5860,5859,5858,5857,5856,5855,5854,5853,5852,5851,5850,5849,5848,5847,5846,5845,5844,5843,5842,5841,5840,5839,5838,5837,5836,5835,5834,5833,5832,5831,5830,5829,5828,5827,5826,5825,5824,5823,5822,5821,5820,5819,5818,5817,5816,5815,5814,5813,5811,5810,5809,5807,5806,5805,5804,5803,5802,5801,5800,5799,5798,5797,5796,5795,5794,5793,5792,5791,5790,5789,5788,5787,5786,5785,5784,5783,5782,5781,5780,5779,5778,5777,5776,5775,5774,5773,5772,5771,5770,5769,5768,5766,5764,5762,5761,5759,5758,5756,5755,5754,5753,5752,5751,5750,5749,5748,5747,5746,5745,5744,5743,5742,5741,5740,5739,5738,5736,5735,5734,5733,5732,5730,5729,5727,5726,5725,5724,5723,5722,5721,5720,5719,5718,5717,5716,5715,5714,5712,5711,5710,5709,5708,5706,5705,5704,5703,5702,5700,5699,5698,5696,5695,5694,5693,5692,5691,5689,5688,5687,5686,5685,5683,5682,5681,5680,5679,5678,5677,5676,5675,5674,5673,5672,5671,5670,5669,5668,5667,5666,5665,5664,5663,5662,5661,5660,5659,5658,5657,5656,5655,5654,5653,5652,5651,5650,5649,5648,5647,5646,5645,5644,5643,5642,5641,5640,5639,5638,5637,5636,5635,5633,5632,5631,5630,5629,5628,5626,5625,5624,5623,5622,5621,5620,5619,5618,5617,5616,5615,5614,5613,5612,5611,5610,5609,5608,5607,5606,5605,5604,5603,5602,5601,5600,5599,5597,5596,5595,5594,5593,5592,5591,5590,5589,5588,5587,5586,5585,5584,5583,5582,5581,5580,5579,5578,5577,5576,5575,5574,5573,5572,5571,5570,5568,5567,5566,5565,5564,5563,5562,5561,5560,5559,5558,5557,5556,5555,5554,5553,5552,5551,5550,5549,5547,5546,5545,5544,5543,5542,5541,5540,5539,5538,5537,5536,5535,5534,5533,5532,5531,5530,5529,5528,5527,5526,5525,5524,5523,5522,5521,5520,5519,5518,5517,5516,5515,5514,5513,5512,5511,5510,5509,5508,5507,5506,5505,5504,5503,5502,5501,5500,5499,5498,5497,5496,5495,5494,5493,5492,5491,5490,5489,5487,5486,5485,5484,5483,5482,5480,5479,5478,5477,5476,5475,5474],"desc":{"talkDesc":"晒美食，晒生活，玩活动","recipeDesc":"写菜谱能得500厨币哟"}}
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
         * talkDesc : 晒美食，晒生活，玩活动
         * recipeDesc : 写菜谱能得500厨币哟
         */

        private DescBean desc;
        /**
         * image : 235783864
         * url : ecook://online?id=1060
         */

        private List<BannerListBean> bannerList;
        /**
         * uid : 235090598
         * imageid : 235091978
         * profile : 对于好吃又美貌的食物永不厌倦
         * title : 甜颜蜜语
         */

        private List<RecommendUserListBean> recommendUserList;
        /**
         * imageId : 223364865
         * num : 1
         * id : 1
         * state : 1
         * title : 签到
         * url :
         */

        private List<ButtonListBean> buttonList;
        private List<Integer> idList;

        public DescBean getDesc() {
            return desc;
        }

        public void setDesc(DescBean desc) {
            this.desc = desc;
        }

        public List<BannerListBean> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<BannerListBean> bannerList) {
            this.bannerList = bannerList;
        }

        public List<RecommendUserListBean> getRecommendUserList() {
            return recommendUserList;
        }

        public void setRecommendUserList(List<RecommendUserListBean> recommendUserList) {
            this.recommendUserList = recommendUserList;
        }

        public List<ButtonListBean> getButtonList() {
            return buttonList;
        }

        public void setButtonList(List<ButtonListBean> buttonList) {
            this.buttonList = buttonList;
        }

        public List<Integer> getIdList() {
            return idList;
        }

        public void setIdList(List<Integer> idList) {
            this.idList = idList;
        }

        public static class DescBean {
            private String talkDesc;
            private String recipeDesc;

            public String getTalkDesc() {
                return talkDesc;
            }

            public void setTalkDesc(String talkDesc) {
                this.talkDesc = talkDesc;
            }

            public String getRecipeDesc() {
                return recipeDesc;
            }

            public void setRecipeDesc(String recipeDesc) {
                this.recipeDesc = recipeDesc;
            }
        }

        public static class BannerListBean {
            private String image;
            private String url;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class RecommendUserListBean {
            private String uid;
            private String imageid;
            private String profile;
            private String title;

            public String getUid() {
                return uid;
            }

            public void setUid(String uid) {
                this.uid = uid;
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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class ButtonListBean {
            private String imageId;
            private int num;
            private int id;
            private int state;
            private String title;
            private String url;

            public String getImageId() {
                return imageId;
            }

            public void setImageId(String imageId) {
                this.imageId = imageId;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
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
