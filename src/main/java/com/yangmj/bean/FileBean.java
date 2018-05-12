package com.yangmj.bean;

public class FileBean {

    private String file;
    private String fileName;
    private String fileSize;
    private String fileLastAnalysis;
    private int fileID;

    public FileBean() {
    }

    public FileBean(String file, String fileName, String fileSize, String fileLastAnalysis, int fileID) {
        this.file = file;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.fileLastAnalysis = fileLastAnalysis;
        this.fileID = fileID;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileLastAnalysis() {
        return fileLastAnalysis;
    }

    public void setFileLastAnalysis(String fileLastAnalysis) {
        this.fileLastAnalysis = fileLastAnalysis;
    }

    public int getFileID() {
        return fileID;
    }

    public void setFileID(int fileID) {
        this.fileID = fileID;
    }

    public String toString(){
        return "file:"+file+". fileName:"+fileName+". fileID:"+fileID+".";
    }
}
