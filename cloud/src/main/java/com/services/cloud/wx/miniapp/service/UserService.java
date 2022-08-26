package com.services.cloud.wx.miniapp.service;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.binarywang.wx.miniapp.bean.WxMaUserInfo;
import com.services.cloud.exception.BusinessExceptionCode;
import com.services.core.bo.weixin.miniapp.Code2SessionResponseBO;
import com.services.core.bo.weixin.miniapp.GetUserInfoRquestBO;
import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final WxMaService wxMaService;

    public UserService(WxMaService wxMaService)
    {
        this.wxMaService = wxMaService;
    }

    public ResponseVO getSessionInfo(String code)
    {
        try
        {
            WxMaJscode2SessionResult wxMaJscode2SessionResult = wxMaService.getUserService().getSessionInfo(code);
            return new ResponseVO(CopyUtil.copy(wxMaJscode2SessionResult, Code2SessionResponseBO.class));
        } catch (WxErrorException e)
        {
            throw BusinessExceptionCode.WX_ERROR.exception(e);
        }
    }

    public ResponseVO getUserInfo(GetUserInfoRquestBO getUserInfoRquestBO)
    {
        boolean signatureInvalid = !wxMaService.getUserService().checkUserInfo(getUserInfoRquestBO.getSessionKey(),
                getUserInfoRquestBO.getRawData(), getUserInfoRquestBO.getSignature());
        if (signatureInvalid)
        {
            BusinessExceptionCode.WX_ERROR.throwException();
        }
        WxMaUserInfo wxMaUserInfo = wxMaService.getUserService().getUserInfo(getUserInfoRquestBO.getSessionKey(),
                getUserInfoRquestBO.getEncryptedData(), getUserInfoRquestBO.getIv());
        return new ResponseVO(wxMaUserInfo);
    }
}
