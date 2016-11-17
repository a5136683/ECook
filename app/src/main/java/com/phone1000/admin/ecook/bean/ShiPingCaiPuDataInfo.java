package com.phone1000.admin.ecook.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/11/15.
 */

public class ShiPingCaiPuDataInfo {

    /**
     * state : 200
     * list : [{"imageid":"236026235","authorname":"冬日阳光","collectCount":"773","name":"香菇焖猪蹄","description":"香菇和哪种食物搭在一起都特别的香，无论是炖汤，还是炒食，焖炖煮都合味道。锅在工作的时候，总是飘出阵阵香气，整得人家都想掀盖来尝尝了。电饭锅菜是懒人菜，把处理好的食材和调料加入锅中，让它完成，香喷喷的，简单又美味。食材：猪蹄1000克、香菇5","likeCount":"299","id":"17859308","authorid":"15863752","type":"","authorimageid":"18570348","commentCount":"7"},{"imageid":"236024489","authorname":"christelle1216","collectCount":"849","name":"葱油面","description":"周末花上一个小时熬制一些葱油，然后在上班日子里简单煮一点面，就可以飞快的享用一餐，是不是个很好的主意？","likeCount":"783","id":"16720882","authorid":"16602243","type":"","authorimageid":"11998013","commentCount":"20"},{"imageid":"16018614","authorname":"puppy在厨房","collectCount":"330","name":"七星鱼丸","description":"鱼丸是福建著名的汤菜之一。它是用鱼肉、瘦猪肉、虾干为主要原料制成的。那一颗颗如核桃大小的雪白的鱼丸，漂浮于热气腾腾的汤面，如满天星斗布于空间。因此，海外华侨把它称为\u201c七星鱼丸\u201d。福州的\u201c七星鱼丸\u201d具有色泽洁白，有弹性而不腻，馅香而松，口味清甜爽滑等特点，久负盛名。","likeCount":"108","id":"16018660","authorid":"14128971","type":"","authorimageid":"14133693","commentCount":"14"},{"imageid":"236012158","authorname":"誓言","collectCount":"881","name":"孜然羊肉炒米饭","description":"兰州夜市名小吃","likeCount":"487","id":"16821011","authorid":"15745719","type":"","authorimageid":"1581738","commentCount":"9"},{"imageid":"17293621","authorname":"傅小姐","collectCount":"6132","name":"可乐鸡翅","description":"鸡翅含有多量可强健血管及皮肤的成胶原及弹性蛋白，对于血管、皮肤及内脏颇具效果。可乐的作用不仅仅是甜，最重要的作用是其中的碳水化合物和柠檬酸成份可以让肉质十分鲜嫩，一次可以让您满足肉与饮料的食欲。（更多小吃制作，小吃技术请继续关注食尚香小吃培","likeCount":"963","id":"17293619","authorid":"15862589","type":"","authorimageid":"1267921","commentCount":"33"},{"imageid":"235869378","authorname":"阿布乘以五","collectCount":"924","name":"香煎豆腐","description":"外焦里嫩的煎豆腐，就是买的少了。。","likeCount":"382","id":"16065586","authorid":"15053481","type":"","authorimageid":"1416151","commentCount":"2"},{"imageid":"235860299","authorname":"孙凯2678399730","collectCount":"1665","name":"新疆大盘鸡","description":"楼下有个新疆馆，偷懒或没时间做饭的时候就爱去蹭蹭，点个大盘鸡，再来几个串，一大杯扎啤准能让我俩吃的肚翻～拍着肚皮走出馆子。","likeCount":"1160","id":"17561684","authorid":"18810688","type":"","authorimageid":"1427415","commentCount":"9"},{"imageid":"31967165","authorname":"童尐果","collectCount":"1244","name":"新奥尔良烤翅","description":"每次去KFC我必点新奥尔良烤翅，其实在自己家里制作非常简单，新手也能做出色香味俱全的烤翅。","likeCount":"137","id":"224084144","authorid":"30293549","type":"","authorimageid":"223819432","commentCount":"37"},{"imageid":"17435604","authorname":"會飛的賽賽梁","collectCount":"387","name":"北非蛋","description":"","likeCount":"290","id":"17435595","authorid":"15114574","type":"","authorimageid":"1458768","commentCount":"4"},{"imageid":"235830176","authorname":"EmmaDuan","collectCount":"646","name":"冰糖银耳雪梨羹","description":"止咳润肺秋季最好的甜品哦～","likeCount":"660","id":"16515165","authorid":"17443676","type":"","authorimageid":"18532229","commentCount":"0"}]
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
         * imageid : 236026235
         * authorname : 冬日阳光
         * collectCount : 773
         * name : 香菇焖猪蹄
         * description : 香菇和哪种食物搭在一起都特别的香，无论是炖汤，还是炒食，焖炖煮都合味道。锅在工作的时候，总是飘出阵阵香气，整得人家都想掀盖来尝尝了。电饭锅菜是懒人菜，把处理好的食材和调料加入锅中，让它完成，香喷喷的，简单又美味。食材：猪蹄1000克、香菇5
         * likeCount : 299
         * id : 17859308
         * authorid : 15863752
         * type :
         * authorimageid : 18570348
         * commentCount : 7
         */

        private String imageid;
        private String authorname;
        private String collectCount;
        private String name;
        private String description;
        private String likeCount;
        private String id;
        private String authorid;
        private String type;
        private String authorimageid;
        private String commentCount;

        public String getImageid() {
            return imageid;
        }

        public void setImageid(String imageid) {
            this.imageid = imageid;
        }

        public String getAuthorname() {
            return authorname;
        }

        public void setAuthorname(String authorname) {
            this.authorname = authorname;
        }

        public String getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(String collectCount) {
            this.collectCount = collectCount;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(String likeCount) {
            this.likeCount = likeCount;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAuthorid() {
            return authorid;
        }

        public void setAuthorid(String authorid) {
            this.authorid = authorid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getAuthorimageid() {
            return authorimageid;
        }

        public void setAuthorimageid(String authorimageid) {
            this.authorimageid = authorimageid;
        }

        public String getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }
    }
}
