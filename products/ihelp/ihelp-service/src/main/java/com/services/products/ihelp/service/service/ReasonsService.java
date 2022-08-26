package com.services.products.ihelp.service.service;

import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.ServiceCancelReason;
import com.services.products.ihelp.dao.domain.ServiceCancelReasonExample;
import com.services.products.ihelp.dao.mapper.ServiceCancelReasonMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceCancelReasonMapper;
import com.services.products.ihelp.dao.dto.SaveServiceCancelReasonDTO;
import com.services.products.ihelp.dao.dto.UpdateServiceCancelReasonDTO;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;
import com.services.products.ihelp.service.vo.ListAllServiceCancelReasonVO;
import com.services.products.ihelp.service.vo.ListUsedServiceCancelReasonVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReasonsService
{
    @Resource
    private ServiceCancelReasonMapper serviceCancelReasonMapper;
    @Resource
    private MyServiceCancelReasonMapper myServiceCancelReasonMapper;

    @Transactional
    public ResponseVO saveServiceCancelReason(SaveServiceCancelReasonDTO saveServiceCancelReasonDTO) {
        nameCheck(saveServiceCancelReasonDTO.getName(), null);
        ServiceCancelReason serviceCancelReason = CopyUtil.copy(saveServiceCancelReasonDTO, ServiceCancelReason.class);
        serviceCancelReason.setCreateTime(LocalDateTime.now());
        serviceCancelReason.setUpdateTime(LocalDateTime.now());
        serviceCancelReason.setIsDeleted(false);
        serviceCancelReasonMapper.insert(serviceCancelReason);
        return listAllServiceCancelReasons();
    }

    public ResponseVO listAllServiceCancelReasons() {
        ListAllServiceCancelReasonVO listAllServiceCancelReasonVO = new ListAllServiceCancelReasonVO();
        return new ResponseVO(listAllServiceCancelReasonVO.copy(listServiceCancelReasons(null)));
    }

    public ResponseVO listUsedServiceCancelReasons() {
        ListUsedServiceCancelReasonVO listUsedServiceCancelReasonVO = new ListUsedServiceCancelReasonVO();
        return new ResponseVO(listUsedServiceCancelReasonVO.copy(listServiceCancelReasons(true)));
    }

    @Transactional
    public ResponseVO updateServiceCancelReason(Integer id, UpdateServiceCancelReasonDTO updateServiceCancelReasonDTO) {
        Optional<String> nameOptional = Optional.ofNullable(updateServiceCancelReasonDTO.getName());
        nameOptional.ifPresent((name) -> nameCheck(name, id));
        ServiceCancelReason serviceCancelReason =
                CopyUtil.copy(updateServiceCancelReasonDTO, ServiceCancelReason.class);
        serviceCancelReason.setId(id);
        serviceCancelReason.setUpdateTime(LocalDateTime.now());
        serviceCancelReasonMapper.updateByPrimaryKeySelective(serviceCancelReason);
        return listAllServiceCancelReasons();
    }

    public ResponseVO deleteServiceCancelReason(Integer id) {
        ServiceCancelReason serviceCancelReason = new ServiceCancelReason();
        serviceCancelReason.setId(id);
        serviceCancelReason.setIsDeleted(true);
        serviceCancelReason.setUpdateTime(LocalDateTime.now());
        serviceCancelReasonMapper.updateByPrimaryKeySelective(serviceCancelReason);
        return listAllServiceCancelReasons();
    }

    /**
     * 查询服务取消原因列表
     *
     * @param isUsed
     * @return
     */
    private List<ServiceCancelReason> listServiceCancelReasons(Boolean isUsed)
    {
        ServiceCancelReasonExample serviceCancelReasonExample = new ServiceCancelReasonExample();
        ServiceCancelReasonExample.Criteria criteria = serviceCancelReasonExample.createCriteria();
        criteria.andIsDeletedEqualTo(false);
        Optional<Boolean> isUsedOptional = Optional.ofNullable(isUsed);
        isUsedOptional.ifPresent(criteria::andIsUsedEqualTo);
        return serviceCancelReasonMapper.selectByExample(serviceCancelReasonExample);
    }

    /**
     * 检查名称是否存在
     *
     * @param name
     */
    private void nameCheck(String name, Integer id)
    {
        boolean nameExisted = myServiceCancelReasonMapper.nameExisted(name, id) != null;
        if (nameExisted)
        {
            BusinessExceptionCode.NAME_EXISTED.throwException();
        }
    }
}
