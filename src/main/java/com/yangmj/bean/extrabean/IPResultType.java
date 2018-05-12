package com.yangmj.bean.extrabean;

import com.yangmj.bean.IPBean;
import com.yangmj.bean.IPDNSBean;
import com.yangmj.bean.IPURLBean;

import java.util.List;


public class IPResultType {

    private IPBean ipBean;
    private List<IPDNSBean> ipdnsBeanList;
    private List<IPURLBean> ipurlBeanList;

    public IPResultType() {
    }

    public IPResultType(IPBean ipBean, List<IPDNSBean> ipdnsBeanList, List<IPURLBean> ipurlBeanList) {
        this.ipBean = ipBean;
        this.ipdnsBeanList = ipdnsBeanList;
        this.ipurlBeanList = ipurlBeanList;
    }

    public IPBean getIpBean() {
        return ipBean;
    }

    public void setIpBean(IPBean ipBean) {
        this.ipBean = ipBean;
    }

    public List<IPDNSBean> getIpdnsBeanList() {
        return ipdnsBeanList;
    }

    public void setIpdnsBeanList(List<IPDNSBean> ipdnsBeanList) {
        this.ipdnsBeanList = ipdnsBeanList;
    }

    public List<IPURLBean> getIpurlBeanList() {
        return ipurlBeanList;
    }

    public void setIpurlBeanList(List<IPURLBean> ipurlBeanList) {
        this.ipurlBeanList = ipurlBeanList;
    }

}
