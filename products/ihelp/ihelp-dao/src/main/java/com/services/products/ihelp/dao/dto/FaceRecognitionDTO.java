package com.services.products.ihelp.dao.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class FaceRecognitionDTO
{
    @NotNull(message = "服务者id不能为空")
    private Long userId;
    @NotEmpty(message = "人脸不能为空")
    private String photo;

    public Long getUserId()
    {
        return userId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FaceRecognitionDTO{");
        sb.append("userId=").append(userId);
        sb.append(", photo='").append(photo).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
