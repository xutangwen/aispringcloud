package com.southwind;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mytest {
    public static void main(String[] args) {
//        List<String> fileList = null;
//        File file = new File("d:/王瑞雪");
//        String[] files = file.list(new FilenameFilter() {
//            @Override
//            public boolean accept(File dir, String name) {
//                File f = new File(dir, name);
//                return f.isFile() && f.getName().endsWith(".pdf");
//            }
//        });
//        if(file.exists()){
//            fileList = Arrays.asList(files);
//        }else{
//            new File("d:/王瑞雪").mkdirs();
//            fileList = new ArrayList<>();
//        }
//        System.out.println("size:"+fileList.size());
//        for (String s : fileList) {
//            System.out.println(s);
//        }
        final String s = testIf("2");
        System.out.println(s);

    }

    public static String testIf(String str) {
        if (str.equals("1") || str.equals("3")) {
            if(true){
                return "1--3";
            }
        }
        System.out.println("会执行吗？");
        if (str.equals("2") || str.equals("3")) {
            return "2---3";
        }
        return "xxx";
    }
}
