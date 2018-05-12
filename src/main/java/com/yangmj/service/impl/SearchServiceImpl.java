package com.yangmj.service.impl;

import com.yangmj.bean.extrabean.DomainResultType;
import com.yangmj.bean.extrabean.FileResultType;
import com.yangmj.bean.extrabean.IPResultType;
import com.yangmj.dao.impl.SearchDAOImpl;
import com.yangmj.service.SearchService;

import java.util.List;
import java.util.Map;

public class SearchServiceImpl implements SearchService {

    private SearchDAOImpl searchDAO;

    public void setSearchDAO(SearchDAOImpl searchDAO) {
        this.searchDAO = searchDAO;
    }

    @Override
    public IPResultType searchIPAddress(String IPAddress) {

        return searchDAO.searchIPAddress(IPAddress);
    }

    @Override
    public DomainResultType searchDomain(String domainAddress) {
        return searchDAO.searchDomain(domainAddress);
    }

    @Override
    public FileResultType searchFile(String fileSHAValue) {
        return searchDAO.searchFile(fileSHAValue);
    }


}
