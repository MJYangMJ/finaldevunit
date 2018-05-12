//package com.yangmj.test;
//
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
//import javassist.ClassPath;
//import net.sf.json.*;
//
//
//public class Test {
//
//    public static void main(String[] args) {
//
//        List<String> subdomainList = new ArrayList<String>();
////        List<String> whoisList = new ArrayList<String>();
//
//        try {
//            FileReader fr = new FileReader("E:\\subdomains_file.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String str2 = br.readLine();
//            while (str2 != null) {
////                System.out.println(str2);
//                subdomainList.add(str2);
//                str2 = br.readLine();
//            }
//            br.close();
//            fr.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        JSONArray subdomainJson = JSONArray.fromObject(subdomainList);
//        System.out.println(subdomainJson.toString().getClass());
//
////
////        Iterator i = subdomainList.iterator();
////        while (i.hasNext()){
////            System.out.println(i.next());
////        }
////
////
////
////        List<String> whoisLookupList = new ArrayList<String>();
////
////
////        try {
////            FileReader fr = new FileReader("E:\\subdomains_file.txt");
////            BufferedReader br = new BufferedReader(fr);
////            String str2 = br.readLine();
////            while (str2 != null) {
//////                System.out.println(str2);
////                whoisLookupList.add(str2);
////                str2 = br.readLine();
////            }
////            br.close();
////            fr.close();
////        }catch (IOException e){
////            e.printStackTrace();
////        }
////
////        i = whoisLookupList.iterator();
////        while (i.hasNext()){
////            System.out.println(i.next());
////        }
//
//
//        List<List<String>> fileDetectionList = new ArrayList<>();
//
//
//
//        try {
//            FileReader fr = new FileReader("E:\\scan_result.txt");
//            BufferedReader br = new BufferedReader(fr);
//            String str2 = br.readLine();
//            while (str2 != null) {
////                System.out.println(str2);
//                fileDetectionList.add(splitResult(str2));
//                str2 = br.readLine();
//            }
//            br.close();
//            fr.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//
//        JSONArray fileDectionJson = JSONArray.fromObject(fileDetectionList);
////        System.out.println(fileDectionJson.toString());
//        for (int i=0;i<fileDectionJson.size();i++){
//            JSONArray tempJsonList = fileDectionJson.getJSONArray(i);
////            System.out.println(tempJsonList.toString());
//            System.out.println("engineName:" + tempJsonList.getString(0)
//                    + " tip:" + tempJsonList.getString(1)
//                    + " result:" + tempJsonList.getString(2));
//        }
//
////        Iterator i = null;
////        i = fileDetectionList.iterator();
////
////        while (i.hasNext()){
////            Iterator j = ((List<String>)i.next()).iterator();
////            while (j.hasNext()){
////                System.out.print(j.next());
////            }
////            System.out.println("");
////        }
//
//    }
//
//    public static List<String> splitResult(String strs){
//        List<String> strlist = new ArrayList<String>();
//        String strSplit[] = strs.split("\\|");
//        for (String str : strSplit){
////            System.out.println(str);
//            strlist.add(str);
//        }
//        return strlist;
//    }
//
//}
//
