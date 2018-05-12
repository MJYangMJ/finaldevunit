package com.yangmj.bean;

public class BlogBean {

    private String blogTitle;
    private String blogDate;
    private int blogClickTimes;
    private String blogContent;
    private int blogID;

    private UserBean userBean;

    public BlogBean() {
    }

    public BlogBean(String blogTitle, String blogDate, int blogClickTimes, String blogContent, int blogID, UserBean userBean) {
        this.blogTitle = blogTitle;
        this.blogDate = blogDate;
        this.blogClickTimes = blogClickTimes;
        this.blogContent = blogContent;
        this.blogID = blogID;
        this.userBean = userBean;
    }

    public UserBean getUserBean() {
        return userBean;
    }

    public void setUserBean(UserBean userBean) {
        this.userBean = userBean;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogDate() {
        return blogDate;
    }

    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }

    public int getBlogClickTimes() {
        return blogClickTimes;
    }

    public void setBlogClickTimes(int blogClickTimes) {
        this.blogClickTimes = blogClickTimes;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public int getBlogID() {
        return blogID;
    }

    public void setBlogID(int blogID) {
        this.blogID = blogID;
    }

    public String toString(){
        return "blog name:"+blogTitle+". blog date:"+blogDate+". blog id:"+blogID;
    }

}
