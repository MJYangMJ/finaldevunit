package com.yangmj.service;

import com.yangmj.bean.extrabean.DomainResultType;
import com.yangmj.bean.extrabean.FileResultType;
import com.yangmj.bean.extrabean.IPResultType;


public interface SearchService {

    IPResultType searchIPAddress(String IPAddress);
    DomainResultType searchDomain(String domainAddress);
    FileResultType searchFile(String fileSHAValue);
}
