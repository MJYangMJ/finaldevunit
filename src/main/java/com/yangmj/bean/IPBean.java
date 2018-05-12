package com.yangmj.bean;

import java.util.Set;

public class IPBean {

    private String IPAddress;
    private String IPCountry;
    private String IPAutonomousSystem;
    private String IPNotes;
    private int IPID;

    private Set<IPDNSBean> ipdnsBeanSet;
    private Set<IPURLBean> ipurlBeanSet;

    public IPBean() {
    }

    public IPBean(String IPAddress, String IPCountry, String IPAutonomousSystem, String IPNotes, int IPID, Set<IPDNSBean> ipdnsBeanSet, Set<IPURLBean> ipurlBeanSet) {
        this.IPAddress = IPAddress;
        this.IPCountry = IPCountry;
        this.IPAutonomousSystem = IPAutonomousSystem;
        this.IPNotes = IPNotes;
        this.IPID = IPID;
        this.ipdnsBeanSet = ipdnsBeanSet;
        this.ipurlBeanSet = ipurlBeanSet;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public String getIPCountry() {
        return IPCountry;
    }

    public void setIPCountry(String IPCountry) {
        this.IPCountry = IPCountry;
    }

    public String getIPAutonomousSystem() {
        return IPAutonomousSystem;
    }

    public void setIPAutonomousSystem(String IPAutonomousSystem) {
        this.IPAutonomousSystem = IPAutonomousSystem;
    }

    public String getIPNotes() {
        return IPNotes;
    }

    public void setIPNotes(String IPNotes) {
        this.IPNotes = IPNotes;
    }

    public int getIPID() {
        return IPID;
    }

    public void setIPID(int IPID) {
        this.IPID = IPID;
    }

    public Set<IPDNSBean> getIpdnsBeanSet() {
        return ipdnsBeanSet;
    }

    public void setIpdnsBeanSet(Set<IPDNSBean> ipdnsBeanSet) {
        this.ipdnsBeanSet = ipdnsBeanSet;
    }

    public Set<IPURLBean> getIpurlBeanSet() {
        return ipurlBeanSet;
    }

    public void setIpurlBeanSet(Set<IPURLBean> ipurlBeanSet) {
        this.ipurlBeanSet = ipurlBeanSet;
    }

    public String toString(){
        return "IP_ID:"+IPID+". IPAddress"+IPAddress+".";
    }

}
