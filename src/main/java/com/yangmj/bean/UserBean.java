package com.yangmj.bean;

import java.util.List;

public class UserBean {

    private String userName;
    private String userPwd;
    private int userID;

    private LevelBean levelBean;
    private List<BlogBean> blogBeanList;

    public UserBean() {
    }

    public UserBean(String userName) {
        this.userName = userName;
    }

    public UserBean(String userName, String userPwd, LevelBean levelBean) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.levelBean = levelBean;
    }

    public UserBean(String userName, String userPwd, int userID, LevelBean levelBean, List<BlogBean> blogBeanList) {
        this.userName = userName;
        this.userPwd = userPwd;
        this.userID = userID;
        this.levelBean = levelBean;
        this.blogBeanList = blogBeanList;
    }

    public LevelBean getLevelBean() {
        return levelBean;
    }

    public void setLevelBean(LevelBean levelBean) {
        this.levelBean = levelBean;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public List<BlogBean> getBlogBeanList() {
        return blogBeanList;
    }

    public void setBlogBeanList(List<BlogBean> blogBeanList) {
        this.blogBeanList = blogBeanList;
    }

    public String toString(){
        return "name:"+userName+". pwd:"+userPwd+". id:"+userID;
    }

}
