package com.services.products.ihelp.dao.dto;

public class UpdateServiceCancelReasonDTO
{

    /**
     * name : 名称
     * isUsed : true
     */

    private String name;
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
        final StringBuilder sb = new StringBuilder("UpdateServiceCancelReasonDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", isUsed=").append(isUsed);
        sb.append('}');
        return sb.toString();
    }
}
