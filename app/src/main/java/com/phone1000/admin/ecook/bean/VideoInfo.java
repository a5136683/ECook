package com.phone1000.admin.ecook.bean;

/**
 * Created by admin on 2016/11/17.
 */

public class VideoInfo {

    /**
     * urlprefix : http://tv.ecook.cn/s/
     * classes :
     * name : 181215.mp4
     * project : 181215
     * id : 192
     * type : s
     * status : 1
     */

    private String urlprefix;
    private String classes;
    private String name;
    private String project;
    private int id;
    private String type;
    private int status;

    public String getUrlprefix() {
        return urlprefix;
    }

    public void setUrlprefix(String urlprefix) {
        this.urlprefix = urlprefix;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
