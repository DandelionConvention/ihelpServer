package com.services.products.ihelp.service.vo;

import com.services.core.util.CopyUtil;
import com.services.products.ihelp.dao.domain.ServiceCancelReason;

import java.util.List;

public class ListUsedServiceCancelReasonVO
{
    private List<ListBean> list;

    public ListUsedServiceCancelReasonVO copy(List<ServiceCancelReason> serviceCancelReasonList)
    {
        list = CopyUtil.copyList(serviceCancelReasonList, ListUsedServiceCancelReasonVO.ListBean.class);
        return this;
    }

    public List<ListBean> getList()
    {
        return list;
    }

    public void setList(List<ListBean> list)
    {
        this.list = list;
    }

    public static class ListBean
    {
        private Integer id;
        private String name;

        public Integer getId()
        {
            return id;
        }

        public void setId(Integer id)
        {
            this.id = id;
        }

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ListBean{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListUsedServiceCancelReasonVO{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
