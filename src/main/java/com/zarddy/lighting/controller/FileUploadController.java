package com.zarddy.lighting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * <a href="https://www.jianshu.com/p/7903b6ebe47f">第十一章：实现SpringBoot单个、多个文件的上传</a>
 */
@Controller
public class FileUploadController {

    @RequestMapping(value = "/fileupload", method = RequestMethod.GET)
    public String index() {
        return "fileupload";
    }

    /**
     * 上传单个文件
     * @param request
     * @param file 上传的文件，此处的 file 必须也前段页面中 input 的 name 相同
     * @return
     */
    @RequestMapping(value = "/uploadSingleFile", method = RequestMethod.POST)
    public @ResponseBody String uploadSingleFile(HttpServletRequest request, MultipartFile file) {
        try {
            // 上传目录路径
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                boolean mkdirState = dir.mkdir();
                if (!mkdirState) {
                    return "上传失败，存储目录创建失败";
                }
            }
            // 执行调用上传方法
            executeUpload(uploadDir, file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }

    /**
     * 上传多个文件
     * @param request
     * @param files 上传的文件，此处的files必须也前段页面中input的name相同
     * @return
     */
    @RequestMapping(value = "/uploadMultipartFiles", method = RequestMethod.POST)
    public @ResponseBody String uploadMultipartFiles(HttpServletRequest request, MultipartFile[] files) {
        try {
            // 上传目录路径
            String uploadDir = request.getSession().getServletContext().getRealPath("/") + "upload/";
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                boolean mkdirState = dir.mkdir();
                if (!mkdirState) {
                    return "上传失败，存储目录创建失败";
                }
            }
            // 遍历文件数组，执行上传
            for (MultipartFile file : files) {
                if (file == null || file.getOriginalFilename().isEmpty()) {
                    continue;
                }
                // 执行调用上传方法
                executeUpload(uploadDir, file);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "上传失败";
        }

        return "上传成功";
    }

    /**
     * 文件上传方法
     * @param uploadDir 保存所上传的文件目录
     * @param file 上传的文件对象
     * @throws IOException
     */
    private void executeUpload(String uploadDir, MultipartFile file) throws IOException {
        // 文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        // 上传文件名
        String filename = UUID.randomUUID() + suffix;
        // 服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        // 将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
