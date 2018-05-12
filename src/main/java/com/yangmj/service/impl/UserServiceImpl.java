package com.yangmj.service.impl;

import com.opensymphony.xwork2.ActionSupport;
import com.yangmj.bean.UserBean;
import com.yangmj.dao.impl.UserDAOImpl;
import com.yangmj.service.UserService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//@Service
public class UserServiceImpl extends ActionSupport implements UserService {

    private UserDAOImpl userDAO;

    public void setUserDAO(UserDAOImpl userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean findUserByUsername(String name) {
        return userDAO.findUserByUsername(name);
    }

    @Override
    public boolean saveUser(String name, String pwd) {
        return userDAO.saveUser(name,pwd);
    }

    @Override
    public List<UserBean> getAllUsers() {
        return userDAO.getAllUsers();
    }

//    @Transactional(propagation = Propagation.REQUIRED,value="transactionManager")
    @Override
    public boolean updateUserInfo(String name, String pwd, String old_name) {
        return userDAO.updateUserInfo(name,pwd,old_name);
    }

    @Override
    public boolean checkUserInputValue(String name, String pwd) {
        return userDAO.checkUserInputValue(name,pwd);
    }

    @Override
    public UserBean getUserBeanByUsername(String name) {
        return userDAO.getUserBeanByUsername(name);
    }
}
