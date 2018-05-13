package com.yangmj.service;

import com.yangmj.bean.BlogBean;

import java.util.List;

public interface BlogService {

    boolean saveBlog(BlogBean blogBean, String currentUserName);
    boolean isBlogTitleExisted(String title);
    List<BlogBean> getBlogListByBlogName(String searchDetails);
    List<BlogBean> getBlogListByUserName(String searchDetails);
    void deleteBlogByBlogID(int operateBlogID);
    void updateBlogByBlogID(int blogID, String blogContent);
    BlogBean getBlogDetailsByBlogID(int operateBlogID);

}
