package com.yangmj.bean;

import java.util.Set;

public class DomainBean {

    private String domainDetial;
    private String domainFeature_1;
    private String domainFeature_2;
    private String domainFeature_3;
    private String domainFeature_4;
    private int domainID;

    private Set<DomainDNSBean> domainDNSBeanSet;

    public DomainBean() {
    }

    public DomainBean(String domainDetial, String domainFeature_1, String domainFeature_2, String domainFeature_3, String domainFeature_4, int domainID, Set<DomainDNSBean> domainDNSBeanSet) {
        this.domainDetial = domainDetial;
        this.domainFeature_1 = domainFeature_1;
        this.domainFeature_2 = domainFeature_2;
        this.domainFeature_3 = domainFeature_3;
        this.domainFeature_4 = domainFeature_4;
        this.domainID = domainID;
        this.domainDNSBeanSet = domainDNSBeanSet;
    }

    public String getDomainDetial() {
        return domainDetial;
    }

    public void setDomainDetial(String domainDetial) {
        this.domainDetial = domainDetial;
    }

    public String getDomainFeature_1() {
        return domainFeature_1;
    }

    public void setDomainFeature_1(String domainFeature_1) {
        this.domainFeature_1 = domainFeature_1;
    }

    public String getDomainFeature_2() {
        return domainFeature_2;
    }

    public void setDomainFeature_2(String domainFeature_2) {
        this.domainFeature_2 = domainFeature_2;
    }

    public String getDomainFeature_3() {
        return domainFeature_3;
    }

    public void setDomainFeature_3(String domainFeature_3) {
        this.domainFeature_3 = domainFeature_3;
    }

    public String getDomainFeature_4() {
        return domainFeature_4;
    }

    public void setDomainFeature_4(String domainFeature_4) {
        this.domainFeature_4 = domainFeature_4;
    }

    public int getDomainID() {
        return domainID;
    }

    public void setDomainID(int domainID) {
        this.domainID = domainID;
    }

    public Set<DomainDNSBean> getDomainDNSBeanSet() {
        return domainDNSBeanSet;
    }

    public void setDomainDNSBeanSet(Set<DomainDNSBean> domainDNSBeanSet) {
        this.domainDNSBeanSet = domainDNSBeanSet;
    }

    public String toString(){
        return "DomainDetails:"+domainDetial+". DomainID:"+domainID;
    }
}
