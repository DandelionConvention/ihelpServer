package com.services.products.ihelp.service.vo;

import com.services.core.util.CopyUtil;
import com.services.products.ihelp.dao.domain.ServiceCancelReason;

import java.util.List;

public class ListAllServiceCancelReasonVO
{
    private List<ListBean> list;

    public ListAllServiceCancelReasonVO copy(List<ServiceCancelReason> serviceCancelReasonList)
    {
        list = CopyUtil.copyList(serviceCancelReasonList, ListAllServiceCancelReasonVO.ListBean.class);
        return this;
    }

    public static class ListBean
    {
        private Integer id;
        private String name;
        private Boolean isUsed;

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

        public Boolean getIsUsed()
        {
            return isUsed;
        }

        public void setIsUsed(Boolean isUsed)
        {
            this.isUsed = isUsed;
        }

        @Override
        public String toString()
        {
            final StringBuilder sb = new StringBuilder("ListBean{");
            sb.append("id=").append(id);
            sb.append(", name='").append(name).append('\'');
            sb.append(", isUsed=").append(isUsed);
            sb.append('}');
            return sb.toString();
        }
    }

    public List<ListBean> getList()
    {
        return list;
    }

    public void setList(List<ListBean> list)
    {
        this.list = list;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListAllServiceCancelReasonVO{");
        sb.append("list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
