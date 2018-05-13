package com.yangmj.action;

import com.opensymphony.xwork2.ActionSupport;
import com.yangmj.bean.extrabean.DomainResultType;
import com.yangmj.bean.extrabean.FileResultType;
import com.yangmj.bean.extrabean.IPResultType;
import com.yangmj.service.impl.SearchServiceImpl;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.opensymphony.xwork2.ModelDriven;

//public class SearchVirusAction extends ActionSupport implements ModelDriven<FileResultType> {
public class SearchVirusAction extends ActionSupport{

    private SearchServiceImpl searchService;

    public void setSearchService(SearchServiceImpl searchService) {
        this.searchService = searchService;
    }

    private FileResultType fileResultType = new FileResultType();
    private IPResultType ipResultType = new IPResultType();
    private DomainResultType domainResultType = new DomainResultType();

    public FileResultType getFileResultType() {
        return fileResultType;
    }

    public void setFileResultType(FileResultType fileResultType) {
        this.fileResultType = fileResultType;
    }

    public IPResultType getIpResultType() {
        return ipResultType;
    }

    public void setIpResultType(IPResultType ipResultType) {
        this.ipResultType = ipResultType;
    }

    public DomainResultType getDomainResultType() {
        return domainResultType;
    }

    public void setDomainResultType(DomainResultType domainResultType) {
        this.domainResultType = domainResultType;
    }

    //    @Override
//    public FileResultType getModel() {
//        return fileResultType;
//    }

    private int searchMode;
    private String searchDetail;

    public int getSearchMode() {
        return searchMode;
    }

    public void setSearchMode(int searchMode) {
        this.searchMode = searchMode;
    }

    public String getSearchDetail() {
        return searchDetail;
    }

    public void setSearchDetail(String searchDetail) {
        this.searchDetail = searchDetail;
    }

    private String runPythonFile(int searchMode, String valueInput) {
        String executeResult = "-1";
        try {
            String[] filesList = {"E:\\ip_mode_py.py", "E:\\domain_mode_py.py", "E:\\file_mode_py.py"};
            String[] args1 = new String[]{"C:\\python36\\python", filesList[searchMode], valueInput};
            Process pr = Runtime.getRuntime().exec(args1);
            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            executeResult = in.readLine();
            in.close();
            pr.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("executeResult:"+executeResult);
        return executeResult;
    }

    public String searchAction() {
        String pythonFileExecResult = runPythonFile(searchMode, searchDetail);
        try {
            if (!pythonFileExecResult.equals("0"))
                return "NOMATCHED";
            else {
                switch (searchMode) {
                    case 0:
                        ipResultType = searchService.searchIPAddress(searchDetail);
                        return "MATCHED";
                    case 1:
                        domainResultType = searchService.searchDomain(searchDetail);
                        return "MATCHED";
                    case 2:
                        fileResultType = searchService.searchFile(searchDetail);
                        return "MATCHED";
                    default:
                        return "NOMATCHED";
                }
            }
        } catch (Exception e){
            return "NOMATCHED";
        }
    }


    public String TestAction(){

        searchMode = 1;
//        fileResultType = searchService.searchFile("a47c9a335eda1860e476e5d926a164ed8dcec3189eb83e32357726fff7a6fd9b");
//        System.out.println("searchMode:"+searchMode);
//        ipResultType = searchService.searchIPAddress("192.168.1.1");
//        domainResultType = searchService.searchDomain("baidu.com");
        return "success";
    }

}
