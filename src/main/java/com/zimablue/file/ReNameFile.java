package com.zimablue.file;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @version : 1.0
 * @auther : 齐马的作品
 * @date : 2020/10/29 23:02
 * @description:
 */

public class ReNameFile {

    @Test
    public void ReNameFile() {
        String path = "E:\\拉钩java\\01 第一阶段 开源框架源码剖析\\模块一 持久层框架设计实现及MyBatis源码分析\\01 录播\\任务三：MyBatis源码剖析";
        String order = "3";
        ArrayList<String> listFileName = new ArrayList<String>();

        getAllFileName(path, listFileName);

        for (String name : listFileName) {
            System.out.println(name);
            renameFile(path, name, order);
        }
    }

    private void renameFile(String filePath, String fileName, String order) {
        String oldFileName = fileName;
        File oldFile = new File(oldFileName);
        String[] split = fileName.split("\\\\");
        String newFileName = filePath + "\\" + order + "-" + split[split.length-1];
        File newFile = new File(newFileName);
        if (oldFile.exists() && oldFile.isFile()) {
            oldFile.renameTo(newFile);
        }
    }

    private void getAllFileName(String path, ArrayList<String> listFileName) {
        File file = new File(path);
        File[] files = file.listFiles();
        String[] names = file.list();

        if (names != null) {
            String[] completNames = new String[names.length];
            for (int i = 0; i < names.length; i++) {
                completNames[i] = path + "\\" + names[i];
            }
            listFileName.addAll(Arrays.asList(completNames));
        }
    }

}
