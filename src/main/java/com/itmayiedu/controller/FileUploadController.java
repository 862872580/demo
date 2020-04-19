package com.itmayiedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FileUploadController {

    @PostMapping(value = "/fileUpload")
    public String fileUpload(MultipartFile[] imgs) throws IOException {
        String path = Thread.currentThread().getContextClassLoader().getResource("").getPath()+"static/imgs";
        System.out.println(path);
        for(MultipartFile img : imgs) {
            if (img.getSize() > 0) {
                //获取到上传文件的原始名称
                String fileName = img.getOriginalFilename();
                if (fileName.endsWith("jpg") || fileName.endsWith("png")) {
                    File file = new File(path, fileName);
                    img.transferTo(file);
                }
            }
        }
        return "welcome";
    }
}
