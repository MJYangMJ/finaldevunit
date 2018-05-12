package com.yangmj.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yangmj.bean.BlogBean;
import com.yangmj.service.impl.BlogServiceImpl;

import java.util.List;

public class BlogStuffsAction extends ActionSupport {

    private BlogServiceImpl blogService;

    public void setBlogService(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    private BlogBean blogBean;
    private List<BlogBean> blogBeanList;

}
