package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.dto.FaceRecognitionDTO;
import com.services.products.ihelp.service.service.FaceRecognitionService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/face-recognition")
public class FaceRecognitionController
{
    public static final String BUSINESS_NAME = "小程序 -> 人脸识别";
    private final FaceRecognitionService faceRecognitionService;

    public FaceRecognitionController(FaceRecognitionService faceRecognitionService)
    {
        this.faceRecognitionService = faceRecognitionService;
    }

    @PostMapping
    public ResponseVO faceRecognition(@Validated @RequestBody FaceRecognitionDTO faceRecognitionDTO)
    {
        return faceRecognitionService.faceRecognition(faceRecognitionDTO);
    }
}
