package com.yangmj.dao.impl;

import com.yangmj.bean.LevelBean;
import com.yangmj.bean.UserBean;
import com.yangmj.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

//    private HibernateTemplate hibernateTemplate;
//
//    public HibernateTemplate getHibernateTemplate() {
//        return hibernateTemplate;
//    }
//
//    public void setHibernateTemplate(SessionFactory sessionFactory) {
//        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
//    }

    @Override
    public boolean findUserByUsername(String name) {
        Session session = sessionFactory.openSession();
        String hql = "from UserBean u where u.userName='"+name+"'";
        Query query = session.createQuery(hql);
        if (query.list().size() != 0) {
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    @Override
    public boolean saveUser(String name, String pwd) {
        LevelBean levelBean = new LevelBean();
        levelBean.setLevelID(2);
        UserBean userBean = new UserBean(name, pwd, levelBean);
        Session session = sessionFactory.openSession();
        session.save(userBean);
        if (checkUserInputValue(name, pwd)) {
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    @Override
    public List<UserBean> getAllUsers() {
        Session session = sessionFactory.openSession();
        List<UserBean> userBeanList = new ArrayList<>();
        userBeanList = (List<UserBean>) session.createQuery("from UserBean").list();
        session.close();
        return userBeanList;
    }

//    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public boolean updateUserInfo(String name, String pwd, String old_name) {
        if (!findUserByUsername(name)){
            return false;
        }
        else {
            int id = getUserBeanID(old_name);
            System.out.println("old_name id is:"+id);
            String hql_update = "update UserBean u set u.userName='"+name+"', " +
                                "u.userPwd='"+pwd+"' where u.userID="+id;

//            HibernateTemplate template = new HibernateTemplate(this.sessionFactory);
//            template.update();

            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery(hql_update);
            query.executeUpdate();
            transaction.commit();
            session.close();
            if (checkUserInputValue(name,pwd))
                return true;
            else
                return false;
        }
    }

    @Override
    public boolean checkUserInputValue(String name, String pwd) {
        Session session = sessionFactory.openSession();
        String hql = "from UserBean u where u.userName='"+name+"' and u.userPwd='"+pwd+"'";
        Query query = session.createQuery(hql);
        if (query.list().size() != 0) {
            session.close();
            return true;
        } else {
            session.close();
            return false;
        }
    }

    @Override
    public UserBean getUserBeanByUsername(String name) {
        Session session = sessionFactory.openSession();
        UserBean userBean = (UserBean) session.createQuery("from UserBean u" +
                " where u.userName='"+name+"'").uniqueResult();
        session.close();
        return userBean;
    }

    private int getUserBeanID(String name){
        Session session = sessionFactory.openSession();
        int userID = (int) session.createQuery("select u.userID from UserBean u" +
                        " where u.userName='"+name+"'").uniqueResult();
        session.close();
        return userID;

    }
}
