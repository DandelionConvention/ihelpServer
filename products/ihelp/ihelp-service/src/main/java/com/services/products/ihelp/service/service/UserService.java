package com.services.products.ihelp.service.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.services.core.util.CopyUtil;
import com.services.core.vo.ResponseVO;
import com.services.products.ihelp.dao.bo.HisServiceBO;
import com.services.products.ihelp.dao.domain.User;
import com.services.products.ihelp.dao.dto.PageDTO;
import com.services.products.ihelp.dao.mapper.UserMapper;
import com.services.products.ihelp.dao.mapper.my.MyServiceOrderMapper;
import com.services.products.ihelp.service.config.BaseConfig;
import com.services.products.ihelp.service.enums.GenderEnum;
import com.services.products.ihelp.service.enums.UserStatusEnum;
import com.services.products.ihelp.service.enums.UserTypeEnum;
import com.services.products.ihelp.service.util.RedisKeyUtil;
import com.services.products.ihelp.service.vo.GetMyInfoVO;
import com.services.products.ihelp.service.vo.GetUserDetailVO;
import com.services.products.ihelp.service.vo.GetUserPhotoVO;
import com.services.products.ihelp.service.vo.ListHisServicesVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService
{
    private final BaseConfig baseConfig;
    @Resource
    private UserMapper userMapper;
    @Resource
    private MyServiceOrderMapper myServiceOrderMapper;

    public UserService(BaseConfig baseConfig)
    {
        this.baseConfig = baseConfig;
    }

    public ResponseVO getUserDetail(Long id)
    {
        User user = userMapper.selectByPrimaryKey(id);
        GetUserDetailVO getUserDetailVO = new GetUserDetailVO();
        getUserDetailVO.setId(user.getId());
        getUserDetailVO.setNickname(user.getNickname());
        getUserDetailVO.setSignature(user.getSignature());
        getUserDetailVO.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
        getUserDetailVO.setRole(UserTypeEnum.getNameByNum(user.getRole().intValue()));
        getUserDetailVO.setVerified(user.getStatus().intValue() == UserStatusEnum.CERTIFIED.num);
        getUserDetailVO.setCreditLevel("信用良好");
        getUserDetailVO.setOnline(false);
        GetUserDetailVO.StatsBean statsBean = new GetUserDetailVO.StatsBean();
        statsBean.setAnswerRate(1);
        Long clientId = null;
        Long servantId = null;
        if (user.getRole().intValue() == UserTypeEnum.CLIENT.num)
        {
            clientId = id;
            statsBean.setCreateTotal(user.getCreateCount());
            statsBean.setRecruitingTotal(myServiceOrderMapper.countRecruiting(id));
        } else if (user.getRole().intValue() == UserTypeEnum.SERVANT.num)
        {
            servantId = id;
            statsBean.setServiceTotal(user.getServiceTimes());
            statsBean.setCommitTotal(user.getCommitCount());
        } else
        {
            return new ResponseVO(getUserDetailVO);
        }
        ListHisServicesVO listHisServicesVO = getHisServices(1, 10, clientId, servantId);
        getUserDetailVO.setServices(listHisServicesVO.getList());
        getUserDetailVO.setPage(listHisServicesVO.getPage());
        getUserDetailVO.setPerPage(listHisServicesVO.getPerPage());
        getUserDetailVO.setHasMore(listHisServicesVO.getHasMore());
        return new ResponseVO(getUserDetailVO);
    }

    public ResponseVO listHisServices(Long id, PageDTO pageDTO)
    {
        User user = userMapper.selectByPrimaryKey(id);
        Long clientId = null;
        Long servantId = null;
        if (user.getRole().intValue() == UserTypeEnum.CLIENT.num)
        {
            clientId = id;
        } else if (user.getRole().intValue() == UserTypeEnum.SERVANT.num)
        {
            servantId = id;
        } else
        {
            return null;
        }
        return new ResponseVO(getHisServices(pageDTO.getPage(), pageDTO.getPerPage(), clientId, servantId));
    }

    /**
     * 获取他的服务
     *
     * @param pageNum
     * @param pageSize
     * @param clientId
     * @param servantId
     * @return
     */
    private ListHisServicesVO getHisServices(Integer pageNum, Integer pageSize, Long clientId, Long servantId)
    {
        PageHelper.startPage(pageNum, pageSize);
        List<HisServiceBO> hisServiceBOList = myServiceOrderMapper.getHisServices(clientId, servantId);
        PageInfo<HisServiceBO> hisServiceBOPageInfo = new PageInfo<>(hisServiceBOList);
        ListHisServicesVO listHisServicesVO = new ListHisServicesVO();
        listHisServicesVO.setPage(hisServiceBOPageInfo.getPageNum());
        listHisServicesVO.setPerPage(hisServiceBOPageInfo.getPageSize());
        listHisServicesVO.setHasMore(hisServiceBOPageInfo.isHasNextPage());
        listHisServicesVO.setList(hisServiceBOList);
        return listHisServicesVO;
    }

    public ResponseVO getUserPhoto(Long id)
    {
        User user = userMapper.selectByPrimaryKey(id);
        GetUserPhotoVO getUserPhotoVO = new GetUserPhotoVO();
        getUserPhotoVO.setGender(GenderEnum.getNameByNum(user.getGender().intValue()));
        getUserPhotoVO.setPhoto(baseConfig.getOssDomain() + user.getPhoto());
        return new ResponseVO(getUserPhotoVO);
    }

    public ResponseVO getMyInfo(String session)
    {
        Long userId = RedisKeyUtil.getUserId(session);
        User user = userMapper.selectByPrimaryKey(userId);
        GetMyInfoVO getMyInfoVO = CopyUtil.copy(user, GetMyInfoVO.class);
        getMyInfoVO.setVerified(user.getStatus().intValue() == 1);
        getMyInfoVO.setRole(UserTypeEnum.getNameByNum(user.getRole().intValue()));
        getMyInfoVO.setAvatar(baseConfig.getOssDomain() + user.getAvatar());
        return new ResponseVO(getMyInfoVO);
    }
}
