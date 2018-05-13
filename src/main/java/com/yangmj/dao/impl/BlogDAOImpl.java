package com.yangmj.dao.impl;

import com.yangmj.bean.BlogBean;
import com.yangmj.bean.UserBean;
import com.yangmj.dao.BlogDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BlogDAOImpl implements BlogDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean saveBlog(BlogBean blogBean, String currentUserName){
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date utilDate=new Date();
        Session session = sessionFactory.openSession();
        UserBean userBean = (UserBean) session.createQuery("from UserBean u" +
                " where u.userName='"+currentUserName+"'").uniqueResult();
        blogBean.setBlogClickTimes(0);
        blogBean.setBlogDate(dateFormat.format(utilDate));
        blogBean.setUserBean(userBean);
        session.save(blogBean);
        session.close();
        return true;
    }

    @Override
    public boolean isBlogTitleExisted(String title){
        Session session = sessionFactory.openSession();
        String hql = "from BlogBean b where b.blogTitle='" + title + "'";
        if (session.createQuery(hql).list().size() != 0) {
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    @Override
    public List<BlogBean> getBlogListByBlogName(String searchDetails) {
        Session session = sessionFactory.openSession();
        List<BlogBean> blogBeanList = new ArrayList<>();
        if(searchDetails.equals("*")){
            String hql = "select b.blogID,b.blogTitle,b.blogContent,b.blogClickTimes,b.blogDate,b.userBean.userName from BlogBean b order by b.blogClickTimes desc";
            blogBeanList = session.createQuery(hql).list();
        }
        else {
            String hql = "from BlogBean b where b.blogTitle like '%" + searchDetails + "%'";
            blogBeanList = session.createQuery(hql).list();
        }
        session.close();
        return blogBeanList;
    }

    @Override
    public List<BlogBean> getBlogListByUserName(String searchDetails) {
        Session session = sessionFactory.openSession();
        List<BlogBean> blogBeanList = new ArrayList<>();
        String hql = "from BlogBean b where b.userBean.userName like '%" + searchDetails + "%'";
        blogBeanList = session.createQuery(hql).list();
        session.close();
        return blogBeanList;
    }

    @Override
    public void deleteBlogByBlogID(int operateBlogID) {
        Session session = sessionFactory.openSession();
        String updateClickTime = "delete from BlogBean b where b.blogID="+operateBlogID;
        Transaction transaction = session.beginTransaction();
        int isDeleted = session.createQuery(updateClickTime).executeUpdate();
        if (isDeleted == 1)
            transaction.commit();
        session.close();
    }

    @Override
    public void updateBlogByBlogID(int blogID, String blogContent) {
        Session session = sessionFactory.openSession();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        java.util.Date utilDate=new Date();
        String updateBlog = "update BlogBean b set b.blogContent='"+blogContent+"',b.blogDate='"+dateFormat.format(utilDate)+"' where b.blogID="+blogID;
        Transaction transaction = session.beginTransaction();
        int isUpdated = session.createQuery(updateBlog).executeUpdate();
        if (isUpdated == 1)
            transaction.commit();
        session.close();
    }

    @Override
    public BlogBean getBlogDetailsByBlogID(int operateBlogID) {
        Session session = sessionFactory.openSession();
        BlogBean blogBean = new BlogBean();
        blogBean = (BlogBean) session.createQuery("from BlogBean b where b.blogID="+operateBlogID).uniqueResult();
        String updateClickTime = "update BlogBean b set b.blogClickTimes=b.blogClickTimes+1 where b.blogID="+operateBlogID;
        Transaction transaction = session.beginTransaction();
        session.createQuery(updateClickTime).executeUpdate();
        transaction.commit();
        session.close();
        return blogBean;
    }



}
