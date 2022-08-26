package com.services.products.ihelp.dao.mapper.my;

import com.services.products.ihelp.dao.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyServiceOrderServantMapper
{
    List<User> listServiceOrderServant(@Param("id") Long id);
}
