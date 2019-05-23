package com.justech.luolesite.controller;

import com.justech.luolesite.entity.jsonEntity;
import com.justech.luolesite.service.fileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author: WangXiaoKun
 * @Date: 2019/4/18 9:49
 * 文件上传
 */
@Controller
@RequestMapping("/file/*")
public class fileController {

    private static long upload_maxsize = 800 * 1024 * 1024; //上传视频大小(800M)

    @Autowired
    private fileService fileService;

    @RequestMapping("/upload")
    @ResponseBody
    public jsonEntity fileUpload(@RequestParam("videoUpload") MultipartFile multipartFile, HttpServletRequest request){
             jsonEntity jsonEntity=new jsonEntity();

             if (multipartFile.getSize()!=0&&!multipartFile.isEmpty()){
                 String fileName=multipartFile.getOriginalFilename();
                 String fileSuffix=fileName.substring(fileName.lastIndexOf('.')).toLowerCase();
             if (!fileService.checkSuffix(fileSuffix)){
                 jsonEntity.failure("上传视频文件格式错误，请重新上传！");
                 return jsonEntity;
             }

             long fileSize=multipartFile.getSize();
             if (fileSize>upload_maxsize){
                 jsonEntity.failure("上传视频文件过大，请重新上传！");
                 return jsonEntity;
              }


             String videoUpload="/videoUpload/";
             String videoUploadPath=request.getSession().getServletContext().getRealPath(videoUpload);

             File file=new File(videoUpload);
             if (!file.exists()){
                file.mkdirs();//生成目录
             }

             String fileNewName= UUID.randomUUID().toString();
             String targetFileName=videoUpload+File.separator+fileNewName+fileSuffix;
             File targetFile=new File(targetFileName);

                 try {
                     multipartFile.transferTo(targetFile);
                     jsonEntity.success("视频上传成功！");
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             else {
                 jsonEntity.failure("请选择文件再上传！");
             }
             return jsonEntity;
    }



}
