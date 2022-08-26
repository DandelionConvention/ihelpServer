package com.services.products.ihelp.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.services.core.util.CopyUtil;
import com.services.core.util.SnowFlakeUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.domain.ServiceApplication;
import com.services.products.ihelp.dao.domain.ServiceCancelApplication;
import com.services.products.ihelp.dao.domain.ServiceOrder;
import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.dto.CancelServiceOrderDTO;
import com.services.products.ihelp.dao.dto.ListOrdersDTO;
import com.services.products.ihelp.dao.mapper.ServiceApplicationMapper;
import com.services.products.ihelp.dao.mapper.ServiceCancelApplicationMapper;
import com.services.products.ihelp.dao.mapper.ServiceOrderMapper;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceApplicationMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceOrderMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceTagMapper;
import com.services.products.ihelp.dao.mapper.my.MyUserMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.service.enums.ServiceStatusEnum;
import com.services.products.ihelp.service.enums.UserTypeEnum;
import com.services.products.ihelp.service.util.RedisKeyUtil;
import com.services.products.ihelp.service.vo.ListOrdersVO;
import com.services.products.ihelp.service.vo.OrderDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersServices
{
    @Resource
    private UserMapper userMapper;
    @Resource
    private ServiceCancelApplicationMapper serviceCancelApplicationMapper;
    @Resource
    private ServiceOrderMapper serviceOrderMapper;
    @Resource
    private ServiceApplicationMapper serviceApplicationMapper;
    @Resource
    private MyServiceOrderMapper myServiceOrderMapper;
    @Resource
    private MyUserMapper myUserMapper;
    @Resource
    MyServiceApplicationMapper myServiceApplicationMapper;
    @Resource
    private MyServiceTagMapper myServiceTagMapper;
    private final BaseConfig baseConfig;

    public OrdersServices(BaseConfig baseConfig)
    {
        this.baseConfig = baseConfig;
    }

    @Transactional
    public ResponseVO cancelServiceOrder(CancelServiceOrderDTO requestDto)
    {
        ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(requestDto.getOrderId());
        User user = userMapper.selectByPrimaryKey(serviceOrder.getClientId());
        User user1 = new User();
        user1.setId(user.getId());
        // 退回老人的积分
        user1.setIntegral(user.getIntegral().add(serviceOrder.getIntegral()));
        userMapper.updateByPrimaryKeySelective(user1);
        // 服务订单表的状态改为已取消
        myServiceOrderMapper.updateServiceOrderStatusByOrderId(requestDto.getOrderId(),
                ServiceStatusEnum.CANCELED.num.byteValue());
        // 所有有关服务申请的状态改为已取消
        myServiceApplicationMapper.updateServiceApplicationStatusByOrderIdAndServiceStatusNum(
                requestDto.getOrderId(),
                ServiceStatusEnum.CANCELED.num.byteValue(),
                ServiceStatusEnum.CREATED.num.byteValue());
        ServiceCancelApplication serviceCancelApplication = new ServiceCancelApplication();
        serviceCancelApplication.setId(SnowFlakeUtil.nextId(System.currentTimeMillis()));
        serviceCancelApplication.setCreateTime(LocalDateTime.now());
        serviceCancelApplication.setDescription(requestDto.getDescription());
        serviceCancelApplication.setImages(requestDto.getImages().toString());
        serviceCancelApplication.setUpdateTime(LocalDateTime.now());
        serviceCancelApplication.setServiceId(requestDto.getOrderId());
        serviceCancelApplication.setId(SnowFlakeUtil.nextId(System.currentTimeMillis()));
        serviceCancelApplication.setServiceCancelReasonId(requestDto.getReasonId());
        serviceCancelApplicationMapper.insert(serviceCancelApplication);
        return new ResponseVO();
    }

    public ResponseVO listOrders(String session, ListOrdersDTO listOrdersDTO)
    {
        ResponseVO responseVO = new ResponseVO();
        ListOrdersVO listOrdersVO = new ListOrdersVO();
        List<ListOrdersVO.ListOrdersDto> listOrdersDtoList = new ArrayList<>();
        Long userId = RedisKeyUtil.getUserId(session);
        if (myUserMapper.selectUserRoleByUserId(userId) == UserTypeEnum.SERVANT.num.byteValue())
        {
            // 如果用户是服务者：
            List<ServiceOrder> serviceOrders = selectServiceOrderWithPageByServantIdAndStatus(userId, listOrdersDTO);
            for (ServiceOrder serviceOrder : serviceOrders)
            {
                ListOrdersVO.ListOrdersDto listOrdersDto = CopyUtil.copy(serviceOrder, ListOrdersVO.ListOrdersDto.class);
                // 根据订单数据查询老人信息
                User user = userMapper.selectByPrimaryKey(serviceOrder.getClientId());
                ListOrdersVO.ListOrdersDto.UserBean client = CopyUtil.copy(user, ListOrdersVO.ListOrdersDto.UserBean.class);
                client.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
                listOrdersDto.setUser(client);
                listOrdersDto.setState(ServiceStatusEnum.getNameByNum(serviceOrder.getServiceStatus().intValue()));
                listOrdersDtoList.add(listOrdersDto);
            }
            PageInfo<ServiceOrder> pageInfo = new PageInfo<>(serviceOrders);
            listOrdersVO.setPage(pageInfo.getPageNum());
            listOrdersVO.setPerPage(pageInfo.getPageSize());
            listOrdersVO.setList(listOrdersDtoList);
            listOrdersVO.setHasMore(pageInfo.isHasNextPage());
            responseVO.setData(listOrdersVO);
        } else if (myUserMapper.selectUserRoleByUserId(userId) == UserTypeEnum.CLIENT.num.byteValue())
        {
            // 如果用户是老人：
            List<ServiceOrder> serviceOrders = selectServiceOrderWithPageByClientIdAndStatus(userId, listOrdersDTO);
            for (ServiceOrder serviceOrder : serviceOrders)
            {
                ListOrdersVO.ListOrdersDto listOrdersDto = CopyUtil.copy(serviceOrder, ListOrdersVO.ListOrdersDto.class);
                // 根据订单数据查询服务者信息，如果订单服务者未确定，返回空值。
                if (serviceOrder.getServantId() != null)
                {
                    User user = userMapper.selectByPrimaryKey(serviceOrder.getServantId());
                    ListOrdersVO.ListOrdersDto.UserBean servant = CopyUtil.copy(user, ListOrdersVO.ListOrdersDto.UserBean.class);
                    servant.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
                    listOrdersDto.setUser(servant);
                } else
                {
                    listOrdersDto.setUser(null);
                }
                listOrdersDto.setState(ServiceStatusEnum.getNameByNum(serviceOrder.getServiceStatus().intValue()));
                listOrdersDtoList.add(listOrdersDto);
            }
            PageInfo<ServiceOrder> pageInfo = new PageInfo<>(serviceOrders);
            listOrdersVO.setPage(pageInfo.getPageNum());
            listOrdersVO.setPerPage(pageInfo.getPageSize());
            listOrdersVO.setList(listOrdersDtoList);
            listOrdersVO.setHasMore(pageInfo.isHasNextPage());
            responseVO.setData(listOrdersVO);
        } else
        {
            responseVO.setData(null);
        }
        return responseVO;
    }

    public ResponseVO getOrderDetail(Long orderId)
    {
        ResponseVO responseVO = new ResponseVO();
        OrderDetailVO orderDetailVO = new OrderDetailVO();
        ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(orderId);
        System.out.println("-------------->");
        System.out.println(serviceOrder.toString());

        OrderDetailVO.ServiceBean serviceBean = new OrderDetailVO.ServiceBean();
        serviceBean.setId(orderId);
        serviceBean.setCreateTime(serviceOrder.getCreateTime());
        serviceBean.setState(ServiceStatusEnum.getNameByNum(serviceOrder.getServiceStatus().intValue()));
        serviceBean.setContent(serviceOrder.getContent());
        List<ServiceTag> serviceTagList = myServiceTagMapper.selectServiceTagListByOrderId(orderId);
        List<OrderDetailVO.ServiceBean.TagsBean> serviceTagsBean =
                CopyUtil.copyList(serviceTagList, OrderDetailVO.ServiceBean.TagsBean.class);
        serviceBean.setTags(serviceTagsBean);
        serviceBean.setIntegral(serviceOrder.getIntegral());
        OrderDetailVO.ServiceBean.RegionBean regionBean =
                CopyUtil.copy(serviceOrder, OrderDetailVO.ServiceBean.RegionBean.class);
        serviceBean.setRegion(regionBean);
        // 如果订单已经确定服务者，设置服务者的commitTime
        // 将服务者信息的设置放在此处仅进行一次判断
        if (serviceOrder.getServantId() == null)
        {
            serviceBean.setCommitTime(null);
            orderDetailVO.setServant(null);
        } else
        {
            ServiceApplication serviceApplication =
                    serviceApplicationMapper.selectByPrimaryKey(orderId, serviceOrder.getServantId());
            User servant = userMapper.selectByPrimaryKey(serviceOrder.getServantId());
            OrderDetailVO.ServantBean servantBean = CopyUtil.copy(servant, OrderDetailVO.ServantBean.class);
            servantBean.setPhone(serviceApplication.getPhone());
            servantBean.setDescription(serviceApplication.getRemark());
            serviceBean.setCommitTime(serviceApplication.getCreateTime());
            orderDetailVO.setServant(servantBean);
        }
        orderDetailVO.setService(serviceBean);
        orderDetailVO.setCancelReason(null);
        User user = userMapper.selectByPrimaryKey(serviceOrder.getClientId());
        OrderDetailVO.ClientBean clientBean = CopyUtil.copy(user, OrderDetailVO.ClientBean.class);
        OrderDetailVO.ClientBean.AddressBean addressBean = CopyUtil.copy(serviceOrder, OrderDetailVO.ClientBean.AddressBean.class);
        addressBean.setDetail(serviceOrder.getDetailedAddress());
        clientBean.setAddress(addressBean);
        clientBean.setPhone(serviceOrder.getPhone());
        orderDetailVO.setClient(clientBean);
        responseVO.setData(orderDetailVO);
        return responseVO;
    }

    private List<ServiceOrder> selectServiceOrderWithPageByServantIdAndStatus(Long id, ListOrdersDTO listOrdersDTO) {
        if("ALL".equals(listOrdersDTO.getScene())) {
            PageHelper.startPage(listOrdersDTO.getPage(), listOrdersDTO.getPerPage());
            return myServiceOrderMapper.selectServiceOrderByServiceApplicationServantId(id);
        } else {
            Byte status = ServiceStatusEnum.getNumByName(listOrdersDTO.getScene()).byteValue();
            PageHelper.startPage(listOrdersDTO.getPage(), listOrdersDTO.getPerPage());
            return myServiceOrderMapper.selectServiceOrderByServiceApplicationServantIdAndStatus(id, status);
        }
    }

    private List<ServiceOrder> selectServiceOrderWithPageByClientIdAndStatus(Long id, ListOrdersDTO listOrdersDTO) {
        if("ALL".equals(listOrdersDTO.getScene())) {
            PageHelper.startPage(listOrdersDTO.getPage(), listOrdersDTO.getPerPage());
            return myServiceOrderMapper.selectServiceOrderByClientId(id);
        } else {
            Byte status = ServiceStatusEnum.getNumByName(listOrdersDTO.getScene()).byteValue();
            PageHelper.startPage(listOrdersDTO.getPage(), listOrdersDTO.getPerPage());
            return myServiceOrderMapper.selectServiceOrderByClientIdAndStatus(id, status);
        }
    }
}
