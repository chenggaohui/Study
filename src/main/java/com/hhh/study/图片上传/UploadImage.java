package com.hhh.study.图片上传;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

@Controller
@RequestMapping("/uploadAndDown")
public class UploadImage {


    @RequestMapping("/uploadImg")
    public void upload(HttpServletRequest request , HttpServletResponse response) throws JSONException, IOException {

        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        JSONObject json = new JSONObject();

        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {
                MultipartFile file = multiRequest.getFile((String) iter.next());
                if (file != null){
                        //上传奖品图片
                        String nameSuffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
                        String pathHead = request.getSession().getServletContext().getRealPath("/")+"images/";
                        File fileHead = new File(pathHead);
                        if(!fileHead .exists() && !fileHead .isDirectory()) {
                            try {
                                fileHead.mkdir();
                            } catch (Exception e) {
                                e.getStackTrace();
                                json.put("status_code", "1");
                                json.put("error", "保存路径文件夹创建异常!");
                            }
                        }
                        //  下面的加的日期是为了防止上传的名字一样
                        String endPath = "prize"+new SimpleDateFormat("yyyyMMdd").format(new Date()) + System.currentTimeMillis()+nameSuffix;
                        String path = pathHead+ endPath;
                        File localFile = new File(path);
                        file.transferTo(localFile);
                        try {
                            json.put("status_code", "0");
                            json.put("imgurl", "images/"+endPath);
                        } catch (Exception e) {
                            json.put("status_code", "1");
                            json.put("error", "头像修改失败");
                        }
                }
                else{
                    json.put("status_code", "1");
                    json.put("error", "上传不能为空");
                }
            }
        }
        else{
            json.put("status_code", "1");
            json.put("error", "文件上传方式有误");
        }
    }
}
