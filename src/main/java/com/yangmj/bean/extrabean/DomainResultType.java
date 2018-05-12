package com.yangmj.bean.extrabean;

import com.yangmj.bean.DomainBean;
import com.yangmj.bean.DomainDNSBean;

import java.util.List;

public class DomainResultType {

    private DomainBean domainBean;
    private List<DomainDNSBean> domainDNSBeanList;
    private List<String> domainSubdomainList;
    private List<String> domainWhoisList;

    public DomainResultType() {
    }

    public DomainResultType(DomainBean domainBean, List<DomainDNSBean> domainDNSBeanList, List<String> domainSubdomainList, List<String> domainWhoisList) {
        this.domainBean = domainBean;
        this.domainDNSBeanList = domainDNSBeanList;
        this.domainSubdomainList = domainSubdomainList;
        this.domainWhoisList = domainWhoisList;
    }

    public DomainBean getDomainBean() {
        return domainBean;
    }

    public void setDomainBean(DomainBean domainBean) {
        this.domainBean = domainBean;
    }

    public List<DomainDNSBean> getDomainDNSBeanList() {
        return domainDNSBeanList;
    }

    public void setDomainDNSBeanList(List<DomainDNSBean> domainDNSBeanList) {
        this.domainDNSBeanList = domainDNSBeanList;
    }

    public List<String> getDomainSubdomainList() {
        return domainSubdomainList;
    }

    public void setDomainSubdomainList(List<String> domainSubdomainList) {
        this.domainSubdomainList = domainSubdomainList;
    }

    public List<String> getDomainWhoisList() {
        return domainWhoisList;
    }

    public void setDomainWhoisList(List<String> domainWhoisList) {
        this.domainWhoisList = domainWhoisList;
    }
}
