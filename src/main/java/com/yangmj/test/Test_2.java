package com.yangmj.test;

import com.yangmj.bean.BlogBean;
import com.yangmj.dao.impl.BlogDAOImpl;
import com.yangmj.dao.impl.UserDAOImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test_2 {

    public static void main(String[] args) {
        java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
//        SimpleDateFormat bartDateFormat = new SimpleDateFormat
//                ("EEEE-MMMM-dd-yyyy");
//        System.out.println(bartDateFormat.format(date));
        System.out.println(date);

        SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        java.util.Date utilDate=new Date();
        java.sql.Date sqlDate=new java.sql.Date(utilDate.getTime());
        java.sql.Time sTime=new java.sql.Time(utilDate.getTime());
        java.sql.Timestamp stp=new java.sql.Timestamp(utilDate.getTime());
        System.out.println(utilDate.getYear());

        System.out.println(f.format(utilDate));
        System.out.println(f.format(sqlDate));

        UserDAOImpl userDAO = new UserDAOImpl();
        BlogDAOImpl blogDAO = new BlogDAOImpl();
        BlogBean blogBean = new BlogBean("test","2018-05-12 09:41:29",1,"test???",userDAO.getUserBeanByUsername("yangmj"));


    }


}
