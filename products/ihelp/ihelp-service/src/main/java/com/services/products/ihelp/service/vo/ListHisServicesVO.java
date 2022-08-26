package com.services.products.ihelp.service.vo;

import com.services.products.ihelp.dao.bo.HisServiceBO;

import java.util.List;

public class ListHisServicesVO
{
    /**
     * perPage : 1
     * page : 10
     * hasMore : true
     * list : [{"id":"563511964567923205376","serviceStatus":"aliqua ad ex eiusmod","content":"pariatur","serviceTag":[{"id":12,"name":"elit Lorem velit ea"}],"integral":21.9,"address":{"province":"et","city":"cupidatat id ex commodo adipisicing"},"serviceTime":"aliqua"}]
     */

    private Integer perPage;
    private Integer page;
    private Boolean hasMore;
    private List<HisServiceBO> list;

    public Integer getPerPage()
    {
        return perPage;
    }

    public void setPerPage(Integer perPage)
    {
        this.perPage = perPage;
    }

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Boolean getHasMore()
    {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore)
    {
        this.hasMore = hasMore;
    }

    public List<HisServiceBO> getList()
    {
        return list;
    }

    public void setList(List<HisServiceBO> list)
    {
        this.list = list;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListHisServicesVO{");
        sb.append("perPage=").append(perPage);
        sb.append(", page=").append(page);
        sb.append(", hasMore=").append(hasMore);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
