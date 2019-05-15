package com.justech.luolesite.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/18 10:52
 * 文件上传
 */
@Service
public class fileService {

    public boolean checkSuffix(String fileSuffix){
        String[] suffixs={".avi", ".mov", ".rmvb", ".rm",
                ".flv",  ".mp4", ".3gp",".wmv",".mpeg",".mkv","f4v"};//视频格式集合

        Iterator<String> suffixList= Arrays.asList(suffixs).iterator();
        while (suffixList.hasNext()){
            if (fileSuffix.equals(suffixList.next())){
                return true;
            }
        }
        return false;
    }

}
