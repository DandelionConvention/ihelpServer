package com.services.products.ihelp.dao.dto;

public class UpdateServiceTagDTO
{
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
}
