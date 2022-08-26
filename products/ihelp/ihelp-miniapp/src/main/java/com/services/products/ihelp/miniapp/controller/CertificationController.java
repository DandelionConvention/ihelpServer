package com.services.products.ihelp.miniapp.controller;

import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.service.CertificationService;
import com.services.products.ihelp.dao.dto.CertificationDTO;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/certification")
public class CertificationController
{
    public static final String BUSINESS_NAME = "小程序 -> 实名认证";
    private final CertificationService certificationService;

    public CertificationController(CertificationService certificationService)
    {
        this.certificationService = certificationService;
    }

    /**
     * 实名认证
     *
     * @param session
     * @param certificationDTO
     * @return
     */
    @PostMapping
    public ResponseVO certification(@RequestHeader("session") String session,
                                    @Validated @RequestBody CertificationDTO certificationDTO)
    {

        return certificationService.certification(session, certificationDTO);
    }
}