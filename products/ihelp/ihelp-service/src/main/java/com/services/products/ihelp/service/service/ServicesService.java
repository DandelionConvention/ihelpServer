package com.services.products.ihelp.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.services.core.util.CopyUtil;
import com.services.core.util.SnowFlakeUtil;
import com.services.core.util.TimeUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.bo.ListServicesBO;
import com.services.products.ihelp.dao.domain.OrderRecord;
import com.services.products.ihelp.dao.domain.ServiceApplication;
import com.services.products.ihelp.dao.domain.ServiceOrder;
import com.services.products.ihelp.dao.domain.ServiceOrderExample;
import com.services.products.ihelp.dao.domain.ServiceOrderServiceTag;
import com.services.products.ihelp.dao.domain.ServiceTag;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.dto.FinishServiceOrderDTO;
import com.services.products.ihelp.dao.dto.ListServiceOrderServantsDTO;
import com.services.products.ihelp.dao.dto.ListServiceOrdersDTO;
import com.services.products.ihelp.dao.dto.SaveServiceApplicationDTO;
import com.services.products.ihelp.dao.dto.SaveServiceOrderDTO;
import com.services.products.ihelp.dao.mapper.OrderRecordMapper;
import com.services.products.ihelp.dao.mapper.ServiceApplicationMapper;
import com.services.products.ihelp.dao.mapper.ServiceOrderMapper;
import com.services.products.ihelp.dao.mapper.ServiceOrderServiceTagMapper;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceApplicationMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceOrderCollectMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceOrderMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceOrderServantMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceTagMapper;
import com.services.products.ihelp.dao.mapper.my.MyUserMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.service.enums.GenderEnum;
import com.services.products.ihelp.service.enums.OrderRecordTypeEnum;
import com.services.products.ihelp.service.enums.ServiceStatusEnum;
import com.services.products.ihelp.service.enums.UserStatusEnum;
import com.services.products.ihelp.service.enums.UserTypeEnum;
import com.services.products.ihelp.service.exception.BusinessException;
import com.services.products.ihelp.service.exception.BusinessExceptionCode;
import com.services.products.ihelp.service.util.DateUtil;
import com.services.products.ihelp.service.util.RedisKeyUtil;
import com.services.products.ihelp.service.vo.GetApplicationDetailVO;
import com.services.products.ihelp.service.vo.ListServiceOrderServantsVO;
import com.services.products.ihelp.service.vo.ListServiceOrdersVO;
import com.services.products.ihelp.service.vo.ServiceDetailVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServicesService
{
    private final BaseConfig baseConfig;
    @Resource
    private UserMapper userMapper;
    @Resource
    private ServiceApplicationMapper serviceApplicationMapper;
    @Resource
    private MyServiceOrderMapper myServiceOrderMapper;
    @Resource
    MyServiceApplicationMapper myServiceApplicationMapper;
    @Resource
    private MyUserMapper myUserMapper;
    @Resource
    private ServiceOrderMapper serviceOrderMapper;
    @Resource
    private ServiceOrderServiceTagMapper serviceOrderServiceTagMapper;
    @Resource
    private MyServiceOrderServantMapper myServiceOrderServantMapper;
    @Resource
    private MyServiceTagMapper myServiceTagMapper;
    @Resource
    private MyServiceOrderCollectMapper myServiceOrderCollectMapper;
    @Resource
    private OrderRecordMapper orderRecordMapper;

    public ServicesService(BaseConfig baseConfig)
    {
        this.baseConfig = baseConfig;
    }

    public ResponseVO getApplicationDetail(Long serviceId, Long servantId)
    {
        User user = userMapper.selectByPrimaryKey(servantId);
        ServiceApplication serviceApplication = serviceApplicationMapper.selectByPrimaryKey(serviceId, servantId);
        GetApplicationDetailVO getApplicationDetailVO = new GetApplicationDetailVO();
        GetApplicationDetailVO.AddressBean addressBean =
                CopyUtil.copy(serviceApplication, GetApplicationDetailVO.AddressBean.class);
        addressBean.setDetail(serviceApplication.getDetailedAddress());
        getApplicationDetailVO.setAddress(addressBean);
        getApplicationDetailVO.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
        getApplicationDetailVO.setDecade(TimeUtil.getGeneration(user.getBirthday()));
        getApplicationDetailVO.setGender(GenderEnum.getNameByNum(user.getGender().intValue()));
        getApplicationDetailVO.setId(user.getId());
        getApplicationDetailVO.setNickname(user.getNickname());
        getApplicationDetailVO.setRemark(serviceApplication.getRemark());
        getApplicationDetailVO.setCreditLevel("信用良好");
        getApplicationDetailVO.setOnline(false);
        return new ResponseVO(getApplicationDetailVO);
    }

    @Transactional
    public ResponseVO saveServiceOrder(String session, SaveServiceOrderDTO requestDto)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        User user = userMapper.selectByPrimaryKey(userId);
        if (user.getRole().intValue() != UserTypeEnum.CLIENT.num)
        {
            BusinessExceptionCode.FORBIDDEN.throwException();
        }
        BigDecimal balance = myUserMapper.selectUserIntegralByUserId(userId);
        BigDecimal amount = requestDto.getIntegral();
        if (amount.compareTo(balance) > 0)
        {
            throw new BusinessException(BusinessExceptionCode.INSUFFICIENT_BALANCE);
        }
        ServiceOrder serviceOrder = CopyUtil.copy(requestDto, ServiceOrder.class);
        serviceOrder.setProvince(requestDto.getAddress().getProvince());
        serviceOrder.setCity(requestDto.getAddress().getCity());
        serviceOrder.setCounty(requestDto.getAddress().getCounty());
        serviceOrder.setDetailedAddress(requestDto.getAddress().getDetail());
        serviceOrder.setLng(requestDto.getAddress().getLng());
        serviceOrder.setLat(requestDto.getAddress().getLat());
        serviceOrder.setRegion(requestDto.getAddress().getRegion());
        serviceOrder.setTip(new BigDecimal(0));
        serviceOrder.setServiceTime(TimeUtil.epochMilliToLocalDateTime(requestDto.getServiceTime(), 8));
        serviceOrder.setServiceDuration(requestDto.getServiceDuration().byteValue());
        serviceOrder.setClientId(userId);
        Long orderId = SnowFlakeUtil.nextId(System.currentTimeMillis());
        serviceOrder.setId(orderId);
        serviceOrder.setServiceStatus(ServiceStatusEnum.CREATED.num.byteValue());
        serviceOrder.setReadingCount(0);
        serviceOrder.setCommitCount(0);
        serviceOrder.setIsDeleted(false);
        serviceOrder.setCreateTime(LocalDateTime.now());
        serviceOrder.setUpdateTime(LocalDateTime.now());
        serviceOrderMapper.insert(serviceOrder);
        // 为申请者增加服务发布次数
        myUserMapper.createCountIncrement(userId);
        // 处理订单表数据
        User user1 = new User();
        user1.setId(user.getId());
        // 退回老人的积分
        user1.setIntegral(user.getIntegral().add(serviceOrder.getIntegral()));
        userMapper.updateByPrimaryKeySelective(user1);
        balance = user1.getIntegral();
        OrderRecord orderRecord = new OrderRecord();
        orderRecord.setId(SnowFlakeUtil.nextId(System.currentTimeMillis()));
        orderRecord.setUserId(userId);
        orderRecord.setOrderId(orderId);
        orderRecord.setType(OrderRecordTypeEnum.COST.num.byteValue());
        orderRecord.setAmount(amount);
        orderRecord.setBalance(balance);
        LocalDateTime now = LocalDateTime.now();
        orderRecord.setCreateTime(now);
        orderRecord.setUpdateTime(now);
        orderRecordMapper.insert(orderRecord);
        // 增加用户表服务创建数
        myUserMapper.createCountIncrement(userId);
        // 处理服务标签表
        for (Integer integer : requestDto.getTags())
        {
            ServiceOrderServiceTag serviceOrderServiceTag = new ServiceOrderServiceTag();
            serviceOrderServiceTag.setServiceTagId(integer);
            serviceOrderServiceTag.setServiceOrderId(orderId);
            serviceOrderServiceTag.setCreateTime(LocalDateTime.now());
            serviceOrderServiceTag.setUpdateTime(LocalDateTime.now());
            serviceOrderServiceTagMapper.insert(serviceOrderServiceTag);
        }
        return new ResponseVO();
    }

    @Transactional
    public ResponseVO applyService(String session, Long orderId, SaveServiceApplicationDTO requestDto)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        User user = userMapper.selectByPrimaryKey(userId);
        if (user.getRole().intValue() != UserTypeEnum.SERVANT.num)
        {
            BusinessExceptionCode.FORBIDDEN.throwException();
        }
        ServiceApplication serviceApplication = CopyUtil.copy(requestDto, ServiceApplication.class);
        serviceApplication.setRemark(requestDto.getDescription());
        serviceApplication.setProvince(requestDto.getAddress().getProvince());
        serviceApplication.setCity(requestDto.getAddress().getCity());
        serviceApplication.setCounty(requestDto.getAddress().getCounty());
        serviceApplication.setDetailedAddress(requestDto.getAddress().getDetail());
        serviceApplication.setLng(requestDto.getAddress().getLng());
        serviceApplication.setLat(requestDto.getAddress().getLat());
        serviceApplication.setRegion(requestDto.getAddress().getRegion());
        serviceApplication.setServantId(userId);
        serviceApplication.setServiceOrderId(orderId);
        serviceApplication.setServiceStatus(ServiceStatusEnum.CREATED.num.byteValue());
        serviceApplication.setIsDeleted(false);
        serviceApplication.setCreateTime(LocalDateTime.now());
        serviceApplication.setUpdateTime(LocalDateTime.now());
        serviceApplicationMapper.insert(serviceApplication);
        // 给对应的服务订单申请数+1并更新
        myServiceOrderMapper.commitCountIncrement(orderId);
        // 为申请者添加申请服务次数
        myUserMapper.commitCountIncrement(userId);
        return new ResponseVO();
    }

    public ResponseVO listServices(ListServiceOrdersDTO listServiceOrdersDTO)
    {
        List<ListServicesBO> listServicesBOS = myServiceOrderMapper.listServices(listServiceOrdersDTO);
        ListServiceOrdersVO listServiceOrdersVO = new ListServiceOrdersVO();
        listServiceOrdersVO.setHasMore(!(listServicesBOS.size() < listServiceOrdersDTO.getPerPage()));
        listServiceOrdersVO.setPage(listServiceOrdersDTO.getPage());
        listServiceOrdersVO.setPerPage(listServiceOrdersDTO.getPerPage());
        listServiceOrdersVO.setList(listServicesBOS);
        return new ResponseVO(listServiceOrdersVO);
    }

    public ResponseVO listApplicants(Long id, ListServiceOrderServantsDTO requestDto)
    {
        ResponseVO responseVO = new ResponseVO();
        // 从数据库中获取User类型的服务者列表，以及分页信息
        PageHelper.startPage(requestDto.getPage(), requestDto.getPerPage());
        List<User> serviceOrderServantList = myServiceOrderServantMapper.listServiceOrderServant(id);
        // 创建空的ServiceOrderServantsDto列表，用于对User类型服务者列表数据转换后返回给前端
        List<ListServiceOrderServantsVO.ServiceOrderServantsDto> serviceOrderServantsDto = new ArrayList<>();
        // 循环User类型的服务者列表，处理数据后add到ServiceOrderServantsDto列表
        for (User servant : serviceOrderServantList)
        {
            ListServiceOrderServantsVO.ServiceOrderServantsDto servantVO =
                    new ListServiceOrderServantsVO.ServiceOrderServantsDto();
            servantVO.setId(servant.getId());
            servantVO.setAvatar(baseConfig.getOssDomain() + servant.getAvatar());
            servantVO.setNickname(servant.getNickname());
            // Decade年代使用DateUtil工具类获取生日计算
            servantVO.setDecade(DateUtil.localDateToDecade(servant.getBirthday()));
            servantVO.setCreditLevel("0");
            servantVO.setOnline(true);
            servantVO.setGender(GenderEnum.getNameByNum(Integer.valueOf(servant.getGender())));
            serviceOrderServantsDto.add(servantVO);
        }
        PageInfo<User> pageInfo = new PageInfo<>(serviceOrderServantList);
        ListServiceOrderServantsVO listServiceOrderServantsVO = new ListServiceOrderServantsVO();
        listServiceOrderServantsVO.setPage(pageInfo.getPageNum());
        listServiceOrderServantsVO.setPerPage(pageInfo.getPageSize());
        listServiceOrderServantsVO.setList(serviceOrderServantsDto);
        listServiceOrderServantsVO.setHasMore(pageInfo.isHasNextPage());
        responseVO.setData(listServiceOrderServantsVO);
        return responseVO;
    }

    @Transactional
    public ResponseVO passServiceApplication(String session, Long orderId, Long servantId)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        boolean orderExisted = myServiceOrderMapper.serviceOrderExistedByOrderIdAndUserId(orderId, userId) != null;
        if (!orderExisted)
        {
            throw new BusinessException(BusinessExceptionCode.FORBIDDEN);
        }
        // 统一接口调用时间
        LocalDateTime now = LocalDateTime.now();
        ServiceOrder serviceOrder = new ServiceOrder();
        serviceOrder.setId(orderId);
        serviceOrder.setServantId(servantId);
        serviceOrder.setServiceStatus(ServiceStatusEnum.PROCESSING.num.byteValue());
        serviceOrder.setPassTime(now);
        serviceOrder.setUpdateTime(now);
        ServiceApplication serviceApplication = new ServiceApplication();
        serviceApplication.setServiceOrderId(orderId);
        serviceApplication.setServantId(servantId);
        serviceApplication.setServiceStatus(ServiceStatusEnum.PROCESSING.num.byteValue());
        serviceApplication.setUpdateTime(now);
        // 对ServiceOrder表进行更新
        serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
        // 对ServiceApplication表进行更新
        serviceApplicationMapper.updateByPrimaryKeySelective(serviceApplication);
        // 对ServiceApplication表中的其它申请状态修改为拒绝
        myServiceApplicationMapper.updateServiceApplicationStatusByOrderIdAndServiceStatusNum(orderId,
                ServiceStatusEnum.REJECTED.num.byteValue(),
                ServiceStatusEnum.CREATED.num.byteValue());
        return new ResponseVO();
    }

    public ResponseVO getServiceDetail(String session, Long orderId)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        ResponseVO responseVO = new ResponseVO();
        ServiceDetailVO serviceDetailVO = new ServiceDetailVO();
        ServiceOrder serviceOrder = serviceOrderMapper.selectByPrimaryKey(orderId);
        serviceOrder.setReadingCount(serviceOrder.getReadingCount() + 1);
        serviceOrderMapper.updateByPrimaryKeySelective(serviceOrder);
        ServiceDetailVO.StatsBean stats = CopyUtil.copy(serviceOrder, ServiceDetailVO.StatsBean.class);
        serviceDetailVO.setStats(stats);
        ServiceDetailVO.DetailBean detail = CopyUtil.copy(serviceOrder, ServiceDetailVO.DetailBean.class);
        ServiceDetailVO.DetailBean.AddressBean address = CopyUtil.copy(serviceOrder,
                ServiceDetailVO.DetailBean.AddressBean.class);
        List<ServiceTag> serviceTagList = myServiceTagMapper.selectServiceTagListByOrderId(orderId);
        List<ServiceDetailVO.DetailBean.ServiceTagBean> serviceTagListVO = CopyUtil.copyList(serviceTagList,
                ServiceDetailVO.DetailBean.ServiceTagBean.class);
        detail.setAddress(address);
        detail.setServiceTag(serviceTagListVO);
        serviceDetailVO.setDetail(detail);
        User user = userMapper.selectByPrimaryKey(serviceOrder.getClientId());
        ServiceDetailVO.UserInfoBean userInfo = CopyUtil.copy(user, ServiceDetailVO.UserInfoBean.class);
        userInfo.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
        userInfo.setGender(GenderEnum.getNameByNum(Integer.valueOf(user.getGender())));
        userInfo.setDecade(DateUtil.localDateToDecade(user.getBirthday()));
        userInfo.setVerified(user.getStatus() == UserStatusEnum.CERTIFIED.num.byteValue());
        userInfo.setCreateTotal(user.getCreateCount());
        userInfo.setCreditLevel(0);
        userInfo.setAnswerRate(100);
        userInfo.setOnline(true);
        // 在招其它服务信息查询
        List<ServiceOrder> recruitingServiceOrders = myServiceOrderMapper.selectServiceOrderByClientId(user.getId());
        ServiceDetailVO.UserInfoBean.RecruitingBean recruiting = new ServiceDetailVO.UserInfoBean.RecruitingBean();
        List<ServiceDetailVO.UserInfoBean.RecruitingBean.ListBean> recruitServiceList = new ArrayList<>();
        recruiting.setTotal(recruitingServiceOrders.size() - 1);
        for (ServiceOrder recruitingServiceOrder : recruitingServiceOrders)
        {
            if (recruitingServiceOrder.getId().equals(serviceOrder.getId()))
            {
                continue;
            }
            ServiceDetailVO.UserInfoBean.RecruitingBean.ListBean recruitingOrder =
                    CopyUtil.copy(recruitingServiceOrder, ServiceDetailVO.UserInfoBean.RecruitingBean.ListBean.class);
            List<ServiceTag> recruitingServiceTagList = myServiceTagMapper.selectServiceTagListByOrderId(orderId);
            List<ServiceDetailVO.UserInfoBean.RecruitingBean.ListBean.TagsBean> recruitingServiceTagsBean =
                    CopyUtil.copyList(recruitingServiceTagList,
                            ServiceDetailVO.UserInfoBean.RecruitingBean.ListBean.TagsBean.class);
            recruitingOrder.setTags(recruitingServiceTagsBean);
            recruitServiceList.add(recruitingOrder);
        }
        recruiting.setList(recruitServiceList);
        userInfo.setRecruiting(recruiting);
        serviceDetailVO.setIsCollected(myServiceOrderCollectMapper.isOrderCollectedByUser(orderId, userId) != null);
        serviceDetailVO.setUserInfo(userInfo);
        responseVO.setData(serviceDetailVO);
        return responseVO;
    }

    @Transactional
    public ResponseVO finishService(String session, Long orderId, FinishServiceOrderDTO requestDto)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        ServiceOrderExample serviceOrderExample = new ServiceOrderExample();
        ServiceOrderExample.Criteria criteria = serviceOrderExample.createCriteria();
        criteria.andClientIdEqualTo(userId).andIdEqualTo(orderId).andServiceStatusEqualTo(ServiceStatusEnum.PROCESSING.num.byteValue());
        List<ServiceOrder> serviceOrderList = serviceOrderMapper.selectByExample(serviceOrderExample);
        if (serviceOrderList.size() < 1)
        {
            BusinessExceptionCode.FORBIDDEN.throwException();
        }
        ServiceOrder serviceOrder = serviceOrderList.get(0);
        User user = userMapper.selectByPrimaryKey(serviceOrder.getServantId());
        User user1 = new User();
        user1.setId(user.getId());
        user1.setIntegral(user.getIntegral().add(serviceOrder.getIntegral()));
        userMapper.updateByPrimaryKeySelective(user1);
        // 订单状态改为待评论
        myServiceOrderMapper.updateServiceOrderStatusByOrderId(orderId,
                ServiceStatusEnum.EVALUATING.num.byteValue());
        // 服务申请状态改为待评论
        myServiceApplicationMapper.updateServiceApplicationStatusByOrderIdAndServiceStatusNum(orderId,
                ServiceStatusEnum.EVALUATING.num.byteValue(),
                ServiceStatusEnum.PROCESSING.num.byteValue());
        return new ResponseVO();
    }
}
