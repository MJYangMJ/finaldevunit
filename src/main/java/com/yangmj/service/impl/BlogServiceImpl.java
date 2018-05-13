package com.yangmj.service.impl;

import com.yangmj.bean.BlogBean;
import com.yangmj.dao.impl.BlogDAOImpl;
import com.yangmj.service.BlogService;

import java.util.List;

public class BlogServiceImpl implements BlogService {
    private BlogDAOImpl blogDao;

    public void setBlogDao(BlogDAOImpl blogDao) {
        this.blogDao = blogDao;
    }

    @Override
    public boolean saveBlog(BlogBean blogBean, String currentUserName) {
        return blogDao.saveBlog(blogBean,currentUserName);
    }

    @Override
    public boolean isBlogTitleExisted(String title) {
        return blogDao.isBlogTitleExisted(title);
    }

    @Override
    public List<BlogBean> getBlogListByBlogName(String searchDetails) {
        return blogDao.getBlogListByBlogName(searchDetails);
    }

    @Override
    public List<BlogBean> getBlogListByUserName(String searchDetails) {
        return blogDao.getBlogListByUserName(searchDetails);
    }

    @Override
    public void deleteBlogByBlogID(int operateBlogID) {
        blogDao.deleteBlogByBlogID(operateBlogID);
    }

    @Override
    public void updateBlogByBlogID(int blogID, String blogContent) {
        blogDao.updateBlogByBlogID(blogID,blogContent);
    }

    @Override
    public BlogBean getBlogDetailsByBlogID(int operateBlogID) {
        return blogDao.getBlogDetailsByBlogID(operateBlogID);
    }
}
