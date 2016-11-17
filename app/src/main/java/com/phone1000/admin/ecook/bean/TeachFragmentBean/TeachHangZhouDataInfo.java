package com.phone1000.admin.ecook.bean.TeachFragmentBean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/10.
 */
public class TeachHangZhouDataInfo {

    /**
     * state : 200
     * list : [{"address":"西湖区竞舟路3号","updateTime":"2016-08-25 20:37:39.0","cityid":"1","gps":"30.26889,120.10619","himg":"227392624","originPrice":98,"title":"抹茶蛋糕","kcoin":100,"roomName":"荷家臻品","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=227392560","distancevalue":1144257.004171516,"createTime":"2016-08-24 21:20:10.0","price":28,"id":"42","status":1},{"address":"西湖区竞舟路3号","updateTime":"2016-08-25 20:36:43.0","cityid":"1","gps":"30.26889,120.10619","himg":"227393232","originPrice":98,"title":"美食课堂之纸杯蛋糕","kcoin":100,"roomName":"荷家臻品","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=227393202","distancevalue":1144257.004171516,"createTime":"2016-08-24 21:28:12.0","price":28,"id":"44","status":1},{"address":"下城区武林路277号皇后公园内","updateTime":"2016-08-25 21:19:38.0","cityid":"1","gps":"30.26515,120.16011","himg":"227470124","originPrice":288,"title":"巧克力香蕉卷体验课","kcoin":100,"roomName":"EBC Studio烘焙教室","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=35653476","distancevalue":1149116.0043496971,"createTime":"2016-08-04 14:13:10.0","price":88,"id":"18","status":1},{"address":"下城区武林路277号皇后公园内","updateTime":"2016-08-25 21:19:32.0","cityid":"1","gps":"30.26515,120.16011","himg":"227470113","originPrice":288,"title":"熔岩巧克力蛋糕","kcoin":100,"roomName":"EBC Studio烘焙教室","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=227455900","distancevalue":1149116.0043496971,"createTime":"2016-08-04 15:26:13.0","price":88,"id":"19","status":1},{"address":"下城区武林路277号皇后公园内","updateTime":"2016-08-25 21:19:12.0","cityid":"1","gps":"30.26515,120.16011","himg":"227470100","originPrice":288,"title":"缤纷水果塔","kcoin":100,"roomName":"EBC Studio烘焙教室","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=227454191","distancevalue":1149116.0043496971,"createTime":"2016-08-25 18:03:51.0","price":88,"id":"48","status":1},{"address":"上城区宋城路11-1号LOMO创意谷E1栋左道CAKE","updateTime":"2016-10-24 10:25:42.0","cityid":"1","gps":"30.21838,120.16865","himg":"232445172","originPrice":88,"title":"司康","kcoin":100,"roomName":"左道西点","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=38067766","distancevalue":1152103.060763112,"createTime":"2016-09-20 12:17:06.0","price":28,"id":"52","status":1},{"address":"上城区宋城路11-1号LOMO创意谷E1栋左道CAKE","updateTime":"2016-10-24 10:28:31.0","cityid":"1","gps":"30.21838,120.16865","himg":"232445212","originPrice":88,"title":"餐包","kcoin":100,"roomName":"左道西点","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=232444684","distancevalue":1152103.060763112,"createTime":"2016-09-20 12:17:35.0","price":28,"id":"53","status":1},{"address":"上城区宋城路11号1lomo创意谷 E1","updateTime":"2016-10-24 10:25:48.0","cityid":"1","gps":"30.21891,120.16931","himg":"232445126","originPrice":68,"title":"玛格丽特","kcoin":100,"roomName":"左道西点","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=232444196","distancevalue":1152134.7316367417,"createTime":"2016-09-20 12:16:21.0","price":18,"id":"51","status":1},{"address":"金城路160号汇金中心A幢3A-405","updateTime":"2016-10-24 10:26:00.0","cityid":"1","gps":"30.18172,120.2451","himg":"232444948","originPrice":298,"title":"法芙娜巧克力曲奇","kcoin":100,"roomName":"lin's cake","url":"http://mall.ecook.cn/good/getGoodDetail?goodId=38067262","distancevalue":1160500.482229125,"createTime":"2016-09-20 12:13:19.0","price":88,"id":"50","status":1}]
     * message : 获取成功！
     */

    private String state;
    private String message;
    private List<ListBean> list;

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

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * address : 西湖区竞舟路3号
         * updateTime : 2016-08-25 20:37:39.0
         * cityid : 1
         * gps : 30.26889,120.10619
         * himg : 227392624
         * originPrice : 98
         * title : 抹茶蛋糕
         * kcoin : 100
         * roomName : 荷家臻品
         * url : http://mall.ecook.cn/good/getGoodDetail?goodId=227392560
         * distancevalue : 1144257.004171516
         * createTime : 2016-08-24 21:20:10.0
         * price : 28
         * id : 42
         * status : 1
         */

        private String address;
        private String updateTime;
        private String cityid;
        private String gps;
        private String himg;
        private int originPrice;
        private String title;
        private int kcoin;
        private String roomName;
        private String url;
        private double distancevalue;
        private String createTime;
        private int price;
        private String id;
        private int status;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getCityid() {
            return cityid;
        }

        public void setCityid(String cityid) {
            this.cityid = cityid;
        }

        public String getGps() {
            return gps;
        }

        public void setGps(String gps) {
            this.gps = gps;
        }

        public String getHimg() {
            return himg;
        }

        public void setHimg(String himg) {
            this.himg = himg;
        }

        public int getOriginPrice() {
            return originPrice;
        }

        public void setOriginPrice(int originPrice) {
            this.originPrice = originPrice;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getKcoin() {
            return kcoin;
        }

        public void setKcoin(int kcoin) {
            this.kcoin = kcoin;
        }

        public String getRoomName() {
            return roomName;
        }

        public void setRoomName(String roomName) {
            this.roomName = roomName;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public double getDistancevalue() {
            return distancevalue;
        }

        public void setDistancevalue(double distancevalue) {
            this.distancevalue = distancevalue;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
