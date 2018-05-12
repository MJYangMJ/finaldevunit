package com.yangmj.bean;

import java.util.Date;

public class IPDNSBean {

    private Date IPDNSDateResolved;
    private String IPDNSWebDomain;
    private int IPDNSReplicationID;

    private IPBean ipBean;

    public IPDNSBean() {
    }

    public IPDNSBean(Date IPDNSDateResolved, String IPDNSWebDomain, int IPDNSReplicationID, IPBean ipBean) {
        this.IPDNSDateResolved = IPDNSDateResolved;
        this.IPDNSWebDomain = IPDNSWebDomain;
        this.IPDNSReplicationID = IPDNSReplicationID;
        this.ipBean = ipBean;
    }

    public Date getIPDNSDateResolved() {
        return IPDNSDateResolved;
    }

    public void setIPDNSDateResolved(Date IPDNSDateResolved) {
        this.IPDNSDateResolved = IPDNSDateResolved;
    }

    public String getIPDNSWebDomain() {
        return IPDNSWebDomain;
    }

    public void setIPDNSWebDomain(String IPDNSWebDomain) {
        this.IPDNSWebDomain = IPDNSWebDomain;
    }

    public int getIPDNSReplicationID() {
        return IPDNSReplicationID;
    }

    public void setIPDNSReplicationID(int IPDNSReplicationID) {
        this.IPDNSReplicationID = IPDNSReplicationID;
    }

    public IPBean getIpBean() {
        return ipBean;
    }

    public void setIpBean(IPBean ipBean) {
        this.ipBean = ipBean;
    }

    public String toString(){
        return "IPDNSID:"+IPDNSReplicationID+". IPDNSDate:"+IPDNSDateResolved;
    }

}
