package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by admin on 2016/11/15.
 */

public class PersonTalkInfo {

    /**
     * state : 200
     * list : [{"displaytime":"5小时前","addtime":"2016-11-15 17:28:00.0","id":"236083858","state":1,"text":"#自制腊鸭腿鸡#腊味煲仔饭\u2026\u2026自制的腊肉咸淡软硬度刚刚好，腊鸭腿有点咸了，下次做腊鸭粥\u2026\u2026又买了10几只鸭腿准备制作腊鸭腿这次的盐少放点","userid":"11877232","imageids":"236083750,236083751"},{"displaytime":"5小时前","addtime":"2016-11-15 16:52:56.0","id":"236082013","state":1,"text":"#超软拉丝🌹小餐包#小🌹包😋😋好吃","userid":"11877232","imageids":"236081961,236081966,236081971,236081960,236081967,236081964"},{"displaytime":"15小时前","addtime":"2016-11-15 06:48:40.0","id":"236054759","state":1,"text":"#早餐#早上好🌹，供暖了，更不愿离开热乎乎的被窝了😊😊😊\u2026\u2026今早做了冬季一定要吃的腊味煲仔饭🍚腊肉腊鸭腿都是今年新制的😋😋😋香芹炒香干、红烧茄子🍆、萝卜牛腩、自制嫩豆腐西红柿🍅汤","userid":"11877232","imageids":"236054321,236054323,236054336,236054728,236054737,236054738,236054729,236054748"},{"displaytime":"昨天","addtime":"2016-11-14 18:17:20.0","id":"236023448","state":1,"text":"#自制腊鸭腿鸡#腊鸭腿不用说，算得上是腊鸭最精华的部分赞赞👍👍👍切块放到白饭上一蒸，便能闻到那带着陈年脂膏香的鸭油沁入白饭时的味道。鸭腿皮微咸有韧性，鸭腿肉紧实，咬在嘴里都是不可言传的微妙香气😋😋好吃","userid":"11877232","imageids":"236022784,236022795,236022846"},{"displaytime":"昨天","addtime":"2016-11-14 06:50:54.0","id":"235993236","state":1,"text":"#早餐#早上好花\u2026\u2026\u2026茄汁豆腐🍤虾仁、素炒菜花、瓜片五花肉、炒腌芥菜笋","userid":"11877232","imageids":"235993105,235993098,235993107,235993101,235993111,235993097,235993103,235993106"},{"displaytime":"11-12 20:17","addtime":"2016-11-12 20:17:32.0","id":"235917841","state":1,"text":"#自制腊鸭腿#经过四天的腌制，七天的晾晒，充满腊香的腊鸭腿制作完成了，迫不及待的蒸了一只鸭腿，真的很好吃😋😋😋，家人说越嚼越香😊\u2026\u2026寒冷的冬日喝一口小酒，吃一块腊鸭腿，神仙也不做😂😂😂","userid":"11877232","imageids":"235917702,235917697,235917699,235917698,235917709,235917706,235917707"},{"displaytime":"11-12 18:15","addtime":"2016-11-12 18:15:11.0","id":"235912051","state":1,"text":"#嫩豆腐#自己做的豆腐就是好吃😋😋😋","userid":"11877232","imageids":"235912033,235912029,235912032,235912022"},{"displaytime":"11-11 10:11","addtime":"2016-11-11 10:11:55.0","id":"235852164","state":1,"text":"@洋洋 真的只是试了一下，没想到会抢到，好开心😄","userid":"11877232","imageids":"235852114"}]
     * message : 获取成功！
     */

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * displaytime : 5小时前
         * addtime : 2016-11-15 17:28:00.0
         * id : 236083858
         * state : 1
         * text : #自制腊鸭腿鸡#腊味煲仔饭……自制的腊肉咸淡软硬度刚刚好，腊鸭腿有点咸了，下次做腊鸭粥……又买了10几只鸭腿准备制作腊鸭腿这次的盐少放点
         * userid : 11877232
         * imageids : 236083750,236083751
         */

        private String displaytime;
        private String addtime;
        private String id;
        private int state;
        private String text;
        private String userid;
        private String imageids;

        public String getDisplaytime() {
            return displaytime;
        }

        public void setDisplaytime(String displaytime) {
            this.displaytime = displaytime;
        }

        public String getAddtime() {
            return addtime;
        }

        public void setAddtime(String addtime) {
            this.addtime = addtime;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getImageids() {
            return imageids;
        }

        public void setImageids(String imageids) {
            this.imageids = imageids;
        }
    }
}
