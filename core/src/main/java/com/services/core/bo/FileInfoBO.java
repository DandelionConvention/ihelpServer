package com.services.core.bo;

public class FileInfoBO
{
    private Long id;
    private String filename;
    private String objectName;
    private String suffix;
    private Integer size;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getFilename()
    {
        return filename;
    }

    public void setFilename(String filename)
    {
        this.filename = filename;
    }

    public String getObjectName()
    {
        return objectName;
    }

    public void setObjectName(String objectName)
    {
        this.objectName = objectName;
    }

    public String getSuffix()
    {
        return suffix;
    }

    public void setSuffix(String suffix)
    {
        this.suffix = suffix;
    }

    public Integer getSize()
    {
        return size;
    }

    public void setSize(Integer size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("FileInfoBO{");
        sb.append("id=").append(id);
        sb.append(", filename='").append(filename).append('\'');
        sb.append(", objectName='").append(objectName).append('\'');
        sb.append(", suffix='").append(suffix).append('\'');
        sb.append(", size=").append(size);
        sb.append('}');
        return sb.toString();
    }
}
