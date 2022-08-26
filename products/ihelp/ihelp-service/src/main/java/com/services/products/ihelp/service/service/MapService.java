package com.services.products.ihelp.service.service;

import com.services.cloud.api.ApiFeign;
import com.services.core.bo.tencent.lbs.CoordinateDetailResponseBO;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.service.vo.GetCoordinateDetailVO;
import org.springframework.stereotype.Service;

@Service
public class MapService
{
    private final ApiFeign apiFeign;

    public MapService(ApiFeign apiFeign)
    {
        this.apiFeign = apiFeign;
    }

    public ResponseVO getCoordinateDetail(String location)
    {
        return new ResponseVO(new GetCoordinateDetailVO().copy(
                ResponseVO.getData(apiFeign.getCoordinateDetail(location), CoordinateDetailResponseBO.class)));
    }
}
