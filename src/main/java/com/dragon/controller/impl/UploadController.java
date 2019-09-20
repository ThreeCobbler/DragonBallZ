package com.dragon.controller.impl;

import com.dragon.common.dto.BaseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author ljn
 * @date 2019/9/20.
 */
@RestController
public class UploadController {

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 上传文件
     * @param uploadFile
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public BaseResponse uploadFile(MultipartFile uploadFile, HttpServletRequest request) {
        BaseResponse response = new BaseResponse();
        try{
            String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
            String format = sdf.format(new Date());
            File file = new File(realPath + format);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
            String oldName = uploadFile.getOriginalFilename();
            String newName = UUID.randomUUID().toString().replaceAll("-", "") + oldName.substring(oldName.lastIndexOf("."), oldName.length());
            uploadFile.transferTo(new File(file, newName));
            String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newName;
            response.setResult(filePath);
            return response;
        }catch (Exception e) {
            e.printStackTrace();
            response.setResult("上传失败");
        }
        return response;
    }
}
