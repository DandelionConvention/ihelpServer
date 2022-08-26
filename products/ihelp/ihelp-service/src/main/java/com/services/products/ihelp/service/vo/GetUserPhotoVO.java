package com.services.products.ihelp.service.vo;

public class GetUserPhotoVO
{
    private String photo;
    private String gender;

    public String getPhoto()
    {
        return photo;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("GetUserPhotoVO{");
        sb.append("photo='").append(photo).append('\'');
        sb.append(", gender='").append(gender).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
