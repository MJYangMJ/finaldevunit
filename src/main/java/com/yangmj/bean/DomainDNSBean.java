package com.yangmj.bean;

import java.util.Date;

public class DomainDNSBean {

    private Date domainDNSDateResolved;
    private String domainDNSIPAddress;
    private int domainDNSReplicationID;

    private DomainBean domainBean;

    public DomainDNSBean() {
    }

    public DomainDNSBean(Date domainDNSDateResolved, String domainDNSIPAddress, int domainDNSReplicationID, DomainBean domainBean) {
        this.domainDNSDateResolved = domainDNSDateResolved;
        this.domainDNSIPAddress = domainDNSIPAddress;
        this.domainDNSReplicationID = domainDNSReplicationID;
        this.domainBean = domainBean;
    }

    public Date getDomainDNSDateResolved() {
        return domainDNSDateResolved;
    }

    public void setDomainDNSDateResolved(Date domainDNSDateResolved) {
        this.domainDNSDateResolved = domainDNSDateResolved;
    }

    public String getDomainDNSIPAddress() {
        return domainDNSIPAddress;
    }

    public void setDomainDNSIPAddress(String domainDNSIPAddress) {
        this.domainDNSIPAddress = domainDNSIPAddress;
    }

    public int getDomainDNSReplicationID() {
        return domainDNSReplicationID;
    }

    public void setDomainDNSReplicationID(int domainDNSReplicationID) {
        this.domainDNSReplicationID = domainDNSReplicationID;
    }

    public DomainBean getDomainBean() {
        return domainBean;
    }

    public void setDomainBean(DomainBean domainBean) {
        this.domainBean = domainBean;
    }

    public String toString(){
        return "DomainID:"+domainDNSReplicationID+". DomainDetails:"+domainDNSIPAddress+".";
    }
}