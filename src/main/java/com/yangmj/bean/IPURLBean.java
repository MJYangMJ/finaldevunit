package com.yangmj.bean;

import java.util.Date;

public class IPURLBean {

    private Date IPURLDateScanned;
    private String IPURLDetection;
    private String IPURLDetail;
    private int IPURLID;

    private IPBean ipBean;

    public IPURLBean() {
    }

    public IPURLBean(Date IPURLDateScanned, String IPURLDetection, String IPURLDetail, int IPURLID, IPBean ipBean) {
        this.IPURLDateScanned = IPURLDateScanned;
        this.IPURLDetection = IPURLDetection;
        this.IPURLDetail = IPURLDetail;
        this.IPURLID = IPURLID;
        this.ipBean = ipBean;
    }

    public Date getIPURLDateScanned() {
        return IPURLDateScanned;
    }

    public void setIPURLDateScanned(Date IPURLDateScanned) {
        this.IPURLDateScanned = IPURLDateScanned;
    }

    public String getIPURLDetection() {
        return IPURLDetection;
    }

    public void setIPURLDetection(String IPURLDetection) {
        this.IPURLDetection = IPURLDetection;
    }

    public String getIPURLDetail() {
        return IPURLDetail;
    }

    public void setIPURLDetail(String IPURLDetail) {
        this.IPURLDetail = IPURLDetail;
    }

    public int getIPURLID() {
        return IPURLID;
    }

    public void setIPURLID(int IPURLID) {
        this.IPURLID = IPURLID;
    }

    public IPBean getIpBean() {
        return ipBean;
    }

    public void setIpBean(IPBean ipBean) {
        this.ipBean = ipBean;
    }

    public String toString(){
        return "IPURLID:"+IPURLID+". IPURLDetails:"+IPURLDetail;
    }

}
