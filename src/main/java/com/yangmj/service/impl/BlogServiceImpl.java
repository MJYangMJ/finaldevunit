package com.yangmj.service.impl;

import com.yangmj.dao.impl.BlogDAOImpl;
import com.yangmj.service.BlogService;

public class BlogServiceImpl implements BlogService {
    private BlogDAOImpl blogDao;

    public void setBlogDao(BlogDAOImpl blogDao) {
        this.blogDao = blogDao;
    }
}
