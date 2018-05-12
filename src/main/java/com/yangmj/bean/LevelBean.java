package com.yangmj.bean;

import java.util.List;

public class LevelBean {

    private String levelDetail;
    private int levelID;

    private List<UserBean> userBeanList;

    public LevelBean() {
    }

    public LevelBean(String levelDetail, int levelID, List<UserBean> userBeanList) {
        this.levelDetail = levelDetail;
        this.levelID = levelID;
        this.userBeanList = userBeanList;
    }

    public int getLevelID() {
        return levelID;
    }

    public void setLevelID(int levelID) {
        this.levelID = levelID;
    }

    public String getLevelDetail() {
        return levelDetail;
    }

    public void setLevelDetail(String levelDetail) {
        this.levelDetail = levelDetail;
    }

    public List<UserBean> getUserBeanList() {
        return userBeanList;
    }

    public void setUserBeanList(List<UserBean> userBeanList) {
        this.userBeanList = userBeanList;
    }
}
