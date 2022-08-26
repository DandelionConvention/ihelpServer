package com.services.core.util;

import com.services.core.bo.FileInfoBO;
import com.services.core.exception.ErrorException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Optional;

/**
 * 文件工具
 */
public class FileUtil
{

    /**
     * MultipartFile转base64
     *
     * @param multipartFile
     * @return
     */
    public static String multipartFileToBase64(MultipartFile multipartFile)
    {
        try
        {
            return new String(Base64.getEncoder().encode(multipartFile.getBytes()), StandardCharsets.UTF_8);
        } catch (IOException e)
        {
            throw new ErrorException(e);
        }
    }

    /**
     * MultipartFile转bytes
     *
     * @param multipartFile
     * @return
     */
    public static byte[] multipartFileToBytes(MultipartFile multipartFile)
    {
        try
        {
            return multipartFile.getBytes();
        } catch (IOException e)
        {
            throw new ErrorException(e);
        }
    }

    /**
     * 获取文件后缀
     *
     * @param filename
     * @return
     */
    public static String getSuffix(String filename)
    {
        if (filename == null)
        {
            return null;
        }
        int index = filename.lastIndexOf(".");
        boolean noSuffix = index <= 0 || index == filename.length() - 1;
        if (noSuffix)
        {
            return null;
        }
        return filename.substring(index);
    }

    /**
     * 生成文件信息
     *
     * @param path 文件路径
     * @param suffix 文件后缀
     * @return
     */
    public static FileInfoBO generateFileInfo(String path, String suffix, Integer size)
    {
        Optional<String> pathOptional = Optional.ofNullable(path);
        Optional<String> suffixOptional = Optional.ofNullable(suffix);
        Long id = SnowFlakeUtil.nextId(System.currentTimeMillis());
        String prefix = UuidUtil.getShortUuid() + "-" + id;
        String filename = prefix + suffixOptional.orElse("");
        String objectName = pathOptional.orElse("") + "/" + filename;
        FileInfoBO fileInfoBO = new FileInfoBO();
        fileInfoBO.setId(id);
        fileInfoBO.setFilename(filename);
        fileInfoBO.setObjectName(objectName);
        fileInfoBO.setSuffix(suffix);
        fileInfoBO.setSize(size);
        return fileInfoBO;
    }
}
