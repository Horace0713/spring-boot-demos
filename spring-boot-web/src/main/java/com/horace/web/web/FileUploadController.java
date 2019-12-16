package com.horace.web.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: Horace
 * @desc:
 * @project: spring-boot-demos
 * @create: 2019-12-16 23:07
 */
@RestController
@Slf4j
public class FileUploadController {

    /**
     *  访问 http://localhost:8080/upload.html
     * @param file
     * @param request
     * @return
     */
    @PostMapping("/upload")
    public String upload(MultipartFile file, HttpServletRequest request) {
        log.info("上传成功");
        return "上传成功";
    }
}
