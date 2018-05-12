package com.yangmj.dao.impl;

import com.yangmj.bean.*;
import com.yangmj.bean.extrabean.DomainResultType;
import com.yangmj.bean.extrabean.FileResultType;
import com.yangmj.bean.extrabean.IPResultType;
import com.yangmj.dao.SearchDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.io.*;
import java.util.*;

public class SearchDAOImpl implements SearchDAO {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public static Boolean isDomainSubdomainTextDone = false;
    public static Boolean isDomainWhoisTextDone = false;
    private static Boolean isFileTxtDone = false;

    @Override
    public IPResultType searchIPAddress(String IPAddress) {
        IPBean ipBean;
        List<IPDNSBean> ipdnsBeanList = new ArrayList<>();
        List<IPURLBean> ipurlBeanList = new ArrayList<>();
        Session session = sessionFactory.openSession();

        String ip_hql = "from IPBean i where i.IPAddress='"+IPAddress+"'";
        Query ip_query = sessionFactory.openSession().createQuery(ip_hql);
        ipBean = (IPBean) ip_query.list().get(0);

        String ip_dns_hql = "from IPDNSBean i where i.ipBean.IPID="+ipBean.getIPID();
        Query ip_dns_query = sessionFactory.openSession().createQuery(ip_dns_hql);
        ipdnsBeanList = ip_dns_query.list();

        String ip_url_hql = "from IPURLBean i where i.ipBean.IPID="+ipBean.getIPID();
        Query ip_url_query = sessionFactory.openSession().createQuery(ip_url_hql);
        ipurlBeanList = ip_url_query.list();
        
        return new IPResultType(ipBean,ipdnsBeanList,ipurlBeanList);
    }

    @Override
    public DomainResultType searchDomain(String domainAddress) {
        DomainBean domainBean;
        List<DomainDNSBean> domainDNSBeanList = new ArrayList<>();
        final List<String> domainSubdomainList = new ArrayList<>();
        final List<String> domainWhoisList = new ArrayList<>();
        Session session = sessionFactory.openSession();

        new Thread(new Runnable(){
            public void run(){
                try {
                    FileReader fr = new FileReader("E:\\subdomains_file.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String str = br.readLine();
                    while (str != null) {
                        domainSubdomainList.add(str);
                        str = br.readLine();
                    }
                    br.close();
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                isDomainSubdomainTextDone = true;
            }
        }).start();

        new Thread(new Runnable(){
            public void run(){
                try {
                    FileReader fr = new FileReader("E:\\whois_file.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String str = br.readLine();
                    while (str != null) {
                        domainWhoisList.add(str);
                        str = br.readLine();
                    }
                    br.close();
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                isDomainWhoisTextDone = true;
            }
        }).start();

        String domain_hql = "from DomainBean d where d.domainDetial='"+domainAddress+"'";
        Query ip_query = session.createQuery(domain_hql);
        domainBean = (DomainBean) ip_query.list().get(0);

        String domain_dns_hql = "from DomainDNSBean d where d.domainBean.domainID="+domainBean.getDomainID();
        Query domain_dns_query = session.createQuery(domain_dns_hql);
        domainDNSBeanList = domain_dns_query.list();

        session.close();
        while(!isDomainSubdomainTextDone){}
        while(!isDomainWhoisTextDone){}

        return new DomainResultType(domainBean,domainDNSBeanList,domainSubdomainList,domainWhoisList);
    }

    @Override
    public FileResultType searchFile(String fileSHAValue) {
        FileResultType fileResultType = new FileResultType();
        FileBean fileBean = new FileBean();
        final List<List<String>> fileDetectionLists = new ArrayList<>();
        Session session = sessionFactory.openSession();

        new Thread(new Runnable(){
            public void run(){
                try {
                    FileReader fr = new FileReader("E:\\scan_result.txt");
                    BufferedReader br = new BufferedReader(fr);
                    String str2 = br.readLine();
                    while (str2 != null) {
                        fileDetectionLists.add(splitResult(str2));
                        str2 = br.readLine();
                    }
                    br.close();
                    fr.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
                isFileTxtDone = true;
            }
        }).start();

        String hql = "from FileBean f where f.file='"+fileSHAValue+"'";
        Query query = session.createQuery(hql);
        fileBean = (FileBean) query.list().get(0);
        session.close();
        while(!isFileTxtDone){}
        return new FileResultType(fileBean,fileDetectionLists);
    }

    private static List<String> splitResult(String strs){
        List<String> strList = new ArrayList<>();
        String strSplit[] = strs.split("\\|");
        for (String str : strSplit){
            strList.add(str);
        }
        return strList;
    }

}