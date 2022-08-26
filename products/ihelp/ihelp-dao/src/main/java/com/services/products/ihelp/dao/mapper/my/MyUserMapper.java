package com.services.products.ihelp.dao.mapper.my;

import com.services.products.ihelp.dao.bo.HisServiceBO;
import com.services.products.ihelp.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

public interface MyUserMapper
{
    void commitCountIncrement(@Param("userId") Long userId);
    void createCountIncrement(@Param("userId") Long userId);
    BigDecimal selectUserIntegralByUserId(@Param("userId") Long userId);
    void updateUserIntegralByUserId(@Param("userId") Long userId, @Param("amount") BigDecimal amount);
    Byte selectUserRoleByUserId(@Param("userId") Long userId);
    User getUserByOpenid(@Param("openid") String openid);
}
