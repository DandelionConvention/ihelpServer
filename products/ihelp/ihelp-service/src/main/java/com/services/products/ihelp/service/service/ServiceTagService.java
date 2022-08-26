package com.services.products.ihelp.service.service;

import com.services.core.util.CopyUtil;
import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.dao.domain.ServiceTagExample;
import com.services.products.ihelp.dao.mapper.ServiceTagMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceTagMapper;
import com.services.products.ihelp.dao.dto.UpdateServiceTagDTO;
import com.services.products.ihelp.service.exception.BusinessException;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServiceTagService
{
    @Resource
    private ServiceTagMapper serviceTagMapper;
    @Resource
    private MyServiceTagMapper myServiceTagMapper;

    public void saveServiceTag(ServiceTag serviceTag)
    {
        serviceTag.setCreateTime(LocalDateTime.now());
        serviceTag.setUpdateTime(LocalDateTime.now());
        serviceTag.setIsDeleted(false);
        serviceTagMapper.insert(serviceTag);
    }

    public void updateServiceTag(Integer id, UpdateServiceTagDTO requestDto)
    {
        if (requestDto.getName() != null)
        {
            if (myServiceTagMapper.nameExisted(requestDto.getName()) != null)
            {
                throw new BusinessException(BusinessExceptionCode.NAME_EXISTED);
            }
        }
        ServiceTag serviceTag = CopyUtil.copy(requestDto, ServiceTag.class);
        if (requestDto.getIsUsed() != null) {
            serviceTag.setIsUsed(requestDto.getIsUsed());
        }
        serviceTag.setId(id);
        serviceTag.setUpdateTime(LocalDateTime.now());
        serviceTagMapper.updateByPrimaryKeySelective(serviceTag);
    }

    public void deleteServiceTag(Integer id)
    {
        ServiceTag serviceTag = new ServiceTag();
        serviceTag.setId(id);
        serviceTag.setIsDeleted(true);
        serviceTag.setUpdateTime(LocalDateTime.now());
        serviceTagMapper.updateByPrimaryKeySelective(serviceTag);
    }

    public List<ServiceTag> list()
    {
        ServiceTagExample serviceTagExample = new ServiceTagExample();
        ServiceTagExample.Criteria criteria = serviceTagExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        return serviceTagMapper.selectByExample(serviceTagExample);
    }
}
