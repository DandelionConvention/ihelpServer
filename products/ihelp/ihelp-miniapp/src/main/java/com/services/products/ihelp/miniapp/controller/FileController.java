package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.service.FileService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/file")
@Validated
public class FileController
{
    public static final String BUSINESS_NAME = "小程序 -> 文件上传";
    private final FileService fileService;

    public FileController(FileService fileService)
    {
        this.fileService = fileService;
    }

    /**
     * 上传文件
     *
     * @param file 文件
     * @param use 用途
     * @param session
     * @return
     */
    @PostMapping("/upload")
    public ResponseVO upload(@RequestParam(value = "file") MultipartFile file,
                             @NotEmpty(message = "用途不能为空") @RequestParam(value = "use") String use,
                             @RequestHeader(value = "session") String session)
    {
        return fileService.upload(file, use, session);
    }
}
