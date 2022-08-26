package com.services.products.ihelp.dao.dto;


import javax.validation.constraints.NotEmpty;

public class ListOrdersDTO extends PageDTO
{
    @NotEmpty(message = "Scene不能为空")
    private String scene;


    public String getScene()
    {
        return scene;
    }

    public void setScene(String scene)
    {
        this.scene = scene;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("ListOrdersDTO{");
        sb.append("scene='").append(scene).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
