package com.yangmj.service;

import com.yangmj.bean.UserBean;

import java.util.List;

public interface UserService {


    boolean findUserByUsername(String name);
    boolean saveUser(String name,String pwd);
    List<UserBean> getAllUsers();
    boolean updateUserInfo(String name, String pwd,String old_name);
    boolean checkUserInputValue(String name, String pwd);
    UserBean getUserBeanByUsername(String name);

}
