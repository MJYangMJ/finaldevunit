package com.yangmj.dao.impl;

import com.yangmj.dao.BlogDAO;
import org.hibernate.SessionFactory;

public class BlogDAOImpl implements BlogDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
