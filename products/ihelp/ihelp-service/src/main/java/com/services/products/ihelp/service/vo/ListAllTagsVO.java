package com.services.products.ihelp.service.vo;

import java.util.List;

public class ListAllTagsVO
{
    private List<ListBean> list;

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
        /**
         * id : 3
         * name : 群支极
         * isUsed : true
         */

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

        public Boolean isIsUsed()
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
}
