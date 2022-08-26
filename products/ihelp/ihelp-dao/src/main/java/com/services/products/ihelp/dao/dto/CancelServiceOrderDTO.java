package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class CancelServiceOrderDTO
{
    /**
     * orderId : 1
     * reasonId : 1
     * description : 原因描述
     * images : ["http://dummyimage.com/300x600","http://dummyimage.com/120x90"]
     */

    @NotNull(message = "orderId不能为空")
    private Long orderId;
    @NotNull(message = "reasonId不能为空")
    private Integer reasonId;
    private String description;
    private List<String> images;

    public Long getOrderId()
    {
        return orderId;
    }

    public void setOrderId(Long orderId)
    {
        this.orderId = orderId;
    }

    public Integer getReasonId()
    {
        return reasonId;
    }

    public void setReasonId(Integer reasonId)
    {
        this.reasonId = reasonId;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public List<String> getImages()
    {
        return images;
    }

    public void setImages(List<String> images)
    {
        this.images = images;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CancelServiceOrderDTO{");
        sb.append("orderId=").append(orderId);
        sb.append(", reasonId=").append(reasonId);
        sb.append(", description='").append(description).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }
}
