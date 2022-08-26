package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.Min;
import java.util.List;

/**
 * 通用分页数据传输对象
 */
public class PageDTO<T>
{

    /**
     * 当前页码
     */
    @Min(value = 1, message = "页码不能小于1")
    private Integer page = 1;

    /**
     * 每页条数
     */
    @Min(value = 1, message = "每页个数不能小于1")
    private Integer perPage = 10;

    /**
     * 是否有下一页
     */
    private Boolean hasMore;

    /**
     * 数据
     */
    private List<T> list;

    public Integer getPage()
    {
        return page;
    }

    public void setPage(Integer page)
    {
        this.page = page;
    }

    public Integer getPerPage()
    {
        return perPage;
    }

    public void setPerPage(Integer perPage)
    {
        this.perPage = perPage;
    }

    public Boolean isHasMore()
    {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore)
    {
        this.hasMore = hasMore;
    }

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("PageDto{");
        sb.append("page=").append(page);
        sb.append(", perPage=").append(perPage);
        sb.append(", hasMore=").append(hasMore);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
