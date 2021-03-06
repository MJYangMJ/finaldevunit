package com.yangmj.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.yangmj.bean.BlogBean;
import com.yangmj.bean.UserBean;
import com.yangmj.service.impl.BlogServiceImpl;
import net.sf.json.JSONArray;

import java.util.List;

public class BlogStuffsAction extends ActionSupport {

    private BlogServiceImpl blogService;

    public void setBlogService(BlogServiceImpl blogService) {
        this.blogService = blogService;
    }

    private BlogBean blogBean;
    private List<BlogBean> blogBeanList;
    private String searchMode;
    private String searchDetails;
    private int operateBlogID;
    private String indexBlogBeanListJson;

    public BlogBean getBlogBean() {
        return blogBean;
    }

    public void setBlogBean(BlogBean blogBean) {
        this.blogBean = blogBean;
    }

    public List<BlogBean> getBlogBeanList() {
        return blogBeanList;
    }

    public void setBlogBeanList(List<BlogBean> blogBeanList) {
        this.blogBeanList = blogBeanList;
    }

    public String getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(String searchMode) {
        this.searchMode = searchMode;
    }

    public String getSearchDetails() {
        return searchDetails;
    }

    public void setSearchDetails(String searchDetails) {
        this.searchDetails = searchDetails;
    }

    public int getOperateBlogID() {
        return operateBlogID;
    }

    public void setOperateBlogID(int operateBlogID) {
        this.operateBlogID = operateBlogID;
    }

    public String getIndexBlogBeanListJson() {
        return indexBlogBeanListJson;
    }

    public void setIndexBlogBeanListJson(String indexBlogBeanListJson) {
        this.indexBlogBeanListJson = indexBlogBeanListJson;
    }

    public String saveBlog(){
        blogService.saveBlog(blogBean,ActionContext.getContext().getSession().get("current_user").toString());
        return "success";
    }

    public String searchBlog(){
        System.out.println(searchMode);
        if (searchDetails.toString().equals("null")){
            return "error";
        } else {
            if (searchMode.equals("BlogName")) {
                System.out.println(searchDetails);
                blogBeanList = blogService.getBlogListByBlogName(searchDetails);
            } else if (searchMode.equals("OwnerName")) {
                System.out.println(searchDetails);
                blogBeanList = blogService.getBlogListByUserName(searchDetails);
            }
            return "success";
        }
    }

    public String getCurrentUserBlog(){
        try {
            String temp = ActionContext.getContext().getSession().get("current_user").toString();
        }
        catch (Exception e){

            return "error";
        }
        blogBeanList = blogService.getBlogListByUserName(ActionContext.getContext().getSession().get("current_user").toString());
        return "success";
    }

    public String deleteBlog(){
        blogService.deleteBlogByBlogID(operateBlogID);
        blogBeanList = blogService.getBlogListByUserName(ActionContext.getContext().getSession().get("current_user").toString());
        return "success";
    }

    public String updateBlog(){
        blogService.updateBlogByBlogID(blogBean.getBlogID(),blogBean.getBlogContent());
        blogBeanList = blogService.getBlogListByUserName(ActionContext.getContext().getSession().get("current_user").toString());
        return "success";
    }

    public String getBlogDetailsByBlogID(){
        blogBean = blogService.getBlogDetailsByBlogID(operateBlogID);
        return "success";
    }

    public boolean isTitleExisted(String title){
        return true;
    }

    public String indexBlogList(){
        blogBeanList = blogService.getBlogListByBlogName("*");
        JSONArray blogBeanListJson = JSONArray.fromObject(blogBeanList);
        indexBlogBeanListJson = blogBeanListJson.toString();
        return "success";
    }

    public String testGetBlogList(){
        blogBeanList = blogService.getBlogListByUserName("yangmj");
        return "success";
    }

}
