package com.yangmj.bean.extrabean;

import com.yangmj.bean.FileBean;

import java.util.List;

public class FileResultType {

    private FileBean fileBean;
    private List<List<String>> fileDetectionLists;

    public FileResultType(){

    }

    public FileResultType(FileBean fileBean, List<List<String>> fileDetectionLists) {
        this.fileBean = fileBean;
        this.fileDetectionLists = fileDetectionLists;
    }

    public List<List<String>> getFileDetectionLists() {
        return fileDetectionLists;
    }

    public void setFileDetectionLists(List<List<String>> fileDetectionLists) {
        this.fileDetectionLists = fileDetectionLists;
    }

    public FileBean getFileBean() {

        return fileBean;
    }

    public void setFileBean(FileBean fileBean) {
        this.fileBean = fileBean;
    }
}
