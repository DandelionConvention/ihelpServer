package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SaveServiceTagDTO
{
    /**
     * name : 名称
     * isUsed : true
     */

    @NotEmpty(message = "名称不能为空")
    private String name;
    @NotNull(message = "是否启用不能为空")
    private Boolean isUsed;

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
        final StringBuilder sb = new StringBuilder("SaveServiceTagDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isUsed=").append(isUsed);
        sb.append('}');
        return sb.toString();
    }
}
