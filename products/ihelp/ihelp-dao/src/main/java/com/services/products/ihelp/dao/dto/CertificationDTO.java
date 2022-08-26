package com.services.products.ihelp.dao.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class CertificationDTO
{
    /**
     * name : 真实姓名
     * idNumber : 12345678912345678x
     * photo : http://dummyimage.com/300x600
     * images : {"front":"http://dummyimage.com/300x600","back":"http://dummyimage.com/120x90"}
     */

    @NotEmpty(message = "姓名不能为空")
    private String name;
    @NotEmpty(message = "身份证号不能为空")
    private String idNumber;
    @NotEmpty(message = "人脸不能为空")
    private String photo;
    @Valid
    @NotNull(message = "身份证照片不能为空")
    private ImagesBean images;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public ImagesBean getImages()
    {
        return images;
    }

    public void setImages(ImagesBean images)
    {
        this.images = images;
    }

    public static class ImagesBean
    {
        /**
         * front : http://dummyimage.com/300x600
         * back : http://dummyimage.com/120x90
         */
        @NotEmpty(message = "身份证正面不能为空")
        private String front;
        @NotEmpty(message = "身份证背面不能为空")
        private String back;

        public String getFront()
        {
            return front;
        }

        public void setFront(String front)
        {
            this.front = front;
        }

        public String getBack()
        {
            return back;
        }

        public void setBack(String back)
        {
            this.back = back;
        }
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("CertificationDTO{");
        sb.append("name='").append(name).append('\'');
        sb.append(", idNumber='").append(idNumber).append('\'');
        sb.append(", photo='").append(photo).append('\'');
        sb.append(", images=").append(images);
        sb.append('}');
        return sb.toString();
    }
}
